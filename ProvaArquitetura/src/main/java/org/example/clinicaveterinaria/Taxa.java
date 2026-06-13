package org.example.clinicaveterinaria;

public class Taxa extends AtendimentoDecorator {
    public Taxa(AtendimentoComponente atendimento) {
        super(atendimento);
    }

    @Override
    public double getValor() {
        return super.getValor() + 50.0;
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " / Taxa domiciliar";
    }
}
