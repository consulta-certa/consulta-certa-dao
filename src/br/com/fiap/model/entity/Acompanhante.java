package br.com.fiap.model.entity;

public class Acompanhante {
    private int idAcompanhante;
    private String nome;
    private String email;
    private String telefone;
    private String parentesco;
    private int idPaciente;

    public Acompanhante() {}

    public Acompanhante(int idAcompanhante, String nome, String email, String telefone, String parentesco, int idPaciente) {
        this.idAcompanhante = idAcompanhante;
        this.email = email;
        this.nome = nome;
        this.telefone = telefone;
        this.parentesco = parentesco;
        this.idPaciente = idPaciente;
    }

    public int getIdAcompanhante() {
        return idAcompanhante;
    }

    public void setIdAcompanhante(int idAcompanhante) {
        this.idAcompanhante = idAcompanhante;
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

    public String getParentesco() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    @Override
    public String toString() {
        return (
            "\nid_acompanhante: " + idAcompanhante +
            "\nemail: " + email +
            "\ntelefone: " + telefone +
            "\nparentesco: " + parentesco +
            "\nid_paciente: " + idPaciente
        );
    }
}

