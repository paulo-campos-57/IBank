package IBank;

abstract class Cartao {

	private ContaCorrente info;
	private ContaPoupanca infoP;
	private int numero;
	private int senha;
	
	public ContaCorrente getInfoCorrente() {
		return info;
	}
	
	public void setInfoCorrente(ContaCorrente info) {
		this.info = info;
	}
	
	public ContaPoupanca getInfoPoupanca() {
		return infoP;
	}

	public void setInfoPoupanca(ContaPoupanca infoP) {
		this.infoP = infoP;
	}

	public int getNumero() {
		return numero;
	}
	
	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	public int getSenha() {
		return senha;
	}
	
	public void setSenha(int senha) {
		this.senha = senha;
	}
}
