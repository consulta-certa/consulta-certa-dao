package br.com.fiap.controller;

import br.com.fiap.model.dao.LembreteDAO;
import br.com.fiap.model.entity.Lembrete;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class LembreteController {
    private final LembreteDAO dao;

    public LembreteController() {
        this.dao = new LembreteDAO();
    }

    // CREATE
    public void inserirLembrete(String idLembreteString, String dataEnvioString, String idConsultaString) {
        if (
            !Validacao.validarInteger(idLembreteString) ||
            !Validacao.validarData(dataEnvioString) ||
            !Validacao.validarInteger(idConsultaString)
        ) {
            return;
        }

        int idLembrete = Integer.parseInt(idLembreteString);
        LocalDateTime dataEnvio = LocalDateTime.parse(dataEnvioString, DataFormatter.formatter);
        int idConsulta = Integer.parseInt(idConsultaString);

        // Check constraint
        if (dataEnvio.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }

        Lembrete lembrete = new Lembrete(idLembrete, dataEnvio, idConsulta);
        JOptionPane.showMessageDialog(null, dao.inserir(lembrete));
    }

    // READ
    public void lerLembrete() {
        int continuar;
        int contador = 0;
        List<Lembrete> lembretesSelecionados = dao.selecionar();

        int quantSelecionados = lembretesSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, lembretesSelecionados.get(contador), "RESULTADOS DA QUERY EM lembretes", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarLembrete(String dataEnvioString, String idConsultaString, String idLembreteString) {
        if (!Validacao.validarInteger(idLembreteString) ||
            !Validacao.validarData(dataEnvioString) ||
            !Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idLembrete = Integer.parseInt(idLembreteString);
        LocalDateTime dataEnvio = LocalDateTime.parse(dataEnvioString, DataFormatter.formatter);
        int idConsulta = Integer.parseInt(idConsultaString);

        // Check constraint
        if (dataEnvio.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }


        Lembrete lembrete = new Lembrete(idLembrete, dataEnvio, idConsulta);
        JOptionPane.showMessageDialog(null, dao.atualizar(lembrete));
    }

    // DELETE
    public void deletarLembrete(String idLembreteString) {
        if (!Validacao.validarInteger(idLembreteString)) {
            return;
        }

        int idLembrete = Integer.parseInt(idLembreteString);
        JOptionPane.showMessageDialog(null, dao.deletar(idLembrete));
    }
}