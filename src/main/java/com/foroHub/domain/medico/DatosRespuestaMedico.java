package com.foroHub.domain.medico;

import com.foroHub.domain.DatosDireccion.DatosDireccion;

public record DatosRespuestaMedico(
        Long id,
        String nombre,
        String email,
        String telefono,
        String documento,
        DatosDireccion direccion
) {
}
