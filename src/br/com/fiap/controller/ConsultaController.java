package br.com.fiap.controller;

import br.com.fiap.model.dao.ConsultaDAO;
import br.com.fiap.model.entity.Consulta;
import br.com.fiap.model.util.Validacao;

import javax.swing.*;

public class ConsultaController {
    private final ConsultaDAO consultaDAO;

    public ConsultaController () {
        this.consultaDAO = new ConsultaDAO();
    }

/* EXECUÇÃO DAS OPERAÇÕES CRUD */
//  Execução do CREATE
    public void inserirConsulta(String idConsulta, String especialidade, String dataConsulta, String canalEnvio) {
        if (
            !Validacao.validarInteger(idConsulta) ||
            !Validacao.validarString(especialidade) ||
            !Validacao.validarString(canalEnvio)
        ) {
            return;
        }

        int id_consulta = Integer.parseInt(idConsulta);

        Consulta consulta = new Consulta();
        consulta.setEspecialidade(especialidade);
        consulta.setData_consulta(dataConsulta);
        consulta.setCanal_envio(canalEnvio);
        consulta.setId_consulta(id_consulta);

        JOptionPane.showMessageDialog(null, consultaDAO.inserir(consulta));
    }

// Execução do READ
    public void lerConsulta(String idConsulta) {
        if (!Validacao.validarInteger(idConsulta)) {
            return;
        }

        int id_consulta = Integer.parseInt(idConsulta);
        JOptionPane.showMessageDialog(null, consultaDAO.selecionar(idConsulta));
    }

// Execução do UPDATE
    public void atualizarConsulta(String especialidade, String dataConsulta, String canalEnvio, String idConsulta) {
        if (
            !Validacao.validarString(especialidade) ||
            !Validacao.validarString(canalEnvio) ||
            !Validacao.validarInteger(idConsulta)
        ) {
            return;
        }

        int id_consulta = Integer.parseInt(idConsulta);

        Consulta consulta = new Consulta();
        consulta.setEspecialidade(especialidade);
        consulta.setData_consulta(dataConsulta);
        consulta.setCanal_envio(canalEnvio);
        consulta.setId_consulta(id_consulta);

        JOptionPane.showMessageDialog(null, consultaDAO.atualizar(consulta));
    }

// Execução do DELETE
    public void deletarConsulta(String idConsulta) {
        if (!Validacao.validarInteger(idConsulta)) {
            return;
        }

        int id_consulta = Integer.parseInt(idConsulta);
        JOptionPane.showMessageDialog(null, consultaDAO.deletar(id_consulta));
    }
}
