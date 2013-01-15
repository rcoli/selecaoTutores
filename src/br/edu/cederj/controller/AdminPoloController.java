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

import br.edu.cederj.model.Polo;
import br.edu.cederj.service.PoloService;

@Controller
public class AdminPoloController extends GenericController {

	@Autowired
	private PoloService poloService;

	private ModelAndView mv = new ModelAndView();

	@RequestMapping("/admin/polo")
	public ModelAndView listagem() {

		mv.addObject("polos", poloService.listar());
		mv.addObject("qtdRegistrosTotais", poloService.listar().size());
		mv.setViewName("admin/polo/index");
		return mv;
	}

	/* ADICIONAR */
	@RequestMapping("/admin/polo/adicao")
	public ModelAndView adicao(@ModelAttribute("polo") Polo polo) {

		mv.addObject("polo", polo);
		mv.setViewName("admin/polo/adicao");
		return mv;
	}

	@RequestMapping(value = "/admin/polo/adicionar", method = RequestMethod.POST)
	public ModelAndView adicionar(@Valid Polo polo, BindingResult result) {

		if (result.hasErrors()) {
			mv.addObject("polo", polo);
			mv.setViewName("admin/polo/adicao");
			return mv;
		}
		mensagensSucesso.add("Registro incluído com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());
		poloService.salvar(polo);
		mv.setViewName("redirect:/admin/polo");
		return mv;
	}

	/* ATUALIZAR */
	@RequestMapping(value = "/admin/polo/atualizacao/{id}", method = RequestMethod.GET)
	public ModelAndView atualizacao(@PathVariable Long id,@ModelAttribute("polo") Polo polo) {
		polo = poloService.listarPorId(id);
		mv.addObject("polo", polo);
		mv.setViewName("admin/polo/atualizacao");
		return mv;
	}

	@RequestMapping(value = "/admin/polo/atualizar", method = RequestMethod.POST)
	public ModelAndView atualizar(@Valid Polo polo, BindingResult result) {

		limparMensagens();

		if (result.hasErrors()) {
			mv.addObject("polo", polo);
			mv.setViewName("admin/polo/atualizacao");
			return mv;
		}

		poloService.atualizar(polo);

		mensagensSucesso.add("Registro atualizado com sucesso!");
		mv.addAllObjects(obterObjetosGlobais());

		mv.setViewName("redirect:/admin/polo");
		return mv;
	}

	/* EXCLUIR */
	@RequestMapping(value = "/admin/polo/exclusao/{id}", method = RequestMethod.GET)
	public ModelAndView exclusao(HttpServletRequest request,@PathVariable Long id,@ModelAttribute("polo") Polo polo) {
		polo = poloService.listarPorId(id);
		mv.addObject("polo", polo);
		mv.setViewName("admin/polo/exclusao");
		return mv;
	}

	@RequestMapping(value = "/admin/polo/excluir", method = RequestMethod.POST)
	public ModelAndView excluir(HttpServletRequest request,@ModelAttribute("polo") Polo polo)
			throws ServletRequestBindingException {
		limparMensagens();
		
		Long poloId = ServletRequestUtils.getLongParameter(
				request, "idPolo");

		//Logger logger = Logger.getLogger("br.edu.cederj");
		//String str = Long.toString(polo.getId());
		//logger.warning(str);
		//logger.warning(polo.getPoloTitulo());

		try {
			polo = poloService.listarPorId(poloId);
			poloService.apagar(polo);
			mensagensSucesso.add("Registro excluído com sucesso!");
			mv.setViewName("redirect:/admin/polo");
		} catch (Exception e) {
			e.printStackTrace();
			mensagensErro.add("Erro ao excluir Registro.");
			mv.setViewName("redirect:/admin/polo/exclusao/" + polo.getId());
		}
		mv.addAllObjects(obterObjetosGlobais());
		return mv;
	}

}