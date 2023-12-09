package in.ineuron.controller.security;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import in.ineuron.model.security.UserDetails;
import in.ineuron.service.security.IUserDetailsService;

@Controller
@RequestMapping(value = "/user")
public class UserDetailsController {
	
	@Autowired
	private IUserDetailsService service;
	
	@GetMapping(value = "/register")
	public String showRegistrationPage(@ModelAttribute("userInfo") UserDetails userDetails) {
		return "/customers/user_register";
	}
	
	@PostMapping(value = "/register")
	public String registerUser(@ModelAttribute("userInfo") UserDetails userDetails, Map<String, String> model) {
		String registerStatus = service.register(userDetails);
		model.put("status", registerStatus);
		return "/customers/user_registered_success";
	}
	
}
