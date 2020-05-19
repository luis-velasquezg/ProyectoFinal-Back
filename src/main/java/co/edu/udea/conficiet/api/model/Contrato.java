package co.edu.udea.conficiet.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "contratos")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Contrato implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    @NotNull
    @NotBlank
    private LocalDateTime fecha;

    @JoinColumn(name = "tipo", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private TipoContrato tipo;

    @JoinColumn(name = "empleado", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.LAZY)
    private Usuario empleado;

}
