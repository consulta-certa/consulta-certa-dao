package br.com.fiap.controller;

import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.util.DataFormatter;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class ConsultaController {
    private final ConsultaDAO dao;

    public ConsultaController () {
        this.dao = new ConsultaDAO();
    }

/* EXECUÇÃO DAS OPERAÇÕES CRUD */
//  Execução do CREATE
    public void inserirConsulta(String idConsultaString, String especialidade, String dataConsultaString, int statusInt, String idPacienteString) {
        if (
            !Validacao.validarInteger(idConsultaString) ||
            !Validacao.validarTexto(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarInteger(idPacienteString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString, DataFormatter.formatter);
        String status = "I";

        // Check constraint
        if (statusInt == 0) {
            status = "A";
        }

        if (dataConsulta.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta(idConsulta, especialidade, dataConsulta, status, idPaciente);
        JOptionPane.showMessageDialog(null, dao.inserir(consulta));
    }

// Execução do READ
    public void lerConsulta() {
        int continuar;
        int contador = 0;
        List<Consulta> consultasSelecionadas = dao.selecionar();

        int quantSelecionados = consultasSelecionadas.toArray().length;

        do {
            if (quantSelecionados == 0) {
                JOptionPane.showMessageDialog(null, "Lista vazia.");
                return;
            }

            JOptionPane.showMessageDialog(null, consultasSelecionadas.get(contador), "RESULTADOS DA QUERY EM consultas", JOptionPane.INFORMATION_MESSAGE);

            if (contador < (quantSelecionados -1)) {
                continuar = (JOptionPane.showConfirmDialog(null, "Deseja ver o próximo registro?", "", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE));
                contador++;

            } else {
                return;
            }
        } while (continuar == 0);
    }

// Execução do UPDATE
    public void atualizarConsulta(String especialidade, String dataConsultaString, int statusInt, String idPacienteString, String idConsultaString) {
        if (
            !Validacao.validarTexto(especialidade) ||
            !Validacao.validarData(dataConsultaString) ||
            !Validacao.validarInteger(idPacienteString) ||
            !Validacao.validarInteger(idConsultaString)
        ) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        LocalDateTime dataConsulta = LocalDateTime.parse(dataConsultaString, DataFormatter.formatter);
        String status = "I";

        // Check constraint
        if (statusInt == 0) {
            status = "A";
        }

        if (dataConsulta.isBefore(LocalDateTime.now())) {
            JOptionPane.showMessageDialog(null, "Operação cancelada. Inserir apenas uma data válida a partir de hoje.");
            return;
        }

        int idPaciente = Integer.parseInt(idPacienteString);

        Consulta consulta = new Consulta(idConsulta, especialidade, dataConsulta, status, idPaciente);
        JOptionPane.showMessageDialog(null, dao.atualizar(consulta));
    }

// Execução do DELETE
    public void deletarConsulta(String idConsultaString) {
        if (!Validacao.validarInteger(idConsultaString)) {
            return;
        }

        int idConsulta = Integer.parseInt(idConsultaString);
        JOptionPane.showMessageDialog(null, dao.deletar(idConsulta));
    }
}
