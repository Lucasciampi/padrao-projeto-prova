package org.example.clinicaveterinaria;

public class Recepcao extends Funcionario {
    private String acaoRealizada;

    public Recepcao(String nome) {
        super(nome);
    }

    @Override
    public void reagirNotificacao(String mensagem) {
        if (mensagem.contains("finalizado")) {
            this.acaoRealizada = "Agendando retorno do paciente e processando pagamento.";
        } else if (mensagem.contains("cancelado")) {
            this.acaoRealizada = "Notificando tutor sobre cancelamento e abrindo fila de espera.";
        }
    }

    public String getAcaoRealizada() {
        return acaoRealizada;
    }
}
