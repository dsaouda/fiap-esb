package main

import (
	"fmt"
	"flag"
	"net/http"
	"github.com/dsaouda/fiap-esb/esb-cliente-api/routers"
)

func main() {
	port := flag.Int("port", 9001, "porta")
	host := flag.String("host", "localhost", "host")
	flag.Parse()
	listen := fmt.Sprintf("%s:%d", *host, *port)

	r := routers.Router()
	fmt.Printf("listening for HTTP on %s", listen)
	http.ListenAndServe(listen, r)

}
