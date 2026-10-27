package strategy;

import java.util.List;

public interface EstrategiaRota {
    Rota escolher(List<Rota> rotas);
}