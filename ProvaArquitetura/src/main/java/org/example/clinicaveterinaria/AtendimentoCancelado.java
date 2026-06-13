package org.example.clinicaveterinaria;

public class AtendimentoCancelado extends AtendimentoEstado {

    private AtendimentoCancelado() {}
    private static AtendimentoCancelado instance = new AtendimentoCancelado();
    public static AtendimentoCancelado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Cancelado";
    }
}