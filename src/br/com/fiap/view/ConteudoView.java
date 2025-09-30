package br.com.fiap.view;

import br.com.fiap.controller.ConteudoController;

import javax.swing.*;

public class ConteudoView {
    private final ConteudoController controller;

    public ConteudoView() {
        this.controller = new ConteudoController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao, this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao() {
        String idConteudo = JOptionPane.showInputDialog("Informe o id do conteúdo");
        String tipo = JOptionPane.showInputDialog("Informe o tipo do conteúdo (F para FAQ, G para Guia)");
        String titulo = JOptionPane.showInputDialog("Informe o título do conteúdo se houver");
        String texto = JOptionPane.showInputDialog("Informe o texto do conteúdo se houver");
        String video = JOptionPane.showInputDialog("Informe a url do vídeo do conteúdo se houver");
        String imagem = JOptionPane.showInputDialog("Informe a url da imagem do conteúdo se houver");
        String dataPublicacao = JOptionPane.showInputDialog("Informe a data de publicação do conteúdo no padrão DD/MM/AAAA HH:MM");
        controller.inserirConteudo(idConteudo, tipo, titulo, texto, video, imagem, dataPublicacao);
    }

    private void coletarSelecao() {
        controller.lerConteudo();
    }

    private void coletarAtualizacao() {
        String idConteudo = JOptionPane.showInputDialog("Informe o id do conteúdo");
        String tipo = JOptionPane.showInputDialog("Informe o tipo do conteúdo (F para FAQ, G para Guia)");
        String titulo = JOptionPane.showInputDialog("Informe o título do conteúdo se houver");
        String texto = JOptionPane.showInputDialog("Informe o texto do conteúdo se houver");
        String video = JOptionPane.showInputDialog("Informe a url do vídeo do conteúdo se houver");
        String imagem = JOptionPane.showInputDialog("Informe a url da imagem do conteúdo se houver");
        String dataPublicacao = JOptionPane.showInputDialog("Informe a data de publicação do conteúdo no padrão DD/MM/AAAA HH:MM");
        controller.atualizarConteudo(tipo, titulo, texto, video, imagem, dataPublicacao, idConteudo);
    }

    private void coletarRemocao() {
        String idConteudo = JOptionPane.showInputDialog("Informe o id do conteúdo");
        controller.deletarConteudo(idConteudo);
    }
}