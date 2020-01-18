package br.unipe.edu.pos.devweb.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ClienteDto {
	private Long id;
	private String nome;
	private String cpf;
	
	@JsonIgnoreProperties("cliente")
	private Set<FestaDto> festas;
	
	public Set<FestaDto> getFestas() {
		return festas;
	}
	public void setFestas(Set<FestaDto> festas) {
		this.festas = festas;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	
	
}
