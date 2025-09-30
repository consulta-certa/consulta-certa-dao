package br.com.fiap.controller;

import br.com.fiap.model.dao.AvaliacaoDAO;
import br.com.fiap.model.entity.Avaliacao;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class AvaliacaoController {
    private final AvaliacaoDAO dao;

    public AvaliacaoController() {
        this.dao = new AvaliacaoDAO();
    }

    // CREATE
    public void inserirAvaliacao(String idAvaliacaoString, String notaString, String comentario, String dataAvaliacaoString) {
        if (
            !Validacao.validarInteger(idAvaliacaoString) ||
            !Validacao.validarInteger(notaString) ||
            !Validacao.validarTexto(comentario) ||
            !Validacao.validarData(dataAvaliacaoString)
        ) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        int nota = Integer.parseInt(notaString);
        LocalDateTime dataAvaliacao = LocalDateTime.parse(dataAvaliacaoString, DataFormatter.formatter);

        // Check constraint
        if (nota < 0 || nota > 5 ) {
            return;
        }

        if (dataAvaliacao.isBefore(LocalDateTime.now().minusDays(14))) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida que seja depois de 14 dias atrás.");
            return;
        }

        Avaliacao avaliacao = new Avaliacao(idAvaliacao, nota, comentario, dataAvaliacao);
        JOptionPane.showMessageDialog(null, dao.inserir(avaliacao));
    }

    // READ
    public void lerAvaliacao() {
        int continuar;
        int contador = 0;
        List<Avaliacao> avaliacoesSelecionadas = dao.selecionar();

        int quantSelecionados = avaliacoesSelecionadas.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, avaliacoesSelecionadas.get(contador), "RESULTADOS DA QUERY EM avaliacoes", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarAvaliacao(String notaString, String comentario, String dataAvaliacaoString, String idAvaliacaoString) {
        if (
            !Validacao.validarInteger(idAvaliacaoString) ||
            !Validacao.validarInteger(notaString) ||
            !Validacao.validarTexto(comentario) ||
            !Validacao.validarData(dataAvaliacaoString)
        ) {
            return;
        }

        int idAvaliacao = Integer.parseInt(idAvaliacaoString);
        int nota = Integer.parseInt(notaString);
        LocalDateTime dataAvaliacao = LocalDateTime.parse(dataAvaliacaoString, DataFormatter.formatter);

        // Check constraint
        if (nota < 0 || nota > 5 ) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir uma nota entre 0 e 5.");
            return;
        }

        if (dataAvaliacao.isBefore(LocalDateTime.now().minusDays(14))) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida que seja depois de 14 dias atrás.");
            return;
        }

        Avaliacao avaliacao = new Avaliacao(idAvaliacao, nota, comentario, dataAvaliacao);
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