package br.com.fiap.model.entity;

import java.time.LocalDateTime;

public class Lembrete {
    private int idLembrete;
    private String canalEnvio;
    private LocalDateTime dataEnvio;
    private int idConsulta;

    public Lembrete() {}

    public Lembrete(int idLembrete, String canalEnvio, LocalDateTime dataEnvio, int idConsulta) {
        this.idLembrete = idLembrete;
        this.canalEnvio = canalEnvio;
        this.dataEnvio = dataEnvio;
        this.idConsulta = idConsulta;
    }

    public int getIdLembrete() {
        return idLembrete;
    }

    public void setIdLembrete(int idLembrete) {
        this.idLembrete = idLembrete;
    }

    public String getCanalEnvio() {
        return canalEnvio;
    }

    public void setCanalEnvio(String canalEnvio) {
        this.canalEnvio = canalEnvio;
    }

    public LocalDateTime getDataEnvio() {
        return dataEnvio;
    }

    public void setDataEnvio(LocalDateTime dataEnvio) {
        this.dataEnvio = dataEnvio;
    }

    public int getIdConsulta() {
        return idConsulta;
    }

    public void setIdConsulta(int idConsulta) {
        this.idConsulta = idConsulta;
    }
}