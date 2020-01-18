package br.unipe.edu.pos.devweb.model;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Usuario {
	@Id
	@GeneratedValue
	private Long id;
	
	private String username;
	private String password;
	
	@OneToMany(mappedBy = "usuario")
	private Set<Festa> festas;
	
	public Set<Festa> getFestas() {
		return festas;
	}

	public void setFestas(Set<Festa> festas) {
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
