# esb-checkout-api

Projeto simula um processo de checkout de um ecommerce. Ao final do processamento um boleto fake é emitido.

# libs

O projeto foi feito usando groovy (http://groovy-lang.org/) com o framework grails (https://grails.org/). Para geração do boleto foi utilizado o projeto stella-boleto (https://github.com/caelum/caelum-stella/wiki/Gerando-boleto).

# acessando o grails

`grailsw`

# testando o projeto e desenvolver

grails> `run-app`

a aplicação firá disponível no endereço http://localhost:8080

# parando o projeto

grails> `stop-app`

# visualizar todos os comandos

grails> `help`

# compilar para produção

grails> `package`

o pacote será gerado em build/libs/<project-name>.war

# executando

`java -Dgrails.env=prod -jar build/libs/<project-name>.war`

# exemplo de utilização

`curl -X POST -d "valor=10.00&cliente_nome=Cliente&cliente_documento=123&endereco_logradouro=Av. Teste&endereco_bairro=Bairro&endereco_cep=12345678&endereco_cidade=Sao Paulo&endereco_uf=UF" http://localhost:8080/v1/checkout`
