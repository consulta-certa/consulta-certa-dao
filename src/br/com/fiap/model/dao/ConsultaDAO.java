package br.com.fiap.model.dao;

import br.com.fiap.model.util.ConnectionFactory;
import br.com.fiap.model.entity.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ConsultaDAO {
    private final Connection conn;

    public ConsultaDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

/*  OPERAÇÕES CRUD */
//  CREATE
    public String inserir(Consulta consulta) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO consultas VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, consulta.getIdConsulta());
            stmt.setString(2, consulta.getEspecialidade());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(consulta.getDataConsulta()));
            stmt.setString(4, consulta.getStatus());
            stmt.setInt(5, consulta.getIdPaciente());
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

//  READ
public ArrayList<Consulta> selecionar() {
    try {
        ArrayList<Consulta> listaConsultas = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM consultas");
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Consulta consulta = new Consulta();

            consulta.setIdConsulta(rs.getInt(1));
            consulta.setEspecialidade(rs.getString(2));
            consulta.setDataConsulta(rs.getTimestamp(3).toLocalDateTime());
            consulta.setStatus(rs.getString(4));
            consulta.setIdPaciente(rs.getInt(5));

            listaConsultas.add(consulta);
        }

        stmt.close();
        return listaConsultas;
    } catch (SQLException e) {
        throw new RuntimeException("Erro envolvendo SQL Statement", e);
    }
}


//  UPDATE
    public String atualizar(Consulta consulta) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE consultas SET especialidade = ?, data_consulta = ?, status = ?, id_paciente = ? WHERE idConsulta = ?");
            stmt.setString(1, consulta.getEspecialidade());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(consulta.getDataConsulta()));
            stmt.setString(3, consulta.getStatus());
            stmt.setInt(4, consulta.getIdPaciente());
            stmt.setInt(5, consulta.getIdConsulta());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

//  DELETE
    public String deletar(int idConsulta) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM consultas WHERE idConsulta = ?");
            stmt.setInt(1, idConsulta);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}