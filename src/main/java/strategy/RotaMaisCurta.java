package strategy;

import java.util.Comparator;
import java.util.List;

public class RotaMaisCurta implements EstrategiaRota {
    public Rota escolher(List<Rota> rotas) {
        return rotas.stream().min(Comparator.comparingDouble(Rota::getDistanciaKm)).orElseThrow(IllegalArgumentException::new);
    }
}