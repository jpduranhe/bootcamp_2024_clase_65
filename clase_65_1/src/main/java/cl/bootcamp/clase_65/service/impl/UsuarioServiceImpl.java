package cl.bootcamp.clase_65.service.impl;

import org.springframework.stereotype.Service;

import cl.bootcamp.clase_65.model.Usuario;
import cl.bootcamp.clase_65.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	private Usuario usuario;
	
	public UsuarioServiceImpl() {
		usuario= new Usuario();
		usuario.setEmail("user@correo.cl");
		usuario.setClave("123");
	}
	
	@Override
	public Usuario getByEmail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUserValid(Usuario usuario) {
		boolean  emailValid = this.usuario.getEmail().equals(usuario.getEmail());
		boolean claveValid= this.usuario.getClave().equals(usuario.getClave());
		boolean validacionFinal= emailValid && claveValid;
		return validacionFinal;
	}

}
