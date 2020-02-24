package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class PapelRegraJogadaTest {

    private static final String PAPEL_EMPATA_COM_PAPEL = "Papel empata com Papel.";
    private static final String PAPEL_GANHA_DE_PEDRA = "Papel ganha de Pedra.";
    private static final String PAPEL_PERDE_PARA_TESOURA = "Papel perde para Tesoura.";

    @InjectMocks
    private PapelRegraJogada regra;

    @Test
    public void deveRetornarMensagemPapelGanhaPedraQuandoInformadoPedra() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PEDRA);
        assertEquals(retorno, PAPEL_GANHA_DE_PEDRA);
    }

    @Test
    public void deveRetornarMensagemPapelPerdeTesouraQuandoInformadoTesoura() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.TESOURA);
        assertEquals(retorno, PAPEL_PERDE_PARA_TESOURA);
    }

    @Test
    public void deveRetornarMensagemPapelEmpataComPapelQuandoInformadoPapel() throws BusinessException {
        final String retorno = regra.validarRegra(TipoJogada.PAPEL);
        assertEquals(retorno, PAPEL_EMPATA_COM_PAPEL);
    }

}