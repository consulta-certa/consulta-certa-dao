package br.com.fiap.model.entity;

import java.time.LocalDateTime;

public class Conteudo {
    private int idConteudo;
    private String tipo;
    private String titulo;
    private String texto;
    private String video;
    private String imagem;
    private LocalDateTime dataPublicacao;

    public Conteudo() {}

    public Conteudo(int idConteudo, String tipo, String titulo, String texto, String video, String imagem, LocalDateTime dataPublicacao) {
        this.idConteudo = idConteudo;
        this.tipo = tipo;
        this.titulo = titulo;
        this.texto = texto;
        this.video = video;
        this.imagem = imagem;
        this.dataPublicacao = dataPublicacao;
    }

    public int getIdConteudo() {
        return idConteudo;
    }

    public void setIdConteudo(int idConteudo) {
        this.idConteudo = idConteudo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    @Override
    public String toString() {
        return (
            "id_conteudo: " + idConteudo +
            "\ntipo: " + tipo +
            "\ntitulo: " + titulo +
            "\ntexto: " + texto +
            "\nvideo: " + video +
            "\nimagem: " + imagem +
            "\ndata_publicacao: " + dataPublicacao
        );
    }
}