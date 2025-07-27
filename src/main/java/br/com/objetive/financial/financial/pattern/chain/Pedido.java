package br.com.objetive.financial.financial.pattern.chain;

import java.util.List;

public class Pedido {

    private List<String> itens;
    private double valorTotal;
    private double imposto;

    public Pedido(List<String> itens, double valorTotal) {
        this.itens = itens;
        this.valorTotal = valorTotal;
    }

    public List<String> getItens() {
        return itens;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public double getImposto() {
        return imposto;
    }

    public void setImposto(double imposto) {
        this.imposto = imposto;
    }
}
