package com.github.dsaouda.fiapesb.model;

public class Checkout {

	private Cliente cliente;
	private Endereco endereco;
	private Produto produto;
	
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
		return "Checkout [cliente=" + cliente + ", endereco=" + endereco + ", produto=" + produto + "]";
	}
}
