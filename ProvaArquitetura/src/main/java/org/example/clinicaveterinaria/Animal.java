package org.example.clinicaveterinaria;

public class Animal {
    private String nome;
    private String especie;
    private boolean adotado;

    public Animal(String nome, String especie, boolean adotado) {
        this.nome = nome;
        this.especie = especie;
        this.adotado = adotado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public boolean isAdotado() {
        return adotado;
    }

    public void setAdotado(boolean adotado) {
        this.adotado = adotado;
    }
}
