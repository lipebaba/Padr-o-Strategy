package strategy;

public class Rota {
    private final String nome;
    private final double distanciaKm;
    private final int tempoMinutos;
    private final double custo;

    public Rota(String nome, double distanciaKm, int tempoMinutos, double custo) {
        if (nome == null || nome.trim().isEmpty() || !Double.isFinite(distanciaKm)
                || distanciaKm < 0 || tempoMinutos < 0 || !Double.isFinite(custo) || custo < 0) {
            throw new IllegalArgumentException("Dados da rota inválidos");
        }
        this.nome = nome;
        this.distanciaKm = distanciaKm;
        this.tempoMinutos = tempoMinutos;
        this.custo = custo;
    }
    public String getNome() { return nome; }
    public double getDistanciaKm() { return distanciaKm; }
    public int getTempoMinutos() { return tempoMinutos; }
    public double getCusto() { return custo; }
}