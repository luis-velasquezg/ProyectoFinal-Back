package co.edu.udea.conficiet.api.DTO;

import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.model.Rol;
import co.edu.udea.conficiet.api.model.Usuario;
import lombok.*;

import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Generated
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UsuarioRequestDTO {

    @NotNull
    private int id;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    private String nombres;

    @NotNull
    @NotBlank
    @Size(min = 2, max = 45)
    private String apellidos;

    @NotNull
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
    @NotBlank
    private Boolean estaActivo;


    public static Usuario toModel(UsuarioRequestDTO usuarioACrear) {

        return Usuario.builder().id(usuarioACrear.getId()).nombres(usuarioACrear.getNombres())
            .apellidos(usuarioACrear.getApellidos()).rol(usuarioACrear.getRol())
            .usuario(usuarioACrear.getUsuario()).contrasenna(usuarioACrear.getContrasenna())
            .telefono(usuarioACrear.getTelefono()).estaActivo(usuarioACrear.getEstaActivo()).build();

    }
}
