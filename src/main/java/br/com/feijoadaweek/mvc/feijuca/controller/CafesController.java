package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.feijoadaweek.mvc.feijuca.model.Cafe;
import br.com.feijoadaweek.mvc.feijuca.repository.CafeRepository;

@Controller
@RequestMapping("cafes")
public class CafesController {

	@Autowired
	private CafeRepository cafeRepository;

	@GetMapping(value={"","/"})
	public String index(Model model) {

		List<Cafe> cafes = cafeRepository.findAll();

		model.addAttribute("cafes", cafes);
		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/cafes");

		return "cafes";
	}
}
