package br.com.fiap.main;

import br.com.fiap.model.util.Validacao;
import br.com.fiap.view.*;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        AcessoFuncionalidadeView acessoFuncionalidadeView = new AcessoFuncionalidadeView();
        AcompanhanteView acompanhanteView = new AcompanhanteView();
        AvaliacaoView avaliacaoView = new AvaliacaoView();
        ConsultaView consultaView = new ConsultaView();
        ContatoView contatoView = new ContatoView();
        ConteudoView conteudoView = new ConteudoView();
        ConversaChatbotView conversaChatbotView = new ConversaChatbotView();
        LembreteView lembreteView = new LembreteView();
        PacienteView pacienteView = new PacienteView();

        String opcao;
        int opcaoValida = 0;
        do {
            opcao = JOptionPane.showInputDialog(null, "Escolha um número entre 0 e 9:\n1. CRUD da tabela acessos_funcionalidade\n2. CRUD da tabela acompanhantes\n3. CRUD da tabela avaliacoes\n4. CRUD da tabela consultas\n5. CRUD da tabela contatos\n6. CRUD da tabela conteudos\n7. CRUD da tabela conversas_chatbot\n8. CRUD da tabela lembretes\n9. CRUD da tabela pacientes\n0. Sair do programa.", "MENU PRINCIPAL", JOptionPane.QUESTION_MESSAGE);

            if (Validacao.validarInteger(opcao)) {
                opcaoValida = Integer.parseInt(opcao);

                if (opcaoValida > -1 && opcaoValida < 10){
                    switch (opcaoValida) {
                        case 1:
                            acessoFuncionalidadeView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 2:
                            acompanhanteView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 3:
                            avaliacaoView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 4:
                            consultaView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 5:
                            contatoView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 6:
                            conteudoView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 7:
                            conversaChatbotView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 8:
                            lembreteView.iniciar();
                            opcaoValida = -1;
                            break;
                        case 9:
                            pacienteView.iniciar();
                            opcaoValida = -1;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Encerrando programa");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Escolha apenas um número inteiro entre 0 e 9.");
            }
        } while (opcaoValida < 0 || opcaoValida > 9);
    }
}