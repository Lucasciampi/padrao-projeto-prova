package org.example.clinicaveterinaria;

import java.util.Observable;
import java.util.Observer;

public class Tutor implements Observer {
    private String nome;
    private Animal animal;
    private String ultimaNotificacao;

    public Tutor(String nome, Animal animal) {
        this.nome = nome;
        this.animal = animal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public String getUltimaNotificacao() {
        return ultimaNotificacao;
    }

    @Override
    public void update(Observable o, Object arg) {
        this.ultimaNotificacao = (String) arg;
    }
}
