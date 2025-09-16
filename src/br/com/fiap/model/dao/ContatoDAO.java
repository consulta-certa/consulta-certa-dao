package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Contato;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    private final Connection conn;

    public ContatoDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    //  CREATE
    public String inserir(Contato contato) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO contatos VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setInt(1, contato.getIdContato());
            stmt.setString(2, contato.getNome());
            stmt.setString(3, contato.getTelefone());
            stmt.setString(4, contato.getEmail());
            stmt.setString(5, contato.getNumero());
            stmt.setString(6, contato.getRua());
            stmt.setString(7, contato.getBairro());
            stmt.setString(8, contato.getCidade());
            stmt.setString(9, contato.getCep());
            stmt.execute();
            stmt.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public List<Contato> selecionar() {
        try {
            ArrayList<Contato> listaContatos = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM contatos");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();

                contato.setIdContato(rs.getInt(1));
                contato.setNome(rs.getString(2));
                contato.setTelefone(rs.getString(3));
                contato.setEmail(rs.getString(4));
                contato.setNumero(rs.getString(5));
                contato.setRua(rs.getString(6));
                contato.setBairro(rs.getString(7));
                contato.setCidade(rs.getString(8));
                contato.setCep(rs.getString(9));

                listaContatos.add(contato);
            }

            stmt.close();
            return listaContatos;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }


    //  UPDATE
    public String atualizar(Contato contato) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE contatos SET nome = ?, telefone = ?, email = ?, numero = ?, rua = ?, bairro = ?, cidade = ?, cep = ? WHERE id_contato = ?");
            stmt.setString(1, contato.getNome());
            stmt.setString(2, contato.getTelefone());
            stmt.setString(3, contato.getEmail());
            stmt.setString(4, contato.getNumero());
            stmt.setString(5, contato.getRua());
            stmt.setString(6, contato.getBairro());
            stmt.setString(7, contato.getCidade());
            stmt.setString(8, contato.getCep());
            stmt.setInt(9, contato.getIdContato());
            stmt.executeUpdate();
            stmt.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idContato) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM contatos WHERE id_contato = ?");
            stmt.setInt(1, idContato);
            stmt.execute();
            stmt.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}
