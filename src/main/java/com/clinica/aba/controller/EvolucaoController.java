package com.clinica.aba.controller;

import com.clinica.aba.model.Evolucao;
import com.clinica.aba.service.EvolucaoService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/evolucoes")
public class EvolucaoController {

    private final EvolucaoService evolucaoService;

    public EvolucaoController(EvolucaoService evolucaoService) {
        this.evolucaoService = evolucaoService;
    }

    @PostMapping("/{pacienteId}")
    public Evolucao registrar(@PathVariable("pacienteId") Long pacienteId,
                              @RequestBody Map<String, String> body) {
        String profissional = body.get("profissional");
        String observacao = body.get("observacao");
        return evolucaoService.registrarEvolucao(pacienteId, profissional, observacao);
    }

    @GetMapping("/{pacienteId}")
    public List<Evolucao> listar(@PathVariable("pacienteId") Long pacienteId) {
        return evolucaoService.listarEvolucoes(pacienteId);
    }
}
