import java.time.LocalDateTime;

public class Carro {
    private String placa;
    private LocalDateTime horarioEntrada;

    public Carro(String placa) {
        this.placa = placa;
        this.horarioEntrada = LocalDateTime.now();
    }

    public String getPlac() {
        return placa;
    }

    public LocalDateTime getHorarioEnt() {
        return horarioEntrada;
    }

    @Override
    public String toString() {
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", horarioEntrada=" + horarioEntrada +
                '}';
    }
}
