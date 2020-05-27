package AluguelDeVeiculos;

import java.time.LocalDate;
import java.util.Calendar;

public class Aluguel {

    private String modelo, placa;
    private int valor;
    private Calendar dataRetirada;
    private LocalDate dataDevolucao;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }


    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public Calendar getDataRetirada() {
        return dataRetirada;
    }

    public void setDataRetirada(Calendar dataRetirada) {
        this.dataRetirada = dataRetirada;
    }
}