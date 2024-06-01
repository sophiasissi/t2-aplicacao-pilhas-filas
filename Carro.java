import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Carro {
    private String placa;
    private LocalDateTime horarioEntrada;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");


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
        String horario = horarioEntrada.format(formatter);
        return "Carro{" +
                "placa='" + placa + '\'' +
                ", horarioEntrada=" + horario +
                '}';
    }
}
