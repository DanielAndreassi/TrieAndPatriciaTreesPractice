package com.fipp;

public class NoTree {
    private String palavra;
    private NoTree[] Vlig;
    private boolean flag;

    public NoTree(String palavra) {
        this.palavra = palavra;
        this.Vlig = new NoTree[26];
        this.flag = false;
    }

    public NoTree(String palavra, boolean flag) {
        this.palavra = palavra;
        this.flag = flag;
        this.Vlig = new NoTree[26];
    }

    public NoTree(String palavra, NoTree[] Vlig, boolean flag) {
        this.palavra = palavra;
        this.Vlig = Vlig;
        this.flag = flag;
    }

    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public NoTree getVlig(int pos) {
        return Vlig[pos];
    }

    public void setVlig(int pos, NoTree vlig) {
        this.Vlig[pos] = vlig;
    }

    public boolean isFlag() {
        return flag;
    }
}
