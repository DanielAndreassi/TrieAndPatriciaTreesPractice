package com.fipp;

public class Fila {

    private NoFila fila;

    public Fila() {}

    public boolean isEmpty() {
        return fila == null;
    }

    public void enqueue(NoTree info) {
        if(isEmpty()){
            fila = new NoFila(info);
        }
        else{
            NoFila nc = new NoFila(info);
            NoFila percorrerFila = fila;
            while(percorrerFila.getProx() != null)
                percorrerFila = percorrerFila.getProx();
            percorrerFila.setProx(nc);
        }
    }

    public NoTree dequeue() {
        NoFila nc = fila;
        fila = fila.getProx();
        return nc.getInfo();
    }

    public int size() {
        int contador = 0;
        NoFila aux = fila;
        while(aux != null){
            contador++;
            aux = aux.getProx();
        }
        return contador;
    }

}
