package banco;
import java.util.Scanner;

public class Conta {

	public static void main(String[] args) {
		int n;
		
		Operacoes op = new Operacoes("Gustavo", "346500-3", 850);
		Scanner sc = new Scanner(System.in);
		
		op.mostraInfo();
		
		do {
			System.out.println("Escolha a operação:");
			System.out.println("1 - Saque\n2 - Depósito\n3 - Transferência");
			while (!sc.hasNextInt()) {
				System.out.println("\nPor favor, digite somente números.");
				System.out.println("1 - Saque\n2 - Depósito\n3 - Transferência");
				sc.next();
			}
			n = sc.nextInt();
		} while(n < 1 || n > 3);
		
		switch(n) {
			case 1:
				op.saque();
				break;
			case 2:
				op.deposito();
				break;
			case 3:
				op.transferencia();
				break;
			default:
				System.out.println("Opção inválida, digite novamente.");
		}
		sc.close();

	}

}
