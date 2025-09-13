package br.com.fiap.controller;

import br.com.fiap.model.dao.ContatoDAO;
import br.com.fiap.model.entity.Contato;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class ContatoController {
    private final ContatoDAO contatoDAO;

    public ContatoController() {
        this.contatoDAO = new ContatoDAO();
    }

    //  Execução do CREATE
    public void inserirContato(String idContatoString, String telefone, String email, String numero, String rua, String bairro, String cidade, String cep) {
        if (
            !Validacao.validarInteger(idContatoString) ||
            !Validacao.validarNome(rua) ||
            !Validacao.validarNome(bairro) ||
            !Validacao.validarNome(cidade)
        ) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);

        Contato contato = new Contato();
        contato.setIdContato(idContato);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        contato.setNumero(numero);
        contato.setRua(rua);
        contato.setBairro(bairro);
        contato.setCidade(cidade);
        contato.setCep(cep);

        JOptionPane.showMessageDialog(null, contatoDAO.inserir(contato));
    }

    // Execução do READ
    public void selecionarContato() {
    }

    // Execução do UPDATE
    public void atualizarContato(String idContatoString, String telefone, String email, String numero, String rua, String bairro, String cidade, String cep) {
        if (
            !Validacao.validarTelefone(telefone) ||
            !Validacao.validarEmail(email) ||
            !Validacao.validarNome(rua) ||
            !Validacao.validarNome(bairro) ||
            !Validacao.validarNome(cidade) ||
            !Validacao.validarCep(cep) ||
            !Validacao.validarInteger(idContatoString)
        ) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);

        Contato contato = new Contato();
        contato.setIdContato(idContato);
        contato.setTelefone(telefone);
        contato.setEmail(email);
        contato.setNumero(numero);
        contato.setRua(rua);
        contato.setBairro(bairro);
        contato.setCidade(cidade);
        contato.setCep(cep);

        JOptionPane.showMessageDialog(null, contatoDAO.atualizar(contato));
    }

    // Execução do DELETE
    public void deletarContato(String idContatoString) {
        if (!Validacao.validarInteger(idContatoString)) {
            return;
        }

        int idContato = Integer.parseInt(idContatoString);
        JOptionPane.showMessageDialog(null, contatoDAO.deletar(idContato));
    }
}
