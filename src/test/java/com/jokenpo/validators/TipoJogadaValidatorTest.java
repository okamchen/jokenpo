package com.jokenpo.validators;

import com.jokenpo.domains.TipoJogada;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class TipoJogadaValidatorTest {

    private static final String PARAMENTRO_NAO_INFORMADO = "'%s' não informado.";
    private static final String PRIMEIRO = "Primeiro";
    private static final String SEGUNDO = "Segundo";

    @InjectMocks
    private TipoJogadaValidator validator;

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoPrimeiroValorInformadoForNulo() throws Exception {
        try {
            validator.execute(null, null);
        } catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), String.format(PARAMENTRO_NAO_INFORMADO, PRIMEIRO));
            throw  exception;
        }
    }

    @Test(expected = Exception.class)
    public void deveLancarExceptionQuandoPrimeiroValorInformadoForEmBranco() throws Exception {
        try {
            validator.execute(TipoJogada.PAPEL, null);
        } catch (Exception exception) {
            Assert.assertEquals(exception.getMessage(), String.format(PARAMENTRO_NAO_INFORMADO, SEGUNDO));
            throw  exception;
        }
    }

    @Test
    public void naoDeveLancarExceptionQuandoValoresInformadosForemValidos() throws Exception {
        validator.execute(TipoJogada.PAPEL, TipoJogada.TESOURA);
    }

}