package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Acompanhante;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AcompanhanteDAO {
    private final Connection conn;

    public AcompanhanteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Acompanhante acompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO acompanhantes VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, acompanhante.getIdAcompanhante());
            stmt.setString(2, acompanhante.getEmail());
            stmt.setString(3, acompanhante.getTelefone());
            stmt.setString(4, acompanhante.getParentesco());
            stmt.setInt(5, acompanhante.getIdPaciente());
            stmt.execute();
            stmt.close();
            return "Acompanhante inserido com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir acompanhante", e);
        }
    }

    // READ
    public Acompanhante selecionar(int idAcompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM acompanhantes WHERE idAcompanhante = ?");
            stmt.setInt(1, idAcompanhante);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Acompanhante acompanhante = new Acompanhante();
                acompanhante.setIdAcompanhante(rs.getInt("idAcompanhante"));
                acompanhante.setEmail(rs.getString("email"));
                acompanhante.setTelefone(rs.getString("telefone"));
                acompanhante.setParentesco(rs.getString("parentesco"));
                acompanhante.setIdPaciente(rs.getInt("idPaciente"));
                return acompanhante;
            }
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar acompanhante", e);
        }
    }

    // UPDATE
    public String atualizar(Acompanhante acompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE acompanhantes SET email = ?, telefone = ?, parentesco = ?, idPaciente = ? WHERE idAcompanhante = ?");
            stmt.setString(1, acompanhante.getEmail());
            stmt.setString(2, acompanhante.getTelefone());
            stmt.setString(3, acompanhante.getParentesco());
            stmt.setInt(4, acompanhante.getIdPaciente());
            stmt.setInt(5, acompanhante.getIdAcompanhante());
            stmt.executeUpdate();
            stmt.close();
            return "Acompanhante atualizado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar acompanhante", e);
        }
    }

    // DELETE
    public String deletar(int idAcompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM acompanhantes WHERE idAcompanhante = ?");
            stmt.setInt(1, idAcompanhante);
            stmt.execute();
            stmt.close();
            return "Acompanhante deletado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar acompanhante", e);
        }
    }
}