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

    public BancoDeAlugueis(String arquivo) throws Exception{

        List<Aluguel> listaDeAlugueis = new ArrayList<>();

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

        LocalDate ld = LocalDate.parse(campos[2], dtf);

        Calendar cal = Calendar.getInstance();
        Date d = sdf.parse(campos[3]);
        cal.setTime(d);

        Aluguel aluguel = new Aluguel();
        aluguel.setModelo(campos[0]);
        aluguel.setPlaca(campos[1]);
        aluguel.setDataRetirada(cal);
        aluguel.setDataDevolucao(ld);
        aluguel.setValor(Integer.parseInt(campos[4]));

        System.out.println(aluguel.getModelo());
        System.out.println(aluguel.getPlaca());
        System.out.println(aluguel.getDataRetirada());
        System.out.println(aluguel.getDataDevolucao());
        System.out.println(aluguel.getValor());

        return aluguel;
    }
}
