package cl.bootcamp.clase_65.service;

import cl.bootcamp.clase_65.model.Usuario;

public interface UsuarioService {
	
	Usuario getByEmail(String email);

	boolean isUserValid(Usuario usuario);
}
