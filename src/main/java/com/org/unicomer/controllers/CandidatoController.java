package com.org.unicomer.controllers;

import com.org.unicomer.UtilResponse;
import com.org.unicomer.models.Candidato;
import com.org.unicomer.services.ICandidatoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class CandidatoController {
    private final ICandidatoService candidatoService;
    @GetMapping("/")
    public ResponseEntity<Object> obtenerCandidatos(@RequestHeader("country") String country){
         try{
                List<Candidato> candidatos = candidatoService.findAllCandidatos(country);
                if (!candidatos.isEmpty())
                    return ResponseEntity.ok(candidatos);
                else
                    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(candidatos);
        }catch (Exception e){
            log.error("Exeception... Error al obtener candidatos"+e.getMessage());
            e.printStackTrace();
            return UtilResponse.generarResponse(HttpStatus.INTERNAL_SERVER_ERROR, "No se obtuvo comunicación... Intente más tarde");
        }
    }
    @PostMapping("/")
    public ResponseEntity<Object> insertarCandidato(@Valid @RequestBody Candidato candidato, @RequestHeader("country") String country){
        try{
                candidato.setCountry(country);
                if (candidatoService.createCandidato(candidato, country).isPresent())
                    return ResponseEntity.ok(candidatoService.createCandidato(candidato, country).get());
                else
                    return UtilResponse.generarResponse(HttpStatus.BAD_REQUEST, "Candidato no creado... Intente más tarde");
        }catch (Exception e){
            log.error("Exeception... Error al crear candidato"+e.getMessage());
            e.printStackTrace();
            return UtilResponse.generarResponse(HttpStatus.INTERNAL_SERVER_ERROR, "No se obtuvo comunicación... Intente más tarde");
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<Object> actualizarCandidato(@Valid @RequestBody Candidato candidato, @RequestHeader("country") String country,
                                                        @PathVariable("id") Integer id){
        try{
            candidato.setId_candidato(id);
        if (candidatoService.updateCandidato(candidato, country).isPresent())
            return ResponseEntity.ok(candidatoService.updateCandidato(candidato, country).get());
        else
            return UtilResponse.generarResponse(HttpStatus.NOT_FOUND, "No se encontró candidato con el id ingresado");
        }catch (Exception e){
        log.error("Exeception... Error al obtener candidatos"+e.getMessage());
        e.printStackTrace();
        return UtilResponse.generarResponse(HttpStatus.INTERNAL_SERVER_ERROR, "No se obtuvo comunicación... Intente más tarde");
        }
    }
}
