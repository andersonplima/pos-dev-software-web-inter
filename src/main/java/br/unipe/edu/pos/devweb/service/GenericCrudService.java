package br.unipe.edu.pos.devweb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class GenericCrudService<T, ID> {
	
	@Autowired
	protected JpaRepository<T, ID> repository;
	
	public T Create(T entity) {
		return repository.save(entity);
	}
	
	public List<T> Retrieve() {
		return repository.findAll();
	}
	
	public T RetrieveById(ID id) {
		return repository.getOne(id);
	}
	
	public T Update(T entity) {
		return repository.save(entity);
	}
	
	public void Delete(ID id) {
		repository.deleteById(id);
	}
}
