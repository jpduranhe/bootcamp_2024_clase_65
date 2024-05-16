
package cl.bootcamp.clase_65.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import cl.bootcamp.clase_65.dao.UsuarioDao;
import cl.bootcamp.clase_65.model.Usuario;


@Repository
public class UsuarioDaoImpl implements UsuarioDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Usuario getByEmail(String email) {
		try{
			
			String sql="select nombre,email, clave from usuario where email='"+email+"'";
			Usuario user=jdbcTemplate.queryForObject(sql,
					(rs,rownum)->{
									Usuario usuario= new Usuario();
									usuario.setEmail(rs.getString("email"));
									usuario.setNombre(rs.getString("nombre"));
									usuario.setClave(rs.getString("clave"));
									return usuario;
								 }
					);
			return user;
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
			return null;
		}
	}

}
