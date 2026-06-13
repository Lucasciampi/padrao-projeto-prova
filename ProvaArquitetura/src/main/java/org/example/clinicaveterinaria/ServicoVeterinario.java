package org.example.clinicaveterinaria;

public class ServicoVeterinario {
    private String descricao;
    private double valorBase;

    public ServicoVeterinario(String descricao, double valorBase) {
        this.descricao = descricao;
        this.valorBase = valorBase;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValorBase() {
        return valorBase;
    }
}
