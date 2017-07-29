# esb-login-api

O projeto simula um serviço de autenticação.

Esse projeto foi feito utilizando golang (https://golang.org/) com o web framework gin (https://gin-gonic.github.io/gin/)

# baixar dependências

`go get`

# testar em desenvolvimento

`go run main.go`

# compilar

`go build`

# rodar projeto compilado

`./esb-login-api -host localhost -port 9002`

# usando

 - criar novo login `curl -X POST -d '{"cliente_uuid":"e4e3bb04-254b-44c7-af4a-b59ae8c10e7c", "cliente_cpf":"123", "login": "cliente@email.com", "senha": "123"}' http://localhost:9002/v1/login`
 - login disponível  - http://localhost:9002/v1/login
 - logar - `curl -X POST -d '{"login":"cliente@email.com", "senha":"123"}' http://localhost:9002/v1/auth`
