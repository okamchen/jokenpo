package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;

public class PedraRegraJogada implements RegraJogada {

    private static final String PEDRA_EMPATA_COM_PEDRA = "Pedra empata com Pedra.";
    private static final String PEDRA_GANHA_DE_TESOURA = "Pedra ganha de Tesoura.";
    private static final String PEDRA_PERDE_PARA_PAPEL = "Pedra perde para Papel.";
    private static final String JOGADA_DESCONHECIDA = "Jogada desconhecida.";

    @Override
    public String validarRegra(TipoJogada tipoJogada) throws BusinessException {
        if (TipoJogada.PEDRA.equals(tipoJogada)) {
            return PEDRA_EMPATA_COM_PEDRA;
        }

        if (TipoJogada.PAPEL.equals(tipoJogada)) {
            return PEDRA_PERDE_PARA_PAPEL;
        }

        if (TipoJogada.TESOURA.equals(tipoJogada)) {
            return PEDRA_GANHA_DE_TESOURA;
        }

        throw new BusinessException(JOGADA_DESCONHECIDA);
    }

}
