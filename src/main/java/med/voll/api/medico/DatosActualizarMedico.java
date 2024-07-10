package med.voll.api.medico;

import jakarta.validation.constraints.NotNull;
import med.voll.api.DatosDireccion.DatosDireccion;

public record DatosActualizarMedico(
        @NotNull
        Long id,
        String nombre,
        String documento,

        DatosDireccion direccion
) {
}
