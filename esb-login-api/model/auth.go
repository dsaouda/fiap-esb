package model

type Auth struct {
	Login      	string  `json:"login" form:"login" binding:"required"`
	Senha		string	`json:"senha" form:"senha" binding:"required"`
}