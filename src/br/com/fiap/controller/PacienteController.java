package br.com.fiap.controller;

import br.com.fiap.model.dao.PacienteDAO;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.List;

public class PacienteController {
    private final PacienteDAO dao;

    public PacienteController() {
        this.dao = new PacienteDAO();
    }

    //  Execução do CREATE
    public void inserirPaciente(String idPacienteString, String nome, String email, String telefone, int acompanhanteInt) {
        if (
            !Validacao.validarInteger(idPacienteString) ||
            !Validacao.validarTexto(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarTelefone(telefone)
        ) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        String acompanhante = "N";

        if (acompanhanteInt == 0) {
            acompanhante = "S";
        }

        Paciente paciente = new Paciente(idPaciente, nome, email, telefone, acompanhante);
        JOptionPane.showMessageDialog(null, dao.inserir(paciente));
    }

    // Execução do READ
    public void selecionarPaciente() {
        int continuar;
        int contador = 0;
        List<Paciente> pacientesSelecionados = dao.selecionar();

        int quantSelecionados = pacientesSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, pacientesSelecionados.get(contador), "RESULTADOS DA QUERY EM pacientes", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // Execução do UPDATE
    public void atualizarPaciente(String nome, String email, String telefone, int acompanhanteInt, String idPacienteString) {
        if (
            !Validacao.validarTexto(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        String acompanhante = "N";

        if (acompanhanteInt == 0) {
            acompanhante = "S";
        }

        Paciente paciente = new Paciente(idPaciente, nome, email, telefone, acompanhante);
        JOptionPane.showMessageDialog(null, dao.atualizar(paciente));
    }

    // Execução do DELETE
    public void deletarPaciente(String idPacienteString) {
        if (!Validacao.validarInteger(idPacienteString)) {
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);
        JOptionPane.showMessageDialog(null, dao.deletar(idPaciente));
    }
}