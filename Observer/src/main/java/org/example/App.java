package org.example;

import java.util.Observable;

public class App extends Observable {
    private String nome;
    private String versao;

    public App(String nome, String versao) {
        this.nome = nome;
        this.versao = versao;
    }

    public void atualizarVersao(String novaVersao) {
        this.versao = novaVersao;
        setChanged();
        notifyObservers();
    }

    public String getNome() {
        return nome;
    }

    public String getVersao() {
        return versao;
    }

    @Override
    public String toString() {
        return nome + " (versão: " + versao + ")";
    }
}