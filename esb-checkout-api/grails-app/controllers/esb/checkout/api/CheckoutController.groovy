package esb.checkout.api

import br.com.caelum.stella.boleto.Beneficiario
import br.com.caelum.stella.boleto.Boleto
import br.com.caelum.stella.boleto.Datas
import br.com.caelum.stella.boleto.Endereco
import br.com.caelum.stella.boleto.Pagador
import br.com.caelum.stella.boleto.bancos.BancoDoBrasil
import br.com.caelum.stella.boleto.transformer.GeradorDeBoleto

import javax.imageio.ImageIO
import java.awt.image.BufferedImage
import java.time.LocalDate

class CheckoutController {

    static allowedMethods = [index:'POST', boleto: 'GET']

    def index() {

        def nomeBoleto = "boleto-" + System.currentTimeMillis() + ".png"

        Datas data = dataBoleto()
        Endereco enderecoBeneficiario = enderecoBeneficiario()
        Beneficiario beneficiario = emissor(enderecoBeneficiario)
        Endereco enderecoPagador = enderecoPagador()
        Pagador pagador = pagador(enderecoPagador)
        Boleto boleto = boletoFactory(data, beneficiario, pagador)

        def gerador = new GeradorDeBoleto(boleto);
        gerador.geraPNG(nomeBoleto)

        render """[{
            "status": "Compra efetuada com sucesso. Agora so falta pagar o boleto",
            "visualizar-boleto": "$grailsLinkGenerator.serverBaseURL/v1/checkout/boleto?f=$nomeBoleto"
        }]"""

    }

    def boleto() {
        String path = params.f

        BufferedImage originalImage = ImageIO.read(new File(path));
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        def fileext = path.substring(path.indexOf(".")+1, path.length())

        ImageIO.write( originalImage, fileext, baos );
        baos.flush();

        byte[] img = baos.toByteArray();
        baos.close();

        response.setHeader('Content-length', img.length.toString())
        response.contentType = "image/"+fileext // or the appropriate image content type
        response.outputStream << img
        response.outputStream.flush()
    }

    private Boleto boletoFactory(Datas data, Beneficiario beneficiario, Pagador pagador) {
        def boleto = Boleto.novoBoleto()
                .comBanco(new BancoDoBrasil())
                .comDatas(data)
                .comBeneficiario(beneficiario)
                .comPagador(pagador)
                .comValorBoleto(params.valor)
                .comNumeroDoDocumento("1234")
                .comInstrucoes("nao pague esse boleto", "ele faz parte de um projeto maior que simula um ESB")
                .comLocaisDePagamento("local 1", "local 2")
        boleto
    }

    private Pagador pagador(Endereco enderecoPagador) {
        def pagador = Pagador.novoPagador()
                .comNome(params.cliente_nome)
                .comDocumento(params.cliente_documento)
                .comEndereco(enderecoPagador)
        pagador
    }

    private Endereco enderecoPagador() {
        def enderecoPagador = Endereco.novoEndereco()
                .comLogradouro(params.endereco_logradouro)
                .comBairro(params.endereco_bairro)
                .comCep(params.endereco_cep)
                .comCidade(params.endereco_cidade)
                .comUf(params.endereco_uf)
        enderecoPagador
    }

    private Beneficiario emissor(Endereco enderecoBeneficiario) {
        def beneficiario = Beneficiario.novoBeneficiario()
                .comNomeBeneficiario("FIAP - Melhor Faculdade de Tecnologia‎")
                .comAgencia("1824").comDigitoAgencia("4")
                .comCodigoBeneficiario("76000")
                .comDigitoCodigoBeneficiario("5")
                .comNumeroConvenio("1207113")
                .comCarteira("18")
                .comEndereco(enderecoBeneficiario)
                .comNossoNumero("9000206")
        beneficiario
    }

    private Endereco enderecoBeneficiario() {
        def enderecoBeneficiario = Endereco.novoEndereco()
                .comLogradouro("Av. Lins de Vasconcelos, 1222")
                .comBairro("Cambuci")
                .comCep("01538-001")
                .comCidade("Sao Paulo")
                .comUf("SP")
        enderecoBeneficiario
    }

    private Datas dataBoleto() {
        def d = LocalDate.now()
        def p = LocalDate.now().minusDays(10)
        def v = LocalDate.now().plusDays(10)

        Datas.novasDatas()
                .comDocumento(d.getDayOfMonth(), d.getMonthValue(), d.getYear())
                .comProcessamento(p.getDayOfMonth(), p.getMonthValue(), p.getYear())
                .comVencimento(v.getDayOfMonth(), v.getMonthValue(), v.getYear())
    }
}
