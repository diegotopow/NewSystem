package br.com.NewSystem.ClienteDTO;

public class ClienteDTO {
	
	
	private String nome_cliente, cpf, email;
	private int id_cliente;

	public String getNome_cliente() {
		return nome_cliente;
	}

	public void setNome_cliente(String nome_funcionario) {
		this.nome_cliente = nome_funcionario;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	
	
}
