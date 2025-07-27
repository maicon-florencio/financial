package br.com.objetive.financial.financial.pattern.chain;

public class CalcularImposto implements Step{

    private Step proximo;

    @Override
    public Pedido processar(Pedido pedido) {
        double imposto = pedido.getValorTotal() * 0.2;
        pedido.setImposto(imposto);
        System.out.println("Imposto calculado: " + imposto);
        return proximo != null ? proximo.processar(pedido) : pedido;
    }

    @Override
    public Step proximo() {
        return proximo;
    }

    @Override
    public void definirProximo(Step proximo) {
        this.proximo = proximo;
    }
}
