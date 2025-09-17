package br.com.fiap.controller;

import br.com.fiap.model.dao.AcompanhanteDAO;
import br.com.fiap.model.entity.Acompanhante;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class AcompanhanteController {
    private final AcompanhanteDAO dao;

    public AcompanhanteController() {
        this.dao = new AcompanhanteDAO();
    }

    // CREATE
    public void inserirAcompanhante(String idAcompanhanteString, String email, String telefone, String parentesco, String idPacienteString) {
        if (!Validacao.validarInteger(idAcompanhanteString) || !Validacao.validarEmail(email) ||
                !Validacao.validarTelefone(telefone) || !Validacao.validarNome(parentesco) ||
                !Validacao.validarInteger(idPacienteString)) {
            return;
        }

        int idAcompanhante = Integer.parseInt(idAcompanhanteString);
        int idPaciente = Integer.parseInt(idPacienteString);

        Acompanhante acompanhante = new Acompanhante(idAcompanhante, email, telefone, parentesco, idPaciente);
        JOptionPane.showMessageDialog(null, dao.inserir(acompanhante));
    }

    // READ
    public void lerAcompanhante() {
        JOptionPane.showMessageDialog(null, dao.selecionar());
    }

    // UPDATE
    public void atualizarAcompanhante(String idAcompanhanteString, String email, String telefone, String parentesco, String idPacienteString) {
        if (!Validacao.validarInteger(idAcompanhanteString) || !Validacao.validarEmail(email) ||
                !Validacao.validarTelefone(telefone) || !Validacao.validarNome(parentesco) ||
                !Validacao.validarInteger(idPacienteString)) {
            return;
        }

        int idAcompanhante = Integer.parseInt(idAcompanhanteString);
        int idPaciente = Integer.parseInt(idPacienteString);

        Acompanhante acompanhante = new Acompanhante(idAcompanhante, email, telefone, parentesco, idPaciente);
        JOptionPane.showMessageDialog(null, dao.atualizar(acompanhante));
    }

    // DELETE
    public void deletarAcompanhante(String idAcompanhanteString) {
        if (!Validacao.validarInteger(idAcompanhanteString)) {
            return;
        }

        int idAcompanhante = Integer.parseInt(idAcompanhanteString);
        JOptionPane.showMessageDialog(null, dao.deletar(idAcompanhante));
    }
}