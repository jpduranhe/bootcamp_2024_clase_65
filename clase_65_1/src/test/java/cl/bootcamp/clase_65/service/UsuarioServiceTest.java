package cl.bootcamp.clase_65.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import cl.bootcamp.clase_65.dao.UsuarioDao;
import cl.bootcamp.clase_65.model.Usuario;
import cl.bootcamp.clase_65.service.impl.UsuarioServiceImpl;

@SpringBootTest
public class UsuarioServiceTest {

	@Autowired
	UsuarioService usuarioService;
	@MockBean
	UsuarioDao usuario;
	
	@BeforeEach
	void setup() {
		//usuarioService=new UsuarioServiceImpl();
	}
	
	@Test
	void validaUsuario() {
		Usuario usuario= new Usuario();
		
		usuario.setEmail("user@correo.cl");
		usuario.setClave("123");
		boolean result= usuarioService.isUserValid(usuario);
		
		
		Assertions.assertTrue(result);
		
		
	};
	@Test
	void validaUsuarioMalEmail() {
		Usuario usuario= new Usuario();
		
		usuario.setEmail("Otr@correo.cl");
		usuario.setClave("123");
		boolean result= usuarioService.isUserValid(usuario);
		
		
		Assertions.assertFalse(result);
		
		
	};
	@Test
	void validaUsuarioMalClave() {
		Usuario usuario= new Usuario();
		
		usuario.setEmail("user@correo.cl");
		usuario.setClave("987");
		boolean result= usuarioService.isUserValid(usuario);
		
		
		Assertions.assertFalse(result);
		
		
	};
}
