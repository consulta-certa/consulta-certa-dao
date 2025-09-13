package br.com.fiap.view;

import br.com.fiap.controller.EnderecoController;

import javax.swing.*;

public class EnderecoView {
    private final EnderecoController controller;

    public EnderecoView() {
        this.controller = new EnderecoController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao,this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao () {
        String idEndereco = JOptionPane.showInputDialog("Informe o id do novo endereço");
        String numero = JOptionPane.showInputDialog("Informe o número do novo endereço");
        String rua = JOptionPane.showInputDialog("Informe a rua do novo endereço");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do novo endereço");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do novo endereço");
        String cep = JOptionPane.showInputDialog("Informe o CEP do novo endereço (apenas os números)");
        controller.inserirEndereco(idEndereco, numero, rua, bairro, cidade, cep);
    }

    private void coletarSelecao () {
        String idEndereco = JOptionPane.showInputDialog("Informe o id do novo endereço");
        controller.selecionarEndereco();
    }

    private void coletarAtualizacao () {
        String numero = JOptionPane.showInputDialog("Informe o número do novo endereço");
        String rua = JOptionPane.showInputDialog("Informe a rua do novo endereço");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do novo endereço");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do novo endereço");
        String cep = JOptionPane.showInputDialog("Informe o CEP do novo endereço (apenas os números)");
        String idEndereco = JOptionPane.showInputDialog("Informe o id do novo endereço");
        controller.atualizarEndereco(numero, rua, bairro, cidade, cep, idEndereco);
    }

    private void coletarRemocao () {
        String idEndereco = JOptionPane.showInputDialog("Informe o id do novo endereço");
        controller.deletarEndereco(idEndereco);
    }
}
