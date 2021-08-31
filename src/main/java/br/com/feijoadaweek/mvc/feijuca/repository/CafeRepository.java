package br.com.feijoadaweek.mvc.feijuca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feijoadaweek.mvc.feijuca.model.Cafe;
import br.com.feijoadaweek.mvc.feijuca.model.Marca;

@Repository
public interface CafeRepository extends JpaRepository<Cafe, Integer>{

	public List<Cafe> findBySlug(String slug);

	public List<Cafe> findByMarca(Marca marca);

}
