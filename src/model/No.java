package model;

import interfaces.INo;

public class No implements INo {
    private Integer conteudo;
    private No prox;
    private No ant;

    public No(Integer conteudo) {
        this.conteudo = conteudo;
        this.prox = null;
        this.ant = null;
    }

    @Override
    public No getProx() {
        return this.prox;
    }

    @Override
    public void setProx(No prox) {
        this.prox = prox;
    }

    @Override
    public Integer getConteudo() {
        return this.conteudo;
    }

    @Override
    public void setConteudo(Integer conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public No getAnt() {
        return this.ant;
    }

    @Override
    public void setAnt(No ant) {
        this.ant = ant;
    }

}
