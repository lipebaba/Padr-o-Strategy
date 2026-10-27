package strategy;

import java.util.Comparator;
import java.util.List;

public class RotaMaisRapida implements EstrategiaRota {
    public Rota escolher(List<Rota> rotas) {
        return rotas.stream().min(Comparator.comparingInt(Rota::getTempoMinutos)).orElseThrow(IllegalArgumentException::new);
    }
}