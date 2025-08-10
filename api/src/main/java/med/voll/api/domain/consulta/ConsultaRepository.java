package med.voll.api.domain.consulta;

import med.voll.api.domain.medico.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    Boolean existsByPacienteIdAndFechaBetween(Long paciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario); //consultas basicas a mi bd

    Boolean existsByMedicoIdAndFecha(Long medico, LocalDateTime fecha);
}
