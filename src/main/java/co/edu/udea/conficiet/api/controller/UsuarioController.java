package co.edu.udea.conficiet.api.controller;


import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.service.MaquinaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/usuarios", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Usuarios"}, value = "Usuarios")
public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping()
    public ResponseEntity<List<UsuarioResponseDTO>> listar(){
        return  ResponseEntity.ok(usuarioService.listar());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> buscarPorId(@Valid @PathVariable("id") @NotNull int id) {
        return null;
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = {HttpHeaders.LOCATION})
    public ResponseEntity<Void> guardar(@Valid @NotNull @RequestBody UsuarioRequestDTO usuarioACrear) {
        return null;
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<UsuarioResponseDTO> actualizar(@Valid @RequestBody @NotNull UsuarioRequestDTO usuarioAActualizar,
                                                        @Valid @PathVariable("id") @NotNull int id) {
        return null;
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@Valid @PathVariable("id") @NotNull int id) {
        return null;
    }


}
