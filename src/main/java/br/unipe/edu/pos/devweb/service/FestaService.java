package br.unipe.edu.pos.devweb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.unipe.edu.pos.devweb.model.Festa;
import br.unipe.edu.pos.devweb.repository.IFestaRepository;

@Service
public class FestaService extends GenericCrudService<Festa, Long> {
	public List<Festa> retrieveFestaByNome(String nome) {
		return ((IFestaRepository) repository).findFestaByNomeQuery(nome);
	}
	
	public List<Festa> retrieveFestaByValorBetween(float valorInicial, float valorFinal) {
		return ((IFestaRepository) repository).findFestaByValorBetween(valorInicial, valorFinal);
	}
}
