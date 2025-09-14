package br.com.fiap.controller;

import br.com.fiap.model.dao.AvaliacaoDAO;
import br.com.fiap.model.entity.Avaliacao;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AvaliacaoController {
    private final AvaliacaoDAO dao;

    public AvaliacaoController() {
        this.dao = new AvaliacaoDAO();
    }

    // CREATE
    public void inserirAvaliacao(String idAvaliacaoString, String notaString, String comentario, String dataAvaliacaoString, String idLembreteString) {
        if (
            !Validacao.validarInteger(idAvaliacaoString) ||
            !Validacao.validarInteger(notaString) ||
            !Validacao.validarNome(comentario) ||
            !Validacao.validarData(dataAvaliacaoString) ||
            !Validacao.validarInteger(idLembreteString)
        ) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        int nota = Integer.parseInt(notaString);
        LocalDateTime dataAvaliacao = LocalDateTime.parse(dataAvaliacaoString, DataFormatter.formatter);
        int idLembrete = Integer.parseInt(idLembreteString);

        Avaliacao avaliacao = new Avaliacao(idAvaliacao, nota, comentario, dataAvaliacao, idLembrete);
        JOptionPane.showMessageDialog(null, dao.inserir(avaliacao));
    }

    // READ
    public void lerAvaliacao(String idAvaliacaoString) {
        if (!Validacao.validarInteger(idAvaliacaoString)) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        JOptionPane.showMessageDialog(null, dao.selecionar(idAvaliacao));
    }

    // UPDATE
    public void atualizarAvaliacao(String idAvaliacaoString, String notaString, String comentario, String dataAvaliacaoString, String idLembreteString) {
        if (
            !Validacao.validarInteger(idAvaliacaoString) ||
            !Validacao.validarInteger(notaString) ||
            !Validacao.validarNome(comentario) ||
            !Validacao.validarData(dataAvaliacaoString) ||
            !Validacao.validarInteger(idLembreteString)
        ) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        int nota = Integer.parseInt(notaString);
        LocalDateTime dataAvaliacao = LocalDateTime.parse(dataAvaliacaoString, DataFormatter.formatter);
        int idLembrete = Integer.parseInt(idLembreteString);

        Avaliacao avaliacao = new Avaliacao(idAvaliacao, nota, comentario, dataAvaliacao, idLembrete);
        JOptionPane.showMessageDialog(null, dao.atualizar(avaliacao));
    }

    // DELETE
    public void deletarAvaliacao(String idAvaliacaoString) {
        if (!Validacao.validarInteger(idAvaliacaoString)) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        JOptionPane.showMessageDialog(null, dao.deletar(idAvaliacao));
    }
}