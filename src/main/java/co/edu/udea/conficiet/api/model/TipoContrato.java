package co.edu.udea.conficiet.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;;

import javax.persistence.*;
import java.io.Serializable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "tipos_contrato")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class TipoContrato implements Serializable {

    @Id
    private int codigo;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String nombre;


}
