package model;

import interfaces.IEstruturaDinamica;

public class FilaDinamica implements IEstruturaDinamica {
    private No primeiroNo;
    private No ultimoNo;

    public FilaDinamica(Integer primeiroNo) {
        this.primeiroNo = new No(primeiroNo);
        this.ultimoNo = this.primeiroNo;
    }

    @Override
    public void inserirElemento(Integer elemento) {
        No novoNo = new No(elemento);
        if (estaVazia()) {
            this.primeiroNo = novoNo;
            this.ultimoNo = this.primeiroNo;
            novoNo.setAnt(null);
            novoNo.setProx(null);
        } else {
            this.ultimoNo.setProx(novoNo);
            novoNo.setAnt(this.ultimoNo);
            this.ultimoNo = novoNo;
        }
    }

    @Override
    public void inserirSequencia(Integer[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            inserirElemento(elementos[i]);
        }
    }

    @Override
    public boolean removerElemento(Integer elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerElemento'");
    }

    @Override
    public void removerSequencia(Integer elementos) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerSequencia'");
    }

    @Override
    public void removerTodasOcorrencias(Integer elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'removerTodasOcorrencias'");
    }

    @Override
    public boolean estaCheia() {
        return false;
    }

    @Override
    public boolean estaVazia() {
        if (primeiroNo == null) {
            return true;
        }
        return false;
    }

    @Override
    public boolean buscarElemento(Integer elemento) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarElemento'");
    }

    @Override
    public void ordenarCrescente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarCrescente'");
    }

    @Override
    public void ordenarDecrescente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarDecrescente'");
    }

    @Override
    public int quantidadeElementos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quantidadeElementos'");
    }

    @Override
    public void editarElemento(Integer elementoAntigo, Integer elementoNovo) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'editarElemento'");
    }

    @Override
    public void limpar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'limpar'");
    }

    @Override
    public void exibir() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'exibir'");
    }

    @Override
    public No obterPrimeiroElemento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterPrimeiroElemento'");
    }

    @Override
    public No obterUltimoElemento() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'obterUltimoElemento'");
    }

}
