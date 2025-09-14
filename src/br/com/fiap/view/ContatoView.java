package br.com.fiap.view;

import br.com.fiap.controller.ContatoController;

import javax.swing.*;

public class ContatoView {
    private final ContatoController controller;

    public ContatoView() {
        this.controller = new ContatoController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao,this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao () {
        String idContato = JOptionPane.showInputDialog("Informe o id do contato");
        String nome = JOptionPane.showInputDialog("Informe o nome do contato");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do contato");
        String email = JOptionPane.showInputDialog("Informe o email do contato");
        String numero = JOptionPane.showInputDialog("Informe o número do contato");
        String rua = JOptionPane.showInputDialog("Informe a rua do contato");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do contato");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do contato");
        String cep = JOptionPane.showInputDialog("Informe o CEP do contato (apenas os números)");
        controller.inserirContato(idContato, nome, telefone, email, numero, rua, bairro, cidade, cep);
    }

    private void coletarSelecao () {
        String idContato = JOptionPane.showInputDialog("Informe o id do contato");
        controller.selecionarContato();
    }

    private void coletarAtualizacao () {
        String nome = JOptionPane.showInputDialog("Informe o nome do contato");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do contato");
        String email = JOptionPane.showInputDialog("Informe o email do contato");
        String numero = JOptionPane.showInputDialog("Informe o número do contato");
        String rua = JOptionPane.showInputDialog("Informe a rua do contato");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do contato");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do contato");
        String cep = JOptionPane.showInputDialog("Informe o CEP do contato (apenas os números)");
        String idContato = JOptionPane.showInputDialog("Informe o id do contato");
        controller.atualizarContato(nome, telefone, email, numero, rua, bairro, cidade, cep, idContato);
    }

    private void coletarRemocao () {
        String idContato = JOptionPane.showInputDialog("Informe o id do contato");
        controller.deletarContato(idContato);
    }
}
