package br.unipe.edu.pos.devweb.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TipoFesta {
	@Id
	@GeneratedValue
	private Short id;

	@Column(length = 100)
	private String nome;

	@Column(length = 255)
	private String descricao;
	
	@OneToMany(mappedBy = "tipoFesta")
	private Set<Festa> festas;
	
	public Set<Festa> getFestas() {
		return festas;
	}

	public void setFestas(Set<Festa> festas) {
		this.festas = festas;
	}
	
	public Short getId() {
		return id;
	}

	public void setId(Short id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
