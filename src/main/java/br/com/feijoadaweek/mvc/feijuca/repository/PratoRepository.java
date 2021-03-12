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

//	List<Prato> findByRestaurante(String slug);
	
//	public List<Prato> findAll();
	
//	public Prato findById(int id) {
//		
//		Prato prato = entityManager.find(Prato.class, id);
//		
//		return prato;
//	}
//	
//	public List<Prato> findByRestaurante(Restaurante restaurante) {		
//		Query query = entityManager.createQuery("SELECT p FROM Prato p WHERE p.restaurante = :restaurante ORDER BY data DESC ", Prato.class);
//		query.setParameter("restaurante", restaurante);
//		
//		return query.getResultList();
//	}
}
