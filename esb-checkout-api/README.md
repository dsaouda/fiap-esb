# esb-checkout-api

Projeto simula um processo de checkout de um ecommerce. Ao final do processamento um boleto fake é emitido.

# libs

O projeto foi feito usando groovy (http://groovy-lang.org/) com o framework grails (https://grails.org/). Para geração do boleto foi utilizado o projeto stella-boleto (https://github.com/caelum/caelum-stella/wiki/Gerando-boleto).

# executar

`grailsw`

grails> `run-app`

# parando o projeto

`grailsw`

grails> `stop-app`

# help

`grailsw`

grails> `help`

# compilar para produção

`grailsw`

grails> `package`

# executando

`java -Dgrails.env=prod -jar build/libs/<project-name>.war`

# exemplo de utilização

`curl -X POST -d "valor=10.00&cliente_nome=Cliente&cliente_documento=123&endereco_logradouro=Av. Teste&endereco_bairro=Bairro&endereco_cep=12345678&endereco_cidade=Sao Paulo&endereco_uf=UF" http://localhost:8080/v1/checkout`
