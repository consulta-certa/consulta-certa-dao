package br.com.fiap.model.dao;

import br.com.fiap.model.entity.AcessoFuncionalidade;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AcessoFuncionalidadeDAO {
    private final Connection conn;

    public AcessoFuncionalidadeDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(AcessoFuncionalidade acesso) {
        try {
            PreparedStatement statement = conn.prepareStatement("INSERT INTO acesso_funcionalidade VALUES (?, ?, ?, ?)");
            statement.setInt(1, acesso.getIdAcesso());
            statement.setString(2, acesso.getFuncionalidade());
            statement.setInt(3, acesso.getQuantidadeAcessos());
            statement.setInt(4, acesso.getTempoPermanenciaSeg());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public String selecionar(int idAcesso) {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM acesso_funcionalidade WHERE idAcesso = ?");
            statement.setInt(1, idAcesso);
            statement.execute();
            statement.close();
            return "Dados selecionados da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // UPDATE
    public String atualizar(AcessoFuncionalidade acesso) {
        try {
            PreparedStatement statement = conn.prepareStatement("UPDATE acesso_funcionalidade SET funcionalidade = ?, quantidade_acessos = ?, tempo_permanencia_seg = ? WHERE idAcesso = ?");
            statement.setString(1, acesso.getFuncionalidade());
            statement.setInt(2, acesso.getQuantidadeAcessos());
            statement.setInt(3, acesso.getTempoPermanenciaSeg());
            statement.setInt(4, acesso.getIdAcesso());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idAcesso) {
        try {
            PreparedStatement statement = conn.prepareStatement("DELETE FROM acesso_funcionalidade WHERE idAcesso = ?");
            statement.setInt(1, idAcesso);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}