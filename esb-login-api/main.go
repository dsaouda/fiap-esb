package main

import (
	"github.com/dsaouda/fiap-esb/esb-login-api/server"
	"flag"
	"fmt"
)

func main() {
	port := flag.Int("port", 9002, "porta")
	host := flag.String("host", "localhost", "host")
	flag.Parse()
	listen := fmt.Sprintf("%s:%d", *host, *port)

	s := server.Setup()
	s.Run(listen)
}