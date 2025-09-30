package br.com.fiap.model.entity;

public class Contato {
    private int idContato;
    private String nome;
    private String telefone;
    private String email;
    private int numero;
    private String rua;
    private String bairro;
    private String cidade;
    private String cep;

    public Contato() {
    }

    public Contato(int idContato, String nome, String telefone, String email, int numero, String rua, String bairro, String cidade, String cep) {
        this.idContato = idContato;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.numero = numero;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.cep = cep;
    }

    public int getIdContato() {
        return idContato;
    }

    public void setIdContato(int idContato) {
        this.idContato = idContato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public String toString() {
        return (
            "\nid_contato: " + idContato +
            "\nnome: " + nome +
            "\ntelefone: " + telefone +
            "\nemail: " + email +
            "\nnumero: " + numero +
            "\nrua: " + rua +
            "\nbairro: " + bairro +
            "\ncidade: " + cidade +
            "\ncep: " + cep
        );
    }
}
