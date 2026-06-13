package org.example.clinicaveterinaria;

public class Veterinario extends Funcionario {
    private String acaoRealizada;

    public Veterinario(String nome) {
        super(nome);
    }

    @Override
    public void reagirNotificacao(String mensagem) {
        if (mensagem.contains("iniciado")) {
            this.acaoRealizada = "Abrindo prontuário médico para o animal.";
        } else if (mensagem.contains("cancelado")) {
            this.acaoRealizada = "Liberando agenda de atendimentos.";
        }
    }

    public String getAcaoRealizada() {
        return acaoRealizada;
    }
}
