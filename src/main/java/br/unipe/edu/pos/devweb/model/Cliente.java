package br.unipe.edu.pos.devweb.model;

import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class Cliente {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String cpf;

	@OneToMany(mappedBy = "cliente")
	private Set<Festa> festas;

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

	public Set<Festa> getFestas() {
		return festas;
	}

	public void setFestas(Set<Festa> festas) {
		this.festas = festas;
	}

}
