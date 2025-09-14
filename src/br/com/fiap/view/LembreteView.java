package br.com.fiap.view;

import br.com.fiap.controller.LembreteController;

import javax.swing.*;

public class LembreteView {
    private final LembreteController controller;

    public LembreteView() {
        this.controller = new LembreteController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idLembrete = JOptionPane.showInputDialog("Informe o id do lembrete");
        String canalEnvio = JOptionPane.showInputDialog("Informe o canal de envio do lembrete");
        String dataEnvio = JOptionPane.showInputDialog("Informe a data de envio do lembrete no padrão DD/MM/AAAA HH:MM");
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta associada");
        controller.inserirLembrete(idLembrete, canalEnvio, dataEnvio, idConsulta);
    }

    private void coletarSelecao() {
        String idLembrete = JOptionPane.showInputDialog("Informe o id do lembrete");
        controller.lerLembrete(idLembrete);
    }

    private void coletarAtualizacao() {
        String idLembrete = JOptionPane.showInputDialog("Informe o id do lembrete");
        String canalEnvio = JOptionPane.showInputDialog("Informe o canal de envio do lembrete");
        String dataEnvio = JOptionPane.showInputDialog("Informe a data de envio do lembrete no padrão DD/MM/AAAA HH:MM");
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta associada");
        controller.atualizarLembrete(idLembrete, canalEnvio, dataEnvio, idConsulta);
    }

    private void coletarRemocao() {
        String idLembrete = JOptionPane.showInputDialog("Informe o id do lembrete");
        controller.deletarLembrete(idLembrete);
    }
}