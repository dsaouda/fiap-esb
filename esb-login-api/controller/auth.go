package controller

import (
	"github.com/gin-gonic/gin"
	"github.com/dsaouda/fiap-esb/esb-login-api/model"
	"github.com/dsaouda/fiap-esb/esb-login-api/database"
)

func PostAuth(c *gin.Context) {
	var auth model.Auth
	c.BindJSON(&auth)

	login, error := database.Get(auth.Login)
	if error != nil {
		c.JSON(401, "Unauthorized")
		return
	}

	if login.Senha == auth.Senha {
		c.JSON(200, "OK")
		return
	}

	c.JSON(401, "Unauthorized")
}
