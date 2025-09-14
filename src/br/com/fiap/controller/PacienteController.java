package br.com.fiap.controller;

import br.com.fiap.model.dao.PacienteDAO;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;

public class PacienteController {
    private final PacienteDAO pacienteDAO;

    public PacienteController() {
        this.pacienteDAO = new PacienteDAO();
    }

    //  Execução do CREATE
    public void inserirPaciente(String idPacienteString, String nome, String email, String telefoneString) {
        if (
            !Validacao.validarInteger(idPacienteString) ||
            !Validacao.validarNome(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarInteger(telefoneString)
        ) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        int telefone = Integer.parseInt(telefoneString);

        Paciente paciente = new Paciente();
        paciente.setIdPaciente(idPaciente);
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setTelefone(telefone);

        JOptionPane.showMessageDialog(null, pacienteDAO.inserir(paciente));
    }

    // Execução do READ
    public void selecionarPaciente() {

    }

    // Execução do UPDATE
    public void atualizarPaciente(String nome, String email, String telefoneString, String idPacienteString) {
        if (
            !Validacao.validarNome(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarInteger(telefoneString) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        int telefone = Integer.parseInt(telefoneString);

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setTelefone(telefone);
        paciente.setIdPaciente(idPaciente);

        JOptionPane.showMessageDialog(null, pacienteDAO.atualizar(paciente));
    }

    // Execução do DELETE
    public void deletarPaciente(String idPacienteString) {
        if (!Validacao.validarInteger(idPacienteString)) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        JOptionPane.showMessageDialog(null, pacienteDAO.deletar(idPaciente));
    }
}