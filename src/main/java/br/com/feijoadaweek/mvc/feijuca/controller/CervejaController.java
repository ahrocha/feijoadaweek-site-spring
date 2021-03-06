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
import br.com.feijoadaweek.mvc.feijuca.model.Foto;
import br.com.feijoadaweek.mvc.feijuca.model.Prato;
import br.com.feijoadaweek.mvc.feijuca.model.Restaurante;
import br.com.feijoadaweek.mvc.feijuca.repository.CervejaRepository;

@Controller
@RequestMapping("cerveja")
public class CervejaController {

	@Autowired
	private CervejaRepository cervejaRepository;

	@GetMapping("/{slug}")
	public String findBySlug(@PathVariable("slug") String slug, Model model) {

		List<Cerveja> cervejas = cervejaRepository.findBySlug(slug);
		Cerveja cerveja = cervejas.get(0);

		model.addAttribute("cerveja", cerveja);
		model.addAttribute("canonical", "https://www.feijoadaweek.com.br/cerveja/" + slug);

		return "cerveja";
	}
}
