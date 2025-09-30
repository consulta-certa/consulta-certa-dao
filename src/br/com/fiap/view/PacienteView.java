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
        int acompanhante = JOptionPane.showConfirmDialog(null, "O paciente tem acompanhante?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        controller.inserirPaciente(idPaciente, nome, email, telefone, acompanhante);
    }

    private void coletarSelecao () {
        controller.selecionarPaciente();
    }

    private void coletarAtualizacao () {
        String nome = JOptionPane.showInputDialog("Informe o nome do paciente");
        String email = JOptionPane.showInputDialog("Informe o email do paciente");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do paciente");
        int acompanhante = JOptionPane.showConfirmDialog(null, "O paciente tem acompanhante?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        controller.atualizarPaciente(nome, email, telefone, acompanhante, idPaciente);
    }

    private void coletarRemocao () {
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente");
        controller.deletarPaciente(idPaciente);
    }
}
