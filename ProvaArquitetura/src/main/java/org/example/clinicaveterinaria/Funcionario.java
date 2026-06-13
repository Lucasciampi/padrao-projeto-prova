package org.example.clinicaveterinaria;

import java.util.Observable;
import java.util.Observer;

public abstract class Funcionario implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Funcionario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public final void update(Observable o, Object arg) {
        String mensagem = (String) arg;
        this.ultimaNotificacao = nome + ": " + mensagem;
        reagirNotificacao(mensagem);
    }

    public abstract void reagirNotificacao(String mensagem);
}
