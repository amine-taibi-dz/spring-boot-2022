package dz.acs.oauth;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("home")
	public String home(ModelMap mm) {
		String username = SecurityContextHolder.getContext()
				.getAuthentication().getName();
		mm.addAttribute("user", username);
		return "home";
	}
}
