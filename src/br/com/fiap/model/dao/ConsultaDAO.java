package br.com.fiap.model.dao;

import br.com.fiap.model.util.ConnectionFactory;
import br.com.fiap.model.entity.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {
    public Connection consultaConn;

    public ConsultaDAO() {
        this.consultaConn = new ConnectionFactory().getConnection();
    }

/*  OPERAÇÕES CRUD */
//  CREATE
    public String inserir(Consulta consulta) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("INSERT INTO consultas VALUES (?, ?, ?, ?)");
            statement.setInt(1, consulta.getId_consulta());
            statement.setString(2, consulta.getEspecialidade());
            statement.setObject(3, consulta.getData_consulta());
            statement.setString(4, consulta.getCanal_envio());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "Operação encerrada.";
    }

//  READ
    public String selecionar(String coluna) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("SELECT ? FROM consultas"); // Não sei se é assim
            statement.setString(1, coluna);
            statement.execute();
            statement.close();
            return "Dados selecionados da tabela";

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "Operação encerrada.";
    }

//  UPDATE
    public String atualizar(Consulta consulta) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("UPDATE consultas SET especialidade = ?, data_consulta = ?, canal_envio = ? WHERE id_consulta = ?");
            statement.setString(1, consulta.getEspecialidade());
            statement.setObject(1, consulta.getData_consulta());
            statement.setString(1, consulta.getCanal_envio());
            statement.setInt(1, consulta.getId_consulta());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "Operação encerrada.";
    }

//  DELETE
    public String deletar(int id) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("DELETE FROM consultas WHERE id_consulta = ?");
            statement.setInt(1, id);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return "Operação encerrada.";
    }
}