package br.com.fiap.model.dao;

import br.com.fiap.model.entity.ConversaChatbot;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConversaChatbotDAO {
    private final Connection conn;

    public ConversaChatbotDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(ConversaChatbot conversa) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO conversas_chatbot VALUES (?, ?, ?)");
            statement.setInt(1, conversa.getIdConversa());
            statement.setString(2, conversa.getPergunta());
            statement.setString(3, conversa.getAprovacao());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public String selecionar(int idConversa) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM conversas_chatbot WHERE idConversa = ?");
            statement.setInt(1, idConversa);
            statement.execute();
            statement.close();
            return "Dados selecionados da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // UPDATE
    public String atualizar(ConversaChatbot conversa) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE conversas_chatbot SET pergunta = ?, aprovacao = ? WHERE idConversa = ?");
            statement.setString(1, conversa.getPergunta());
            statement.setString(2, conversa.getAprovacao());
            statement.setInt(3, conversa.getIdConversa());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idConversa) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM conversas_chatbot WHERE idConversa = ?");
            statement.setInt(1, idConversa);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}