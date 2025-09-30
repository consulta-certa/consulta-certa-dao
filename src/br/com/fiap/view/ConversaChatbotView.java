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
        int aprovacao = JOptionPane.showConfirmDialog(null, "Informe o status de aprovação da conversa (S se foi aprovada e N se não foi)", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        controller.inserirConversaChatbot(idConversa, pergunta, aprovacao);
    }

    private void coletarSelecao() {
        controller.lerConversaChatbot();
    }

    private void coletarAtualizacao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        String pergunta = JOptionPane.showInputDialog("Informe a pergunta");
        int aprovacao = JOptionPane.showConfirmDialog(null, "Informe o status de aprovação da conversa (S se foi aprovada e N se não foi)", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        controller.atualizarConversaChatbot(pergunta, aprovacao, idConversa);
    }

    private void coletarRemocao() {
        String idConversa = JOptionPane.showInputDialog("Informe o id da conversa");
        controller.deletarConversaChatbot(idConversa);
    }
}