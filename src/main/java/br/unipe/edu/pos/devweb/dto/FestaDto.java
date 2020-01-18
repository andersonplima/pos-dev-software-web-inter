package br.unipe.edu.pos.devweb.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class FestaDto {
	private Long id;
	private String nome;
	private String tema;
	private Float valor;	
	private TipoFestaDto tipoFesta;
	
	@JsonIgnoreProperties("festas")
	private UsuarioDto usuario;
	
	@JsonIgnoreProperties("festas")
	private ClienteDto cliente;	
	
	public ClienteDto getCliente() {
		return cliente;
	}

	public void setCliente(ClienteDto cliente) {
		this.cliente = cliente;
	}

	public TipoFestaDto getTipoFesta() {
		return tipoFesta;
	}

	public void setTipoFesta(TipoFestaDto tipoFesta) {
		this.tipoFesta = tipoFesta;
	}

	public UsuarioDto getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioDto usuario) {
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
