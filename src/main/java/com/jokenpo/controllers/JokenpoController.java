package com.jokenpo.controllers;

import com.jokenpo.domains.TipoJogada;
import com.jokenpo.services.JokenpoService;

import static java.util.Objects.isNull;

public class JokenpoController {

    private static final String PARAMETRO_NAO_INFORMADO = "'%s' parâmetro não informado.";
    private static final String PRIMEIRO = "Primeiro";
    private static final String SEGUNDO = "Segundo";

    private JokenpoService jokenpoService = new JokenpoService();

    public String play(final String jogada1, final String jogada2) throws Exception {
        if (isNull(jogada1)) {
            throw new Exception(String.format(PARAMETRO_NAO_INFORMADO, PRIMEIRO));
        }

        if (isNull(jogada2)) {
            throw new Exception(String.format(PARAMETRO_NAO_INFORMADO, SEGUNDO));
        }

        final TipoJogada tipoJogada1 = TipoJogada.getEnumIgnoreCase(jogada1);
        final TipoJogada tipoJogada2 = TipoJogada.getEnumIgnoreCase(jogada2);

        return jokenpoService.execute(tipoJogada1, tipoJogada2);
    }

}
