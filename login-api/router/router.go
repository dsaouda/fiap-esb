package router

import (
	"github.com/dsaouda/fiap-esb/esb-login-api/controller"
	"github.com/gin-gonic/gin"
)

func Initialize(r *gin.Engine) {

	api := r.Group("/v1/login")
	{
		api.GET("", cors, controller.GetAllLogin)
		api.GET("/:id", cors, controller.GetLogin)
		api.POST("", cors, controller.PostLogin)
		api.PUT("/:id", cors, controller.PutLogin)
		api.DELETE("/:id", cors, controller.DeleteLogin)
		api.OPTIONS("", cors)
		api.OPTIONS("/:id", cors)
	}

	apiAuth := r.Group("/v1/auth")
	{
		apiAuth.POST("", cors, controller.PostAuth)
		apiAuth.OPTIONS("", cors)
	}
}

func cors(c *gin.Context) {
	c.Header("Access-Control-Allow-Origin", "*")
	c.Header("Access-Control-Allow-Headers", "access-control-allow-origin, access-control-allow-headers, AnonymousToken")
}
