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
        No aux = this.ultimoNo;
        int contador = 0;

        while (aux.getAnt() != null) {
            if (aux.getConteudo() > aux.getAnt().getConteudo()) {
                int aux2 = aux.getConteudo();
                aux.setConteudo(aux.getAnt().getConteudo());
                aux.getAnt().setConteudo(aux2);
                contador++;
            }
        }

        if (contador != 0) {
            ordenarDecrescente();
        }
    }

    @Override
    public int quantidadeElementos() {
        No aux = this.primeiroNo;
        int contador = 0;
        while (aux != null) {
            contador++;
            aux = aux.getProx();
        }
        return contador;
    }

    @Override
    public void editarElemento(Integer elementoAntigo, Integer elementoNovo) {
        No aux = obterElemento(elementoAntigo);
        if (aux != null) {
            aux.setConteudo(elementoNovo);
        } else {
            System.out.println("Elemento não encontrado.");
        }
    }

    public No obterElemento(Integer elemento) {
        No aux = this.primeiroNo;
        while (aux != null) {
            if (aux.getConteudo() == elemento) {
                return aux;
            }
            aux = aux.getProx();
        }
        return null;
    }

    @Override
    public void limpar() {
        No aux = this.primeiroNo;
        while (aux != null) {
            aux.setConteudo(null);
            aux = aux.getProx();
        }
    }

    @Override
    public void exibir() {
        No aux = this.primeiroNo;
        while (aux != null) {
            System.out.println(aux.getConteudo());
            aux = aux.getProx();
        }
    }

    @Override
    public No obterPrimeiroElemento() {
        return this.primeiroNo;
    }

    @Override
    public No obterUltimoElemento() {
        return this.ultimoNo;
    }

}
