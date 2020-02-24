package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;

public class PapelRegraJogada implements RegraJogada {

    private static final String PAPEL_EMPATA_COM_PAPEL = "Papel empata com Papel.";
    private static final String PAPEL_GANHA_DE_PEDRA = "Papel ganha de Pedra.";
    private static final String PAPEL_PERDE_PARA_TESOURA = "Papel perde para Tesoura.";
    private static final String JOGADA_DESCONHECIDA = "Jogada desconhecida.";

    @Override
    public String validarRegra(TipoJogada tipoJogada) throws BusinessException {
        if (TipoJogada.PAPEL.equals(tipoJogada)) {
            return PAPEL_EMPATA_COM_PAPEL;
        }

        if (TipoJogada.PEDRA.equals(tipoJogada)) {
            return PAPEL_GANHA_DE_PEDRA;
        }

        if (TipoJogada.TESOURA.equals(tipoJogada)) {
            return PAPEL_PERDE_PARA_TESOURA;
        }

        throw new BusinessException(JOGADA_DESCONHECIDA);
    }

}
