package br.unipe.edu.pos.devweb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.unipe.edu.pos.devweb.model.Festa;

@Repository
public interface IFestaRepository extends JpaRepository<Festa, Long> {
	public List<Festa> findFestaByNome(String nome);
	
	@Query("select f from Festa f where f.nome = :nome")
	public List<Festa> findFestaByNomeQuery(@Param("nome") String nome);
	
	public List<Festa> findFestaByValorBetween(float valorInicial, float valorFinal);
}
