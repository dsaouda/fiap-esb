package com.github.dsaouda.fiapesb.model;

public class Cliente {

	private String id;
	private String loginId;
	private String nome;
	private String cpf;
	private String login;
	private String senha;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getLoginId() {
		return loginId;
	}
	
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", loginId=" + loginId + ", nome=" + nome + ", cpf=" + cpf + ", login=" + login
				+ ", senha=" + senha + "]";
	}
}
