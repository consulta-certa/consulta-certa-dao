package br.com.fiap.controller;

import br.com.fiap.model.dao.AcessoFuncionalidadeDAO;
import br.com.fiap.model.entity.AcessoFuncionalidade;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class AcessoFuncionalidadeController {
    private final AcessoFuncionalidadeDAO dao;

    public AcessoFuncionalidadeController() {
        this.dao = new AcessoFuncionalidadeDAO();
    }

    // CREATE
    public void inserirAcessoFuncionalidade(String idAcessoString, String funcionalidade, String quantidadeAcessosString, String tempoPermanenciaSegString) {
        if (
            !Validacao.validarInteger(idAcessoString) ||
            !Validacao.validarNome(funcionalidade) ||
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
        JOptionPane.showMessageDialog(null, dao.selecionar());
    }

    // UPDATE
    public void atualizarAcessoFuncionalidade(String idAcessoString, String funcionalidade, String quantidadeAcessosString, String tempoPermanenciaSegString) {
        if (
                !Validacao.validarInteger(idAcessoString) ||
                        !Validacao.validarNome(funcionalidade) ||
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