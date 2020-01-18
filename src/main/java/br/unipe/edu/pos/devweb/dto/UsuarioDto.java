package br.unipe.edu.pos.devweb.dto;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class UsuarioDto {
	private Long id;
	private String username;
	private String password;

	@JsonIgnoreProperties("usuario")
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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
