package com.foroHub.domain.medico;

import com.foroHub.domain.DatosDireccion.DatosDireccion;
import jakarta.validation.constraints.NotNull;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,

        DatosDireccion direccion
) {
}
