package ch.ethz.id.bi.b3.onlineservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.ethz.id.bi.b3.onlineservices.repositories.PageRepository;

@Controller
public class PageController {
	
	private final PageRepository pageRepository;
	
	public PageController(PageRepository pageRepository) {
		super();
		this.pageRepository = pageRepository;
	}

	@RequestMapping("/pages")
	public String getPage(Model model) {
		model.addAttribute("pages", pageRepository.findAll());
		return "pages";
	}

}
