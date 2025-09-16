package com.clinica.aba.repository;

import com.clinica.aba.model.Evolucao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface EvolucaoRepository extends JpaRepository<Evolucao, Long> {
    // Busca todas as evoluções de um paciente pelo id
    List<Evolucao> findByPacienteId(Long pacienteId);
}
