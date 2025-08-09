package med.voll.api.domain.consulta.validaciones;


import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.DatosReservaConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidadorPacienteActivo {

    private PacienteRepository pacienteRepository;

    public void validar(DatosReservaConsulta datos) {
        boolean pacienteEstaActivo = pacienteRepository.findActivoById(datos.idPaciente());

        if (!pacienteEstaActivo) {
            throw new ValidacionException("Consulta no puede ser reservada con pacientes excluidos");
        }
    }
}
