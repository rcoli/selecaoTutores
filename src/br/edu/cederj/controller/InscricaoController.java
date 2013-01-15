package br.edu.cederj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.cederj.model.Inscricao;
import br.edu.cederj.service.InscricaoService;
import br.edu.cederj.service.VagaService;
import br.edu.cederj.util.LogonHandler;
import br.edu.cederj.util.UserSession;

@Controller
public class InscricaoController extends GenericController {

	// @Autowired
	// private ConcursoService concursoService;

	@Autowired
	private VagaService vagaService;

	@Autowired
	private InscricaoService inscricaoService;
	
	@Autowired
	private UserSession userSession;

	private ModelAndView mv = new ModelAndView();

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		dateFormat.setLenient(false);

		// true passed to CustomDateEditor constructor means convert empty
		// String to null
		binder.registerCustomEditor(Date.class, new CustomDateEditor(
				dateFormat, true));
	}

	@RequestMapping("/inscricao")
	public ModelAndView index() {
		mv.setViewName("inscricao/index");
		return mv;
	}

	@RequestMapping(value = "/inscricao/login")
	public ModelAndView login(String j_username, Date j_password) {

		Inscricao inscricao = inscricaoService.login(j_username, j_password);

		mv.addObject("inscricao", inscricao);
		
		System.out.println("id");
		System.out.println(inscricao.getId());
		
		if (inscricao.getId() != null) {			
			mv.setViewName("inscricao/inicio");
		} else {
			mv.addObject("vagas", vagaService.listarPorVaga());
			mv.setViewName("inscricao/adicao");
		}
		return mv;
	}

	@RequestMapping(value = "/inscricao/logout")
	public ModelAndView login() {

		inscricaoService.logout();
		// redirect
		mv.setViewName("inscricao/index");
		return mv;

	}

	@RequestMapping("/inscricao/inicio")
	public ModelAndView inicio() {
		mv.setViewName("inscricao/inicio");
		return mv;
	}

	@RequestMapping("/inscricao/adicao")
	public ModelAndView adicao(@ModelAttribute("inscricao") Inscricao inscricao) {
		mv.addObject("inscricao", inscricao);
		mv.addObject("vagas", vagaService.listarPorVaga());
		mv.setViewName("inscricao/adicao");
		return mv;
	}
	
	@RequestMapping("/inscricao/atualiza")
	public ModelAndView atualiza(@ModelAttribute("inscricao") Inscricao inscricao) {
		mv.addObject("inscricao", userSession.getInscricao());
		mv.addObject("vagas", vagaService.listarPorVaga());
		mv.setViewName("inscricao/adicao");
		return mv;
	}

	@RequestMapping("/inscricao/adicionar")
	public ModelAndView adicionar(@Valid Inscricao inscricao,
			BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("inscricao", inscricao);
			mv.addObject("vagas", vagaService.listarPorVaga());
			mv.setViewName("inscricao/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		inscricaoService.salvar(inscricao);
		mv.addObject("inscricao", inscricao);
		mv.setViewName("forward:confirma");
		return mv;
	}	
	
	@RequestMapping("/inscricao/confirma")
	public ModelAndView confirmaInclusao(
			@ModelAttribute("inscricao") Inscricao inscricao) {
		
		mv.addObject("inscricao", inscricao);
		mv.setViewName("inscricao/comprovante");
		return mv;
	}

	@RequestMapping("inscricao/comprovante")
	public ModelAndView comprovante(
			@ModelAttribute("inscricao") Inscricao inscricao) {

		mv.addObject("inscricao", userSession.getInscricao());
		mv.setViewName("inscricao/comprovante");
		return mv;
	}

	@RequestMapping("/logout")
	public ModelAndView logout() {
		mv.setViewName("inscricao/index");
		return mv;
	}
}