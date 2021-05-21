package IBank;

abstract class Conta {

	private int numero;
	private String agencia;
	private Cliente dono; 	
	private double saldo;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public Cliente getDono() {
		return dono;
	}

	public void setDono(Cliente dono) {
		this.dono = dono;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public abstract void exibirSaldo();
	
	public abstract void transferencia(Conta contaDestino, double valor);
	
	public abstract void sacar(double valor);

	public abstract void depositar(double valor);
	
}
