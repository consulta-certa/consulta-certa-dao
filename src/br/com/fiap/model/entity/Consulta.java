package br.com.fiap.model.entity;

public class Consulta {
    private int id_consulta;
    private String especialidade;
    private String data_consulta;
    private String canal_envio;

    public Consulta() {
    }

    public Consulta(int id_consulta, String especialidade, String data_consulta, String canal_envio) {
        this.id_consulta = id_consulta;
        this.especialidade = especialidade;
        this.data_consulta = data_consulta;
        this.canal_envio = canal_envio;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(String data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getCanal_envio() {
        return canal_envio;
    }

    public void setCanal_envio(String canal_envio) {
        this.canal_envio = canal_envio;
    }
}
