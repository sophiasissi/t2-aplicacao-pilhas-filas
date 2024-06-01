public class Main {
    public static void main(String[] args) {
        Pilha estacionamento = new Pilha(3);

        // Entrada de carros
        estacionamento.push(new Carro("ABC-0123"));
        estacionamento.push(new Carro("DEF-4567"));
        estacionamento.push(new Carro("GHI-8910"));
        estacionamento.push(new Carro("JKL-1648")); 
        //Estacionamento cheio não suporta mais a entrada de carros

        // Relatório de carros
        estacionamento.relatorioCarro();

        // Saída de carros
        estacionamento.sair("DEF-4567");

        // Relatório de carros depois da saída de um carro
        estacionamento.relatorioCarro();

        // Consulta de carro
        estacionamento.consulta("ABC-0123");

        System.out.println("\nNúmero de manobras realizadas por cada carro ao sair: " + estacionamento.getManobras());
    }
}