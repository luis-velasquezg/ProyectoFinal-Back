package co.edu.udea.conficiet.api.DTO;

import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.model.Usuario;
import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data
@Generated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MaquinaResponseDTO {

    private int id;

    private String marca;

    private String modelo;

    private String tipo;

    private String estado;

    private String ubicacion;

    private double precioCompra;

    private int reciboCompra;

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaVenta;

    private Usuario vendedor;


    public static MaquinaResponseDTO fromModel(Maquina maquina) {
//        return MaquinaResponseDTO.builder().id(maquina.getId()).marca(maquina.getMarca()).modelo(maquina.getModelo())
//                .tipo(maquina.getTipo()).estado(maquina.getEstado())
//                .ubicacion(maquina.getUbicacion).precioCompra(maquina.getPrecioCompra())
//                .reciboCompra(maquina.getReciboCompra()).fechaCreacion(maquina.getFechaCreacion())
//                .fechaVenta(maquina.getFechaVenta()).vendedor(maquina.getVendedor()).build();

        MaquinaResponseDTO maquinaResponseDTO = new  MaquinaResponseDTO();

        maquinaResponseDTO.setId(maquina.getId());
        maquinaResponseDTO.setMarca(maquina.getMarca());
        maquinaResponseDTO.setModelo(maquina.getModelo());
        maquinaResponseDTO.setTipo(maquina.getTipo());
        maquinaResponseDTO.setEstado(maquina.getEstado());
        maquinaResponseDTO.setUbicacion(maquina.getUbicacion());
        maquinaResponseDTO.setPrecioCompra(maquina.getPrecioCompra());
        maquinaResponseDTO.setReciboCompra(maquina.getReciboCompra());
        maquinaResponseDTO.setFechaCreacion(maquina.getFechaCreacion());
        maquinaResponseDTO.setFechaVenta(maquina.getFechaVenta());
        maquinaResponseDTO.setVendedor(maquina.getVendedor());

        return maquinaResponseDTO;

    }

}
