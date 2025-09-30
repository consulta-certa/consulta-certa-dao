package br.com.fiap.model.dao;

import br.com.fiap.model.entity.AcessoFuncionalidade;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcessoFuncionalidadeDAO {
    private final Connection conn;

    public AcessoFuncionalidadeDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(AcessoFuncionalidade acesso) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO acessos_funcionalidade VALUES (?, ?, ?, ?)");
            stmt.setInt(1, acesso.getIdAcesso());
            stmt.setString(2, acesso.getFuncionalidade());
            stmt.setInt(3, acesso.getQuantidadeAcessos());
            stmt.setInt(4, acesso.getTempoPermanenciaSeg());
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // READ
    public List<AcessoFuncionalidade> selecionar() {
        try {
            ArrayList<AcessoFuncionalidade> listaAcessos = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM acessos_funcionalidade");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                AcessoFuncionalidade acessoFuncionalidade = new AcessoFuncionalidade();

                acessoFuncionalidade.setIdAcesso(rs.getInt(1));
                acessoFuncionalidade.setFuncionalidade(rs.getString(2));
                acessoFuncionalidade.setQuantidadeAcessos(rs.getInt(3));
                acessoFuncionalidade.setTempoPermanenciaSeg(rs.getInt(4));

                listaAcessos.add(acessoFuncionalidade);
            }

            stmt.close();
            return listaAcessos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // UPDATE
    public String atualizar(AcessoFuncionalidade acesso) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE acessos_funcionalidade SET funcionalidade = ?, quantidade_acessos = ?, tempo_permanencia_seg = ? WHERE idAcesso = ?");
            stmt.setString(1, acesso.getFuncionalidade());
            stmt.setInt(2, acesso.getQuantidadeAcessos());
            stmt.setInt(3, acesso.getTempoPermanenciaSeg());
            stmt.setInt(4, acesso.getIdAcesso());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // DELETE
    public String deletar(int idAcesso) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM acessos_funcionalidade WHERE id_acesso = ?");
            stmt.setInt(1, idAcesso);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}