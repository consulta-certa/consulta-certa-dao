package br.com.fiap.model.entity;

import java.time.LocalDateTime;

public class Consulta {
    private int idConsulta;
    private String especialidade;
    private LocalDateTime data_consulta;
    private String status;
    private int id_paciente;

    public Consulta() {
    }

    public Consulta(int idConsulta, String especialidade, LocalDateTime data_consulta, String status, int id_paciente) {
        this.idConsulta = idConsulta;
        this.especialidade = especialidade;
        this.data_consulta = data_consulta;
        this.status = status;
        this.id_paciente = id_paciente;
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

    public LocalDateTime getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(LocalDateTime data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }
}
