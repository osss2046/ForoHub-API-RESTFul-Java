package med.voll.api.medico;

import med.voll.api.DatosMedicos.Medico;

public record DatosListadoMedico(
        Long id,
        String nombre,
        String especialidad,
        String documento,
        String email
) {
    public DatosListadoMedico(Medico medico) {
        this(medico.getId(), medico.getNombre(), medico.getEspecialidad().toString(), medico.getDocumento(), medico.getEmail());

    }
}
