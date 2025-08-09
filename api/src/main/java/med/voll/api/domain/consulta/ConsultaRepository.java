package med.voll.api.domain.consulta;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
    boolean existByPacienteIdAndFechaBetween(Long idPaciente, LocalDateTime primerHorario, LocalDateTime ultimoHorario); //consultas basicas a mi bd

    boolean existByMedicoIdAndFecha(Long idMedico, LocalDateTime fecha);
}
