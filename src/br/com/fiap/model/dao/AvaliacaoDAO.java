package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Avaliacao;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AvaliacaoDAO {
    private final Connection conn;

    public AvaliacaoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Avaliacao avaliacao) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO avaliacoes VALUES (?, ?, ?, ?, )");
            stmt.setInt(1, avaliacao.getIdAvaliacao());
            stmt.setInt(2, avaliacao.getNota());
            stmt.setString(3, avaliacao.getComentario());
            stmt.setTimestamp(4, java.sql.Timestamp.valueOf(avaliacao.getDataAvaliacao()));
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public List<Avaliacao> selecionar() {
        try {
            ArrayList<Avaliacao> listaAvaliacoes = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM avaliacoes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Avaliacao avaliacao = new Avaliacao(
                    rs.getInt(1),
                    rs.getInt(2),
                    rs.getString(3),
                    rs.getTimestamp(4).toLocalDateTime()
                );

                listaAvaliacoes.add(avaliacao);
            }

            stmt.close();
            return listaAvaliacoes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }


    // UPDATE
    public String atualizar(Avaliacao avaliacao) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE avaliacoes SET nota = ?, comentario = ?, data_avaliacao = ? WHERE idAvaliacao = ?");
            stmt.setInt(1, avaliacao.getNota());
            stmt.setString(2, avaliacao.getComentario());
            stmt.setTimestamp(3, java.sql.Timestamp.valueOf(avaliacao.getDataAvaliacao()));
            stmt.setInt(5, avaliacao.getIdAvaliacao());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idAvaliacao) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM avaliacoes WHERE id_avaliacao = ?");
            stmt.setInt(1, idAvaliacao);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}