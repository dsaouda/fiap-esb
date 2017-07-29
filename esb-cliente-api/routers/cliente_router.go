package routers

import (
	"github.com/gorilla/mux"
	"github.com/dsaouda/fiap-esb/esb-cliente-api/handlers"
)

func Router() *mux.Router {
	r := mux.NewRouter()
	c := handlers.ClienteHandler{}
	r.HandleFunc("/v1/cliente", c.Index).Methods("GET")
	r.HandleFunc("/v1/cliente", c.Store).Methods("POST")
	return r
}

