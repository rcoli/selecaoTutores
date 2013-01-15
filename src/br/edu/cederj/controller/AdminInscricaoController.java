package br.edu.cederj.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.edu.cederj.model.Inscricao;
import br.edu.cederj.service.ConcursoService;
import br.edu.cederj.service.InscricaoService;

@Controller
public class AdminInscricaoController extends GenericController {

	@Autowired
	private InscricaoService inscricaoService;	
	@Autowired
	private ConcursoService concursoService;	

	private ModelAndView mv = new ModelAndView();	

	@RequestMapping("/admin/inscricao")
	public ModelAndView listagem() {
		mv.addObject("inscricoes", inscricaoService.listar());
		mv.addObject("qtdRegistrosTotais", inscricaoService.listar().size());
		mv.setViewName("admin/inscricao/index");
		return mv;
	}
	/* VISUALIZACAO */
	@RequestMapping(value = "/admin/inscricao/visualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView visualizacao(@PathVariable Long id,	@ModelAttribute("inscricao") Inscricao inscricao) {
		inscricao = inscricaoService.listarPorId(id);
		mv.addObject("inscricao", inscricao);
		mv.setViewName("admin/inscricao/visualizacao");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/inscricao/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(@PathVariable Long id,	@ModelAttribute("inscricao") Inscricao inscricao) {
		inscricao = inscricaoService.listarPorId(id);
		mv.addObject("inscricao", inscricao);
		mv.setViewName("admin/inscricao/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/inscricao/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request, @ModelAttribute("inscricao") Inscricao inscricao)
			throws ServletRequestBindingException {
		limparMensagens();
		
		Long inscricaoId = ServletRequestUtils.getLongParameter(
				request, "idInscricao");

		try {
			inscricao = inscricaoService.listarPorId(inscricaoId);
			inscricaoService.apagar(inscricao);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/inscricao");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("redirect:/admin/inscricao/exclusao/" + inscricao.getId());
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}