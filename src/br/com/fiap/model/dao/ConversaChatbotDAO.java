package br.com.fiap.model.dao;

import br.com.fiap.model.entity.ConversaChatbot;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConversaChatbotDAO {
    private final Connection conn;

    public ConversaChatbotDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(ConversaChatbot conversa) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO conversas_chatbot VALUES (?, ?, ?)");
            stmt.setInt(1, conversa.getIdConversa());
            stmt.setString(2, conversa.getPergunta());
            stmt.setString(3, conversa.getAprovacao());
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public List<ConversaChatbot> selecionar() {
        try {
            ArrayList<ConversaChatbot> listaConversas = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM conversas_chatbot");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                ConversaChatbot conversaChatbot = new ConversaChatbot(
                    rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3)
                );

                listaConversas.add(conversaChatbot);
            }

            stmt.close();
            return listaConversas;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }


    // UPDATE
    public String atualizar(ConversaChatbot conversa) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE conversas_chatbot SET pergunta = ?, aprovacao = ? WHERE idConversa = ?");
            stmt.setString(1, conversa.getPergunta());
            stmt.setString(2, conversa.getAprovacao());
            stmt.setInt(3, conversa.getIdConversa());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idConversa) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM conversas_chatbot WHERE id_conversa = ?");
            stmt.setInt(1, idConversa);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}