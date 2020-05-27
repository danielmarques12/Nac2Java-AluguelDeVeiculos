package AluguelDeVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class BancoDeAlugueis {

    private List<Aluguel> listaDeAlugueis = new ArrayList<Aluguel>();

    public BancoDeAlugueis(String arquivo) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha = br.readLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while(linha != null){

            String registro[] = linha.split(",");
            Aluguel aluguel = converte(registro, sdf, dtf);
            listaDeAlugueis.add(aluguel);
            linha = br.readLine();
        }
        br.close();
    }

    private Aluguel converte(String[] campos, SimpleDateFormat sdf, DateTimeFormatter dtf) throws Exception{

        LocalDate ld = LocalDate.parse(campos[3], dtf);

        Calendar cal = Calendar.getInstance();
        Date d = sdf.parse(campos[3]);
        cal.setTime(d);

        int valor = Integer.parseInt(campos[4]);

        Aluguel aluguel = new Aluguel();

        return aluguel;
    }
}
