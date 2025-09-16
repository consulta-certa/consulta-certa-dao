package br.com.fiap.model.dao;

import br.com.fiap.model.util.ConnectionFactory;
import br.com.fiap.model.entity.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsultaDAO {
    private final Connection consultaConn;

    public ConsultaDAO() {
        this.consultaConn = new ConnectionFactory().getConnection();
    }

/*  OPERAÇÕES CRUD */
//  CREATE
    public String inserir(Consulta consulta) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("INSERT INTO consultas VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, consulta.getIdConsulta());
            statement.setString(2, consulta.getEspecialidade());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(consulta.getDataConsulta()));
            statement.setString(4, consulta.getStatus());
            statement.setInt(5, consulta.getIdPaciente());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

//  READ
    public String selecionar() {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("SELECT * FROM consultas");
            statement.execute();
            statement.close();
            return "Dados selecionados da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

//  UPDATE
    public String atualizar(Consulta consulta) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("UPDATE consultas SET especialidade = ?, data_consulta = ?, status = ?, id_paciente = ? WHERE idConsulta = ?");
            statement.setString(1, consulta.getEspecialidade());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(consulta.getDataConsulta()));
            statement.setString(3, consulta.getStatus());
            statement.setInt(4, consulta.getIdPaciente());
            statement.setInt(5, consulta.getIdConsulta());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

//  DELETE
    public String deletar(int idConsulta) {
        try {
            PreparedStatement statement = consultaConn.prepareStatement("DELETE FROM consultas WHERE idConsulta = ?");
            statement.setInt(1, idConsulta);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}