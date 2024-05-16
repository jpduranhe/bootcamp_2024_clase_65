package cl.bootcamp.clase_65.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cl.bootcamp.clase_65.model.Usuario;
import cl.bootcamp.clase_65.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	public UsuarioController(UsuarioService usuarioService) {
		this.usuarioService=usuarioService;
	}
	
	@GetMapping("/login")
	public ModelAndView loginGet() {		
		return new ModelAndView("login.jsp");		
	}
	
	@PostMapping("/login")
	public  ModelAndView loginPost(@ModelAttribute Usuario usuario){
		
		boolean result=usuarioService.isUserValid(usuario);
		
		String view="home.jsp";
		if(!result) {
			view="error_login.jsp";
		}
		
		return new ModelAndView(view);
	}
	@GetMapping("/muestra/{email}")
	public ModelAndView muestrausuarioGet(@PathVariable String email) {		
		
		ModelAndView modelAndView=new ModelAndView("muestra-usuario.jsp");
		
		Usuario usuario=usuarioService.getByEmail(email);
		
		modelAndView.addObject("usuario", usuario);
		
		return modelAndView;		
	}

}
