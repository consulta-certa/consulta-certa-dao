package br.com.fiap.controller;

import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class ConsultaController {
    private final ConsultaDAO consultaDAO;

    public ConsultaController () {
        this.consultaDAO = new ConsultaDAO();
    }

/* EXECUÇÃO DAS OPERAÇÕES CRUD */
//  Execução do CREATE
    public void inserirConsulta(String idConsultaString, String especialidade, String dataConsultaString, String status, String idPacienteString) {
        if (
            !Validacao.validarInteger(idConsultaString) ||
            !Validacao.validarNome(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarNome(status) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString, DataFormatter.formatter);
        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);
        consulta.setEspecialidade(especialidade);
        consulta.setDataConsulta(dataConsulta);
        consulta.setStatus(status);
        consulta.setIdPaciente(idPaciente);

        JOptionPane.showMessageDialog(null, consultaDAO.inserir(consulta));
    }

// Execução do READ
    public void lerConsulta() {
        JOptionPane.showMessageDialog(null, consultaDAO.selecionar());
    }

// Execução do UPDATE
    public void atualizarConsulta(String especialidade, String dataConsultaString, String status, String idPacienteString, String idConsultaString) {
        if (
            !Validacao.validarNome(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarNome(status) ||
            !Validacao.validarInteger(idPacienteString) ||
            !Validacao.validarInteger(idConsultaString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString, DataFormatter.formatter);
        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta();
        consulta.setEspecialidade(especialidade);
        consulta.setDataConsulta(dataConsulta);
        consulta.setStatus(status);
        consulta.setIdPaciente(idPaciente);
        consulta.setIdConsulta(idConsulta);

        JOptionPane.showMessageDialog(null, consultaDAO.atualizar(consulta));
    }

// Execução do DELETE
    public void deletarConsulta(String idConsultaString) {
        if (!Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        JOptionPane.showMessageDialog(null, consultaDAO.deletar(idConsulta));
    }
}
