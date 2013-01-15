package br.edu.cederj.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AdminController {
	
	//@Resource(name = "concursoDao")
	//private STUConcursoDao concursoDao = new STUConcursoDao();

	@RequestMapping("/admin")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		//mv.addObject("concurso",this.concursoDao.findAll(0, 100));
		mv.setViewName("admin/index");
		return mv;
	}
	
/*
	@RequestMapping("/stu")
    public String index(Model model) {
        //model.addAttribute("concurso", this.concursoDao.findAll(0, 100));
        return "stu/index";
    }
	*/
	
	
}