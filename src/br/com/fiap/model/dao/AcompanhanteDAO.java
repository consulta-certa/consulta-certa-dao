package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Acompanhante;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AcompanhanteDAO {
    private final Connection conn;

    public AcompanhanteDAO() {
        this.conn = new ConnectionFactory().getConnection();
    }

    // CREATE
    public String inserir(Acompanhante acompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO acompanhantes VALUES (?, ?, ?, ?, ?)");
            stmt.setInt(1, acompanhante.getIdAcompanhante());
            stmt.setString(2, acompanhante.getEmail());
            stmt.setString(3, acompanhante.getTelefone());
            stmt.setString(4, acompanhante.getParentesco());
            stmt.setInt(5, acompanhante.getIdPaciente());
            stmt.execute();
            stmt.close();
            return "Acompanhante inserido com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir acompanhante", e);
        }
    }

    // READ
    public List<Acompanhante> selecionar() {
        try {
            ArrayList<Acompanhante> listaAcompanhantes = new ArrayList<>();

            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM acompanhantes");
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Acompanhante acompanhante = new Acompanhante();

                acompanhante.setIdAcompanhante(rs.getInt(1));
                acompanhante.setEmail(rs.getString(2));
                acompanhante.setTelefone(rs.getString(3));
                acompanhante.setParentesco(rs.getString(4));
                acompanhante.setIdPaciente(rs.getInt(5));

                listaAcompanhantes.add(acompanhante);
            }

            stmt.close();
            return listaAcompanhantes;
        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    // UPDATE
    public String atualizar(Acompanhante acompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("UPDATE acompanhantes SET email = ?, telefone = ?, parentesco = ?, idPaciente = ? WHERE idAcompanhante = ?");
            stmt.setString(1, acompanhante.getEmail());
            stmt.setString(2, acompanhante.getTelefone());
            stmt.setString(3, acompanhante.getParentesco());
            stmt.setInt(4, acompanhante.getIdPaciente());
            stmt.setInt(5, acompanhante.getIdAcompanhante());
            stmt.executeUpdate();
            stmt.close();
            return "Acompanhante atualizado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar acompanhante", e);
        }
    }

    // DELETE
    public String deletar(int idAcompanhante) {
        try {
            PreparedStatement stmt = conn.prepareStatement("DELETE FROM acompanhantes WHERE idAcompanhante = ?");
            stmt.setInt(1, idAcompanhante);
            stmt.execute();
            stmt.close();
            return "Acompanhante deletado com sucesso!";
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao deletar acompanhante", e);
        }
    }
}