package br.com.ecommerce.model;

import br.com.ecommerce.exception.TipoFreteInvalidoException;

public class CalculadoraFrete {

    public double processarFrete(double valorPedido, EstrategiaFrete estrategiaFrete) {
        if (estrategiaFrete == null) {
            throw new TipoFreteInvalidoException("Frete invalido");
        }

        return estrategiaFrete.calcular(valorPedido);
    }
}
