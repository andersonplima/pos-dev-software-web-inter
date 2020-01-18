package br.unipe.edu.pos.devweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Festa {
	@Id
	@GeneratedValue
	private Long id;

	private String nome;
	private String tema;
	private Float valor;

	@ManyToOne
	private Usuario usuario;

	@ManyToOne
	private TipoFesta tipoFesta;
	
	@ManyToOne
	private Cliente cliente;	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public TipoFesta getTipoFesta() {
		return tipoFesta;
	}

	public void setTipoFesta(TipoFesta tipoFesta) {
		this.tipoFesta = tipoFesta;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
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

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

}
