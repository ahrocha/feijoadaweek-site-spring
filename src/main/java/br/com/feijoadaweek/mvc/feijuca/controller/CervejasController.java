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

import br.com.feijoadaweek.mvc.feijuca.model.Cerveja;
import br.com.feijoadaweek.mvc.feijuca.model.Prato;
import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;
import br.com.feijoadaweek.mvc.feijuca.repository.CervejaRepository;

@Controller
@RequestMapping("cervejas")
public class CervejasController {

	@Autowired
	private CervejaRepository cervejaRepository;

	@GetMapping(value={"","/"})
	public String index(Model model) {

		List<Cerveja> cervejas = cervejaRepository.findAll();
		
		model.addAttribute("cervejas", cervejas);
		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/cervejas");

		return "cervejas";
	}
}
