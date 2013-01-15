package br.edu.cederj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.cederj.model.Concurso;
import br.edu.cederj.service.ConcursoService;

@Controller
public class AdminConcursoController extends GenericController {

	// return new Redirectview;

	@Autowired
	private ConcursoService concursoService;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping("/admin/concurso")
	public ModelAndView listagem() {

		mv.addObject("concursos", concursoService.listar());
		mv.addObject("qtdRegistrosTotais", concursoService.listar().size());
		mv.setViewName("admin/concurso/index");
		return mv;
	}

	/* ADICIONAR */
	@RequestMapping("/admin/concurso/adicao")
	public ModelAndView adicao(@ModelAttribute("concurso") Concurso concurso) {

		mv.addObject("concurso", concurso);
		mv.setViewName("admin/concurso/adicao");
		return mv;
	}

	@RequestMapping(value = "/admin/concurso/adicionar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid Concurso concurso, BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("concurso", concurso);
			mv.setViewName("admin/concurso/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		concursoService.salvar(concurso);
		mv.setViewName("redirect:/admin/concurso");
		return mv;
	}

	/* ATUALIZAR */
	@RequestMapping(value = "/admin/concurso/atualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView atualizacao(@PathVariable Long id, @ModelAttribute("concurso") Concurso concurso) {
		concurso = concursoService.listarPorId(id);
		mv.addObject("concurso", concurso);
		mv.setViewName("admin/concurso/atualizacao");
		return mv;
	}

	@RequestMapping(value = "/admin/concurso/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizar(@Valid Concurso concurso, BindingResult result)
			throws ServletRequestBindingException {

		limparMensagens();

		if (result.hasErrors()) {
			mv.addObject("concurso", concurso);
			mv.setViewName("admin/concurso/atualizacao");
			return mv;
		}

		concursoService.atualizar(concurso);

		mensagensSucesso.add("Registro atualizado com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());

		mv.setViewName("redirect:/admin/concurso");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/concurso/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(@PathVariable Long id, @ModelAttribute("concurso") Concurso concurso) {
		concurso = concursoService.listarPorId(id);
		mv.addObject("concurso", concurso);
		mv.setViewName("admin/concurso/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/concurso/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request, @ModelAttribute("concurso") Concurso concurso)
			throws ServletRequestBindingException {
		limparMensagens();
		long idConcurso = ServletRequestUtils.getLongParameter(request,"idConcurso");
		try {
			concurso = concursoService.listarPorId(idConcurso);
			concursoService.apagar(concurso);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/concurso");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("/admin/concurso/exclusao/{idConcurso}");
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}