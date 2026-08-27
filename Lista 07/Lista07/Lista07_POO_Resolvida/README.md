# Lista 07 - POO - Operação Refatoração

Projeto desenvolvido conforme a Missão 07 do enunciado.

## Estrutura

```text
Lista07_POO_Resolvida
└── src
    └── br
        └── com
            └── ecommerce
                ├── exception
                │   └── TipoFreteInvalidoException.java
                ├── main
                │   └── MainTeste.java
                └── model
                    ├── CalculadoraFrete.java
                    ├── EstrategiaFrete.java
                    ├── FreteMotoboy.java
                    ├── FretePac.java
                    └── FreteSedex.java
```

## Requisitos atendidos

- Exceção customizada `TipoFreteInvalidoException` herdando de `RuntimeException`.
- Interface `EstrategiaFrete` com o método `double calcular(double valorPedido)`.
- Estratégias `FreteSedex`, `FretePac` e `FreteMotoboy`.
- Padrão Strategy para eliminar os `if/else` das transportadoras.
- `CalculadoraFrete` recebe a estratégia pronta.
- Estratégia `null` gera `TipoFreteInvalidoException`.
- `MainTeste` testa SEDEX, PAC e MOTOBOY com pedido de R$ 100,00.
- O erro proposital é capturado pelo `try-catch`, imprimindo somente a mensagem.

## Resultado esperado

```text
Frete SEDEX: R$ 10.0
Frete PAC: R$ 5.0
Frete MOTOBOY: R$ 15.0
Frete invalido
```

## Git

Depois de colocar o projeto no repositório:

```bash
git add .
git commit -m "Refatora calculadora de frete com Strategy"
git push
```
