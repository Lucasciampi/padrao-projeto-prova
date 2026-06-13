package org.example.clinicaveterinaria;

public abstract class AtendimentoDecorator implements AtendimentoComponente {
    private AtendimentoComponente atendimento;

    public AtendimentoDecorator(AtendimentoComponente atendimento) {
        this.atendimento = atendimento;
    }

    public AtendimentoComponente getAtendimento() {
        return atendimento;
    }

    @Override
    public double getValor() {
        return this.atendimento.getValor();
    }

    @Override
    public String getDescricao() {
        return this.atendimento.getDescricao();
    }
}
