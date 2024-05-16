package cl.bootcamp.clase_65.dao;

import cl.bootcamp.clase_65.model.Usuario;

public interface UsuarioDao {
	
	Usuario getByEmail(String email);

}
