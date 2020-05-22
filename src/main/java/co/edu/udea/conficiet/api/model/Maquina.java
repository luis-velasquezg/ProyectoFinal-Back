package co.edu.udea.conficiet.api.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = "maquinas")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Maquina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    private LocalDateTime fechaCreacion;

    private LocalDateTime fechaVenta;


    @JoinColumn(name = "vendedor", nullable = true)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Usuario vendedor;

}
