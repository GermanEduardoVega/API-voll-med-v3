package med.voll.api.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
    Page<Medico> findAllByActivoTrue(Pageable paginacion);


    @Query( """
            SELECT m FROM Medico m
            where m.activo = TRUE
            and
            m.especialidad = :especialidad
            and
            m.id not in (
                select c.medico.id from Consulta c
                where
                c.fecha = :fecha
            and
                c.motivoCancelamiento is null
            )
            order by rand()
            Limit 1
""")
    Medico elegirMedicoAleatorioDisponibleEnLaFecha(Especialidad especialidad, LocalDateTime fecha);


    @Query("""
            select m.activo
            from Medico m
            where
            m.id = :medico
            """)
    Boolean findActivoById(Long medico);
}
