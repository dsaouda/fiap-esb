package database

import (
	"github.com/dsaouda/fiap-esb/esb-login-api/model"
	"errors"
)

var database map[string]model.Login = make(map[string]model.Login)

func Save(login model.Login) {
	database[login.Login] = login
}

func GetAll() map[string]model.Login {
	return database
}

func Get(login string) (model.Login, error) {

	model, key := database[login]

	var erro error

	if key == false {
		erro = errors.New("login nao encontrado")
	}

	return model, erro
}