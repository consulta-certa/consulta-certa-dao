package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Lembrete;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class LembreteDAO {
    private final Connection conn;

    public LembreteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Lembrete lembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO lembretes VALUES (?, ?, ?)");
            stmt.setInt(1, lembrete.getIdLembrete());
            stmt.setTimestamp(2, java.sql.Timestamp.valueOf(lembrete.getDataEnvio()));
            stmt.setInt(3, lembrete.getIdConsulta());
            stmt.execute();
            stmt.close();
            return "Lembrete inserido com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir lembrete", e);
        }
    }

    // READ
    public List<Lembrete> selecionar() {
        try {
            ArrayList<Lembrete> listaLembretes = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM lembretes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Lembrete lembrete = new Lembrete();

                lembrete.setIdLembrete(rs.getInt(1));
                lembrete.setDataEnvio(rs.getTimestamp(2).toLocalDateTime());
                lembrete.setIdConsulta(rs.getInt(3));

                listaLembretes.add(lembrete);
            }

            stmt.close();
            return listaLembretes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }


    // UPDATE
    public String atualizar(Lembrete lembrete) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE lembretes SET dataEnvio = ?, idConsulta = ? WHERE idLembrete = ?");
            stmt.setTimestamp(1, java.sql.Timestamp.valueOf(lembrete.getDataEnvio()));
            stmt.setInt(2, lembrete.getIdConsulta());
            stmt.setInt(3, lembrete.getIdLembrete());
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
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM lembretes WHERE id_lembrete = ?");
            stmt.setInt(1, idLembrete);
            stmt.execute();
            stmt.close();
            return "Lembrete deletado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar lembrete", e);
        }
    }
}