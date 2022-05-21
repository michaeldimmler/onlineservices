package ch.ethz.id.bi.b3.onlineservices.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import ch.ethz.id.bi.b3.onlineservices.repositories.InputElementRepository;

@Controller
public class InputElementsController {

	private final InputElementRepository inputElementRepository;

	public InputElementsController(InputElementRepository inputElementRepository) {
		super();
		this.inputElementRepository = inputElementRepository;
	}
	
	@RequestMapping("/inputElements")
	public String getInputElement(Model model) {
		model.addAttribute("inputElements", inputElementRepository.findAll());
		return "inputElements";
	}
	
}
