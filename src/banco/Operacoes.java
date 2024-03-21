package banco;
import java.util.Scanner;

public class Operacoes {
	String titular, nrConta;
	double saldo;
	
	Scanner sc = new Scanner(System.in);
	
	public Operacoes() {}
	public Operacoes(String titular, String nrConta, double saldo) {
		this.nrConta = nrConta;
		this.saldo = saldo;
		this.titular = titular;
	}
	
	//Método para depósitos
	public void deposito() {
		double valor;
		
		System.out.println("Digite o valor do depósito: ");
		valor = sc.nextDouble();
		
		if (valor > 0) {
			saldo = saldo + valor;
			System.out.println("\nDepósito efetuado.");
			System.out.println("Valor: R$"+valor+"\n");
		}
		else {
			System.out.println("O valor deve ser mais que 0.\n");
		}
		mostraInfo();
	}
	
	//Método para saques
	public void saque() {
		double valor;
		
		System.out.println("Digite o valor do saque: ");
		valor = sc.nextDouble();
		
		if (valor > 0) {
			if (saldo > valor) {
				saldo = saldo - valor;
				System.out.println("\nSaque efetuado.");
				System.out.println("Valor: R$"+valor+"\n");
			}
			else {
				System.out.println("Saldo insuficiente.\n");
			}
		}
		else {
			System.out.println("O valor deve ser mais que 0.\n");
		}
		mostraInfo();
	}
	
	//Método para transferências
	public void transferencia() {
		double valor;
		String nrConta;
		
		System.out.println("\nDigite o número da conta do destinário: ");
		nrConta = sc.nextLine();
		System.out.println("Digite o valor da transferência: ");
		valor = sc.nextDouble();
		
		while(valor <= 0) {
			System.out.println("Valor inválido, digite novamente.");
			valor = sc.nextDouble();
		}
		
		if(saldo > valor) {
			saldo = saldo - valor;
			System.out.println("\n-----------------------------");
			System.out.println("Transferência efetuada.");
			System.out.println("-----------------------------");
			System.out.println("A conta: "+nrConta+ "\nRecebeu o valor de: R$"+valor);
			System.out.println("-----------------------------\n");
		}
		else {
			System.out.println("Saldo insuficiente.");
		}
		mostraInfo();
	}
	
	//Método para mostrar Informações
	public void mostraInfo() {
		System.out.println("-----------EXTRATO-----------");
		System.out.println("-----------------------------");
		System.out.println("Titular conta: "+titular);
		System.out.println("Número da conta: "+nrConta);
		System.out.println("Saldo da conta: R$"+saldo);
		System.out.println("-----------------------------\n");
	}
}
