package br.com.fiap.model.entity;

import java.time.LocalDateTime;

public class Avaliacao {
    private int idAvaliacao;
    private int nota;
    private String comentario;
    private LocalDateTime dataAvaliacao;

    public Avaliacao() {}

    public Avaliacao(int idAvaliacao, int nota, String comentario, LocalDateTime dataAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.nota = nota;
        this.comentario = comentario;
        this.dataAvaliacao = dataAvaliacao;
    }

    public int getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(int idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public LocalDateTime getDataAvaliacao() {
        return dataAvaliacao;
    }

    public void setDataAvaliacao(LocalDateTime dataAvaliacao) {
        this.dataAvaliacao = dataAvaliacao;
    }

    @Override
    public String toString() {
        return (
            "\nid_avaliacao: " + idAvaliacao +
            "\nnota: " + nota +
            "\ncomentario: " + comentario +
            "\ndata_avaliacao: " + dataAvaliacao
        );
    }
}