package com.jokenpo.controllers;

import com.jokenpo.domains.TipoJogada;
import com.jokenpo.services.JokenpoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JokenpoControllerTest {

    private static final String PARAMETRO_INVALIDO = "Parâmetro '%s' inválido.";
    private static final String PARAMETRO_NAO_INFORMADO = "'%s' parâmetro não informado.";
    private static final String PRIMEIRO = "Primeiro";
    private static final String SEGUNDO = "Segundo";
    private static final String VALOR_INVALIDO = "Valor inválido.";

    @InjectMocks
    private  JokenpoController controller;

    @Mock
    private JokenpoService service;

    @Captor
    private ArgumentCaptor<TipoJogada> tipoJogada1Captor;

    @Captor
    private ArgumentCaptor<TipoJogada> tipoJogada2Captor;

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoPrimeiroValorInformadoNaoForInformado() throws Exception {
        try {
            controller.play(null, null);
        } catch (Exception expcetion) {
            assertEquals(expcetion.getMessage(), String.format(PARAMETRO_NAO_INFORMADO, PRIMEIRO));
            throw expcetion;
        } finally {
            verify(service, never()).execute(any(TipoJogada.class), any(TipoJogada.class));
        }
    }

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoSegundoValorInformadoNaoForInformado() throws Exception {
        final String jogada1 = TipoJogada.PAPEL.getDescricao();

        try {
            controller.play(jogada1, null);
        } catch (Exception expcetion) {
            assertEquals(expcetion.getMessage(), String.format(PARAMETRO_NAO_INFORMADO, SEGUNDO));
            throw expcetion;
        } finally {
            verify(service, never()).execute(any(TipoJogada.class), any(TipoJogada.class));
        }
    }

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoPrimeiroValorInformadoNaoForValido() throws Exception {
        final String valor1 = random(10);
        try {
            controller.play(valor1, TipoJogada.PAPEL.getDescricao());
        } catch (Exception expcetion) {
            assertEquals(expcetion.getMessage(), VALOR_INVALIDO);
            throw expcetion;
        } finally {
            verify(service, never()).execute(any(TipoJogada.class), any(TipoJogada.class));
        }
    }

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoSegundoValorInformadoNaoForValido() throws Exception {
        final String valor2 = random(10);
        try {
            controller.play( TipoJogada.PAPEL.getDescricao(), valor2);
        } catch (Exception expcetion) {
            assertEquals(expcetion.getMessage(), VALOR_INVALIDO);
            throw expcetion;
        } finally {
            verify(service, never()).execute(any(TipoJogada.class), any(TipoJogada.class));
        }
    }

    @Test
    public void deveRetornarMensagemDeRegraDeJokenpoServiceQuandoInformadoValoresDeJogadasValidas() throws Exception {
        final String jogada1 = TipoJogada.PAPEL.getDescricao();
        final String jogada2 = TipoJogada.TESOURA.getDescricao();
        final String mensagemRetorno = random(10);

        when(service.execute(any(TipoJogada.class), any(TipoJogada.class))).thenReturn(mensagemRetorno);

        final String mensagem = controller.play(jogada1, jogada2);

        assertEquals(mensagem, mensagemRetorno);
    }

    @Test
    public void deveRepassarValoresDeJogadaParaJokenpoServiceQuandoInformadoValoresDeJogadasValidas() throws Exception {
        final String jogada1 = TipoJogada.PAPEL.getDescricao();
        final String jogada2 = TipoJogada.TESOURA.getDescricao();
        final String mensagemRetorno = random(10);

        when(service.execute(any(TipoJogada.class), any(TipoJogada.class))).thenReturn(mensagemRetorno);

        controller.play(jogada1, jogada2);

        verify(service).execute(tipoJogada1Captor.capture(), tipoJogada2Captor.capture());

        assertEquals(tipoJogada1Captor.getValue().getDescricao(), jogada1);
        assertEquals(tipoJogada2Captor.getValue().getDescricao(), jogada2);
    }

}
