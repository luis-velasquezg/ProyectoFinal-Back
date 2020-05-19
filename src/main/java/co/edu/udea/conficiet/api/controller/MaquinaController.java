package co.edu.udea.conficiet.api.controller;

import co.edu.udea.conficiet.api.DTO.MaquinaRequestDTO;
import co.edu.udea.conficiet.api.DTO.MaquinaResponseDTO;
import co.edu.udea.conficiet.api.model.Maquina;
import co.edu.udea.conficiet.api.service.MaquinaService;
import io.swagger.annotations.Api;
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
        //LocalDateTime fecha = new LocalDateTime();
        return  ResponseEntity.ok(maquinaService.listar());
    }

    @PostMapping()
    public ResponseEntity<Void> guardar(@Valid @NotNull @RequestBody MaquinaRequestDTO maquinaACrear) {
        Maquina maquinaCreada = maquinaService.crear(maquinaACrear);

        URI location = fromUriString("/api/v1/maquinas").path("/{id}")
                .buildAndExpand(maquinaCreada.getId()).toUri();

        return ResponseEntity.created(location).build();
    }



}

