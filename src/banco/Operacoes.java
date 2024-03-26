package banco;

public class Operacoes {
	private String titular, nrConta;
	private double saldo;
	
	public void setInfo(String titular, String nrConta, double saldo) {
		this.titular = titular;
		this.nrConta = nrConta;
		this.saldo = saldo;
	}
	
	//Método para depósitos
	public void deposito(double valor) {
		
		if (valor > 0) {
			saldo = saldo + valor;
			System.out.println("\n-----------------------------");
			System.out.println("Depósito efetuado.");
			System.out.println("-----------------------------");
			System.out.println("Valor: R$"+valor);
		}
		else {
			System.out.println("O valor deve ser mais que 0.\n");
		}
		
	}
	
	//Método para saques
	public void saque(double valor) {
		
		if (valor > 0) {
			if (saldo > valor) {
				saldo = saldo - valor;
				System.out.println("\n-----------------------------");
				System.out.println("Saque efetuado.");
				System.out.println("-----------------------------");
				System.out.println("Valor: R$"+valor);
			}
			else {
				System.out.println("Saldo insuficiente.\n");
				System.out.println(valor);
			}
		}
		else {
			System.out.println("O valor deve ser mais que 0.\n");
		}
		
	}
	
	//Método para transferências
	public void transferencia(String nrConta, double valor) {
		if(saldo > valor) {
			saldo = saldo - valor;
			System.out.println("\n-----------------------------");
			System.out.println("Transferência efetuada.");
			System.out.println("-----------------------------");
			System.out.println("A conta: "+nrConta+ "\nRecebeu o valor de: R$"+valor);
		}
		else {
			System.out.println("Saldo insuficiente.");
		}
		
	}
	
	//Método para mostrar Informações
	public void mostraInfo() {
		System.out.println("-----------EXTRATO-----------");
		System.out.println("-----------------------------");
		System.out.println("Titular conta: "+titular);
		System.out.println("Número da conta: "+nrConta);
		System.out.println("Saldo da conta: R$"+saldo);
		System.out.println("-----------------------------");
	}
}
