package br.com.fiap.view;

import br.com.fiap.controller.ConversaChatbotController;

import javax.swing.*;

public class ConversaChatbotView {
    private final ConversaChatbotController controller;

    public ConversaChatbotView() {
        this.controller = new ConversaChatbotController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        String pergunta = JOptionPane.showInputDialog("Informe a pergunta");
        String aprovacao = JOptionPane.showInputDialog("Informe o status de aprovação da conversa (S se foi aprovada e N se não foi)");
        controller.inserirConversaChatbot(idConversa, pergunta, aprovacao);
    }

    private void coletarSelecao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        controller.lerConversaChatbot(idConversa);
    }

    private void coletarAtualizacao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        String pergunta = JOptionPane.showInputDialog("Informe a pergunta");
        String aprovacao = JOptionPane.showInputDialog("Informe o status de aprovação da conversa (S se foi aprovada e N se não foi)");
        controller.atualizarConversaChatbot(idConversa, pergunta, aprovacao);
    }

    private void coletarRemocao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        controller.deletarConversaChatbot(idConversa);
    }
}