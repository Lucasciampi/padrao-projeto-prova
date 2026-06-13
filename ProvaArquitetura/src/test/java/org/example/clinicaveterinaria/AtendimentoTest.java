package org.example.clinicaveterinaria;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AtendimentoTest {

    Atendimento atendimento;
    Tutor tutor;
    Veterinario veterinario;
    Recepcao recepcao;
    Animal animal;

    @BeforeEach
    void setUp() {
        animal = new Animal("Robson", "Cachorro", false);
        tutor = new Tutor("Carlos", animal);
        veterinario = new Veterinario("Dra. Veterinaria");
        recepcao = new Recepcao("Recepcionista");
        ServicoVeterinario servico = new ServicoVeterinario("Consulta", 100.0);
        atendimento = new Atendimento(tutor, servico);
        atendimento.addObserver(tutor);
        atendimento.addObserver(veterinario);
        atendimento.addObserver(recepcao);
    }

    @Test
    void deveIniciarAtendimentoAgendado() {
        assertTrue(atendimento.iniciar());
        assertEquals("EmAtendimento", atendimento.getNomeEstado());
    }

    @Test
    void deveCancelarAtendimentoAgendado() {
        assertTrue(atendimento.cancelar());
        assertEquals("Cancelado", atendimento.getNomeEstado());
    }

    @Test
    void deveFinalizarAtendimentoEmAtendimento() {
        atendimento.iniciar();
        assertTrue(atendimento.finalizar());
        assertEquals("Finalizado", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveFinalizarAtendimentoAgendado() {
        assertFalse(atendimento.finalizar());
        assertEquals("Agendado", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveCancelarAtendimentoFinalizado() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertFalse(atendimento.cancelar());
        assertEquals("Finalizado", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveIniciarAtendimentoCancelado() {
        atendimento.cancelar();
        assertFalse(atendimento.iniciar());
        assertEquals("Cancelado", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveFinalizarAtendimentoCancelado() {
        atendimento.cancelar();
        assertFalse(atendimento.finalizar());
        assertEquals("Cancelado", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveIniciarAtendimentoJaEmAtendimento() {
        atendimento.iniciar();
        assertFalse(atendimento.iniciar());
        assertEquals("EmAtendimento", atendimento.getNomeEstado());
    }

    @Test
    void naoDeveCancelarAtendimentoEmAtendimento() {
        atendimento.iniciar();
        assertFalse(atendimento.cancelar());
        assertEquals("EmAtendimento", atendimento.getNomeEstado());
    }

    @Test
    void deveComunicarTutorAoIniciarAtendimento() {
        atendimento.iniciar();
        assertEquals("Atendimento de Robson foi iniciado.", tutor.getUltimaNotificacao());
    }

    @Test
    void deveComunicarVeterinarioAoIniciarAtendimento() {
        atendimento.iniciar();
        assertEquals("Dra. Veterinaria: Atendimento de Robson foi iniciado.", veterinario.getUltimaNotificacao());
    }

    @Test
    void deveComunicarVeterinarioAoCancelarAtendimento() {
        atendimento.cancelar();
        assertEquals("Dra. Veterinaria: Atendimento de Robson foi cancelado.", veterinario.getUltimaNotificacao());
    }

    @Test
    void deveComunicarRecepcaoAoFinalizarAtendimento() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertEquals("Recepcionista: Atendimento de Robson foi finalizado.", recepcao.getUltimaNotificacao());
    }

    @Test
    void naoDeveNotificarSeTransicaoInvalida() {
        atendimento.finalizar();
        assertNull(tutor.getUltimaNotificacao());
        assertNull(veterinario.getUltimaNotificacao());
        assertNull(recepcao.getUltimaNotificacao());
    }
    
    @Test
    void deveVeterinarioAbrirProntuarioAoIniciar() {
        atendimento.iniciar();
        assertEquals("Abrindo prontuário médico para o animal.", veterinario.getAcaoRealizada());
    }

    @Test
    void deveVeterinarioLiberarAgendaAoCancelar() {
        atendimento.cancelar();
        assertEquals("Liberando agenda de atendimentos.", veterinario.getAcaoRealizada());
    }

    @Test
    void deveRecepcaoAgendarRetornoAoFinalizar() {
        atendimento.iniciar();
        atendimento.finalizar();
        assertEquals("Agendando retorno do paciente e processando pagamento.", recepcao.getAcaoRealizada());
    }

    @Test
    void deveRecepcaoNotificarTutorAoCancelar() {
        atendimento.cancelar();
        assertEquals("Notificando tutor sobre cancelamento e abrindo fila de espera.", recepcao.getAcaoRealizada());
    }

    @Test
    void deveRetornarValorBaseSemDecoradores() {
        assertEquals(100.0, atendimento.getValor(), 0.01);
    }

    @Test
    void deveAplicarDescontoParaAnimalAdotado() {
        Animal animalAdotado = new Animal("Robson", "Cachorro", true);
        AtendimentoComponente valor = new Desconto(atendimento, animalAdotado);
        assertEquals(90.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Desconto animal adotado", valor.getDescricao());
    }

    @Test
    void naoDeveAplicarDescontoParaAnimalNaoAdotado() {
        AtendimentoComponente valor = new Desconto(atendimento, animal);
        assertEquals(100.0, valor.getValor(), 0.01);
        assertEquals("Consulta", valor.getDescricao());
    }

    @Test
    void deveAplicarTaxaDomiciliar() {
        AtendimentoComponente valor = new Taxa(atendimento);
        assertEquals(150.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Taxa domiciliar", valor.getDescricao());
    }

    @Test
    void deveAplicarBanhoPosConsulta() {
        AtendimentoComponente valor = new BanhoPosConsulta(atendimento);
        assertEquals(180.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Banho pós-consulta", valor.getDescricao());
    }

    @Test
    void deveAplicarTaxaEBanhoCombinados() {
        AtendimentoComponente valor = new BanhoPosConsulta(new Taxa(atendimento));
        assertEquals(230.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Taxa domiciliar / Banho pós-consulta", valor.getDescricao());
    }

    @Test
    void deveAplicarDescontoETaxaParaAnimalAdotado() {
        Animal animalAdotado = new Animal("Robson", "Cachorro", true);
        AtendimentoComponente valor = new Taxa(new Desconto(atendimento, animalAdotado));
        assertEquals(140.0, valor.getValor(), 0.01);
    }

    @Test
    void deveAplicarTodosOsDecoradoresParaAnimalAdotado() {
        Animal animalAdotado = new Animal("Robson", "Cachorro", true);
        AtendimentoComponente valor = new BanhoPosConsulta(new Taxa(new Desconto(atendimento, animalAdotado)));
        assertEquals(220.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Desconto animal adotado / Taxa domiciliar / Banho pós-consulta", valor.getDescricao());
    }

    @Test
    void deveAplicarTaxaEBanhoParaAnimalNaoAdotado() {
        AtendimentoComponente valor = new BanhoPosConsulta(new Taxa(new Desconto(atendimento, animal)));
        assertEquals(230.0, valor.getValor(), 0.01);
        assertEquals("Consulta / Taxa domiciliar / Banho pós-consulta", valor.getDescricao());
    }
}