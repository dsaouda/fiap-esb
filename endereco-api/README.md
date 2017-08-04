# esb-endereco

O projeto representa uma aplicação de endereço/cep. Esse projeto utiliza a api do ViaCEP (https://viacep.com.br/)

Esse projeto foi feito utilizando kotlin (https://kotlinlang.org/) com framework spring-boot (https://projects.spring.io/spring-boot/) e como http client foi utilizado o retrofit (http://square.github.io/retrofit/).

# compilar o projeto

`./gradlew build`

# executar o projeto

`java -jar -Dserver.port=8081 esb-endereco-1.0.0.jar`

# usando

acesse http://localhost:8081/v1/cep?codigo=01538001
