package main

import (
	"github.com/dsaouda/fiap-esb/esb-login-api/server"
)

func main() {
	s := server.Setup()
	s.Run("localhost:9002")
}