package br.com.fiap.view;

import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class MenuCRUD {
    public static void iniciarMenu (Runnable criar, Runnable selecionar, Runnable atualizar, Runnable deletar){
        String opcao;
        int opcaoSelecionada = 0;

        do {
            opcao = JOptionPane.showInputDialog(null, "Escolha um número entre 1 e 4:\n1. Inserir dados na tabela\n2. Selecionar dados da tabela\n3. Atualizar dados da tabela\n4. Excluir dados da tabela", "MENU", JOptionPane.QUESTION_MESSAGE);

            if (Validacao.validarInteger(opcao)) {
                opcaoSelecionada = Integer.parseInt(opcao);

                if (opcaoSelecionada > 0 && opcaoSelecionada < 5){
                    switch (opcaoSelecionada) {
                        case 1:
                            criar.run();
                        case 2:
                            selecionar.run();
                        case 3:
                            atualizar.run();
                        case 4:
                            deletar.run();
                    }
                }

            } else {
                JOptionPane.showMessageDialog(null, "Escolha apenas um número inteiro entre 1 e 4.");
            }
        } while (opcaoSelecionada < 1 || opcaoSelecionada > 4);
    }
}
