package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.feijoadaweek.mvc.feijuca.model.Prato;
import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;
import br.com.feijoadaweek.mvc.feijuca.repository.PratoRepository;
import br.com.feijoadaweek.mvc.feijuca.repository.RestauranteRepository;

@Controller
@RequestMapping("restaurante")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private PratoRepository pratoRepository;

//	@GetMapping("listar")
//	public String hello(Model model) {
//		List<Restaurante> restaurantes = restauranteRepository.findAll();
//	
//		model.addAttribute("restaurantes", restaurantes);
//		model.addAttribute("canonical", "http://www.feijoadaweek.com.br/");
//
//		return "restaurantes";
//	}

	@GetMapping("/{slug}")
	public String findBySlug(@PathVariable("slug") String slug, Model model) {

		List<Restaurante> restaurantes = restauranteRepository.findBySlug(slug);
		Restaurante restaurante = restaurantes.get(0);
		
		List<Prato> pratos = pratoRepository.findByRestaurante(restaurante);

		model.addAttribute("restaurante", restaurante);
		model.addAttribute("pratos", pratos);

		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/restaurante/" + slug);

		return "restaurante";
	}
}
