package com.foroHub.controller;

import com.foroHub.domain.DatosTopicos.Topico;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import com.foroHub.domain.DatosTopicos.DatosRegistroTopico;
import com.foroHub.domain.Topico.DatosActualizarTopico;
import com.foroHub.domain.Topico.DatosListadoTopico;
import com.foroHub.domain.DatosTopicos.TopicoRepository;
import com.foroHub.domain.Topico.DatosRespuestaTopico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository TopicoRepository;

    @PostMapping
    public ResponseEntity<DatosRespuestaTopico> registrar(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico,
                                                          UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = TopicoRepository.save(new Topico(datosRegistroTopico));
        DatosRespuestaTopico datosRespuestaTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getMensaje(), topico.getNombreCurso(),
                topico.getTitulo()
        );
        URI url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosListadoTopico>> listadoTopicos(
            @PageableDefault(size = 2) Pageable paginacion) {
        return ResponseEntity.ok(TopicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DatosRespuestaTopico> actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico) {
        Topico topico = TopicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new DatosRespuestaTopico(topico.getId(), topico.getMensaje(), topico.getNombreCurso(),
                topico.getTitulo()
            ));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id) {
        Topico topico = TopicoRepository.getReferenceById(id);
        topico.desactivarTopico();
        return ResponseEntity.noContent().build();
    }


    @GetMapping("/{id}")
    public ResponseEntity<DatosRespuestaTopico> retornaDatosTopico(@PathVariable Long id) {
        Topico topico = TopicoRepository.getReferenceById(id);
        var datosTopico = new DatosRespuestaTopico(
                topico.getId(), topico.getMensaje(), topico.getNombreCurso(),
                topico.getTitulo()

        );
        return ResponseEntity.ok(datosTopico);
    }


}