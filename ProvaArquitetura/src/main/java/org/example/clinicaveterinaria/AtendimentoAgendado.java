package org.example.clinicaveterinaria;

public class AtendimentoAgendado extends AtendimentoEstado {

    private AtendimentoAgendado() {}
    private static AtendimentoAgendado instance = new AtendimentoAgendado();
    public static AtendimentoAgendado getInstance() {
        return instance;
    }

    @Override
    public String getEstado() {
        return "Agendado";
    }

    @Override
    public boolean iniciar(Atendimento atendimento) {
        atendimento.setEstado(AtendimentoEmAtendimento.getInstance());
        return true;
    }

    @Override
    public boolean cancelar(Atendimento atendimento) {
        atendimento.setEstado(AtendimentoCancelado.getInstance());
        return true;
    }
}