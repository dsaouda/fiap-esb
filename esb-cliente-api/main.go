package main

//https://thenewstack.io/make-a-restful-json-api-go/

import (
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
)

func main() {
	//https://github.com/Coderockr/APIVagaFrontend/blob/master/server/server.go
	fmt.Println("Iniciado")
	r := mux.NewRouter()

	ClienteHandler{r}.InitRouter()

	http.ListenAndServe("localhost:8000", r)

}
