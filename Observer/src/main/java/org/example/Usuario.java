package org.example;

import java.util.Observable;
import java.util.Observer;

public class Usuario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Observable app, Object arg) {
        if (app instanceof App) {
            App aplicativo = (App) app;
            this.ultimaNotificacao = nome + ", nova atualização disponível: " + aplicativo.toString();
            System.out.println(ultimaNotificacao);
        }
    }

    public void seguirApp(App app) {
        app.addObserver(this);
    }
}
