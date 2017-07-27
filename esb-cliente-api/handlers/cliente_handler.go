package handlers

import (
	"net/http"
	"io/ioutil"
	"encoding/json"
	"regexp"
	"github.com/satori/go.uuid"
)

type ResponseError struct {
	Code int
	Message string
}

type Cliente struct {
	Uuid uuid.UUID `json:"uuid"`
	Nome string `json:"nome"`
	Cpf string `json:"cpf"`
}

type ClienteHandler struct {}

var store map[string]Cliente = make(map[string]Cliente)

func save(cliente Cliente) {
	store[cliente.Cpf] = cliente
}

func (c ClienteHandler) Index(w http.ResponseWriter, r *http.Request) {
	w.Header().Set("Content-Type", "application/json; charset=UTF-8")
	json.NewEncoder(w).Encode(store)
}

func (c ClienteHandler) Store(w http.ResponseWriter, r *http.Request) {
	var cliente Cliente

	body, _ := ioutil.ReadAll(r.Body)

	w.Header().Set("Content-Type", "application/json; charset=UTF-8")

	if err := json.Unmarshal(body, &cliente); err != nil {
		w.WriteHeader(400)
		w.Write([]byte("BadRequest"))
		return
	}

	//remover tudo diferente de números
	cliente.Cpf = regexp.MustCompile("[^0-9]").ReplaceAllString(cliente.Cpf, "")
	cliente.Uuid = uuid.NewV4()


	save(cliente)
	json.NewEncoder(w).Encode(cliente)
}