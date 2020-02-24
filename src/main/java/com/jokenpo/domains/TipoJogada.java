package com.jokenpo.domains;

import com.jokenpo.exception.BusinessException;

import java.util.EnumSet;

import static org.apache.commons.lang3.StringUtils.isBlank;

public enum TipoJogada implements RegraJogada {

    PEDRA("PEDRA", new PedraRegraJogada()),
    PAPEL("PAPEL", new PapelRegraJogada()),
    TESOURA("TESOURA", new TesouraRegraJogada());

    private static final String VALOR_INVALIDO = "Valor inválido.";

    private String descricao;
    private RegraJogada regraJogada;

    TipoJogada(final String descricao, final RegraJogada regraJogada) {
        this.descricao = descricao;
        this.regraJogada = regraJogada;
    }

    @Override
    public String validarRegra(TipoJogada tipoJogada) throws BusinessException {
        return this.regraJogada.validarRegra(tipoJogada);
    }

    public static TipoJogada getEnumIgnoreCase(final String valor) throws BusinessException {
        if (isBlank(valor)) {
            throw new BusinessException(VALOR_INVALIDO);
        }

        return EnumSet.allOf(TipoJogada.class)
                .stream()
                .filter(tipo -> tipo.name().equalsIgnoreCase(valor))
                .findFirst().orElseThrow(() -> new BusinessException(VALOR_INVALIDO));
    }

    public String getDescricao() {
        return this.descricao;
    }

    public RegraJogada getRegra() {
        return this.regraJogada;
    }
}
