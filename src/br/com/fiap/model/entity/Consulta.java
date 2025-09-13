package br.com.fiap.model.entity;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta;
    private String especialidade;
    private LocalDateTime dataConsulta;
    private String status;
    private int idPaciente;

    public Consulta() {
    }

    public Consulta(int idConsulta, String especialidade, LocalDateTime dataConsulta, String status, int id_paciente) {
        this.idConsulta = idConsulta;
        this.especialidade = especialidade;
        this.dataConsulta = dataConsulta;
        this.status = status;
        this.idPaciente = idPaciente;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public LocalDateTime getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDateTime dataConsulta) {
        this.dataConsulta = dataConsulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }
}
