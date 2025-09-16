package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Avaliacao;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AvaliacaoDAO {
    private final Connection conn;

    public AvaliacaoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Avaliacao avaliacao) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO avaliacoes VALUES (?, ?, ?, ?, ?)");
            statement.setInt(1, avaliacao.getIdAvaliacao());
            statement.setInt(2, avaliacao.getNota());
            statement.setString(3, avaliacao.getComentario());
            statement.setTimestamp(4, java.sql.Timestamp.valueOf(avaliacao.getDataAvaliacao()));
            statement.setInt(5, avaliacao.getIdLembrete());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public String selecionar() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM avaliacoes");
            statement.execute();
            statement.close();
            return "Dados selecionados da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // UPDATE
    public String atualizar(Avaliacao avaliacao) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE avaliacoes SET nota = ?, comentario = ?, data_avaliacao = ?, id_lembrete = ? WHERE idAvaliacao = ?");
            statement.setInt(1, avaliacao.getNota());
            statement.setString(2, avaliacao.getComentario());
            statement.setTimestamp(3, java.sql.Timestamp.valueOf(avaliacao.getDataAvaliacao()));
            statement.setInt(4, avaliacao.getIdLembrete());
            statement.setInt(5, avaliacao.getIdAvaliacao());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idAvaliacao) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM avaliacoes WHERE idAvaliacao = ?");
            statement.setInt(1, idAvaliacao);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}