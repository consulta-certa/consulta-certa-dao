package br.com.fiap.controller;

import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class ConsultaController {
    private final ConsultaDAO consultaDAO;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm").withResolverStyle(ResolverStyle.STRICT);

    public ConsultaController () {
        this.consultaDAO = new ConsultaDAO();
    }

/* EXECUÇÃO DAS OPERAÇÕES CRUD */
//  Execução do CREATE
    public void inserirConsulta(String idConsultaString, String especialidade, String dataConsultaString, String status, String idPacienteString) {
        if (
            !Validacao.validarInteger(idConsultaString) ||
            !Validacao.validarString(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarString(status) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString,formatter);
        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta();
        consulta.setIdConsulta(idConsulta);
        consulta.setEspecialidade(especialidade);
        consulta.setData_consulta(dataConsulta);
        consulta.setStatus(status);
        consulta.setId_paciente(idPaciente);

        JOptionPane.showMessageDialog(null, consultaDAO.inserir(consulta));
    }

// Execução do READ
    public void lerConsulta(String idConsultaString) {
        if (!Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        JOptionPane.showMessageDialog(null, consultaDAO.selecionar(idConsulta));
    }

// Execução do UPDATE
    public void atualizarConsulta(String especialidade, String dataConsultaString, String status, String idPacienteString, String idConsultaString) {
        if (
            !Validacao.validarString(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarString(status) ||
            !Validacao.validarInteger(idPacienteString) ||
            !Validacao.validarInteger(idConsultaString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString,formatter);
        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta();
        consulta.setEspecialidade(especialidade);
        consulta.setData_consulta(dataConsulta);
        consulta.setStatus(status);
        consulta.setId_paciente(idPaciente);
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
