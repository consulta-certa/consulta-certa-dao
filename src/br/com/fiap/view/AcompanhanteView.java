package br.com.fiap.view;

import br.com.fiap.controller.AcompanhanteController;

import javax.swing.*;

public class AcompanhanteView {
    private final AcompanhanteController controller;

    public AcompanhanteView() {
        this.controller = new AcompanhanteController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idAcompanhante = JOptionPane.showInputDialog("Informe o id do acompanhante");
        String email = JOptionPane.showInputDialog("Informe o email do acompanhante");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do acompanhante");
        String parentesco = JOptionPane.showInputDialog("Informe o parentesco do acompanhante");
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente associado");
        controller.inserirAcompanhante(idAcompanhante, email, telefone, parentesco, idPaciente);
    }

    private void coletarSelecao() {
        String idAcompanhante = JOptionPane.showInputDialog("Informe o id do acompanhante");
        controller.lerAcompanhante(idAcompanhante);
    }

    private void coletarAtualizacao() {

        String idAcompanhante = JOptionPane.showInputDialog("Informe o id do acompanhante");
        String email = JOptionPane.showInputDialog("Informe o email do acompanhante");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do acompanhante");
        String parentesco = JOptionPane.showInputDialog("Informe o parentesco do acompanhante");
        String idPaciente = JOptionPane.showInputDialog("Informe o id do paciente associado");
        controller.atualizarAcompanhante(idAcompanhante, email, telefone, parentesco, idPaciente);
    }

    private void coletarRemocao() {
        String idAcompanhante = JOptionPane.showInputDialog("Informe o id do acompanhante");
        controller.deletarAcompanhante(idAcompanhante);
    }
}