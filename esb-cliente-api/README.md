# esb-cliente-api

O projeto simula um serviço gerenciamento de cliente (apenas cadastro).

Esse projeto foi feito utilizando golang (https://golang.org/) com o pacote http do gorilla mux (https://github.com/gorilla/mux).

# baixar dependências

`go get`

# testar em desenvolvimento

`go run main.go`

# compilar

`go build`

# rodar projeto compilado

`./esb-cliente-api -host localhost -port 9001`

# usando

POST `curl -X POST -d '{"nome":"Cliente", "cpf":"123"}' http://localhost:9001/v1/cliente`

GET  http://localhost:9001/v1/cliente
