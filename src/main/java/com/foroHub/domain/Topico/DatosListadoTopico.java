package com.foroHub.domain.Topico;

import com.foroHub.domain.DatosTopicos.Topico;

public record DatosListadoTopico(
        Long id,
        String mensaje,
        String nombreCurso,
        String titulo
) {
    public DatosListadoTopico(Topico topico) {
        this(topico.getId(), topico.getMensaje(), topico.getNombreCurso(), topico.getTitulo());

    }
}
