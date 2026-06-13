package org.example.clinicaveterinaria;

public class AtendimentoEmAtendimento extends AtendimentoEstado {

    private AtendimentoEmAtendimento() {}
    private static AtendimentoEmAtendimento instance = new AtendimentoEmAtendimento();
    public static AtendimentoEmAtendimento getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "EmAtendimento";
    }

    @Override
    public boolean finalizar(Atendimento atd) {
        atd.setEstado(AtendimentoFinalizado.getInstance());
        return true;
    }
}