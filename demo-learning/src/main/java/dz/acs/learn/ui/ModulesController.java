package dz.acs.learn.ui;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import dz.acs.learn.model.Modules;

@Controller
@RequestMapping("/ui/modules")
public class ModulesController {
	private static final Logger LOGGER =  LoggerFactory.getLogger(ModulesController.class);
	@GetMapping(path = "/list")
	public String list(ModelMap mm) {
		LOGGER.error("ERROR BLA BLA");
		List<Modules> listModules = new ArrayList<>();
		
		mm.addAttribute("mods", listModules);
		return "modules";
	}

}
