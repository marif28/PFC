package com.clinica.aba.service;

import com.clinica.aba.model.Evolucao;
import com.clinica.aba.model.Paciente;
import com.clinica.aba.repository.EvolucaoRepository;
import com.clinica.aba.repository.PacienteRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class EvolucaoService {

    private final EvolucaoRepository evolucaoRepository;
    private final PacienteRepository pacienteRepository;

    public EvolucaoService(EvolucaoRepository evolucaoRepository, PacienteRepository pacienteRepository) {
        this.evolucaoRepository = evolucaoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    // Registra uma evolução para um paciente
    public Evolucao registrarEvolucao(Long pacienteId, String profissional, String observacao) {
        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));

        Evolucao evolucao = new Evolucao();
        evolucao.setPaciente(paciente);
        evolucao.setProfissional(profissional);
        evolucao.setData(LocalDate.now());
        evolucao.setObservacao(observacao);


        return evolucaoRepository.save(evolucao);
    }

    // Lista todas as evoluções de um paciente
    public List<Evolucao> listarEvolucoes(Long pacienteId) {
        // Busca diretamente no repositório pelo paciente_id
        return evolucaoRepository.findByPacienteId(pacienteId);
    }
}
