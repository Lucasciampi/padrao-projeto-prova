package org.example.clinicaveterinaria;

public class AtendimentoFinalizado extends AtendimentoEstado {

    private AtendimentoFinalizado() {}
    private static AtendimentoFinalizado instance = new AtendimentoFinalizado();
    public static AtendimentoFinalizado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Finalizado";
    }
}