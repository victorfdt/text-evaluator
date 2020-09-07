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

import nl.elros.textevaluator.entity.User;
import nl.elros.textevaluator.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserController {

	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		this.userRepository = userRepository;

	}

	@GetMapping("/createForm")
	public String createForm(Model model) {

		User user = new User();
		model.addAttribute("user", user);

		return "user/form";
	}

	@PostMapping("/save")
	public String save(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "user/form";
		}

		userRepository.save(user);

		// use a redirect to prevent duplicate submissions
		return "redirect:/user/list";
	}

	@GetMapping("/updateForm")
	public String updateForm(@RequestParam("userId") int userId, Model model) {
		Optional<User> user = userRepository.findById(userId);

		if (user.isEmpty()) {
			throw new RuntimeException("It was not possible to find user by id: " + userId);

		}
		model.addAttribute("user", user.get());

		return "user/form";
	}

	@GetMapping("/list")
	public String list(Model model) {

		List<User> users = userRepository.findAll();
		model.addAttribute("users", users);

		return "user/list";

	}

	@GetMapping("/delete")
	public String delete(@RequestParam("userId") Integer userId) {
		userRepository.deleteById(userId);

		return "redirect:/user/list";
	}

}
