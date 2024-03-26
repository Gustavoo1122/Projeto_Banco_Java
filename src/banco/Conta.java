package banco;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {

	public static void main(String[] args) {
		String nomeTitular, nrConta;
		double saldo = 0;
		boolean saldoValido = false;
		
		Scanner sc = new Scanner(System.in);
		Operacoes op = new Operacoes();
		Menu me = new Menu();
		
		System.out.println("Digite o nome do Titular:");
		nomeTitular = sc.nextLine();
		System.out.println("Digite o número da conta:");
		nrConta = sc.nextLine();
		
		while(!saldoValido) {
			try {
				System.out.println("Digite o saldo da conta:");
				saldo = sc.nextDouble();
				saldoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite somente números.");
				sc.next();
			}
			
		}
		
		op.setInfo(nomeTitular, nrConta, saldo);
		
		op.mostraInfo();
		boolean continuar = true;
		
		while(continuar) {
			me.exibirmenu();
			int opcao = sc.nextInt();
			sc.nextLine();			
			
			switch(opcao) {
			case 1:
				System.out.println("\nDigite o valor do depósito: ");
				double valorDep = sc.nextDouble();
				sc.nextLine();
				
				op.deposito(valorDep);
				op.mostraInfo();
				break;
			case 2:
				System.out.println("\nDigite o valor do saque: ");
				double valorSaque = sc.nextDouble();
				sc.nextLine();
				
				op.saque(valorSaque);
				op.mostraInfo();
				break;
			case 3:
				System.out.println("\nDigite o número da conta do destinário: ");
				String nrContaD = sc.nextLine();
				System.out.println("Digite o valor da transferência: ");
				double valorTransf = sc.nextDouble();
				sc.nextLine();
				
				op.transferencia(nrContaD, valorTransf);
				op.mostraInfo();
				break;
			case 4:
				continuar = false;
				System.out.println("Sessão encerrada.");
				
				break;
			default:
				System.out.println("Opção inválida, tente novamente.");
			}
		}
		
		sc.close();

	}

}
