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

		return "restaurante";
	}

	@GetMapping("adicionar")
	public String adicionarForm(RequisicaoNovoRestaurante requisicao, Model model) {
		model.addAttribute("mensagem", "Formulário para adicionar GET");
		return "restaurante-adicionar";
	}

	@PostMapping("adicionar")
	public String adicionarAction(@Valid RequisicaoNovoRestaurante requisicao, BindingResult result, Model model ) {
		
		if (result.hasErrors()) {
			model.addAttribute("mensagem", "Erro. Preencha todos os campos.");
			return "restaurante-adicionar-post";
		}

		Restaurante restaurante = requisicao.toRestaurante();
		System.out.println("Restaurante " + restaurante.getNome());
//		restauranteRepository.save(restaurante);

		model.addAttribute("mensagem", "Resultado da inclusão POST");
		return "restaurante-adicionar-post";
	}
}
