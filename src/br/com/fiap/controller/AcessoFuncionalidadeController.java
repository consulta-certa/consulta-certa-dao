package br.com.fiap.controller;

import br.com.fiap.model.dao.AcessoFuncionalidadeDAO;
import br.com.fiap.model.entity.AcessoFuncionalidade;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        String continuar;
        int contador = 0;
        ArrayList<AcessoFuncionalidade> acessosSelecionados = dao.selecionar();

        int quantSelecionados = acessosSelecionados.toArray().length;

        do {
            JOptionPane.showMessageDialog(null, acessosSelecionados.get(contador), "RESULTADOS DA QUERY EM acessos_funcionalidade", JOptionPane.INFORMATION_MESSAGE);

            if (quantSelecionados > 0 && contador < quantSelecionados) {
                continuar = (JOptionPane.showInputDialog(null, "Deseja ver o próximo registro? Informe apenas S para sim e N para não", JOptionPane.QUESTION_MESSAGE));

                while (!Validacao.validarNome(continuar) || !continuar.equalsIgnoreCase("N")) {
                    JOptionPane.showMessageDialog(null, "Informe apenas S ou N");
                    continuar = JOptionPane.showInputDialog(null, "Deseja ver o próximo registro? Informe apenas S para sim e N para não", JOptionPane.QUESTION_MESSAGE);
                }

                contador++;
            } else {
                return;
            }
        } while (!continuar.equalsIgnoreCase("N"));
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