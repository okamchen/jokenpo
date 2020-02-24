package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;

public interface RegraJogada {

    String validarRegra(TipoJogada tipoJogada) throws BusinessException;

}
