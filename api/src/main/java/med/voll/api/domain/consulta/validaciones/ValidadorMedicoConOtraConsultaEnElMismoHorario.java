package med.voll.api.domain.consulta.validaciones;

import med.voll.api.domain.ValidacionException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DatosReservaConsulta;

public class ValidadorMedicoConOtraConsultaEnElMismoHorario {
    private ConsultaRepository consultaRepository;

    public void validar(DatosReservaConsulta datos) {

        var medicoTieneOtraConsultaEnElMismoHorario = consultaRepository.existByMedicoIdAndFecha(
                datos.idMedico(), datos.fecha());

        if (medicoTieneOtraConsultaEnElMismoHorario ) {
            throw new ValidacionException("Médico ya tiene otra consulta en esa misma fecha y hora");
        }
    }
}
