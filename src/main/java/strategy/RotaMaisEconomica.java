package strategy;

import java.util.Comparator;
import java.util.List;

public class RotaMaisEconomica implements EstrategiaRota {
    public Rota escolher(List<Rota> rotas) {
        return rotas.stream().min(Comparator.comparingDouble(Rota::getCusto)).orElseThrow(IllegalArgumentException::new);
    }
}