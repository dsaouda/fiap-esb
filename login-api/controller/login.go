package controller

import (
	"github.com/gin-gonic/gin"
	"github.com/dsaouda/fiap-esb/esb-login-api/model"
	"github.com/dsaouda/fiap-esb/esb-login-api/database"
	"github.com/satori/go.uuid"
)

func GetAllLogin(c *gin.Context) {
	c.JSON(200, database.GetAll())
}

func GetLogin(c *gin.Context) {
	c.JSON(501, "Not Implemented")
}

func PostLogin(c *gin.Context) {
	var login model.Login
	c.BindJSON(&login)

	login.Uuid = uuid.NewV4()
	database.Save(login)

	c.JSON(201, login)
}

func PutLogin(c *gin.Context) {
	c.JSON(501, "Not Implemented")
}

func DeleteLogin(c *gin.Context) {
	c.JSON(501, "Not Implemented")
}