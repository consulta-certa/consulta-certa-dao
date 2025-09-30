package br.com.fiap.controller;

import br.com.fiap.model.dao.AcessoFuncionalidadeDAO;
import br.com.fiap.model.entity.AcessoFuncionalidade;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.List;

public class AcessoFuncionalidadeController {
    private final AcessoFuncionalidadeDAO dao;

    public AcessoFuncionalidadeController() {
        this.dao = new AcessoFuncionalidadeDAO();
    }

    // CREATE
    public void inserirAcessoFuncionalidade(String idAcessoString, String funcionalidade, String quantidadeAcessosString, String tempoPermanenciaSegString) {
        if (
            !Validacao.validarInteger(idAcessoString) ||
            !Validacao.validarTexto(funcionalidade) ||
            !Validacao.validarInteger(quantidadeAcessosString) ||
            !Validacao.validarInteger(tempoPermanenciaSegString)
        ) {
            return;
        }

        int idAcesso = Integer.parseInt(idAcessoString);
        int quantidadeAcessos = Integer.parseInt(quantidadeAcessosString);
        int tempoPermanenciaSeg = Integer.parseInt(tempoPermanenciaSegString);

        AcessoFuncionalidade acesso = new AcessoFuncionalidade(idAcesso, funcionalidade, quantidadeAcessos, tempoPermanenciaSeg);
        JOptionPane.showMessageDialog(null, dao.inserir(acesso));
    }

    // READ
    public void lerAcessoFuncionalidade() {
        int continuar;
        int contador = 0;
        List<AcessoFuncionalidade> acessosSelecionados = dao.selecionar();

        int quantSelecionados = acessosSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, acessosSelecionados.get(contador), "RESULTADOS DA QUERY EM acessos_funcionalidade", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // UPDATE
    public void atualizarAcessoFuncionalidade(String funcionalidade, String quantidadeAcessosString, String tempoPermanenciaSegString, String idAcessoString) {
        if (
                !Validacao.validarInteger(idAcessoString) ||
                        !Validacao.validarTexto(funcionalidade) ||
                        !Validacao.validarInteger(quantidadeAcessosString) ||
                        !Validacao.validarInteger(tempoPermanenciaSegString)
        ) {
            return;
        }

        int idAcesso = Integer.parseInt(idAcessoString);
        int quantidadeAcessos = Integer.parseInt(quantidadeAcessosString);
        int tempoPermanenciaSeg = Integer.parseInt(tempoPermanenciaSegString);

        AcessoFuncionalidade acesso = new AcessoFuncionalidade(idAcesso, funcionalidade, quantidadeAcessos, tempoPermanenciaSeg);
        JOptionPane.showMessageDialog(null, dao.atualizar(acesso));
    }

    // DELETE
    public void deletarAcessoFuncionalidade(String idAcessoString) {
        if (!Validacao.validarInteger(idAcessoString)) {
            return;
        }

        int idAcesso = Integer.parseInt(idAcessoString);
        JOptionPane.showMessageDialog(null, dao.deletar(idAcesso));
    }
}