package AluguelDeVeiculos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BancoDeAlugueis bancoDeAlugueis = new BancoDeAlugueis(
                "D:\\Biblioteca\\Documentos\\Pasta Faculdade\\POO com Java e Web\\" +
                        "Nac2Java-AluguelDeVeiculos\\dados.csv");

        bancoDeAlugueis.retornaAluguelDoCarro("LXD-4902");
        bancoDeAlugueis.retornaCarrosaluguel();

    }
}
