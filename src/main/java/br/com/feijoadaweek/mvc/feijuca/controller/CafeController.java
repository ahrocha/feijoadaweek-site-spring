package br.com.feijoadaweek.mvc.feijuca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.feijoadaweek.mvc.feijuca.model.Cafe;
import br.com.feijoadaweek.mvc.feijuca.repository.CafeRepository;

@Controller
@RequestMapping("cafe")
public class CafeController {

	@Autowired
	private CafeRepository cafeRepository;

	@GetMapping("/{slug}")
	public String findBySlug(@PathVariable("slug") String slug, Model model) {

		List<Cafe> cafes = cafeRepository.findBySlug(slug);
		Cafe cafe = cafes.get(0);

		model.addAttribute("cafe", cafe);
		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/cafe/" + slug);

		return "cafe";
	}
}
