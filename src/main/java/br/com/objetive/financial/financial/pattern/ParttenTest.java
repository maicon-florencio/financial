package br.com.objetive.financial.financial.pattern;

import br.com.objetive.financial.financial.pattern.chain.*;

import java.util.Arrays;
import java.util.List;

public class ParttenTest {
    public static void main(String[] args) {

        System.out.println("starting processoGeradoPorMin");
        var processGeradoPorMinStarting = System.currentTimeMillis();
        processoGeradoPorMin();
        var processGeradoPorMinEnding = System.currentTimeMillis();
        System.out.println("starting processoGeradoPorMin time: " + (processGeradoPorMinEnding - processGeradoPorMinStarting));

//        System.out.println("starting processoGeradoPorChatGpt");
//        var processGeradoPorGptStarting = System.currentTimeMillis();
//        processoGeradoPorChatGpt();
//        var processGeradoPorGptEnding = System.currentTimeMillis();
//        System.out.println("ending processoGeradoPorChatGpt tempo : " +(processGeradoPorGptEnding - processGeradoPorGptStarting));




    }

    //static Pedido facadeChainStartRun()

    static Step catalogSteps(Step... steps){
        for(int index = 0; index < steps.length -1; index++) {
            Step currentProcess = steps[index];
            currentProcess.definirProximo(steps[index + 1]);
        }
        return steps[0];
    }

    static Pedido facadeChainStartRun(Step steps,Pedido orderInicial){
        return steps.processar(orderInicial);
    }

    static void processoGeradoPorChatGpt(){

        List<Step> steps = Arrays.asList(
                new ValidarPedido(),
                new AplicarDesconto(),
                new CalcularImposto()
        );

        var pedido = new Pedido(Arrays.asList("Item 1", "Item 2"), 100.0);

        Step primeiroStep = steps.get(0);
        for (int i = 0; i < steps.size() - 1; i++) {
            steps.get(i).definirProximo(steps.get(i + 1));
        }

          var pedidoFinal = primeiroStep.processar(pedido);


        if (pedidoFinal != null) {
            System.out.println("Pedido final: " + pedidoFinal.getValorTotal() + ", Imposto: " + pedidoFinal.getImposto());
        }
    }

   static void processoGeradoPorMin(){
        var pedido = new Pedido(Arrays.asList("Item 1", "Item 2"), 100.0);

        var actualCatalog = catalogSteps(new ValidarPedido(),new AplicarDesconto(),new CalcularImposto());
        var pedidoFinal = facadeChainStartRun(actualCatalog,pedido);

        if (pedidoFinal != null) {
            System.out.println("Pedido final: " + pedidoFinal.getValorTotal() + ", Imposto: " + pedidoFinal.getImposto());
        }
    }
}
