package org.example.clinicaveterinaria;

public class Desconto extends AtendimentoDecorator {

    private Animal animal;

    public Desconto(AtendimentoComponente atendimento, Animal animal) {
        super(atendimento);
        this.animal = animal;
    }

    @Override
    public double getValor() {
        if (animal.isAdotado()) {
            return super.getValor() * 0.9;
        }
        return super.getValor();
    }

    @Override
    public String getDescricao() {
        if (animal.isAdotado()) {
            return super.getDescricao() + " / Desconto animal adotado";
        }
        return super.getDescricao();
    }
}