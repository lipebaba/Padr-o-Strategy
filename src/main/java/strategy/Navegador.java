package strategy;

import java.util.List;
import java.util.Objects;

public class Navegador {
    private EstrategiaRota estrategia;

    public Navegador(EstrategiaRota estrategia) {
        setEstrategia(estrategia);
    }

    public void setEstrategia(EstrategiaRota estrategia) {
        this.estrategia = Objects.requireNonNull(estrategia, "A estratégia é obrigatória");
    }

    public Rota calcularRota(List<Rota> rotas) {
        if (rotas == null || rotas.isEmpty() || rotas.contains(null)) {
            throw new IllegalArgumentException("Informe uma lista de rotas não vazia e sem valores nulos");
        }
        return estrategia.escolher(rotas);
    }
}