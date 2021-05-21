package IBank;

public class ContaPoupanca extends Conta{

	private final double BONUS = 10;
	
	public double getBonus() {
		return BONUS;
	}
	
	@Override
	public void exibirSaldo() {
		System.out.println("Saldo da conta poupança.");
		System.out.println("O seu saldo é: " + getSaldo());
	}
	
	@Override
	public void transferencia(Conta contaDestino, double valor) {
		if (valor > getSaldo()) {
			System.out.println("Não é possível realizar essa transferência.");
			System.out.println("Não há saldo suficiente na conta.");
		}else {
			System.out.println("Transferido para conta de número: " + contaDestino.getNumero());
			System.out.println("Valor da transferência: " + valor);
			this.setSaldo(getSaldo() - valor);
		}
	}
	
	@Override
	public void sacar(double valor) {
		if (valor > getSaldo()) {
			System.out.println("Saldo insuficiente.");
		}else {
			this.setSaldo(getSaldo() - valor);
			System.out.println("Valor sacado com sucesso.");
		}
	}
	
	@Override
	public void depositar(double valor) {
		System.out.println("Cada depósito feito é contemplado com um bonus de R$ 10,00.");
		this.setSaldo(getSaldo() + (valor + BONUS));
		System.out.println("Foi depositado o valor de R$ " + (valor + BONUS));
	}
	
}
