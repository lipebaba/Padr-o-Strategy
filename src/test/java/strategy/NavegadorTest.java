package strategy;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class NavegadorTest {
    private final Rota centro = new Rota("Centro", 10, 25, 12);
    private final Rota rodovia = new Rota("Rodovia", 15, 15, 20);
    private final Rota bairro = new Rota("Bairro", 12, 30, 5);
    private final List<Rota> rotas = Arrays.asList(centro, rodovia, bairro);

    @Test void escolheMaisCurta() {
        assertSame(centro, new Navegador(new RotaMaisCurta()).calcularRota(rotas));
    }
    @Test void escolheMaisRapida() {
        assertSame(rodovia, new Navegador(new RotaMaisRapida()).calcularRota(rotas));
    }
    @Test void escolheMaisEconomica() {
        assertSame(bairro, new Navegador(new RotaMaisEconomica()).calcularRota(rotas));
    }
    @Test void permiteTrocarEstrategiaNoMesmoNavegador() {
        Navegador navegador = new Navegador(new RotaMaisCurta());
        assertSame(centro, navegador.calcularRota(rotas));
        navegador.setEstrategia(new RotaMaisRapida());
        assertSame(rodovia, navegador.calcularRota(rotas));
    }
    @Test void rejeitaListaInvalida() {
        Navegador navegador = new Navegador(new RotaMaisCurta());
        assertThrows(IllegalArgumentException.class, () -> navegador.calcularRota(null));
        assertThrows(IllegalArgumentException.class, () -> navegador.calcularRota(Collections.emptyList()));
        assertThrows(IllegalArgumentException.class, () -> navegador.calcularRota(Arrays.asList(centro, null)));
    }
    @Test void rejeitaEstrategiaNula() {
        assertThrows(NullPointerException.class, () -> new Navegador(null));
    }
    @Test void rejeitaDadosInvalidos() {
        assertThrows(IllegalArgumentException.class, () -> new Rota("", 1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Rota("A", -1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Rota("A", 1, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> new Rota("A", 1, 1, Double.NaN));
    }
}