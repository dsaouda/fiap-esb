# esb-endereco
Projeto representa uma aplicação de endereço/cep. Esse projeto utiliza a api do ViaCEP (https://viacep.com.br/)

# compilar o projeto

`./gradlew build`

# executar o projeto

`java -jar -Dserver.port=8081 esb-endereco-1.0.0.jar`

# acessando o projeto

em um navegador acesse http://localhost:8081/v1/cep?codigo=01538001 aonde o parâmetro código deve receber o CEP