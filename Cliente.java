package IBank;

public class Cliente {
	
	private String nome;
	private String sobrenome;
	private String cpf;
	private int idade;
	private Endereco end;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public Endereco getEnd() {
		return end;
	}
	
	public void setEnd(Endereco end) {
		this.end = end;
	}
}
