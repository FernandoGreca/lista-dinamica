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
            System.out.println("A fila está vazia, não há elemento para remover.");
            return;
        }
        No atual = this.primeiroNo;
        // Caso seja o primeiro elemento a ser removido
        if (atual.getConteudo().equals(elemento)) {
            this.primeiroNo = atual.getProx();
            if (this.primeiroNo != null) {
                this.primeiroNo.setAnt(null);
            } else {
                this.ultimoNo = null;
            }
            System.out.println("O elemento " + elemento + " foi removido.");
            return;
        }
        // Percorre a fila para encontrar o elemento, enquanto o atual não for nulo e
        // atual não for igual ao elemento pega o próximo
        while (atual != null && !atual.getConteudo().equals(elemento)) {
            atual = atual.getProx();
        }
        // Se o elemento não foi encontrado
        if (atual == null) {
            System.out.println("O elemento " + elemento + " não está na fila.");
            return;
        }
        // Se o elemento for o último nó
        if (atual == this.ultimoNo) {
            this.ultimoNo = atual.getAnt();
            if (this.ultimoNo != null) {
                this.ultimoNo.setProx(null);
            }
        } else {
            // Caso esteja no meio da fila para corrigir os apontamentos
            atual.getAnt().setProx(atual.getProx());
            atual.getProx().setAnt(atual.getAnt());
        }
        System.out.println("O elemento " + elemento + " foi removido.");

    }

    @Override
    public void removerSequencia(Integer[] elementos) {
        for (int i = 0; i < elementos.length; i++) {
            removerElemento(elementos[i]);
        }
    }

    @Override
    public void removerTodasOcorrencias(Integer elemento) {
        if (estaVazia()) {
            System.out.println("A fila está vazia, não há elementos para remover.");
            return;
        }
        No atual = this.primeiroNo;
        while (atual != null) {
            if (atual.getConteudo().equals(elemento)) {
                // Caso seja o primeiro nó
                if (atual == this.primeiroNo) {
                    this.primeiroNo = atual.getProx();
                    if (this.primeiroNo != null) {
                        this.primeiroNo.setAnt(null);
                    } else {
                        this.ultimoNo = null; // Para caso a fila esteja vazia, tem que atualiza o ultimoNo
                    }
                }
                // Caso seja o último nó
                else if (atual == this.ultimoNo) {
                    this.ultimoNo = atual.getAnt();
                    if (this.ultimoNo != null) {
                        this.ultimoNo.setProx(null);
                    }
                }
                // Caso seja um nó intermediário
                else {
                    atual.getAnt().setProx(atual.getProx());
                    atual.getProx().setAnt(atual.getAnt());
                }
            }
            // Se atual não for igual ao elemento
            atual = atual.getProx();
        }
        System.out.println("Todas as ocorrências do elemento " + elemento + " foram removidas.");
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
        if (estaVazia()) {
            System.out.println("A fila está vazia, não há elementos para ordenar");
        } else {
            int contadorTrocas = 0;
            No aux = this.primeiroNo;

            while (aux.getProx() != null) {
                No auxProx = aux.getProx();

                if (aux.getConteudo() > auxProx.getConteudo()) {
                    int temp = aux.getConteudo();
                    aux.setConteudo(auxProx.getConteudo());
                    auxProx.setConteudo(temp);
                    contadorTrocas++;
                }
                aux = auxProx;
            }
            // O processo de repete através da recursividade até que o contadorTrocas seja 0, o que significa que está ordenado
            if (contadorTrocas > 0) {
                ordenarCrescente();
            }
        }
    }

    @Override
    public void ordenarDecrescente() {
        if (estaVazia()) {
            System.out.println("A fila está vazia. Não há o que ordenar.");
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
