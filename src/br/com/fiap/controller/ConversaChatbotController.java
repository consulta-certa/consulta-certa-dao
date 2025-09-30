package br.com.fiap.controller;

import br.com.fiap.model.dao.ConversaChatbotDAO;
import br.com.fiap.model.entity.ConversaChatbot;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.List;

public class ConversaChatbotController {
    private final ConversaChatbotDAO dao;

    public ConversaChatbotController() {
        this.dao = new ConversaChatbotDAO();
    }

    // CREATE
    public void inserirConversaChatbot(String idConversaString, String pergunta, int aprovacaoInt) {
        if (
                !Validacao.validarInteger(idConversaString) ||
                !Validacao.validarTexto(pergunta)
        ) {
            return;
        }

        int idConversa = Integer.parseInt(idConversaString);
        String aprovacao = "N";

        if (aprovacaoInt == 0) {
            aprovacao = "S";
        }

        ConversaChatbot conversa = new ConversaChatbot(idConversa, pergunta, aprovacao);
        JOptionPane.showMessageDialog(null, dao.inserir(conversa));
    }

    // READ
    public void lerConversaChatbot() {
        int continuar;
        int contador = 0;
        List<ConversaChatbot> conversasSelecionadas = dao.selecionar();

        int quantSelecionados = conversasSelecionadas.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, conversasSelecionadas.get(contador), "RESULTADOS DA QUERY EM conversas_chatbot", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarConversaChatbot(String pergunta, int aprovacaoInt, String idConversaString) {
        if (
            !Validacao.validarInteger(idConversaString) ||
            !Validacao.validarTexto(pergunta)
        ) {
            return;
        }

        int idConversa = Integer.parseInt(idConversaString);
        String aprovacao = "N";

        if (aprovacaoInt == 0) {
            aprovacao = "S";
        }

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