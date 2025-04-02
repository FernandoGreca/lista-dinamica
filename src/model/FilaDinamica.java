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
    public void removerElemento(Integer elemento) {
        if (estaVazia()) {
            System.out.println("A fila está vazia, não existe elemento(s) para remover");
        } else {
            if (this.primeiroNo == this.ultimoNo) {
                this.primeiroNo = this.primeiroNo.getProx();
                this.ultimoNo = this.primeiroNo;
            } else {
                this.primeiroNo = this.primeiroNo.getProx();
            }
        }
    }

    @Override
    public void removerSequencia(Integer[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            removerElemento(elementos[i]);
        }
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
        if (estaVazia()) {
            System.out.println("A fila está vazia, não há elementos para serem buscados.");
            return false;
        }
        No atual = this.primeiroNo;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                System.out.println("O elemento " + elemento + " existe na fila.");
                return true;
            }
            atual = atual.getProx();
        }
        System.out.println("O elemento " + elemento + " não foi encontrado na fila.");
        return false;
    }

    @Override
    public void ordenarCrescente() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ordenarCrescente'");
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não à o que ordenar.");
        } else {
            int contador = 0;
            No aux = this.ultimoNo;

            while (aux.getAnt() != null) {
                No auxAnt = aux.getAnt();

                if (aux.getConteudo() > auxAnt.getConteudo()) {
                    int temp = aux.getConteudo();
                    aux.setConteudo(auxAnt.getConteudo());
                    auxAnt.setConteudo(temp);

                    contador++;
                }

                aux = auxAnt;
            }

            if (contador > 0) {
                ordenarDecrescente();
            }
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
