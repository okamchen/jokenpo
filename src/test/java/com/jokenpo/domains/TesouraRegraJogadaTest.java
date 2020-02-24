package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class TesouraRegraJogadaTest {

    private static final String TESOURA_EMPATA_COM_TESOURA = "Tesoura empata com Tesoura.";
    private static final String TESOURA_GANHA_DE_PAPEL = "Tesoura ganha de Papel.";
    private static final String TESOURA_PERDE_PARA_PEDRA = "Tesoura perde para Pedra.";

    @InjectMocks
    private TesouraRegraJogada regra;

    @Test
    public void deveRetornarMensagemTesouraGanhaPapelQuandoInformadoPapel() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PAPEL);
        assertEquals(retorno, TESOURA_GANHA_DE_PAPEL);
    }

    @Test
    public void deveRetornarMensagemTesouraPerdePedraQuandoInformadoPedra() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PEDRA);
        assertEquals(retorno, TESOURA_PERDE_PARA_PEDRA);
    }

    @Test
    public void deveRetornarMensagemTesouraEmpataComTesouraQuandoInformadoTesoura() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.TESOURA);
        assertEquals(retorno, TESOURA_EMPATA_COM_TESOURA);
    }

}