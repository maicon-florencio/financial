package br.com.objetive.financial.financial.pattern.chain;

public interface Step {
    Pedido processar(Pedido pedido);
    Step proximo();
    void definirProximo(Step proximo);
}
