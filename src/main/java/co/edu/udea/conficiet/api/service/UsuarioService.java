package co.edu.udea.conficiet.api.service;

import java.util.List;

import javax.validation.constraints.NotNull;

import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioRequestDTO;
import co.edu.udea.conficiet.api.DTO.UsuarioDTO.UsuarioResponseDTO;
import co.edu.udea.conficiet.api.model.Usuario;



public interface UsuarioService {
	
    Usuario crear(@NotNull UsuarioRequestDTO usuarioRequestDTO);

    List<UsuarioResponseDTO> listar();

    UsuarioResponseDTO buscarPorId(@NotNull int id);

    UsuarioResponseDTO actualizar(@NotNull int id, @NotNull UsuarioRequestDTO usuarioAActualizar);

    void eliminarPorId(@NotNull int id);
	
	

}
