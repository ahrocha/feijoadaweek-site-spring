package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;

//import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;

import br.com.feijoadaweek.mvc.feijuca.model.Prato;
//import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;
import br.com.feijoadaweek.mvc.feijuca.repository.PratoRepository;
//import br.com.feijoadaweek.mvc.feijuca.repository.RestauranteRepository;

@Controller
public class OutrosController {
	
	@Autowired
	private PratoRepository pratoRepository;

	@RequestMapping("/outros")
	public String index(Model model) {

		List<Prato> pratos = pratoRepository.findTop10ByFeijoadaOrderByDataDesc(false);
		
		model.addAttribute("pratos", pratos);
		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/");

		return "home";
	}
}
