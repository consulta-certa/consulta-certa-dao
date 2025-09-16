package br.com.fiap.model.entity;

public class AcessoFuncionalidade {
    private int idAcesso;
    private String funcionalidade;
    private int quantidadeAcessos;
    private int tempoPermanenciaSeg;

    public AcessoFuncionalidade() {}

    public AcessoFuncionalidade(int idAcesso, String funcionalidade, int quantidadeAcessos, int tempoPermanenciaSeg) {
        this.idAcesso = idAcesso;
        this.funcionalidade = funcionalidade;
        this.quantidadeAcessos = quantidadeAcessos;
        this.tempoPermanenciaSeg = tempoPermanenciaSeg;
    }

    public int getIdAcesso() {
        return idAcesso;
    }

    public void setIdAcesso(int idAcesso) {
        this.idAcesso = idAcesso;
    }

    public String getFuncionalidade() {
        return funcionalidade;
    }

    public void setFuncionalidade(String funcionalidade) {
        this.funcionalidade = funcionalidade;
    }

    public int getQuantidadeAcessos() {
        return quantidadeAcessos;
    }

    public void setQuantidadeAcessos(int quantidadeAcessos) {
        this.quantidadeAcessos = quantidadeAcessos;
    }

    public int getTempoPermanenciaSeg() {
        return tempoPermanenciaSeg;
    }

    public void setTempoPermanenciaSeg(int tempoPermanenciaSeg) {
        this.tempoPermanenciaSeg = tempoPermanenciaSeg;
    }

    @Override
    public String toString() {
        return (
            String.format("--------------%n") +
            String.format("| %40s | %30s | %20s | %10s |\n", "id_acesso","funcionalidade","quantidade_acesso", "tempo_permanencia_seg") +
            String.format("| %40s | %30s | %20s | %10s |\n",idAcesso, funcionalidade, quantidadeAcessos, tempoPermanenciaSeg)
        );
    }
}