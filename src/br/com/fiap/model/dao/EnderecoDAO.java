package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Endereco;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {
    private final Connection enderecoConn;

    public EnderecoDAO () {
        this.enderecoConn = new ConnectionFactory().getConnection();
    }

    //  CREATE
    public String inserir(Endereco endereco) {
        try {
            PreparedStatement statement = enderecoConn.prepareStatement("INSERT INTO enderecos VALUES (?, ?, ?, ?, ?, ?)");
            statement.setInt(1, endereco.getIdEndereco());
            statement.setInt(2, endereco.getNumero());
            statement.setString(3, endereco.getRua());
            statement.setString(4, endereco.getBairro());
            statement.setString(5, endereco.getCidade());
            statement.setInt(6, endereco.getCep());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public String selecionar(int idPaciente) {
        return "E";
    }

    //  UPDATE
    public String atualizar(Endereco endereco) {
        try {
            PreparedStatement statement = enderecoConn.prepareStatement("UPDATE enderecos SET numero = ?, rua = ?, bairro = ?, cidade = ?, cep = ? WHERE id_endereco = ?");
            statement.setInt(1, endereco.getNumero());
            statement.setString(2, endereco.getRua());
            statement.setString(3, endereco.getBairro());
            statement.setString(4, endereco.getCidade());
            statement.setInt(5, endereco.getCep());
            statement.setInt(6, endereco.getIdEndereco());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idEndereco) {
        try {
            PreparedStatement statement = enderecoConn.prepareStatement("DELETE FROM enderecos WHERE id_endereco = ?");
            statement.setInt(1, idEndereco);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}
