package main

//https://thenewstack.io/make-a-restful-json-api-go/

import (
	"fmt"
	"github.com/gorilla/mux"
	"net/http"
	"encoding/json"
)

type Cliente struct {
	Uuid string `json:"uuid"`
	Nome string `json:"nome"`
	Cpf string `json:"cpf"`
}

func ClienteHandler(w http.ResponseWriter, r *http.Request) {
	cliente := Cliente{"1", "Diego Saouda", "23063377805"}
	json.NewEncoder(w).Encode(cliente)
}

func main() {
	fmt.Println("Iniciado")
	r := mux.NewRouter()
	r.HandleFunc("/", ClienteHandler)
	r.HandleFunc("/products", ClienteHandler).Methods("POST")

	http.ListenAndServe("localhost:8000", r)

}
