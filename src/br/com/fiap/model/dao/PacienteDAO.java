package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacienteDAO {
    private final Connection conn;

    public PacienteDAO () {
        this.conn = new ConnectionFactory().getConnection();
    }

    //  CREATE
    public String inserir(Paciente paciente) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO pacientes VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, paciente.getIdPaciente());
            stmt.setString(2, paciente.getNome());
            stmt.setString(3, paciente.getEmail());
            stmt.setString(4, paciente.getTelefone());
            stmt.setString(5, paciente.getAcompanhante());
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public List<Paciente> selecionar() {
        try {
            ArrayList<Paciente> listaPacientes = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pacientes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Paciente paciente = new Paciente(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5)
                );

                listaPacientes.add(paciente);
            }

            stmt.close();
            return listaPacientes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  UPDATE
    public String atualizar(Paciente paciente) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE pacientes SET nome = ?, email = ?, telefone = ? WHERE id_paciente = ?");
            stmt.setString(1, paciente.getNome());
            stmt.setString(2, paciente.getEmail());
            stmt.setString(3, paciente.getTelefone());
            stmt.setString(4, paciente.getAcompanhante());
            stmt.setInt(5, paciente.getIdPaciente());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idPaciente) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM pacientes WHERE id_paciente = ?");
            stmt.setInt(1, idPaciente);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}