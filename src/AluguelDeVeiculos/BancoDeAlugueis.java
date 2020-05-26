package AluguelDeVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class BancoDeAlugueis {

    private List<Aluguel> listaAlugueis = new ArrayList<Aluguel>();

    public BancoDeAlugueis(String arquivo) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha = br.readLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while(linha != null){

            String registro[] = linha.split(",");
            Aluguel aluguel = new Aluguel(registro, dtf, sdf);
        }
        br.close();
    }

    public Aluguel converte(String[] campos, SimpleDateFormat sdf, DateTimeFormatter dtf) throws Exception{


    }
}
