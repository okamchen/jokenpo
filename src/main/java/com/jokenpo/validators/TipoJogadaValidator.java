package com.jokenpo.validators;

import com.jokenpo.domains.TipoJogada;
import com.jokenpo.exception.BusinessException;

import static java.util.Objects.isNull;

public class TipoJogadaValidator {

    private static final String PARAMENTRO_NAO_INFORMADO = "'%s' não informado.";
    private static final String PRIMEIRO = "Primeiro";
    private static final String SEGUNDO = "Segundo";

    public void execute(final TipoJogada jogada1, final TipoJogada jogada2) throws BusinessException {
        if (isNull(jogada1)) {
            throw new BusinessException(String.format(PARAMENTRO_NAO_INFORMADO, PRIMEIRO));
        }

        if (isNull(jogada2)) {
            throw new BusinessException(String.format(PARAMENTRO_NAO_INFORMADO, SEGUNDO));
        }

    }
}
