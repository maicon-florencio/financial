package br.com.objetive.financial.financial.pattern.chain;

public class AplicarDesconto implements Step{
    private Step proximo;

    @Override
    public Pedido processar(Pedido pedido) {
        double desconto = pedido.getValorTotal() * 0.1;
        pedido.setValorTotal(pedido.getValorTotal() - desconto);
        System.out.println("Desconto aplicado: " + desconto);
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
