package server

import (
	"github.com/dsaouda/fiap-esb/esb-login-api/router"
	"github.com/gin-gonic/gin"

)

func Setup() *gin.Engine {
	r := gin.Default()
	router.Initialize(r)
	return r
}