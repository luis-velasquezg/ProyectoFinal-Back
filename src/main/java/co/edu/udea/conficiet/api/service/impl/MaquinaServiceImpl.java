package co.edu.udea.conficiet.api.service.impl;

import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.repository.MaquinaRepository;
import co.edu.udea.conficiet.api.service.MaquinaService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Service
public class MaquinaServiceImpl implements MaquinaService {


    private MaquinaResponseDTO maquinaResponseDTO;
    private List<Maquina> maquinas;
    private List<MaquinaResponseDTO> maquinasResponseDTO;
    private MaquinaRepository maquinaRepository;


    public MaquinaServiceImpl(MaquinaRepository maquinaRepository) {
        this.maquinaRepository = maquinaRepository;
    }

    @Override
    public Maquina crear(@NotNull MaquinaRequestDTO maquinaACrearDTO) {
        Maquina maquinaACrear = MaquinaRequestDTO.toModel(maquinaACrearDTO);
        maquinaACrear.setFechaCreacion(LocalDateTime.now());
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

    @Override
    @Transactional(readOnly = true)
    public Maquina buscarPorId(@NotNull int id) {
        Maquina maquinaEncontrada = maquinaRepository.findMaquinaById(id);

        return maquinaEncontrada;
    }

    @Override
    public Maquina actualizar(@NotNull int id, @NotNull MaquinaRequestDTO maquinaAActualizarDTO) {
        Maquina maquinaEnBaseDatos = buscarPorId(id);

        Maquina maquinaAActualizar = maquinaEnBaseDatos.toBuilder().marca(maquinaAActualizarDTO.getMarca()).modelo(maquinaAActualizarDTO.getModelo())
                .tipo(maquinaAActualizarDTO.getTipo()).estado(maquinaAActualizarDTO.getEstado())
                .ubicacion(maquinaAActualizarDTO.getUbicacion()).precioCompra(maquinaAActualizarDTO.getPrecioCompra())
                .reciboCompra(maquinaAActualizarDTO.getReciboCompra()).fechaVenta(maquinaAActualizarDTO.getFechaVenta())
                .vendedor(maquinaAActualizarDTO.getVendedor()).build();

        Maquina maquinaActualizada = maquinaRepository.save(maquinaAActualizar);

        return maquinaActualizada;
    }

    @Override
    @Transactional()
    public void eliminarPorId(@NotNull int id) {
        maquinaRepository.deleteMaquinaById(id);
    }


}
