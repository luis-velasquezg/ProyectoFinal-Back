package co.edu.udea.conficiet.api.model;


import lombok.*;
;

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
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Maquina implements Serializable {

    @Id
//    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
//    @Column(name = "marca")
    private String marca;

    @NotNull
    @NotBlank
    @Size(max = 45)
//    @Column(name = "modelo")
    private String modelo;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
//    @Column(name = "tipo")
    private String tipo;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
//    @Column(name = "estado")
    private String estado;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
//    @Column(name = "ubicacion")
    private String ubicacion;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
//    @Column(name = "precio_compra")
    private double precioCompra;

    @NotNull
    @NotBlank
//    @Column(name = "recibo_compra")
    private int reciboCompra;

    @NotNull
    @NotBlank
//    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;


//    @Column(name = "fecha_venta")
    private LocalDateTime fechaVenta;

    @JoinColumn(name = "vendedor", nullable = true)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Usuario vendedor;


}
