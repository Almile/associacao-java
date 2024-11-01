package br.edu.fatecpg.associacao.model;

public class Calculadora {
	 public double somar(double a, double b) {
        return a + b;
    }

	 public double subtrair(double a, double b) {
	        return a - b;
    }
	 
    public double dividir(double a, double b) {
        if (b != 0) {
            return a / b;
        } else {
            System.out.println("Não é possível dividir por zero(0)!");
            return 0;
        }
    }
    
	 public double multiplicar(double a, double b) {
	        return a * b;
	 }
}
