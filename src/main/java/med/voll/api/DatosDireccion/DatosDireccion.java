package med.voll.api.DatosDireccion;
import jakarta.validation.constraints.NotBlank;
import med.voll.api.DatosDireccion.DatosDireccion;
import med.voll.api.DatosMedicos.Especialidad;

public record DatosDireccion(
        @NotBlank
        String calle,
        @NotBlank
        String distrito,
        @NotBlank
        String ciudad,
        @NotBlank
        String numero,
        @NotBlank
        String complemento ) {
}