package br.com.feijoadaweek.mvc.feijuca.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.feijoadaweek.mvc.feijuca.model.Prato;
//import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;
import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer>{

	public List<Prato> findTop10ByOrderByDataDesc();

	public List<Prato> findByRestaurante(Restaurante restaurante);

}
