package com.github.dsaouda.fiapesb.model;

public class Checkout {

	private String statusCompra;
	private String urlBoleto;
	private Cliente cliente;
	private Endereco endereco;
	private Produto produto;
	
	public String getStatusCompra() {
		return statusCompra;
	}

	public void setStatusCompra(String statusCompra) {
		this.statusCompra = statusCompra;
	}

	public String getUrlBoleto() {
		return urlBoleto;
	}

	public void setUrlBoleto(String urlBoleto) {
		this.urlBoleto = urlBoleto;
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public Produto getProduto() {
		return produto;
	}
	
	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "Checkout [statusCompra=" + statusCompra + ", urlBoleto=" + urlBoleto + ", cliente=" + cliente
				+ ", endereco=" + endereco + ", produto=" + produto + "]";
	}
}
