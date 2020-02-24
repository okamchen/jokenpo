package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.apache.commons.lang3.RandomStringUtils.random;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class TipoJogadaTest {

    private static final String VALOR_INVALIDO = "Valor inválido.";

    @Captor
    private ArgumentCaptor<TipoJogada> tipoJogadaCaptor;

    @Test
    public void deveImplementarRegraDoTipoTesouraQuandoEnumForTesoura() {
        assertEquals(TipoJogada.TESOURA.getRegra().getClass(), TesouraRegraJogada.class);
    }

    @Test
    public void deveImplementarRegraDoTipoPapelQuandoEnumForPapel() {
        assertEquals(TipoJogada.PAPEL.getRegra().getClass(), PapelRegraJogada.class);
    }

    @Test
    public void deveImplementarRegraDoTipoPedraQuandoEnumForPedra() {
        assertEquals(TipoJogada.PEDRA.getRegra().getClass(), PedraRegraJogada.class);
    }

    @Test(expected = BusinessException.class)
    public void deveLancarExceptionQuandoValorInformadoForNulo() throws BusinessException {
        try {
            TipoJogada.getEnumIgnoreCase(null);
        } catch (BusinessException exception) {
            assertEquals(exception.getMessage(), VALOR_INVALIDO);
            throw exception;
        }
    }

    @Test(expected = BusinessException.class)
    public void deveLancarExceptionQuandoValorInformadoNaoExistirComoTipo() throws BusinessException {
        try {
            TipoJogada.getEnumIgnoreCase(random(10));
        } catch (BusinessException exception) {
            assertEquals(exception.getMessage(), VALOR_INVALIDO);
            throw exception;
        }
    }

    @Test
    public void deveRetornarTipoQuandoValorInformadoForIgualATipo() throws BusinessException {
        TipoJogada retorno = TipoJogada.getEnumIgnoreCase(TipoJogada.TESOURA.getDescricao());
        assertEquals(retorno, TipoJogada.TESOURA);
    }

}