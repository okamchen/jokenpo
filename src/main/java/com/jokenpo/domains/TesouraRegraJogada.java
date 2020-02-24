package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;

public class TesouraRegraJogada implements RegraJogada {

    private static final String TESOURA_EMPATA_COM_TESOURA = "Tesoura empata com Tesoura.";
    private static final String TESOURA_GANHA_DE_PAPEL = "Tesoura ganha de Papel.";
    private static final String TESOURA_PERDE_PARA_PEDRA = "Tesoura perde para Pedra.";
    private static final String JOGADA_DESCONHECIDA = "Jogada desconhecida.";

    @Override
    public String validarRegra(TipoJogada tipoJogada) throws BusinessException {
        if (TipoJogada.TESOURA.equals(tipoJogada)) {
            return TESOURA_EMPATA_COM_TESOURA;
        }

        if (TipoJogada.PEDRA.equals(tipoJogada)) {
            return TESOURA_PERDE_PARA_PEDRA;
        }

        if (TipoJogada.PAPEL.equals(tipoJogada)) {
            return TESOURA_GANHA_DE_PAPEL;
        }

        throw new BusinessException(JOGADA_DESCONHECIDA);
    }

}
