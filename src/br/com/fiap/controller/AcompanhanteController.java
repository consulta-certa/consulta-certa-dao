package br.com.fiap.controller;

import br.com.fiap.model.dao.AcompanhanteDAO;
import br.com.fiap.model.entity.Acompanhante;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.List;

public class AcompanhanteController {
    private final AcompanhanteDAO dao;

    public AcompanhanteController() {
        this.dao = new AcompanhanteDAO();
    }

    // CREATE
    public void inserirAcompanhante(String idAcompanhanteString, String nome, String email, String telefone, String parentesco, String idPacienteString) {
        if (
            !Validacao.validarInteger(idAcompanhanteString) ||
            !Validacao.validarTexto(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarTexto(parentesco) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idAcompanhante = Integer.parseInt(idAcompanhanteString);
        int idPaciente = Integer.parseInt(idPacienteString);

        Acompanhante acompanhante = new Acompanhante(idAcompanhante, nome, email, telefone, parentesco, idPaciente);
        JOptionPane.showMessageDialog(null, dao.inserir(acompanhante));
    }

    // READ
    public void lerAcompanhante() {
        int continuar;
        int contador = 0;
        List<Acompanhante> acompanhantesSelecionados = dao.selecionar();

        int quantSelecionados = acompanhantesSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, acompanhantesSelecionados.get(contador), "RESULTADOS DA QUERY EM acompanhantes", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarAcompanhante(String nome, String email, String telefone, String parentesco, String idPacienteString, String idAcompanhanteString) {
        if (
            !Validacao.validarInteger(idAcompanhanteString) ||
            !Validacao.validarTexto(nome) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarTexto(parentesco) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idAcompanhante = Integer.parseInt(idAcompanhanteString);
        int idPaciente = Integer.parseInt(idPacienteString);

        Acompanhante acompanhante = new Acompanhante(idAcompanhante, nome, email, telefone, parentesco, idPaciente);
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