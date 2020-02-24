package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PedraRegraJogadaTest {

    private static final String PEDRA_EMPATA_COM_PEDRA = "Pedra empata com Pedra.";
    private static final String PEDRA_GANHA_DE_TESOURA = "Pedra ganha de Tesoura.";
    private static final String PEDRA_PERDE_PARA_PAPEL = "Pedra perde para Papel.";

    @InjectMocks
    private PedraRegraJogada regra;

    @Test
    public void deveRetonarMensagemPedraGanhaTesouraQuandoInformadoTesoura() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.TESOURA);
        assertEquals(retorno, PEDRA_GANHA_DE_TESOURA);
    }

    @Test
    public void deveRetonarMensagemPedraEmpataPedraQuandoInformadoPedra() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PEDRA);
        assertEquals(retorno, PEDRA_EMPATA_COM_PEDRA);
    }

    @Test
    public void deveRetonarMensagemPedraPerdePapelQuandoInformadoPapel() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PAPEL);
        assertEquals(retorno, PEDRA_PERDE_PARA_PAPEL);
    }

}