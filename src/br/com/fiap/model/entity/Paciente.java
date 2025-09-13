package br.com.fiap.model.entity;

public class Paciente {
    private int idPaciente;
    private String nome;
    private String email;
    private int telefone;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nome, String email, int telefone) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }
}
