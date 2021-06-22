package br.com.feijoadaweek.mvc.feijuca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feijoadaweek.mvc.feijuca.model.Cerveja;
import br.com.feijoadaweek.mvc.feijuca.model.Marca;
import br.com.feijoadaweek.mvc.feijuca.model.Tipo;

@Repository
public interface CervejaRepository extends JpaRepository<Cerveja, Integer>{

	public List<Cerveja> findBySlug(String slug);

	public List<Cerveja> findByMarca(Marca marca);

	public List<Cerveja> findByTipo(Tipo tipo);

}
