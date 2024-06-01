import java.time.LocalDateTime;
import java.util.Stack;
import java.time.format.DateTimeFormatter;
import java.time.Duration;

public class Pilha {
    private No topo;
    private int capacidade;
    private int totalManobras;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

    public Pilha(int capacidade) {
        this.capacidade = capacidade;
        this.totalManobras = 0;
    }

    public int getManobras() {
        return totalManobras;
    }

    public boolean estaVazia() {
        return topo == null;
    }

    public boolean estaCheia() {
        int count = 0;
        No aux = topo;
        while (aux != null) {
            count++;
            aux = aux.getProximo();
        }
        return count >= capacidade;
    }

    public void push(Carro carro) {
        if (estaCheia()) {
            System.out.println("Estacionamento está cheio.");
            return;
        }
        No novo = new No(carro);
        if (!estaVazia()) {
            novo.setProximo(topo);
        }
        topo = novo;
        System.out.println("Carro de placa: " + carro.getPlac() + ", entrou no horário das: " + carro.getHorarioEnt().format(formatter));
    }

    public Carro pop() {
        if (estaVazia()) {
            return null;
        }
        Carro temp = topo.getInfo();
        topo = topo.getProximo();
        return temp;
    }

    public Carro peek() {
        if (estaVazia()) {
            return null;
        }
        return topo.getInfo();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("Pilha: ");
        if (estaVazia()) {
            s.append("vazia");
        } else {
            No aux = topo;
            while (aux != null) {
                s.append(aux).append("\n");
                aux = aux.getProximo();
            }
            s.append("\\\\");
        }
        return s.toString();
    }

    public void sair(String placa) {
        Stack<No> tempStack = new Stack<>();
        int manobras = 0;

        while (!estaVazia() && !peek().getPlac().equals(placa)) {
            tempStack.push(topo);
            pop();
            manobras++;
        }

        if (!estaVazia() && peek().getPlac().equals(placa)) {
            Carro carro = pop();
            LocalDateTime horarioSaida = LocalDateTime.now();
            Duration permanencia = Duration.between(carro.getHorarioEnt(), horarioSaida);
            System.out.println("\nCarro de placa: " + placa + ", saiu no horário das: " + horarioSaida.format(formatter) + ". \nTempo total de permanência: " + permanencia.toMinutes() + " min.\nManobras realizadas: " + manobras + ".");
            totalManobras += manobras;
        } else {
            System.out.println("Carro não encontrado.");
        }
        while (!tempStack.isEmpty()) {
            push(tempStack.pop().getInfo());
        }
    }

    public void consulta(String placa) {
        int posicao = 1;
        No aux = topo;
        while (aux != null) {
            if (aux.getInfo().getPlac().equals(placa)) {
                System.out.println("\nCarro de placa: " + placa + " está na posição " + posicao + " da pilha. Horário de entrada: " + aux.getInfo().getHorarioEnt().format(formatter) + ".");
                return;
            }
            aux = aux.getProximo();
            posicao++;
        }
        System.out.println("Carro não encontrado.");
    }

    public void relatorioCarro() {
        System.out.println("\nRelatório sobre a ocupação atual: ");
        if (estaVazia()) {
            System.out.println("Estacionamento está vazio.");
        } else {
            No aux = topo;
            int posicao = 1;
            while (aux != null) {
                System.out.println("Posição " + posicao + ": " + aux.getInfo().getPlac() + ", horário de entrada: " + aux.getInfo().getHorarioEnt().format(formatter));
                aux = aux.getProximo();
                posicao++;
            }
        }
    }

}