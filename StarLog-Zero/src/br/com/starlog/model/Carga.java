package br.com.starlog.model;

import java.util.Objects;

public class Carga {

    private final String codigoRastreio;
    private String categoria;
    private double pesoKg;
    private double valorSeguro;
    
    public Carga(String codigoRastreio, String categoria, double pesoKg, double valorSeguro){
        if (codigoRastreio == null || trim().isEmpty()){
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");

        }

        if (pesoKg <= 0){
            throw new IllegalArgumentException("Codigo de rastreio da carga nao pode ser nulo ou vazio.");

        } 

        this.codigoRastreio = codigoRastreio;
        this.categoria = categoria;
        this.pesoKg = pesoKg;
        this.valorSeguro = valorSeguro;

        }
        
        public String getcodigoRastreio(){
            return codigoRastreio;
        }

        public String getcategoria(){
            return categoria;
        }

        public double getpesoKg(){
            return pesoKg;
        }

        public double valorSeguro(){
            return valorSeguro;
        }
    

        @Override 
        public boolean equals(Object o){
            if (this == o) {
                return true;
            }

            if (!(o instanceof Carga)){
                return false;
            }

            Carga carga = (Carga) o;

            return Objects.equals(codigoRastreio, carga.codigoRastreio);

        }
    
        @Override 
        public String toString(){
            return "Carga [rastreio=" + codigoRastreio
                    + ", categoria=" + categoria
                    + ", peso=="    +  pesoKg
                    +"kg, seguro=RS="+ valorSeguro + "]";
        }


};



