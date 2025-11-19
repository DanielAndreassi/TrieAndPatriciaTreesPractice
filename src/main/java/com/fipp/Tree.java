package com.fipp;

public class Tree {
    private final int TAMANHO_ALFABETO = 26;
    private final char LETRA_BASE = 'a';
    private NoTree raiz;

    public Tree() {
        this.raiz = new NoTree("");
    }

    public void inserir (String palavra) {
        palavra = palavra.toLowerCase();
        int pos = palavra.charAt(0) - LETRA_BASE;
        NoTree pai = raiz,sub = raiz.getVlig(pos);
        String prefixo, posfixo;
        boolean flag = true;
        int i = 0;

        while(sub != null && flag) {
            palavra = palavra.substring(1);
            for(i = 1; !palavra.isEmpty() && i < sub.getPalavra().length(); i++)
                if(palavra.charAt(0) != sub.getPalavra().charAt(i))
                    flag = false;
                else
                    palavra = palavra.substring(1);

            if(flag)
                if(palavra.isEmpty()) {
                    prefixo = sub.getPalavra().substring(0,i);
                    posfixo = sub.getPalavra().substring(i);

                    NoTree nc = new NoTree(prefixo,true);
                    sub.setPalavra(posfixo);
                    pos = posfixo.charAt(0) -  LETRA_BASE;
                    nc.setVlig(pos,sub);

                    pos = nc.getPalavra().charAt(0) - LETRA_BASE;
                    pai.setVlig(pos,nc);
                    flag = false;
                }
                else {
                    pai = sub;
                    pos = palavra.charAt(0) - LETRA_BASE;
                    sub = pai.getVlig(pos);
                }
        }
        if(sub == null)
            pai.setVlig(pos, new NoTree(palavra,true));
        else if(!palavra.isEmpty()) {
            prefixo = sub.getPalavra().substring(0,i-1);
            posfixo = sub.getPalavra().substring(i-1);

            NoTree nc = new NoTree(prefixo);
            sub.setPalavra(posfixo);
            pos = posfixo.charAt(0) - LETRA_BASE;
            nc.setVlig(pos,sub);

            pos = palavra.charAt(0) - LETRA_BASE;
            nc.setVlig(pos,new NoTree(palavra,true));

            pos = prefixo.charAt(0) - LETRA_BASE;
            pai.setVlig(pos,nc);
        }
    }

    public void exibirEmNivel() {
        Fila fila = new Fila();
        NoTree noTree;
        int nivel = 1; // comeca de 1 pois 0 eh raiz e nao eh exibida

        for (int i = 0; i < TAMANHO_ALFABETO; i++)
            if(raiz.getVlig(i) != null)
                fila.enqueue(raiz.getVlig(i));

        while(!fila.isEmpty()) {
            //size apenas calcula quantos nos tem no nivel para entrar na repiticao do nivel pode ser feito sem tambem
            //fiz apenas para exibir o nivel que esta a palavra
            int qtdNosNivel = fila.size();

            while(qtdNosNivel > 0) {
                noTree = fila.dequeue();
                // Cria uma string com espaços baseada no nível (ex: nível 3 = "   ")
                String indent = " ".repeat((nivel - 1) * 2);
                String marcador = noTree.isFlag() ? "[x]" : "";

                System.out.println(indent + nivel + ". " + noTree.getPalavra() + marcador);
                for (int i = 0; i < TAMANHO_ALFABETO; i++)
                    if(noTree.getVlig(i) != null)
                        fila.enqueue(noTree.getVlig(i));

                qtdNosNivel--;
            }
            nivel++;
        }
    }

    private void imprimirPalavras(NoTree noTree,String palavra) {
        palavra = palavra.concat(noTree.getPalavra());

        if(noTree.isFlag())
            System.out.println(palavra);
        for (int i = 0; i < TAMANHO_ALFABETO; i++)
            if(noTree.getVlig(i) != null)
                imprimirPalavras(noTree.getVlig(i),palavra);
    }

    public void imprimir() {
        for (int i = 0; i < TAMANHO_ALFABETO; i++)
            if (raiz.getVlig(i) != null)
                imprimirPalavras(raiz.getVlig(i),"");
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.inserir("amarelo");
        tree.inserir("amar");
        tree.inserir("ama");
        tree.inserir("bear");
        tree.inserir("Bell");
        tree.inserir("bid");
        tree.inserir("Bull");
        tree.inserir("buy");
        tree.inserir("sell");
        tree.inserir("stock");
        tree.inserir("stop");
        tree.inserir("amigo");
        tree.inserir("amiga");
        tree.inserir("amor");
        tree.inserir("bala");
        tree.inserir("bola");
        tree.inserir("banco");
        tree.inserir("cartao");
        tree.inserir("carta");
        tree.inserir("correr");
        tree.inserir("dado");
        tree.inserir("desenho");
        tree.inserir("dica");
        tree.inserir("eixo");
        tree.inserir("elefante");
        tree.inserir("eco");
        tree.inserir("foca");
        tree.inserir("foco");
        tree.inserir("flor");
        tree.inserir("gelo");
        tree.inserir("gole");
        tree.inserir("gato");
        tree.inserir("homem");
        tree.inserir("homen");
        tree.inserir("horm");
        tree.inserir("ilustracao");
        tree.inserir("imprimir");
        tree.inserir("inicio");
        tree.inserir("leao");
        tree.inserir("lanche");
        tree.inserir("limbo");
        tree.inserir("lar");
        tree.inserir("macho");
        tree.inserir("mae");
        tree.inserir("mentir");
        tree.inserir("mistura");
        tree.inserir("noite");
        tree.inserir("nuvem");
        tree.inserir("nunca");
        tree.inserir("oasis");
        tree.inserir("obama");
        tree.inserir("osso");
        tree.inserir("plantar");
        tree.inserir("pular");
        tree.inserir("pilar");
        tree.inserir("ver");
        tree.inserir("vaso");
        tree.inserir("vaca");
        tree.inserir("viver");
        tree.inserir("zapato");

        System.out.println("Exbicao em nível");
        tree.exibirEmNivel();
        System.out.println();
        System.out.println("Palavras na árvore:");
        tree.imprimir();
    }
}