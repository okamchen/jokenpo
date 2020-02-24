package com.jokenpo.services;

import com.jokenpo.domains.TipoJogada;
import com.jokenpo.exception.BusinessException;
import com.jokenpo.validators.TipoJogadaValidator;

public class JokenpoService {

    private TipoJogadaValidator validator = new TipoJogadaValidator();

    public String execute(final TipoJogada jogada1, final TipoJogada jogada2) throws BusinessException {
        validator.execute(jogada1, jogada1);

        return jogada1.validarRegra(jogada2);
    }

}
