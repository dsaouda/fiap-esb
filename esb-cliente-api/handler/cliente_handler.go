package handler

import (
	"net/http"
	"github.com/gorilla/mux"
	//"encoding/json"
)

type Cliente struct {
	Uuid string `json:"uuid"`
	Nome string `json:"nome"`
	Cpf string `json:"cpf"`
}

type ClienteHandler struct {
	Router *mux.Router
}

func (c *ClienteHandler) InitRouter() {
	c.Router.HandleFunc("/v1/cliente", c.index).Methods("GET")
	c.Router.HandleFunc("/v1/cliente/{uuid:[a-zA-Z0-9\\-]}", c.show).Methods("GET")
	c.Router.HandleFunc("/v1/cliente", c.store).Methods("POST")
	c.Router.HandleFunc("/v1/cliente/{uuid:[a-zA-Z0-9\\-]}", c.update).Methods("PUT")
	c.Router.HandleFunc("/v1/cliente/{uuid:[a-zA-Z0-9\\-]}", c.destroy).Methods("DELETE")
}

func (c ClienteHandler) index(w http.ResponseWriter, r *http.Request) {
	//cliente := Cliente{"1", "Diego Saouda", "23063377805"}
	//json.NewEncoder(w).Encode(cliente)

	//w.Header().Set("Content-Type", "application/json")
	w.Write([]byte("index\n"))
}

func (c ClienteHandler) show(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("show\n"))
}

func (c ClienteHandler) store(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("store\n"))
}

func (c ClienteHandler) update(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("update\n"))
}

func (c ClienteHandler) destroy(w http.ResponseWriter, r *http.Request) {
	w.Write([]byte("destroy\n"))
}