package br.edu.cederj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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

import br.edu.cederj.model.Vaga;
import br.edu.cederj.service.ConcursoService;
import br.edu.cederj.service.DisciplinaService;
import br.edu.cederj.service.PoloService;
import br.edu.cederj.service.VagaService;

@Controller
public class AdminVagaController extends GenericController {

	@Autowired
	private VagaService vagaService;
	@Autowired	
	private PoloService poloService;
	@Autowired
	private DisciplinaService disciplinaService;
	@Autowired
	private ConcursoService concursoService;
	

	private ModelAndView mv = new ModelAndView();

	@RequestMapping("/admin/vaga")
	public ModelAndView listagem() {

		mv.addObject("vagas", vagaService.listar());
		mv.addObject("qtdRegistrosTotais", vagaService.listar().size());
		mv.setViewName("admin/vaga/index");
		return mv;
	}

	/* ADICIONAR */
	@RequestMapping("/admin/vaga/adicao")
	public ModelAndView adicao(@ModelAttribute("vaga") Vaga vaga) {
		
		mv.addObject("polos", poloService.listar());
		mv.addObject("disciplinas", disciplinaService.listar());
		mv.addObject("concursos", concursoService.listar());
		mv.addObject("vaga", vaga);
		mv.setViewName("admin/vaga/adicao");
		return mv;
	}

	@RequestMapping(value = "/admin/vaga/adicionar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid Vaga vaga, BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("vaga", vaga);
			mv.setViewName("admin/vaga/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		vagaService.salvar(vaga);
		mv.setViewName("redirect:/admin/vaga");
		return mv;
	}

	/* ATUALIZAR */
	@RequestMapping(value = "/admin/vaga/atualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView atualizacao(@PathVariable Long id,@ModelAttribute("vaga") Vaga vaga) {
		vaga = vagaService.listarPorId(id);
		mv.addObject("polos", poloService.listar());
		mv.addObject("disciplinas", disciplinaService.listar());
		mv.addObject("concursos", concursoService.listar());
		mv.addObject("vaga", vaga);
		mv.setViewName("admin/vaga/atualizacao");
		return mv;
	}

	@RequestMapping(value = "/admin/vaga/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizar(@Valid Vaga vaga, BindingResult result) {

		limparMensagens();

		if (result.hasErrors()) {
			mv.addObject("vaga", vaga);
			mv.setViewName("admin/vaga/atualizacao");
			return mv;
		}

		vagaService.atualizar(vaga);

		mensagensSucesso.add("Registro atualizado com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());

		mv.setViewName("redirect:/admin/vaga");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/vaga/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(@PathVariable Long id,@ModelAttribute("vaga") Vaga vaga) {
		vaga = vagaService.listarPorId(id);
		mv.addObject("vaga", vaga);
		mv.setViewName("admin/vaga/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/vaga/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request,@ModelAttribute("vaga") Vaga vaga)
			throws ServletRequestBindingException {
		limparMensagens();
		
		Long vagaId = ServletRequestUtils.getLongParameter(
				request, "idVaga");

		try {
			vaga = vagaService.listarPorId(vagaId);
			vagaService.apagar(vaga);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/vaga");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("redirect:/admin/vaga/exclusao/" + vaga.getId());
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}