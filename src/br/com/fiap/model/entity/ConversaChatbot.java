package br.com.fiap.model.entity;

public class ConversaChatbot {
    private int idConversa;
    private String pergunta;
    private String aprovacao;

    public ConversaChatbot() {}

    public ConversaChatbot(int idConversa, String pergunta, String aprovacao) {
        this.idConversa = idConversa;
        this.pergunta = pergunta;
        this.aprovacao = aprovacao;
    }

    public int getIdConversa() {
        return idConversa;
    }

    public void setIdConversa(int idConversa) {
        this.idConversa = idConversa;
    }

    public String getPergunta() {
        return pergunta;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public String getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(String aprovacao) {
        this.aprovacao = aprovacao;
    }

    @Override
    public String toString() {
        return (
            "\nid_conversa: " + idConversa +
            "\npergunta: " + pergunta +
            "\naprovacao: " + aprovacao
        );
    }
}