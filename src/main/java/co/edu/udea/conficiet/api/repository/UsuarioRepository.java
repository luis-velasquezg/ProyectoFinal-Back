package co.edu.udea.conficiet.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.edu.udea.conficiet.api.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	public Usuario findUsuarioById(int id);
	public void deleteUsuarioById(int id);
	public Usuario findUsuarioByUsuario(String username);

}
