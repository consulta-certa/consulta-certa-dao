package br.com.fiap.controller;

import br.com.fiap.model.dao.ConteudoDAO;
import br.com.fiap.model.entity.Conteudo;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;

public class ConteudoController {
    private final ConteudoDAO dao;

    public ConteudoController() {
        this.dao = new ConteudoDAO();
    }

    // CREATE
    public void inserirConteudo(String idConteudoString, String tipo, String titulo, String texto, String video, String imagem, String dataPublicacaoString) {
        if (
                !Validacao.validarInteger(idConteudoString) ||
                !Validacao.validarNome(tipo) ||
                !Validacao.validarNome(titulo) ||
                !Validacao.validarNome(texto) ||
                !Validacao.validarNome(video) ||
                !Validacao.validarNome(imagem) ||
                !Validacao.validarData(dataPublicacaoString)
        ) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        LocalDateTime dataPublicacao = LocalDateTime.parse(dataPublicacaoString, DataFormatter.formatter);

        Conteudo conteudo = new Conteudo(idConteudo, tipo, titulo, texto, video, imagem, dataPublicacao);
        JOptionPane.showMessageDialog(null, dao.inserir(conteudo));
    }

    // READ
    public void lerConteudo(String idConteudoString) {
        if (!Validacao.validarInteger(idConteudoString)) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        Conteudo conteudo = dao.selecionar(idConteudo);
        if (conteudo != null) {
            JOptionPane.showMessageDialog(null, "Conteúdo encontrado: " + conteudo.getTitulo());
        } else {
            JOptionPane.showMessageDialog(null, "Conteúdo não encontrado");
        }
    }

    // UPDATE
    public void atualizarConteudo(String idConteudoString, String tipo, String titulo, String texto, String video, String imagem, String dataPublicacaoString) {
        if (!Validacao.validarInteger(idConteudoString) || !Validacao.validarNome(tipo) || !Validacao.validarNome(titulo) ||
                !Validacao.validarNome(texto) || !Validacao.validarNome(video) || !Validacao.validarNome(imagem) ||
                !Validacao.validarData(dataPublicacaoString)) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        LocalDateTime dataPublicacao = LocalDateTime.parse(dataPublicacaoString, DataFormatter.formatter);

        Conteudo conteudo = new Conteudo(idConteudo, tipo, titulo, texto, video, imagem, dataPublicacao);
        JOptionPane.showMessageDialog(null, dao.atualizar(conteudo));
    }

    // DELETE
    public void deletarConteudo(String idConteudoString) {
        if (!Validacao.validarInteger(idConteudoString)) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        JOptionPane.showMessageDialog(null, dao.deletar(idConteudo));
    }
}