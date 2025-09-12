package br.com.fiap.view;

import br.com.fiap.controller.ConsultaController;

import javax.swing.*;

public class ConsultaView {
    private final ConsultaController controller;

    public ConsultaView () {
        this.controller = new ConsultaController();
    }

    public void iniciar() {
        MenuCRUD.iniciarMenu(this::coletarInsercao,this::coletarSelecao, this::coletarAtualizacao, this::coletarRemocao);
    }

    private void coletarInsercao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da nova consulta");
        String especialidade = JOptionPane.showInputDialog("Informe a especialidade da nova consulta");
        String dataConsulta = JOptionPane.showInputDialog("Informe a data da nova consulta");
        String canalEnvio = JOptionPane.showInputDialog("Informe o canal de envio da nova consulta");
        controller.inserirConsulta(idConsulta, especialidade, dataConsulta, canalEnvio);
    }

    private void coletarSelecao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da nova consulta");
        controller.lerConsulta(idConsulta);    }

    private void coletarAtualizacao () {
        String especialidade = JOptionPane.showInputDialog("Informe a especialidade da nova consulta");
        String dataConsulta = JOptionPane.showInputDialog("Informe a data da nova consulta");
        String canalEnvio = JOptionPane.showInputDialog("Informe o canal de envio da nova consulta");
        String idConsulta = JOptionPane.showInputDialog("Informe o id da nova consulta");
        controller.atualizarConsulta(especialidade, dataConsulta, canalEnvio, idConsulta);
    }

    private void coletarRemocao () {
        String idConsulta = JOptionPane.showInputDialog("Informe o id da nova consulta");
        controller.deletarConsulta(idConsulta);
    }
}