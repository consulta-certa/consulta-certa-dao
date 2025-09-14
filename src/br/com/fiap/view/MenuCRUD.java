package br.com.fiap.view;

import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class MenuCRUD {
    public static void iniciarMenu (Runnable criar, Runnable selecionar, Runnable atualizar, Runnable deletar){
        String opcao;
        int opcaoSelecionada = 0;

        do {
            opcao = JOptionPane.showInputDialog(null, "Escolha um número entre 1 e 5:\n1. Inserir dados na tabela\n2. Selecionar dados da tabela\n3. Atualizar dados da tabela\n4. Excluir dados da tabela\n5. Voltar ao menu", "OPERAÇÕES CRUD", JOptionPane.QUESTION_MESSAGE);

            if (Validacao.validarInteger(opcao)) {
                opcaoSelecionada = Integer.parseInt(opcao);

                if (opcaoSelecionada > 0 && opcaoSelecionada < 6){
                    switch (opcaoSelecionada) {
                        case 1:
                            criar.run();
                            opcaoSelecionada = 0;
                            break;
                        case 2:
                            selecionar.run();
                            opcaoSelecionada = 0;
                            break;
                        case 3:
                            atualizar.run();
                            opcaoSelecionada = 0;
                            break;
                        case 4:
                            deletar.run();
                            opcaoSelecionada = 0;
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Voltando ao menu");
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Escolha apenas um número inteiro entre 1 e 5.");
            }
        } while (opcaoSelecionada < 1 || opcaoSelecionada > 5);
    }
}
