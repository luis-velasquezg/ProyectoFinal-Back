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
    private double precioCompra;

    @NotNull
    private int reciboCompra;

    private LocalDateTime fechaVenta;

    private Usuario vendedor;

    public static Maquina toModel(MaquinaRequestDTO maquinaACrear) {

        return Maquina.builder().marca(maquinaACrear.getMarca()).modelo(maquinaACrear.getModelo())
                .tipo(maquinaACrear.getTipo()).estado(maquinaACrear.getEstado())
                .ubicacion(maquinaACrear.getUbicacion()).precioCompra(maquinaACrear.getPrecioCompra())
                .reciboCompra(maquinaACrear.getReciboCompra()).fechaVenta(maquinaACrear.getFechaVenta())
                .vendedor(maquinaACrear.getVendedor()).build();


//        Maquina maquina = new  Maquina();
//
//        maquina.setId(maquinaACrear.getId());
//        maquina.setMarca(maquinaACrear.getMarca());
//        maquina.setModelo(maquinaACrear.getModelo());
//        maquina.setTipo(maquinaACrear.getTipo());
//        maquina.setEstado(maquinaACrear.getEstado());
//        maquina.setUbicacion(maquinaACrear.getUbicacion());
//        maquina.setPrecioCompra(maquinaACrear.getPrecioCompra());
//        maquina.setReciboCompra(maquinaACrear.getReciboCompra());
//        maquina.setFechaCreacion(maquinaACrear.getFechaCreacion());
//        maquina.setFechaVenta(maquinaACrear.getFechaVenta());
//        maquina.setVendedor(maquinaACrear.getVendedor());
//
//        return maquina;

    }

}
