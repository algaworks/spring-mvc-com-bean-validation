package com.algaworks.cadastro.controller;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.cadastro.model.Cliente;
import com.algaworks.cadastro.model.Sexo;

@Controller
@RequestMapping("/clientes")
public class ClientesController {

	@RequestMapping(value = "/novo", method = RequestMethod.GET)
	public ModelAndView novo(Cliente cliente) {
		ModelAndView mv = new ModelAndView("CadastroCliente");
		mv.addObject("sexos", Arrays.asList(Sexo.values()));
		return mv;
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result
			, RedirectAttributes attributes) {
		if (result.hasErrors()) {
			return novo(cliente);
		}
		
		ModelAndView mv = new ModelAndView("redirect:/clientes/novo");
		attributes.addFlashAttribute("mensagem", "Cliente salvo com sucesso.");
		return mv;
	}
	
}
