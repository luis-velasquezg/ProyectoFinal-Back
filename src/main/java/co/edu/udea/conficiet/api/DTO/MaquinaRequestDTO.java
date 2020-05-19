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
public class MaquinaRequestDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String marca;

    @NotNull
    @NotBlank
    @Size(max = 45)
    private String modelo;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String tipo;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String estado;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String ubicacion;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private double precioCompra;

    @NotNull
    @NotBlank
    private int reciboCompra;

    @NotNull
    @NotBlank
    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaVenta;

    private Usuario vendedor;

    public static Maquina toModel(MaquinaRequestDTO maquinaACrear) {
//        return MaquinaSaveCmd.builder().marca(maquinaACrear.getMarca()).modelo(maquinaACrear.getModelo())
//                .tipo(maquinaACrear.getTipo()).estado(maquinaACrear.getEstado())
//                .ubicacion(maquinaACrear.getUbicacion).precioCompra(maquinaACrear.getPrecioCompra())
//                .reciboCompra(maquinaACrear.getReciboCompra()).fechaCreacion(maquinaACrear.getFechaCreacion())
//                .fechaVenta(maquinaACrear.getFechaVenta()).vendedor(maquinaACrear.getVendedor()).build();

        Maquina maquina = new  Maquina();

        maquina.setMarca(maquinaACrear.getMarca());
        maquina.setModelo(maquinaACrear.getModelo());
        maquina.setTipo(maquinaACrear.getTipo());
        maquina.setEstado(maquinaACrear.getEstado());
        maquina.setUbicacion(maquinaACrear.getUbicacion());
        maquina.setPrecioCompra(maquinaACrear.getPrecioCompra());
        maquina.setReciboCompra(maquinaACrear.getReciboCompra());
        maquina.setFechaCreacion(maquinaACrear.getFechaCreacion());
        maquina.setFechaVenta(maquinaACrear.getFechaVenta());
        maquina.setVendedor(maquinaACrear.getVendedor());

        return maquina;

    }

}
