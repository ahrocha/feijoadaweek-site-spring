package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.feijoadaweek.mvc.feijuca.dto.RequisicaoNovoRestaurante;
import br.com.feijoadaweek.mvc.feijuca.model.Foto;
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

	@GetMapping("listar")
	public String hello(Model model) {
		List<Restaurante> restaurantes = restauranteRepository.findAll();
	
		model.addAttribute("restaurantes", restaurantes);

		return "restaurantes";
	}

	@GetMapping("/{slug}")
	public String findBySlug(@PathVariable("slug") String slug, RequisicaoNovoRestaurante requisicao, Model model) {

		List<Restaurante> restaurantes = restauranteRepository.findBySlug(slug);
		Restaurante restaurante = restaurantes.get(0);
		
		List<Prato> pratos = pratoRepository.findByRestaurante(restaurante);

		model.addAttribute("restaurante", restaurante);
		model.addAttribute("pratos", pratos);
System.out.println("DEBUG");
		System.out.println(pratos.get(0).getId());
		
		for(Foto foto : pratos.get(0).getFotos() ) {
			System.out.println(foto.getUrl());
			System.out.println("Prato " + foto.getPrato().getId());
			System.out.println("Restaurante " + foto.getRestaurante().getId());			
		}
//		System.out.println(pratos.get(0).getFotos().get(0).getUrl());
		return "restaurante";
	}
}
