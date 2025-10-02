package br.com.fiap.controller;

import br.com.fiap.model.dao.ConteudoDAO;
import br.com.fiap.model.entity.Conteudo;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class ConteudoController {
    private final ConteudoDAO dao;

    public ConteudoController() {
        this.dao = new ConteudoDAO();
    }

    // CREATE
    public void inserirConteudo(String idConteudoString, String tipo, String titulo, String texto, String video, String imagem, String dataPublicacaoString) {
        if (
                !Validacao.validarInteger(idConteudoString) ||
                !Validacao.validarTexto(tipo) ||
                !Validacao.validarTexto(titulo) ||
                !Validacao.validarTexto(texto) ||
                !Validacao.validarTexto(video) ||
                !Validacao.validarTexto(imagem) ||
                !Validacao.validarData(dataPublicacaoString)
        ) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        LocalDateTime dataPublicacao = LocalDateTime.parse(dataPublicacaoString, DataFormatter.formatter);

        // Check constraints
        if (dataPublicacao.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }

        if (!tipo.equalsIgnoreCase("p") && !tipo.equalsIgnoreCase("t") && !tipo.equalsIgnoreCase("f")) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas um dos tipos disponíveis: P para guias do portal, T para guias de teleconsulta ou F para faqs.");
            return;
        }

        Conteudo conteudo = new Conteudo(idConteudo, tipo, titulo, texto, video, imagem, dataPublicacao);
        JOptionPane.showMessageDialog(null, dao.inserir(conteudo));
    }

    // READ
    public void lerConteudo() {
        int continuar;
        int contador = 0;
        List<Conteudo> conteudosSelecionados = dao.selecionar();

        int quantSelecionados = conteudosSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, conteudosSelecionados.get(contador), "RESULTADOS DA QUERY EM conteudos", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarConteudo(String tipo, String titulo, String texto, String video, String imagem, String dataPublicacaoString, String idConteudoString) {
        if (!Validacao.validarInteger(idConteudoString) || !Validacao.validarTexto(tipo) || !Validacao.validarTexto(titulo) ||
                !Validacao.validarTexto(texto) || !Validacao.validarTexto(video) || !Validacao.validarTexto(imagem) ||
                !Validacao.validarData(dataPublicacaoString)) {
            return;
        }

        int idConteudo = Integer.parseInt(idConteudoString);
        LocalDateTime dataPublicacao = LocalDateTime.parse(dataPublicacaoString, DataFormatter.formatter);

        // Check constraints
        if (dataPublicacao.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }

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