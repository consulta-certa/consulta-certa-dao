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
        String idContato = JOptionPane.showInputDialog("Informe o id do novo contato");
        String telefone = JOptionPane.showInputDialog("Informe o telefone do novo contato");
        String email = JOptionPane.showInputDialog("Informe o email do novo contato");
        String numero = JOptionPane.showInputDialog("Informe o número do novo contato");
        String rua = JOptionPane.showInputDialog("Informe a rua do novo contato");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do novo contato");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do novo contato");
        String cep = JOptionPane.showInputDialog("Informe o CEP do novo contato (apenas os números)");
        controller.inserirContato(idContato, telefone, email, numero, rua, bairro, cidade, cep);
    }

    private void coletarSelecao () {
        String idContato = JOptionPane.showInputDialog("Informe o id do novo contato");
        controller.selecionarContato();
    }

    private void coletarAtualizacao () {
        String telefone = JOptionPane.showInputDialog("Informe o telefone do novo contato");
        String email = JOptionPane.showInputDialog("Informe o email do novo contato");
        String numero = JOptionPane.showInputDialog("Informe o número do novo contato");
        String rua = JOptionPane.showInputDialog("Informe a rua do novo contato");
        String bairro = JOptionPane.showInputDialog("Informe o bairro do novo contato");
        String cidade = JOptionPane.showInputDialog("Informe a cidade do novo contato");
        String cep = JOptionPane.showInputDialog("Informe o CEP do novo contato (apenas os números)");
        String idContato = JOptionPane.showInputDialog("Informe o id do novo contato");
        controller.atualizarContato(telefone, email, numero, rua, bairro, cidade, cep, idContato);
    }

    private void coletarRemocao () {
        String idContato = JOptionPane.showInputDialog("Informe o id do novo contato");
        controller.deletarContato(idContato);
    }
}
