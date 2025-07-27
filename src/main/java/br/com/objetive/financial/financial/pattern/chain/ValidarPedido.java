package br.com.objetive.financial.financial.pattern.chain;

public class ValidarPedido implements Step {
    private Step proximo;
    @Override
    public Pedido processar(Pedido pedido) {
        if (pedido.getItens().isEmpty()) {
            System.out.println("Pedido sem itens.");
            return null;
        }
        System.out.println("Pedido validado.");
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
