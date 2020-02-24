package com.jokenpo.services;

import com.jokenpo.domains.TipoJogada;
import com.jokenpo.exception.BusinessException;
import com.jokenpo.validators.TipoJogadaValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class JokenpoServiceTest {

    @InjectMocks
    private JokenpoService service;

    @Mock
    private TipoJogadaValidator validator;

    @Captor
    private ArgumentCaptor<TipoJogada> tipoJogada1Captor;

    @Captor
    private ArgumentCaptor<TipoJogada> tipoJogada2Captor;

    @Test(expected = BusinessException.class)
    public void deveExecutarValidacaoComParametroInformadosSempreQueInvocadoMetodoExecute() throws BusinessException {
        TipoJogada jogada1 = null;
        TipoJogada jogada2 = null;
        try {
            doThrow(new BusinessException(random(10))).when(validator).execute(jogada1, jogada2);

            service.execute(jogada1, jogada2);
        } catch (BusinessException exception) {
            verify(validator).execute(tipoJogada1Captor.capture(), tipoJogada2Captor.capture());

            assertEquals(jogada1, tipoJogada1Captor.getValue());
            assertEquals(jogada2, tipoJogada2Captor.getValue());

            throw exception;
        }
    }

    @Test
    public void deveRetornarMensagemQuandoInformadosTiposValidos() throws BusinessException {
        TipoJogada jogada1 = TipoJogada.PAPEL;
        TipoJogada jogada2 = TipoJogada.PEDRA;

        final String mensagem = service.execute(jogada1, jogada2);

        assertNotNull(mensagem);
    }

}