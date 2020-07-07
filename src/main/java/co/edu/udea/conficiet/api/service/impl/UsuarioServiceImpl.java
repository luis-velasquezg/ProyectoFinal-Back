package co.edu.udea.conficiet.api.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioRequestDTO;
import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioResponseDTO;
import co.edu.udea.conficiet.api.model.Usuario;
import co.edu.udea.conficiet.api.repository.UsuarioRepository;
import co.edu.udea.conficiet.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository usuarioRepository;
	private List <Usuario> usuarios;
	private List<UsuarioResponseDTO> usuariosResponseDTO;
	private UsuarioResponseDTO usuarioResponseDTO;
	
	public UsuarioServiceImpl (UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario crear(@NotNull UsuarioRequestDTO usuarioACrearDTO) {
		Usuario usuarioACrear = UsuarioRequestDTO.toModel(usuarioACrearDTO);
		Usuario usuarioCreado = usuarioRepository.save(usuarioACrear);
		return usuarioCreado;
	}

	@Override
	public List<UsuarioResponseDTO> listar() {
		usuarioResponseDTO = new UsuarioResponseDTO();
		usuariosResponseDTO = new ArrayList<>();
		usuarios = usuarioRepository.findAll();
		
		for(Usuario usuario : usuarios) {
			usuariosResponseDTO.add(usuarioResponseDTO.fromModel(usuario));
		}
		// TODO Auto-generated method stub
		return usuariosResponseDTO;
	}

	@Override
	@Transactional(readOnly = true)
	public UsuarioResponseDTO buscarPorId(@NotNull int id) {
		Usuario usuarioEncontrado = usuarioRepository.findUsuarioById(id);
		UsuarioResponseDTO usuarioEncontradoDTO= new UsuarioResponseDTO();
		usuarioEncontradoDTO = usuarioEncontradoDTO.fromModel(usuarioEncontrado);
		return usuarioEncontradoDTO;
	}

	@Override
	public UsuarioResponseDTO actualizar(@NotNull int id, @NotNull UsuarioRequestDTO usuarioAActualizarDTO) {
		Usuario usuarioEnBaseDatos = usuarioRepository.findUsuarioById(id);
		
		Usuario usuarioAActualizar = usuarioEnBaseDatos.toBuilder().id(usuarioAActualizarDTO.getId()).nombres(usuarioAActualizarDTO.getNombres())
	            .apellidos(usuarioAActualizarDTO.getApellidos()).rol(usuarioAActualizarDTO.getRol())
	            .usuario(usuarioAActualizarDTO.getUsuario()).contrasenna(usuarioAActualizarDTO.getContrasenna())
	            .telefono(usuarioAActualizarDTO.getTelefono()).estaActivo(usuarioAActualizarDTO.getEstaActivo()).build();
		
		Usuario usuarioActualizado = usuarioRepository.save(usuarioAActualizar);
		
		UsuarioResponseDTO usuarioActualizadoDTO = new UsuarioResponseDTO().fromModel(usuarioActualizado);
		return usuarioActualizadoDTO;
	}

	@Override
	@Transactional()
	public void eliminarPorId(@NotNull int id) {
		usuarioRepository.deleteUsuarioById(id);
		
	}

	@Override
	public UsuarioResponseDTO verificarLogin(@NotNull String usuario, @NotNull String contrasena) {
		
		Usuario usuarioEncontrado = new Usuario();
		usuarioEncontrado = usuarioRepository.findUsuarioByUsuario(usuario);
		if(usuarioEncontrado == null) {
			return null;
		}
		
		String contrasenaUsuarioEncontrado = usuarioEncontrado.getContrasenna();
		if(contrasenaUsuarioEncontrado.equals(contrasena)) {
			UsuarioResponseDTO usuarioEncontradoDTO = new UsuarioResponseDTO().fromModel(usuarioEncontrado);
			return usuarioEncontradoDTO;
		}else {
			return null;
		}
		
	}
	
	
	

}
