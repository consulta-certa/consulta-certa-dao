package br.com.fiap.view;

import br.com.fiap.controller.ConsultaController;

import javax.swing.*;

public class ConsultaView {
    private final ConsultaController controller;

    public ConsultaView () {
        this.controller = new ConsultaController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao,this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta");
        String especialidade = JOptionPane.showInputDialog("Informe a especialidade da consulta");
        String dataConsulta = JOptionPane.showInputDialog("Informe a data da consulta no padrão DD/MM/AAAA HH:MM");
        String status = JOptionPane.showInputDialog("Informe status da consulta (A para ativa e I para inativa)");
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente associado");
        controller.inserirConsulta(idConsulta, especialidade, dataConsulta, status, idPaciente);
    }

    private void coletarSelecao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta");
        controller.lerConsulta(idConsulta);    }

    private void coletarAtualizacao () {
        String especialidade = JOptionPane.showInputDialog("Informe a especialidade da consulta");
        String dataConsulta = JOptionPane.showInputDialog("Informe a data da consulta no padrão DD/MM/AAAA HH:MM");
        String status = JOptionPane.showInputDialog("Informe status da consulta (A para ativa e I para inativa)");
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente associado");
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta");
        controller.atualizarConsulta(especialidade, dataConsulta, status, idPaciente, idConsulta);
    }

    private void coletarRemocao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da consulta");
        controller.deletarConsulta(idConsulta);
    }
}