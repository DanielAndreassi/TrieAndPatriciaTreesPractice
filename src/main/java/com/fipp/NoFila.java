package com.fipp;

public class NoFila {

    private NoTree info;
    private NoFila prox;

    public NoFila(NoTree info) {
        this.info = info;
    }
    public NoTree getInfo() {
        return info;
    }

    public NoFila getProx() {
        return prox;
    }

    public void setProx(NoFila prox) {
        this.prox = prox;
    }
}
