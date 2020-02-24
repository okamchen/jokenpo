package com.jokenpo;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MainTest {

    private static final String MININO_ARGUMENTOS_NAO_INFORMADOS = "É necessário informar 2 argumentos para rodar o jogo.";

    @Test
    public void deveLancarExcecaoQuandoNaoInformadoArgumento() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        Main.main(null);

        verify(out).print(MININO_ARGUMENTOS_NAO_INFORMADOS);
    }

    @Test
    public void deveLancarExcecaoQuandoInformadoSomenteUmArgumento() {
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        final String[] args = {""};

        Main.main(args);

        verify(out).print(MININO_ARGUMENTOS_NAO_INFORMADOS);
    }

    @Test
    public void deveApresentarMensagemRetornadaDeController() throws Exception {
        final String[] args = {"PEDRA", "PAPEL"};
        PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        final String mensagemRetorno = "Pedra perde para Papel.";

        Main.main(args);

        verify(out).print(mensagemRetorno);
    }

}