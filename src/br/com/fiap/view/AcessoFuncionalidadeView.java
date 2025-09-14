package br.com.fiap.view;

import br.com.fiap.controller.AcessoFuncionalidadeController;

import javax.swing.*;

public class AcessoFuncionalidadeView {
    private final AcessoFuncionalidadeController controller;

    public AcessoFuncionalidadeView() {
        this.controller = new AcessoFuncionalidadeController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idAcesso = JOptionPane.showInputDialog("Informe o id de acesso");
        String funcionalidade = JOptionPane.showInputDialog("Informe a funcionalidade");
        String quantidadeAcessos = JOptionPane.showInputDialog("Informe a quantidade de acessos");
        String tempoPermanenciaSeg = JOptionPane.showInputDialog("Informe o tempo de permanência em segundos");
        controller.inserirAcessoFuncionalidade(idAcesso, funcionalidade, quantidadeAcessos, tempoPermanenciaSeg);
    }

    private void coletarSelecao() {
        String idAcesso = JOptionPane.showInputDialog("Informe o id de acesso");
        controller.lerAcessoFuncionalidade(idAcesso);
    }

    private void coletarAtualizacao() {
        String idAcesso = JOptionPane.showInputDialog("Informe o id de acesso");
        String funcionalidade = JOptionPane.showInputDialog("Informe a funcionalidade");
        String quantidadeAcessos = JOptionPane.showInputDialog("Informe a quantidade de acessos");
        String tempoPermanenciaSeg = JOptionPane.showInputDialog("Informe o tempo de permanência em segundos");
        controller.atualizarAcessoFuncionalidade(idAcesso, funcionalidade, quantidadeAcessos, tempoPermanenciaSeg);
    }

    private void coletarRemocao() {
        String idAcesso = JOptionPane.showInputDialog("Informe o id de acesso");
        controller.deletarAcessoFuncionalidade(idAcesso);
    }
}