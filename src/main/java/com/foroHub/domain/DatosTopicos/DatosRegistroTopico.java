package com.foroHub.domain.DatosTopicos;

import jakarta.validation.constraints.NotBlank;

public record DatosRegistroTopico(
        @NotBlank
        String mensaje,
        @NotBlank
        String nombre_curso,
        @NotBlank
        String titulo
) {
}