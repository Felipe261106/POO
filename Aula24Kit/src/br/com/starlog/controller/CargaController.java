package br.com.starlog.controller;

import br.com.starlog.model.Carga;
import br.com.starlog.view.TelaCadastroCarga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CargaController {
    private final List<Carga> repositorio = new ArrayList<>();

    public void cadastrarCarga(String codigoRaw, String categoriaRaw, String pesoRaw,
                               String valorRaw, TelaCadastroCarga tela) {
        try {
            if (pesoRaw == null || pesoRaw.trim().isEmpty()) {
                throw new IllegalArgumentException("O peso da carga deve ser informado.");
            }
            if (valorRaw == null || valorRaw.trim().isEmpty()) {
                throw new IllegalArgumentException("O valor declarado deve ser informado.");
            }

            double peso = Double.parseDouble(pesoRaw.trim().replace(",", "."));
            double valor = Double.parseDouble(valorRaw.trim().replace(",", "."));

            Carga novaCarga = new Carga(codigoRaw, categoriaRaw, peso, valor);
            repositorio.add(novaCarga);

            tela.exibirMensagemSucesso("Carga cadastrada com sucesso!\\n" + novaCarga.toString());
            tela.atualizarRelatorio(gerarTextoRelatorio());

        } catch (NumberFormatException e) {
            tela.exibirMensagemErro("Erro de formato numérico: Digite apenas números válidos para Peso e Valor!");
        } catch (IllegalArgumentException e) {
            tela.exibirMensagemErro("Regra de Negócio Violada: " + e.getMessage());
        }
    }

    public String gerarTextoRelatorio() {
        if (repositorio.isEmpty()) {
            return "Nenhuma carga registrada na esteira.";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("--- RELATÓRIO OFICIAL DE DESPACHO ---\\n");
        double totalSeguro = 0.0;
        double pesoTotal = 0.0;

        for (int i = 0; i < repositorio.size(); i++) {
            Carga c = repositorio.get(i);
            sb.append(String.format("%02d. %s\\n", (i + 1), c.toString()));
            totalSeguro += c.calcularSeguro();
            pesoTotal += c.getPeso();
        }

        sb.append("-------------------------------------\\n");
        sb.append(String.format("Total de Cargas: %d | Peso Total: %.2f kg | Seguro Acumulado: R$ %.2f\\n",
                repositorio.size(), pesoTotal, totalSeguro));
        return sb.toString();
    }

    public List<Carga> getRepositorio() {
        return Collections.unmodifiableList(repositorio);
    }
}
