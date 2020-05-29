package AluguelDeVeiculos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class BancoDeAlugueis {

    private List<Aluguel> listaDeAlugueis = new ArrayList<>();

    public BancoDeAlugueis(String arquivo) throws Exception{

        BufferedReader br = new BufferedReader(new FileReader(arquivo));
        String linha = br.readLine();

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        while(linha != null){

            String[] registros = linha.split(",");
            Aluguel aluguel = converte(registros, sdf, dtf);
            listaDeAlugueis.add(aluguel);
            linha = br.readLine();
        }
        br.close();
    }

    public void faturamentoTotal(){

        int faturamentoTotal = 0;

        for (Aluguel aluguel : listaDeAlugueis){

            faturamentoTotal += aluguel.getValor();
        }
        System.out.println("O faturamento total foi de: R$ " + faturamentoTotal);
    }

    public List<Aluguel> retornaAluguelDoCarro(String placa){

        List<Aluguel> filtrarCarrosAlugadosPelaPlaca = new ArrayList<>();

        for(Aluguel aluguel : listaDeAlugueis){

            if(aluguel.getPlaca().equals(placa)){
                filtrarCarrosAlugadosPelaPlaca.add(aluguel);
            }
        }
        return filtrarCarrosAlugadosPelaPlaca;
    }

    public List<Carro> retornaCarrosaluguel(){

        List<Carro> carros = new ArrayList<>();
        List<Carro> retornaCarrosAluguel = new ArrayList<>();
        List<String> verificaCarrosRepetidos = new ArrayList<>();

        for(Aluguel aluguel : listaDeAlugueis){

            Carro carro = new Carro();
            carro.setModelo(aluguel.getModelo());
            carro.setPlaca(aluguel.getPlaca());
            carros.add(carro);
            retornaCarrosAluguel.add(carro);
        }

        carros.forEach(
            object -> {
                if(verificaCarrosRepetidos.contains(object.getModelo())){
                    retornaCarrosAluguel.remove(object);
                }
                else{
                    verificaCarrosRepetidos.add(object.getModelo());
                }
            }
        );
        return retornaCarrosAluguel;
    }

    private void getAluguel(Aluguel aluguel){

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
        aluguel.setDataRetirada(ld);
        aluguel.setDataDevolucao(ld);
        aluguel.setValor(Integer.parseInt(registros[4]));

//        getAluguel(aluguel);

        return aluguel;
    }
}
