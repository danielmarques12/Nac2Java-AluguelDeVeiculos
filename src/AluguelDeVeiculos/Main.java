package AluguelDeVeiculos;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        BancoDeAlugueis bancoDeAlugueis = new BancoDeAlugueis(
                "D:\\Biblioteca\\Documents\\Pasta Faculdade\\" +
                        "2º Ano\\POO com Java e Web\\Nac2 - CSV\\dados.csv");

        bancoDeAlugueis.retornaAluguelDoCarro("LXD-4902");
        bancoDeAlugueis.retornaCarrosaluguel();

    }
}
