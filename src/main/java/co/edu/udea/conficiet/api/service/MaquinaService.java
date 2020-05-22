package co.edu.udea.conficiet.api.service;

import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.model.Maquina;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface MaquinaService {

    Maquina crear(@NotNull MaquinaRequestDTO maquinaRequestDTO);

    List<MaquinaResponseDTO> listar();

    Maquina buscarPorId(@NotNull int id);

    Maquina actualizar(@NotNull int id, @NotNull MaquinaRequestDTO maquinaAActualizar);

    void eliminarPorId(@NotNull int id);
}
