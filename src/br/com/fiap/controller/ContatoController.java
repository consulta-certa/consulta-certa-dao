package br.com.fiap.controller;

import br.com.fiap.model.dao.ContatoDAO;
import br.com.fiap.model.entity.Contato;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.util.List;

public class ContatoController {
    private final ContatoDAO dao;

    public ContatoController() {
        this.dao = new ContatoDAO();
    }

    //  Execução do CREATE
    public void inserirContato(String idContatoString, String nome, String telefone, String email, String numeroString, String rua, String bairro, String cidade, String cep) {
        if (
            !Validacao.validarTexto(nome) ||
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarInteger(numeroString) ||
            !Validacao.validarTexto(rua) ||
            !Validacao.validarTexto(bairro) ||
            !Validacao.validarTexto(cidade) ||
            !Validacao.validarCep(cep) ||
            !Validacao.validarInteger(idContatoString)
        ) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);
        int numero = Integer.parseInt(numeroString);

        Contato contato = new Contato(idContato, nome, telefone, email, numero, rua, bairro, cidade, cep);
        JOptionPane.showMessageDialog(null, dao.inserir(contato));
    }

    // Execução do READ
    public void selecionarContato() {
        int continuar;
        int contador = 0;
        List<Contato> contatosSelecionados = dao.selecionar();

        int quantSelecionados = contatosSelecionados.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, contatosSelecionados.get(contador), "RESULTADOS DA QUERY EM contatos", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

    // Execução do UPDATE
    public void atualizarContato(String nome, String telefone, String email, String numeroString, String rua, String bairro, String cidade, String cep, String idContatoString) {
        if (
            !Validacao.validarTexto(nome) ||
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarTexto(rua) ||
            !Validacao.validarTexto(bairro) ||
            !Validacao.validarTexto(cidade) ||
            !Validacao.validarCep(cep) ||
            !Validacao.validarInteger(idContatoString)
        ) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);
        int numero = Integer.parseInt(numeroString);

        Contato contato = new Contato(idContato, nome, telefone, email, numero, rua, bairro, cidade, cep);
        JOptionPane.showMessageDialog(null, dao.atualizar(contato));
    }

    // Execução do DELETE
    public void deletarContato(String idContatoString) {
        if (!Validacao.validarInteger(idContatoString)) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);
        JOptionPane.showMessageDialog(null, dao.deletar(idContato));
    }
}
