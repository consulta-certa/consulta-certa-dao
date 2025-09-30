package br.com.fiap.view;

import br.com.fiap.controller.AvaliacaoController;

import javax.swing.*;

public class AvaliacaoView {
    private final AvaliacaoController controller;

    public AvaliacaoView() {
        this.controller = new AvaliacaoController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idAvaliacao = JOptionPane.showInputDialog("Informe o id da avaliação");
        String nota = JOptionPane.showInputDialog("Informe a nota da avaliação (de 0 a 5)");
        String comentario = JOptionPane.showInputDialog("Informe o comentário da avaliação");
        String dataAvaliacao = JOptionPane.showInputDialog("Informe a data da avaliação no padrão DD/MM/AAAA HH:MM");

        controller.inserirAvaliacao(idAvaliacao, nota, comentario, dataAvaliacao);
    }

    private void coletarSelecao() {
        controller.lerAvaliacao();
    }

    private void coletarAtualizacao() {
        String idAvaliacao = JOptionPane.showInputDialog("Informe o id da avaliação");
        String nota = JOptionPane.showInputDialog("Informe a nota da avaliação (de 1 a 5)");
        String comentario = JOptionPane.showInputDialog("Informe o comentário da avaliação");
        String dataAvaliacao = JOptionPane.showInputDialog("Informe a data da avaliação no padrão DD/MM/AAAA HH:MM");

        controller.atualizarAvaliacao(nota, comentario, dataAvaliacao, idAvaliacao);
    }

    private void coletarRemocao() {
        String idAvaliacao = JOptionPane.showInputDialog("Informe o id da avaliação");
        controller.deletarAvaliacao(idAvaliacao);
    }
}