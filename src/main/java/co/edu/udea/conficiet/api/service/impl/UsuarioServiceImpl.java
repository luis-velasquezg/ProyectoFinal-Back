package co.edu.udea.conficiet.api.service.impl;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;

import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioRequestDTO;
import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioResponseDTO;
import co.edu.udea.conficiet.api.model.Usuario;
import co.edu.udea.conficiet.api.repository.UsuarioRepository;
import co.edu.udea.conficiet.api.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
	
	private UsuarioRepository usuarioRepository;
	
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario buscarPorId(@NotNull int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Usuario actualizar(@NotNull int id, @NotNull UsuarioRequestDTO usuarioAActualizar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void eliminarPorId(@NotNull int id) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
