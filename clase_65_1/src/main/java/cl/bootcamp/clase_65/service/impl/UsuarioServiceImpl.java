package cl.bootcamp.clase_65.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.bootcamp.clase_65.dao.UsuarioDao;
import cl.bootcamp.clase_65.model.Usuario;
import cl.bootcamp.clase_65.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	
	@Override
	public Usuario getByEmail(String email) {
		return usuarioDao.getByEmail(email);
	}

	@Override
	public boolean isUserValid(Usuario usuario) {
		//boolean  emailValid = this.usuario.getEmail().equals(usuario.getEmail());
		//boolean claveValid= this.usuario.getClave().equals(usuario.getClave());
		//boolean validacionFinal= emailValid && claveValid;
		return false;// validacionFinal;
	}

}
