package nl.elros.textevaluator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}

}
