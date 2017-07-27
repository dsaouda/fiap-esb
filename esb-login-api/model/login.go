package model

import "github.com/satori/go.uuid"

type Login struct {
	Uuid      	uuid.UUID  	`json:"uuid"`
	UuidCliente uuid.UUID 	`json:"cliente_uuid" form:"cliente_uuid" binding:"required"`
	CpfCliente 	string		`json:"cliente_cpf" form:"cliente_cpf" binding:"required"`
	Login      	string     	`json:"login" form:"login" binding:"required"`
	Senha    	string     	`json:"senha" form:"senha" binding:"required"`
}
