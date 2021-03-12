package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.feijoadaweek.mvc.feijuca.model.Prato;
import br.com.feijoadaweek.mvc.feijuca.repository.PratoRepository;

@Controller
public class HelloController {
	
	@Autowired
	private PratoRepository pratoRepository;

	@GetMapping("/oba")
	public String hello(Model model) {
		List<Prato> pratos = pratoRepository.findAll();
	
		model.addAttribute("pratos", pratos);

		return "hello";
	}
}
