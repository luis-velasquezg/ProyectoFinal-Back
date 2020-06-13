package co.edu.udea.conficiet.api.DTO.UsuarioDTO;

import co.edu.udea.conficiet.api.model.Rol;
import co.edu.udea.conficiet.api.model.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioResponseDTO {

	private int id;

	private String nombres;

	private String apellidos;

	private Rol rol;

	private String usuario;

	private String telefono;

	private Boolean estaActivo;

	public static UsuarioResponseDTO fromModel(Usuario usuario) {
		return UsuarioResponseDTO.builder().id(usuario.getId()).nombres(usuario.getNombres())
				.apellidos(usuario.getApellidos()).rol(usuario.getRol()).usuario(usuario.getUsuario())
				.telefono(usuario.getTelefono()).estaActivo(usuario.getEstaActivo()).build();
	}
}
