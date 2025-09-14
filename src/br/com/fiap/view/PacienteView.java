package br.com.fiap.view;

import br.com.fiap.controller.PacienteController;

import javax.swing.*;

public class PacienteView {
    private final PacienteController controller;

    public PacienteView () {
        this.controller = new PacienteController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao,this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao () {
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        String nome = JOptionPane.showInputDialog("Informe o nome do paciente");
        String email = JOptionPane.showInputDialog("Informe o email do paciente");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do paciente");
        controller.inserirPaciente(idPaciente, nome, email, telefone);
    }

    private void coletarSelecao () {
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        controller.selecionarPaciente();
    }

    private void coletarAtualizacao () {
        String nome = JOptionPane.showInputDialog("Informe o nome do paciente");
        String email = JOptionPane.showInputDialog("Informe o email do paciente");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do paciente");
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        controller.atualizarPaciente(nome, email, telefone, idPaciente);
    }

    private void coletarRemocao () {
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        controller.deletarPaciente(idPaciente);
    }
}
