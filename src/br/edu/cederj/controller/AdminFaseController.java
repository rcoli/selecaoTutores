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

import br.edu.cederj.model.Fase;
import br.edu.cederj.service.ConcursoService;
import br.edu.cederj.service.FaseService;

@Controller
public class AdminFaseController extends GenericController {

	@Autowired
	private FaseService faseService;	
	@Autowired
	private ConcursoService concursoService;	

	private ModelAndView mv = new ModelAndView();
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    dateFormat.setLenient(false);

	    // true passed to CustomDateEditor constructor means convert empty String to null
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
	

	@RequestMapping("/admin/fase")
	public ModelAndView listagem() {
		mv.addObject("fases", faseService.listar());
		mv.addObject("qtdRegistrosTotais", faseService.listar().size());
		mv.setViewName("admin/fase/index");
		return mv;
	}

	/* ADICIONAR */
	@RequestMapping("/admin/fase/adicao")
	public ModelAndView adicao(@ModelAttribute("fase") Fase fase) {		
		mv.addObject("concursos", concursoService.listar());
		mv.addObject("fase", fase);
		mv.setViewName("admin/fase/adicao");
		return mv;
	}

	@RequestMapping(value = "/admin/fase/adicionar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid Fase fase, BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("fase", fase);
			mv.setViewName("admin/fase/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		faseService.salvar(fase);
		mv.setViewName("redirect:/admin/fase");
		return mv;
	}

	/* ATUALIZAR */
	@RequestMapping(value = "/admin/fase/atualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView atualizacao(@PathVariable Long id,@ModelAttribute("fase") Fase fase) {
		fase = faseService.listarPorId(id);
		
		mv.addObject("concursos", concursoService.listar());
		mv.addObject("fase", fase);
		mv.setViewName("admin/fase/atualizacao");
		return mv;
	}

	@RequestMapping(value = "/admin/fase/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizar(@Valid Fase fase, BindingResult result) {

		limparMensagens();

		if (result.hasErrors()) {
			mv.addObject("fase", fase);
			mv.setViewName("admin/fase/atualizacao");
			return mv;
		}

		faseService.atualizar(fase);

		mensagensSucesso.add("Registro atualizado com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());

		mv.setViewName("redirect:/admin/fase");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/fase/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(@PathVariable Long id,	@ModelAttribute("fase") Fase fase) {
		fase = faseService.listarPorId(id);
		mv.addObject("fase", fase);
		mv.setViewName("admin/fase/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/fase/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request, @ModelAttribute("fase") Fase fase)
			throws ServletRequestBindingException {
		limparMensagens();
		
		Long faseId = ServletRequestUtils.getLongParameter(request, "idFase");

		try {
			fase = faseService.listarPorId(faseId);
			faseService.apagar(fase);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/fase");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("redirect:/admin/fase/exclusao/" + fase.getId());
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}