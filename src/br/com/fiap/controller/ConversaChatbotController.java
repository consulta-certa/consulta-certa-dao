package br.com.fiap.controller;

import br.com.fiap.model.dao.ConversaChatbotDAO;
import br.com.fiap.model.entity.ConversaChatbot;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class ConversaChatbotController {
    private final ConversaChatbotDAO dao;

    public ConversaChatbotController() {
        this.dao = new ConversaChatbotDAO();
    }

    // CREATE
    public void inserirConversaChatbot(String idConversaString, String pergunta, String aprovacao) {
        if (
                !Validacao.validarInteger(idConversaString) ||
                        !Validacao.validarNome(pergunta) ||
                        !Validacao.validarNome(aprovacao)
        ) {
            return;
        }

        int idConversa = Integer.parseInt(idConversaString);

        ConversaChatbot conversa = new ConversaChatbot(idConversa, pergunta, aprovacao);
        JOptionPane.showMessageDialog(null, dao.inserir(conversa));
    }

    // READ
    public void lerConversaChatbot() {
        JOptionPane.showMessageDialog(null, dao.selecionar());
    }

    // UPDATE
    public void atualizarConversaChatbot(String idConversaString, String pergunta, String aprovacao) {
        if (
                !Validacao.validarInteger(idConversaString) ||
                        !Validacao.validarNome(pergunta) ||
                        !Validacao.validarNome(aprovacao)
        ) {
            return;
        }

        int idConversa = Integer.parseInt(idConversaString);

        ConversaChatbot conversa = new ConversaChatbot(idConversa, pergunta, aprovacao);
        JOptionPane.showMessageDialog(null, dao.atualizar(conversa));
    }

    // DELETE
    public void deletarConversaChatbot(String idConversaString) {
        if (!Validacao.validarInteger(idConversaString)) {
            return;
        }

        int idConversa = Integer.parseInt(idConversaString);
        JOptionPane.showMessageDialog(null, dao.deletar(idConversa));
    }
}