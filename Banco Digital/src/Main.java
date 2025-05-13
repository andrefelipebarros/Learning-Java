public class Main {

    public static void main(String[] args) {

        Cliente juliana = new Cliente();
        juliana.setNome("Juliana");

        ContaBancaria corrente = new ContaCorrente(juliana);
        ContaBancaria poupanca = new ContaPoupanca(juliana);

        corrente.depositar(1000);
        corrente.transferir(500, poupanca);

        corrente.imprimirExtrato();
        poupanca.imprimirExtrato();
    }
}
