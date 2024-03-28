package banco;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Conta {

	public static void main(String[] args) {
		String nomeTitular, nrConta;
		double saldo = 0;
		boolean nomeValido = false, saldoValido = false;
		
		Scanner sc = new Scanner(System.in);
		Operacoes op = new Operacoes();
		Menu me = new Menu();
		
		System.out.println("Digite o nome do Titular:");
		
		while(!nomeValido) {
			nomeTitular = sc.nextLine();
			if(nomeTitular.matches("[a-zA-Z]+")) {
				op.setTitular(nomeTitular);
				nomeValido = true;
			}
			else {
				System.out.println("Por favor, digite somente letras.");
			}
		}
		
		System.out.println("Digite o número da conta:");
		nrConta = sc.nextLine();
		op.setNrConta(nrConta);
		
		while(!saldoValido) {
			try {
				System.out.println("Digite o saldo da conta:");
				saldo = sc.nextDouble();
				op.setSaldo(saldo);
				
				saldoValido = true;
			} catch (InputMismatchException e) {
				System.out.println("Por favor, digite somente números.");
				sc.next();
			}
			
		}
		
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
