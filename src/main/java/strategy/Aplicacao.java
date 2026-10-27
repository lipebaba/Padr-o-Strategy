package strategy;

import java.util.Arrays;
import java.util.List;

public class Aplicacao {
    public static void main(String[] args) {
        List<Rota> rotas = Arrays.asList(
            new Rota("Centro", 10, 25, 12),
            new Rota("Rodovia", 15, 15, 20),
            new Rota("Bairro", 12, 30, 5));
        Navegador navegador = new Navegador(new RotaMaisCurta());
        System.out.println("Mais curta: " + navegador.calcularRota(rotas).getNome());
        navegador.setEstrategia(new RotaMaisRapida());
        System.out.println("Mais rápida: " + navegador.calcularRota(rotas).getNome());
        navegador.setEstrategia(new RotaMaisEconomica());
        System.out.println("Mais econômica: " + navegador.calcularRota(rotas).getNome());
    }
}