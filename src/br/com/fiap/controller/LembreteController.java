package br.com.fiap.controller;

import br.com.fiap.model.dao.LembreteDAO;
import br.com.fiap.model.entity.Lembrete;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;

public class LembreteController {
    private final LembreteDAO dao;

    public LembreteController() {
        this.dao = new LembreteDAO();
    }

    // CREATE
    public void inserirLembrete(String idLembreteString, String canalEnvio, String dataEnvioString, String idConsultaString) {
        if (!Validacao.validarInteger(idLembreteString) || !Validacao.validarNome(canalEnvio) ||
                !Validacao.validarData(dataEnvioString) || !Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idLembrete = Integer.parseInt(idLembreteString);
        LocalDateTime dataEnvio = LocalDateTime.parse(dataEnvioString, DataFormatter.formatter);
        int idConsulta = Integer.parseInt(idConsultaString);

        Lembrete lembrete = new Lembrete(idLembrete, canalEnvio, dataEnvio, idConsulta);
        JOptionPane.showMessageDialog(null, dao.inserir(lembrete));
    }

    // READ
    public void lerLembrete() {
        JOptionPane.showMessageDialog(null, "Lembrete não encontrado");
    }

    // UPDATE
    public void atualizarLembrete(String idLembreteString, String canalEnvio, String dataEnvioString, String idConsultaString) {
        if (!Validacao.validarInteger(idLembreteString) || !Validacao.validarNome(canalEnvio) ||
                !Validacao.validarData(dataEnvioString) || !Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idLembrete = Integer.parseInt(idLembreteString);
        LocalDateTime dataEnvio = LocalDateTime.parse(dataEnvioString, DataFormatter.formatter);
        int idConsulta = Integer.parseInt(idConsultaString);

        Lembrete lembrete = new Lembrete(idLembrete, canalEnvio, dataEnvio, idConsulta);
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