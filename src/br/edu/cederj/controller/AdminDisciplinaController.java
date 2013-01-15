package br.edu.cederj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.cederj.model.Disciplina;
import br.edu.cederj.service.DisciplinaService;

@Controller
@PreAuthorize("hasRole('supervisor')")
public class AdminDisciplinaController extends GenericController {

	@Autowired
	private DisciplinaService disciplinaService;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping("/admin/disciplina")
	public ModelAndView listagem() {
		
		mv.addObject("disciplinas", disciplinaService.listar());
		mv.addObject("qtdRegistrosTotais", disciplinaService.listar().size());
		mv.setViewName("admin/disciplina/index");
		return mv;
	}

	/* ADICIONAR */
	@RequestMapping("/admin/disciplina/adicao")
	public ModelAndView adicao(@ModelAttribute("disciplina") Disciplina disciplina) {

		mv.addObject("disciplina", disciplina);
		mv.setViewName("admin/disciplina/adicao");
		return mv;
	}

	@RequestMapping(value = "/admin/disciplina/adicionar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid Disciplina disciplina,	BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("disciplina", disciplina);
			mv.setViewName("admin/disciplina/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		disciplinaService.salvar(disciplina);
		mv.setViewName("redirect:/admin/disciplina");
		return mv;
	}

	/* ATUALIZAR */
	@RequestMapping(value = "/admin/disciplina/atualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView atualizacao(@PathVariable Long id,@ModelAttribute("disciplina") Disciplina disciplina) {
		disciplina = disciplinaService.listarPorId(id);
		mv.addObject("disciplina", disciplina);
		mv.setViewName("admin/disciplina/atualizacao");
		return mv;
	}

	@RequestMapping(value = "/admin/disciplina/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizar(@Valid Disciplina disciplina,	BindingResult result) throws ServletRequestBindingException {

		limparMensagens();

		if (result.hasErrors()) {
			mv.addObject("disciplina", disciplina);
			mv.setViewName("admin/disciplina/atualizacao");
			return mv;
		}

		disciplinaService.atualizar(disciplina);

		mensagensSucesso.add("Registro atualizado com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());

		mv.setViewName("redirect:/admin/disciplina");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/disciplina/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(@PathVariable Long id,	@ModelAttribute("disciplina") Disciplina disciplina) {
		disciplina = disciplinaService.listarPorId(id);
		mv.addObject("disciplina", disciplina);
		mv.setViewName("admin/disciplina/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/disciplina/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request,	@ModelAttribute("disciplina") Disciplina disciplina)
			throws ServletRequestBindingException {
		limparMensagens();
		long idDisciplina = ServletRequestUtils.getLongParameter(request,"idDisciplina");
		try {
			disciplina = disciplinaService.listarPorId(idDisciplina);
			disciplinaService.apagar(disciplina);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/disciplina");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("/admin/disciplina/exclusao/{idDisciplina}");
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}