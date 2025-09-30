package br.com.fiap.model.entity;

public class Paciente {
    private int idPaciente;
    private String nome;
    private String email;
    private String telefone;
    private String acompanhante;

    public Paciente() {
    }

    public Paciente(int idPaciente, String nome, String email, String telefone, String acompanhante) {
        this.idPaciente = idPaciente;
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.acompanhante = acompanhante;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getAcompanhante() {
        return acompanhante;
    }

    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    @Override
    public String toString() {
        return (
            "id_paciente: " + idPaciente +
            "nome: " + nome +
            "email: " + email +
            "telefone: " + telefone +
            "acompanhante: " + acompanhante
        );
    }
}
