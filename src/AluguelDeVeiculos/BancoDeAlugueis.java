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

            String registros[] = linha.split(",");
            Aluguel aluguel = converte(registros, sdf, dtf);
            listaDeAlugueis.add(aluguel);
            linha = br.readLine();
        }
        br.close();
    }

    private void getAluguelFields(Aluguel aluguel){

        System.out.println(aluguel.getModelo() + ", " + aluguel.getPlaca() + "," + aluguel.getDataRetirada() +
                ", " + aluguel.getDataDevolucao() + ", " + aluguel.getValor());
    }

    private Aluguel converte(String[] registros, SimpleDateFormat sdf, DateTimeFormatter dtf) throws Exception{

        LocalDate ld = LocalDate.parse(registros[2], dtf);

        Calendar cal = Calendar.getInstance();
        Date d = sdf.parse(registros[3]);
        cal.setTime(d);

        Aluguel aluguel = new Aluguel();

        aluguel.setModelo(registros[0]);
        aluguel.setPlaca(registros[1]);
        aluguel.setDataRetirada(cal);
        aluguel.setDataDevolucao(ld);
        aluguel.setValor(Integer.parseInt(registros[4]));

        getAluguelFields(aluguel);

        return aluguel;
    }
}
