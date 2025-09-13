package br.com.fiap.model.dao;

import br.com.fiap.model.entity.Paciente;
import br.com.fiap.model.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PacienteDAO {
    private final Connection pacienteConn;

    public PacienteDAO () {
        this.pacienteConn = new ConnectionFactory().getConnection();
    }

    //  CREATE
    public String inserir(Paciente paciente) {
        try {
            PreparedStatement statement = pacienteConn.prepareStatement("INSERT INTO pacientes VALUES (?, ?, ?, ?)");
            statement.setInt(1, paciente.getIdPaciente());
            statement.setString(2, paciente.getNome());
            statement.setString(3, paciente.getEmail());
            statement.setInt(4, paciente.getTelefone());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public String selecionar(int idPaciente) {
        return "E";
    }

    //  UPDATE
    public String atualizar(Paciente paciente) {
        try {
            PreparedStatement statement = pacienteConn.prepareStatement("UPDATE pacientes SET nome = ?, email = ?, telefone = ? WHERE id_paciente = ?");
            statement.setString(1, paciente.getNome());
            statement.setString(2, paciente.getEmail());
            statement.setInt(3, paciente.getTelefone());
            statement.setInt(4, paciente.getIdPaciente());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idPaciente) {
        try {
            PreparedStatement statement = pacienteConn.prepareStatement("DELETE FROM pacientes WHERE id_paciente = ?");
            statement.setInt(1, idPaciente);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
}

/*
    //  CREATE
    public String inserir(Classe instancia) {
        try {
            PreparedStatement statement = instanciaConn.prepareStatement("INSERT INTO instancias VALUES (?, ?, ?, ?)");
            statement.setInt(1, instancia.getIdClasse());
            statement.setInt(2, instancia.getAtributos());
            statement.execute();
            statement.close();
            return "Dados inseridos na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    public String selecionar(int idPaciente) {
        return "E";
    }

    //  UPDATE
    public String atualizar(Classe instancia) {
        try {
            PreparedStatement statement = instanciaConn.prepareStatement("UPDATE instancias SET atributos = ? WHERE id_instancia = ?");
            statement.setString(1, instancia.getAtributos());
            statement.setInt(2, instancia.getIdClasse());
            statement.executeUpdate();
            statement.close();
            return "Dados atualizados na tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }

    //  DELETE
    public String deletar(int idClasse) {
        try {
            PreparedStatement statement = instanciaConn.prepareStatement("DELETE FROM instancias WHERE id_instancia = ?");
            statement.setInt(1, idClasse);
            statement.execute();
            statement.close();
            return "Dados removidos da tabela";

        } catch (SQLException e) {
            throw new RuntimeException("Erro envolvendo SQL Statement", e);
        }
    }
*/