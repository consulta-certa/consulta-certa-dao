package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Contato;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ContatoDAO {
    private final Connection contatoConn;

    public ContatoDAO() {
        this.contatoConn = new ConnectionFactory().getConnection();
    }

    //  CREATE
    public String inserir(Contato contato) {
        try {
            PreparedStatement statement = contatoConn.prepareStatement("INSERT INTO contatos VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, contato.getIdContato());
            statement.setString(2, contato.getTelefone());
            statement.setString(3, contato.getEmail());
            statement.setString(4, contato.getNumero());
            statement.setString(5, contato.getRua());
            statement.setString(6, contato.getBairro());
            statement.setString(7, contato.getCidade());
            statement.setString(8, contato.getCep());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public String selecionar(int idContato) {
        return "E";
    }

    //  UPDATE
    public String atualizar(Contato contato) {
        try {
            PreparedStatement statement = contatoConn.prepareStatement("UPDATE contatos SET telefone = ?, email = ?, numero = ?, rua = ?, bairro = ?, cidade = ?, cep = ? WHERE id_contato = ?");
            statement.setString(1, contato.getTelefone());
            statement.setString(2, contato.getEmail());
            statement.setString(3, contato.getNumero());
            statement.setString(4, contato.getRua());
            statement.setString(5, contato.getBairro());
            statement.setString(6, contato.getCidade());
            statement.setString(7, contato.getCep());
            statement.setInt(8, contato.getIdContato());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idContato) {
        try {
            PreparedStatement statement = contatoConn.prepareStatement("DELETE FROM contatos WHERE id_contato = ?");
            statement.setInt(1, idContato);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}
