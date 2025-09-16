package com.clinica.aba.controller;

import com.clinica.aba.model.Paciente;
import com.clinica.aba.service.PacienteService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService pacienteService;

    public PacienteController(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }

    @PostMapping
    public Paciente cadastrar(@RequestBody Paciente paciente) {
        return pacienteService.salvar(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Paciente buscar(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }
}
