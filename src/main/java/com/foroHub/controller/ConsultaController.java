package com.foroHub.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.foroHub.domain.consulta.DatosAgendarConsulta;
import com.foroHub.domain.consulta.DatosDetalleConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    @PostMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DatosAgendarConsulta datos) {
        System.out.println(datos);
        return ResponseEntity.ok(new DatosDetalleConsulta(null, null,null,null));
    }

}
