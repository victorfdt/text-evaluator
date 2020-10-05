package nl.elros.textevaluator.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import nl.elros.textevaluator.entity.Evaluation;
import nl.elros.textevaluator.repository.EvaluationRepository;

@Controller
@RequestMapping("/evaluation")
public class EvaluationController {

	private EvaluationRepository evaluationRepository;

	public EvaluationController(EvaluationRepository evaluationRepository) {
		this.evaluationRepository = evaluationRepository;
	}

	@GetMapping("/list")
	public String list(Model model) {

		List<Evaluation> evaluations = evaluationRepository.findAll();
		model.addAttribute("evaluations", evaluations);

		return "evaluation/list";
	}

	@GetMapping("/createForm")
	public String createForm(Model model) {

		Evaluation evaluation = new Evaluation();
		model.addAttribute("evaluation", evaluation);

		return "evaluation/form";
	}

	@PostMapping("/save")
	public String save(@Valid Evaluation evaluation, BindingResult result, Model model) {
		
		System.out.println(result.toString());
		
		if (result.hasErrors()) {
			
			return "evaluation/form";
		}

		evaluationRepository.save(evaluation);

		// use a redirect to prevent duplicate submissions
		return "redirect:/evaluation/list";
	}

	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("evaluationId") int evaluationId, Model model) {
		Optional<Evaluation> evaluation = evaluationRepository.findById(evaluationId);

		if (evaluation.isEmpty()) {
			throw new RuntimeException("It was not possible to find user by id: " + evaluationId);

		}
		model.addAttribute("evaluation", evaluation.get());

		return "evaluation/form";
	}
	
	@GetMapping("/delete")
	public String delete(@RequestParam("evaluationId") int evaluationId) {
		evaluationRepository.deleteById(evaluationId);
		
		return "redirect:/evaluation/list";
	}
}
