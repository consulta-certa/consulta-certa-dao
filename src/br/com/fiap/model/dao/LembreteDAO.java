package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Lembrete;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class LembreteDAO {
    private final Connection conn;

    public LembreteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Lembrete lembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lembretes VALUES (?, ?, ?, ?)");
            stmt.setInt(1, lembrete.getIdLembrete());
            stmt.setString(2, lembrete.getCanalEnvio());
            stmt.setObject(3, lembrete.getDataEnvio());
            stmt.setInt(4, lembrete.getIdConsulta());
            stmt.execute();
            stmt.close();
            return "Lembrete inserido com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir lembrete", e);
        }
    }

    // READ
    public Lembrete selecionar(int idLembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lembretes WHERE idLembrete = ?");
            stmt.setInt(1, idLembrete);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Lembrete lembrete = new Lembrete();
                lembrete.setIdLembrete(rs.getInt("idLembrete"));
                lembrete.setCanalEnvio(rs.getString("canalEnvio"));
                lembrete.setDataEnvio(rs.getObject("dataEnvio", LocalDateTime.class));
                lembrete.setIdConsulta(rs.getInt("idConsulta"));
                return lembrete;
            }
            stmt.close();
            return null;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao selecionar lembrete", e);
        }
    }

    // UPDATE
    public String atualizar(Lembrete lembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE lembretes SET canalEnvio = ?, dataEnvio = ?, idConsulta = ? WHERE idLembrete = ?");
            stmt.setString(1, lembrete.getCanalEnvio());
            stmt.setObject(2, lembrete.getDataEnvio());
            stmt.setInt(3, lembrete.getIdConsulta());
            stmt.setInt(4, lembrete.getIdLembrete());
            stmt.executeUpdate();
            stmt.close();
            return "Lembrete atualizado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar lembrete", e);
        }
    }

    // DELETE
    public String deletar(int idLembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM lembretes WHERE idLembrete = ?");
            stmt.setInt(1, idLembrete);
            stmt.execute();
            stmt.close();
            return "Lembrete deletado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar lembrete", e);
        }
    }
}