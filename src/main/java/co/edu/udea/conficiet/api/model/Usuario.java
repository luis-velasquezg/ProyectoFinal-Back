package co.edu.udea.conficiet.api.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "usuarios")
@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class Usuario implements Serializable {

    @Id
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    private String nombres;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    private String apellidos;

    @JoinColumn(name = "rol", nullable = false)
    @ManyToOne(optional = false,  fetch = FetchType.EAGER)
    private Rol rol;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 45)
    private String usuario;

    @NotNull
    @NotBlank
    @Size(min = 8, max = 45)
    private String contrasenna;

    @Size(min = 7, max = 25)
    private String telefono;

    @NotNull   
    private Boolean estaActivo;
    

}
