package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Conteudo;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ConteudoDAO {
    private final Connection conn;

    public ConteudoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Conteudo conteudo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO conteudos VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, conteudo.getIdConteudo());
            stmt.setString(2, conteudo.getTipo());
            stmt.setString(3, conteudo.getTitulo());
            stmt.setString(4, conteudo.getTexto());
            stmt.setString(5, conteudo.getVideo());
            stmt.setString(6, conteudo.getImagem());
            stmt.setTimestamp(7, java.sql.Timestamp.valueOf(conteudo.getDataPublicacao()));
            stmt.execute();
            stmt.close();
            return "Conteúdo inserido com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir conteúdo", e);
        }
    }

    // READ
    public List<Conteudo> selecionar() {
        try {
            ArrayList<Conteudo> listaConteudos = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM conteudos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Conteudo conteudo = new Conteudo(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6),
                    rs.getTimestamp(7).toLocalDateTime()
                );

                listaConteudos.add(conteudo);
            }

            stmt.close();
            return listaConteudos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }


    // UPDATE
    public String atualizar(Conteudo conteudo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE conteudos SET tipo = ?, titulo = ?, texto = ?, video = ?, imagem = ?, dataPublicacao = ? WHERE idConteudo = ?");
            stmt.setString(1, conteudo.getTipo());
            stmt.setString(2, conteudo.getTitulo());
            stmt.setString(3, conteudo.getTexto());
            stmt.setString(4, conteudo.getVideo());
            stmt.setString(5, conteudo.getImagem());
            stmt.setTimestamp(6, java.sql.Timestamp.valueOf(conteudo.getDataPublicacao()));
            stmt.setInt(7, conteudo.getIdConteudo());
            stmt.executeUpdate();
            stmt.close();
            return "Conteúdo atualizado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar conteúdo", e);
        }
    }

    // DELETE
    public String deletar(int idConteudo) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM conteudos WHERE id_conteudo = ?");
            stmt.setInt(1, idConteudo);
            stmt.execute();
            stmt.close();
            return "Conteúdo deletado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar conteúdo", e);
        }
    }
}