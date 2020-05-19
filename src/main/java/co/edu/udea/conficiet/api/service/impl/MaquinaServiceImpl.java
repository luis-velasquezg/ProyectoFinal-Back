package co.edu.udea.conficiet.api.service.impl;

import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.repository.MaquinaRepository;
import co.edu.udea.conficiet.api.service.MaquinaService;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Service
public class MaquinaServiceImpl implements MaquinaService {


    private MaquinaResponseDTO maquinaResponseDTO;
    private List<Maquina> maquinas;
    private List<MaquinaResponseDTO> maquinasResponseDTO;
    private MaquinaRepository maquinaRepository;


    @Override
    public Maquina crear(@NotNull MaquinaRequestDTO maquinaACrearDTO) {

        Maquina maquinaACrear = MaquinaRequestDTO.toModel(maquinaACrearDTO);
        // maquinaRepository.save(maquinaACrear);
        // return maquinaACrear;
        Maquina maquinaCreada = maquinaRepository.save(maquinaACrear);
        return maquinaCreada;

    }

    @Override
    public List<MaquinaResponseDTO> listar() {
        maquinaResponseDTO = new MaquinaResponseDTO();
        maquinasResponseDTO = new ArrayList<>();
        maquinas = maquinaRepository.findAll();

        for(Maquina maquina : maquinas){
            maquinasResponseDTO.add(maquinaResponseDTO.fromModel(maquina));
        }

        return maquinasResponseDTO;
    }
}
