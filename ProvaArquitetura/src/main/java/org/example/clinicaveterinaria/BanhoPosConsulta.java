package org.example.clinicaveterinaria;

public class BanhoPosConsulta extends AtendimentoDecorator {
    public BanhoPosConsulta(AtendimentoComponente atendimento) {
        super(atendimento);
    }

    @Override
    public double getValor() {
        return super.getValor() + 80.0; // R$80.00 banho pós-consulta
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " / Banho pós-consulta";
    }
}
