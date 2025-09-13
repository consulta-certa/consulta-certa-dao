package br.com.fiap.controller;

import br.com.fiap.model.dao.EnderecoDAO;
import br.com.fiap.model.entity.Endereco;
import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class EnderecoController {
    private final EnderecoDAO enderecoDAO;

    public EnderecoController () {
        this.enderecoDAO = new EnderecoDAO();
    }
    
    //  Execução do CREATE
    public void inserirEndereco(String idEnderecoString, String numeroString, String rua, String bairro, String cidade, String cepString) {
        if (
            !Validacao.validarInteger(idEnderecoString) ||
            !Validacao.validarInteger(numeroString) ||
            !Validacao.validarString(rua) ||
            !Validacao.validarString(bairro) ||
            !Validacao.validarString(cidade) ||
            !Validacao.validarInteger(cepString)
        ) {
            return;
        }

        int idEndereco = Integer.parseInt(idEnderecoString);
        int numero = Integer.parseInt(numeroString);
        int cep = Integer.parseInt(cepString);

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(idEndereco);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setCep(cep);

        JOptionPane.showMessageDialog(null, enderecoDAO.inserir(endereco));
    }

    // Execução do READ
    public void selecionarEndereco() {
    }

    // Execução do UPDATE
    public void atualizarEndereco(String numeroString, String rua, String bairro, String cidade, String cepString, String idEnderecoString) {
        if (
            !Validacao.validarInteger(numeroString) ||
            !Validacao.validarString(rua) ||
            !Validacao.validarString(bairro) ||
            !Validacao.validarString(cidade) ||
            !Validacao.validarInteger(cepString) ||
            !Validacao.validarInteger(idEnderecoString)
        ) {
            return;
        }

        int idEndereco = Integer.parseInt(idEnderecoString);
        int numero = Integer.parseInt(numeroString);
        int cep = Integer.parseInt(cepString);

        Endereco endereco = new Endereco();
        endereco.setIdEndereco(idEndereco);
        endereco.setNumero(numero);
        endereco.setRua(rua);
        endereco.setBairro(bairro);
        endereco.setCidade(cidade);
        endereco.setCep(cep);

        JOptionPane.showMessageDialog(null, enderecoDAO.atualizar(endereco));
    }

    // Execução do DELETE
    public void deletarEndereco(String idEnderecoString) {
        if (!Validacao.validarInteger(idEnderecoString)) {
            return;
        }

        int idEndereco = Integer.parseInt(idEnderecoString);
        JOptionPane.showMessageDialog(null, enderecoDAO.deletar(idEndereco));
    }
}
