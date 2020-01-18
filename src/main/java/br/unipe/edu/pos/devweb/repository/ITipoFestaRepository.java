package br.unipe.edu.pos.devweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.unipe.edu.pos.devweb.model.TipoFesta;

@Repository
public interface ITipoFestaRepository extends JpaRepository<TipoFesta, Short> {

}
