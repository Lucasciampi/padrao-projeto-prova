package org.example.clinicaveterinaria;

import java.util.Observable;

public class Atendimento extends Observable implements AtendimentoComponente {

    private AtendimentoEstado estado;
    private Tutor tutor;
    private ServicoVeterinario servico;

    public Atendimento(Tutor tutor, ServicoVeterinario servico) {
        this.estado = AtendimentoAgendado.getInstance();
        this.tutor = tutor;
        this.servico = servico;
    }

    public void setEstado(AtendimentoEstado estado) {
        this.estado = estado;
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public Tutor getTutor() {
        return tutor;
    }

    public ServicoVeterinario getServico() {
        return servico;
    }

    public boolean iniciar() {
        boolean sucesso = estado.iniciar(this);
        if (sucesso) {
            setChanged();
            notifyObservers("Atendimento de " + tutor.getAnimal().getNome() + " foi iniciado.");
        }
        return sucesso;
    }

    public boolean finalizar() {
        boolean sucesso = estado.finalizar(this);
        if (sucesso) {
            setChanged();
            notifyObservers("Atendimento de " + tutor.getAnimal().getNome() + " foi finalizado.");
        }
        return sucesso;
    }

    public boolean cancelar() {
        boolean sucesso = estado.cancelar(this);
        if (sucesso) {
            setChanged();
            notifyObservers("Atendimento de " + tutor.getAnimal().getNome() + " foi cancelado.");
        }
        return sucesso;
    }

    @Override
    public double getValor() {
        return servico.getValorBase();
    }

    @Override
    public String getDescricao() {
        return servico.getDescricao();
    }
}