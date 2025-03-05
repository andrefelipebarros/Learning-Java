import java.util.Random;
import java.util.Scanner;

public class ContaBancaria {
    private static final int AGENCIA_LENGTH = 4;
    private static final int CONTA_LENGTH = 6;
    private static final double SALDO_MAXIMO = 500.0;

    private String titular;
    private String agencia;
    private int numeroConta;
    private double saldo;

    //Constructor
    public ContaBancaria(String titular, String agencia, int numeroConta, double saldo) {
        this.titular = titular;
        this.agencia = agencia;
        this.numeroConta = numeroConta;
        this.saldo = saldo;
    }

    public void consultarSaldo() {
        System.out.println("Saldo atual: R$" + String.format("%.2f", saldo));
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
            System.out.println("Depósito de R$" + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("Valor inválido para depósito.");
        }
    }

    public void sacar(double valor) {
        if (valor > 0 && valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque de R$" + String.format("%.2f", valor) + " realizado com sucesso!");
        } else {
            System.out.println("Saldo insuficiente ou valor inválido.");
        }
    }

    //Main
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        //Scanners
        System.out.print("Digite seu nome: ");
        String nomeCliente = scanner.nextLine();

        String agencia = solicitarAgencia(scanner);
        int numeroConta = solicitarNumeroConta(scanner);
        //End Scanners
        double saldoInicial = random.nextDouble() * SALDO_MAXIMO;
        ContaBancaria conta = new ContaBancaria(nomeCliente, agencia, numeroConta, saldoInicial);

        System.out.println("\nOlá " + nomeCliente.toUpperCase() + ", obrigado por criar uma conta em nosso banco.");
        System.out.println("Sua agência é " + agencia + ", conta " + numeroConta + " e seu saldo é R$" + String.format("%.2f", saldoInicial) + ".");
        System.out.println("Seu saldo já está disponível para saque.");

        while (true) {
            System.out.println("\n--- Menu ---");
            System.out.println("1. Consultar Saldo");
            System.out.println("2. Depositar");
            System.out.println("3. Sacar");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            
            switch (opcao) {
                case 1:
                    conta.consultarSaldo();
                    break;
                case 2:
                    System.out.print("Digite o valor para depósito: ");
                    double deposito = scanner.nextDouble();
                    conta.depositar(deposito);
                    break;
                case 3:
                    System.out.print("Digite o valor para saque: ");
                    double saque = scanner.nextDouble();
                    conta.sacar(saque);
                    break;
                case 4:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    private static String solicitarAgencia(Scanner scanner) {
        while (true) {
            System.out.print("Por favor, digite o número da Agência (" + AGENCIA_LENGTH + " dígitos): ");
            String agencia = scanner.nextLine();

            if (agencia.length() == AGENCIA_LENGTH && agencia.matches("[0-9]+")) {
                return agencia;
            } else {
                System.out.println("Número de agência inválido. Digite exatamente " + AGENCIA_LENGTH + " dígitos numéricos.");
            }
        }
    }

    private static int solicitarNumeroConta(Scanner scanner) {
        while (true) {
            System.out.print("Digite o número da conta (" + CONTA_LENGTH + " dígitos): ");
            String input = scanner.nextLine();

            if (input.length() == CONTA_LENGTH && input.matches("[0-9]+")) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Número de conta inválido. Digite exatamente " + CONTA_LENGTH + " dígitos numéricos.");
            }
        }
    }
}
