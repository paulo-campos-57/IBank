package IBank;

public class ContaCorrente extends Conta{

	private double salario;
	private boolean pix;
	private final double DESCONTO = 5;
	
	public double getSalario() {
		return salario;
	}
	public void setSalario(double salario) {
		this.salario = salario;
	}
	public boolean isPix() {
		return pix;
	}
	public void setPix(boolean pix) {
		this.pix = pix;
	}
	
	public double getDesconto() {
		return DESCONTO;
	}
	
	@Override
	public void exibirSaldo() {
		System.out.println("Saldo da conta corrente.");
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
		System.out.println("Cada depósito feito tem um desconto de R$ 5,00.");
		this.setSaldo(getSaldo() + (valor - DESCONTO));
		System.out.println("Foi depositado o valor de R$ " + (valor - DESCONTO));
	}
	
	public void emprestimo(double valor, int meses) {
		double parcela = valor / meses;
		if (parcela > ((getSalario() * 40) / 100)) {
			System.out.println("Empréstimo negado.");
		}else {
			System.out.println("Empréstimo aprovado.");
			System.out.println("Valor da parcela mensal: " + parcela);
		}
	}
	
	public void pix(double valor, int numPix) {
		if (valor > getSaldo()) {
			System.out.println("Não é possível realizar a transferência.");
			System.out.println("Não há saldo o suficiente na conta.");
		}else {
			System.out.println("Transferido para o PIX de número: " + numPix);
			System.out.println("Valor da transferência: " + valor);
			this.setSaldo(getSaldo() - valor);
		}
	}
	
}
