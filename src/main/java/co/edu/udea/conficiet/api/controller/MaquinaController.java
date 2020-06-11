package co.edu.udea.conficiet.api.controller;

import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.service.MaquinaService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.net.URI;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@RestController
@RequestMapping(path = "api/v1/maquinas", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(tags = {"Maquinas"}, value = "Maquinas")
public class MaquinaController {

    private MaquinaService maquinaService;

    public MaquinaController(MaquinaService maquinaService) {
        this.maquinaService = maquinaService;
    }

    @GetMapping()
    public ResponseEntity<List<MaquinaResponseDTO>> listar(){
        return  ResponseEntity.ok(maquinaService.listar());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<MaquinaResponseDTO> buscarPorId(@Valid @PathVariable("id") @NotNull int id) {
        Maquina maquinaEncontrada = maquinaService.buscarPorId(id);

        if (maquinaEncontrada == null)
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        return ResponseEntity.ok(MaquinaResponseDTO.fromModel(maquinaEncontrada));
    }

    @PostMapping()
    @ResponseStatus(value = HttpStatus.CREATED)
    @CrossOrigin(exposedHeaders = {HttpHeaders.LOCATION})
    public ResponseEntity<Void> guardar(@Valid @NotNull @RequestBody MaquinaRequestDTO maquinaACrear) {
        Maquina maquinaCreada = maquinaService.crear(maquinaACrear);

        URI location = fromUriString("/api/v1/maquinas").path("/{id}")
                .buildAndExpand(maquinaCreada.getId()).toUri();

        return ResponseEntity.created(location).build();
    }


    @PutMapping(path = "/{id}")
    public ResponseEntity<MaquinaResponseDTO> actualizar(@Valid @RequestBody @NotNull MaquinaRequestDTO maquinaAActualizar,
                                                   @Valid @PathVariable("id") @NotNull int id) {
        Maquina maquinaActualizada = maquinaService.actualizar(id, maquinaAActualizar);

        return ResponseEntity.ok(MaquinaResponseDTO.fromModel(maquinaActualizada));
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> eliminar(@Valid @PathVariable("id") @NotNull int id) {
        maquinaService.eliminarPorId(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}

