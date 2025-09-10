package br.com.fiap.dao;

import br.com.fiap.infraestructure.connection.ConnectionFactory;
import br.com.fiap.model.Consulta;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class ConsultaDAO {
    Consulta consulta = new Consulta();
    Connection consultaConn = new ConnectionFactory().getConnection();

    PreparedStatement stmt;
}