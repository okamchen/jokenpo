package com.jokenpo;

import com.jokenpo.controllers.JokenpoController;

public class Main {

    private static final String MININO_ARGUMENTOS_NAO_INFORMADOS = "É necessário informar 2 argumentos para rodar o jogo.";

    public static void main(String[] args) {
        try {
            if (args == null || args.length < 2) {
                throw new Exception(MININO_ARGUMENTOS_NAO_INFORMADOS);
            }

            final JokenpoController controller = new JokenpoController();
            final String resultado = controller.play(args[0], args[1]);

            System.out.print(resultado);
        } catch (Exception exception) {
            System.out.print(exception.getMessage());
        }

    }
}
