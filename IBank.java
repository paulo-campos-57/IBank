package IBank;

import java.util.Scanner;

public class IBank {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		Cliente cliente = new Cliente();
		ContaCorrente contaC = new ContaCorrente();
		ContaPoupanca contaP = new ContaPoupanca();
		System.out.println("Bem vindo ao IBank, para continuar seu cadastro preencha as informações a seguir: ");
		System.out.print("Digite aqui seu nome: ");
		cliente.setNome(in.nextLine());
		System.out.print("Digite aqui o seu sobrenome: ");
		cliente.setSobrenome(in.next());
		System.out.print("Digite aqui o seu CPF: ");
		cliente.setCpf(in.next());
		System.out.print("Digite aqui sua idade: ");
		cliente.setIdade(in.nextInt());
		
		System.out.println("\n--------------------------------------------------------------------------------");
		Endereco end = new Endereco();
		System.out.println("Excelente " + cliente.getNome() + "! Agora preencha os dados de seu endereço: ");
		System.out.print("Digite aqui o seu CEP: ");
		end.setCep(in.next());
		System.out.print("Digite aqui o estado em que você reside: ");
		end.setEstado(in.next());
		System.out.print("Digite aqui a cidade em que você reside: ");
		end.setCidade(in.next());
		in.nextLine();//esvaziar o buffer para testes.
		System.out.print("Digite aqui a rua em que você reside: ");
		end.setRua(in.nextLine());
		System.out.print("Digite aqui o número de sua residência: ");
		end.setNumero(in.next());
		System.out.print("Digite aqui um complemento de seu endereço (digite '-' caso não haja um): ");
		end.setComplemento(in.next()); 
		in.nextLine();//esvaziar o buffer para testes.
		cliente.setEnd(end);
		
		boolean contaCorrente = false;
		boolean contaPoupanca = false;
		int op = 3;
		while (op != 0) {
			System.out.println("\n--------------------------------------------------------------------------------");
			System.out.println("Quase tudo pronto! Selecione o tipo de conta que você quer cadastrar: ");
			System.out.println("1-Conta Corrente");
			System.out.println("2-Conta Poupança");
			op = in.nextInt();
			switch (op) {
				case 1:
					contaCorrente = true;
					System.out.println("Você selecionou cadastrar uma conta corrente.");
					contaC.setDono(cliente);
					System.out.print("Digite o número de sua conta: ");
					contaC.setNumero(in.nextInt());
					System.out.print("Digite o número de sua agência: ");
					contaC.setAgencia(in.next());
					System.out.print("Digite quanto deseja aplicar na conta: ");
					contaC.setSaldo(in.nextDouble());
					System.out.print("Digite aqui o seu salário mensal: ");
					contaC.setSalario(in.nextDouble());
					System.out.print("Deseja que sua conta aceite PIX? (1-Sim/0-Não): ");
					int pix = in.nextInt();
					if(pix == 1) {
						contaC.setPix(true);
					}else {
						contaC.setPix(false);
					}
					System.out.println("Tecle 0 para confirmar.");
					op = in.nextInt();
					break;
				case 2:
					contaPoupanca = true;
					System.out.println("Você selecionou cadastrar uma conta poupança.");
					contaP.setDono(cliente);
					System.out.print("Digite o número de sua conta: ");
					contaP.setNumero(in.nextInt());
					System.out.print("Digite o número de sua agência: ");
					contaP.setAgencia(in.next());
					System.out.print("Digite quanto deseja aplicar na conta: ");
					contaP.setSaldo(in.nextDouble());
					System.out.println("Tecle 0 para confirmar.");
					op = in.nextInt();
					break;
				default:
					System.out.println("Opção digitada inválida.");
					break;
			}
		}
		
		int x = 20;
		while (x != 0) {  //executa enquanto x for diferente de 0
			if(contaCorrente == true && contaPoupanca == false) {  //menu de operações conta corrente
				if(contaC.isPix() == true) {  //menu de operações conta corrente com PIX
					System.out.println("Menu Conta Corrente");
					System.out.println("1-Conferir informações da conta");
					System.out.println("2-Exibir saldo na tela");
					System.out.println("3-Realizar transferência");
					System.out.println("4-Realizar saque");
					System.out.println("5-Realizar depósito");
					System.out.println("6-Solicitar cartão de crédito");
					System.out.println("7-Solicitar cartão de débito");
					System.out.println("8-Simular empréstimo");
					System.out.println("9-Pagamento via PIX");
					System.out.println("10-Cadastrar conta poupança");
					System.out.println("0-Sair");
					System.out.print("Selecione uma das opções acima e tecle ENTER: ");
					x = in.nextInt();
					System.out.println("\n--------------------------------------------------------------------------------");
					switch (x) {
						case 1:
							System.out.println("Informações sobre a conta corrente:");
							System.out.println("Titular da conta: " + contaC.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaC.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaC.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaC.getNumero());
							System.out.println("Agência da conta: " + contaC.getAgencia());
							break;
						case 2:
							contaC.exibirSaldo();
							break;
						case 3:
							ContaCorrente contaD = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaD.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferencia = in.nextDouble();
							contaC.transferencia(contaD, valorTransferencia);
							break;
						case 4:
							System.out.print("Informe aqui o valor que deseja sacar: ");
							double valorSaque = in.nextDouble();
							contaC.sacar(valorSaque);
							break;
						case 5:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDeposito = in.nextDouble();
							contaC.depositar(valorDeposito);
							break;
						case 6:
							CartaoCredito cartaoC = new CartaoCredito();
							cartaoC.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoC.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoC.setSenha(in.nextInt());
							double limite = (contaC.getSalario() / 40);
							cartaoC.setLimite(limite);
							System.out.println("O limite do seu cartão de crédito é: " + cartaoC.getLimite());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 7:
							CartaoDebito cartaoD = new CartaoDebito();
							cartaoD.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoD.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoD.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 8:
							System.out.print("Informe aqui o valor que deseja pegar no empréstimo: ");
							double valorEmprestimo = in.nextDouble();
							System.out.println("Informe aqui em quantos meses deseja pagar o empréstimo: ");
							int meses = in.nextInt();
							contaC.emprestimo(valorEmprestimo, meses);
							break;
						case 9:
							System.out.print("Informe o número do PIX destino: ");
							int numPix = in.nextInt();
							System.out.print("Informe o valor da transferência que deseja realizar: ");
							double valorPix = in.nextDouble();
							contaC.pix(valorPix, numPix);
							break;
						case 10:
							System.out.println("Você selecionou cadastrar uma conta poupança.");
							contaP.setDono(cliente);
							System.out.print("Digite o número de sua conta: ");
							contaP.setNumero(in.nextInt());
							System.out.print("Digite o número de sua agência: ");
							contaP.setAgencia(in.next());
							System.out.print("Digite quanto deseja aplicar na conta: ");
							contaP.setSaldo(in.nextDouble());
							contaPoupanca = true;
							break;
						default:
							System.out.println("Opção inválida.");
							break;
					}
					System.out.println("\n--------------------------------------------------------------------------------");
				}else {  //menu de operações conta corrente sem PIX
					System.out.println("Menu Conta Corrente");
					System.out.println("1-Conferir informações da conta");
					System.out.println("2-Exibir saldo na tela");
					System.out.println("3-Realizar transferência");
					System.out.println("4-Realizar saque");
					System.out.println("5-Realizar depósito");
					System.out.println("6-Solicitar cartão de crédito");
					System.out.println("7-Solicitar cartão de débito");
					System.out.println("8-Simular empréstimo");
					System.out.println("9-Cadastrar conta poupança");
					System.out.println("0-Sair");
					System.out.print("Selecione uma das opções acima e tecle ENTER: ");
					x = in.nextInt();
					System.out.println("\n--------------------------------------------------------------------------------");
					switch (x) {
						case 1:
							System.out.println("Informações sobre a conta corrente:");
							System.out.println("Titular da conta: " + contaC.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaC.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaC.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaC.getNumero());
							System.out.println("Agência da conta: " + contaC.getAgencia());
							break;
						case 2:
							contaC.exibirSaldo();
							break;
						case 3:
							ContaCorrente contaD = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaD.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferencia = in.nextDouble();
							contaC.transferencia(contaD, valorTransferencia);
							break;
						case 4:
							System.out.print("Informe aqui o valor que deseja sacar: ");
							double valorSaque = in.nextDouble();
							contaC.sacar(valorSaque);
							break;
						case 5:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDeposito = in.nextDouble();
							contaC.depositar(valorDeposito);
							break;
						case 6:
							CartaoCredito cartaoC = new CartaoCredito();
							cartaoC.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoC.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoC.setSenha(in.nextInt());
							double limite = (contaC.getSalario() / 40);
							cartaoC.setLimite(limite);
							System.out.println("O limite do seu cartão de crédito é: " + cartaoC.getLimite());
							System.out.println("Cartão cadastrado com sucesso na conta corrente.");
							break;
						case 7:
							CartaoDebito cartaoD = new CartaoDebito();
							cartaoD.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoD.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoD.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso na conta corrente.");
							break;
						case 8:
							System.out.print("Informe aqui o valor que deseja pegar no empréstimo: ");
							double valorEmprestimo = in.nextDouble();
							System.out.println("Informe aqui em quantos meses deseja pagar o empréstimo: ");
							int meses = in.nextInt();
							contaC.emprestimo(valorEmprestimo, meses);
							break;
						case 9:
							System.out.println("Você selecionou cadastrar uma conta poupança.");
							contaP.setDono(cliente);
							System.out.print("Digite o número de sua conta: ");
							contaP.setNumero(in.nextInt());
							System.out.print("Digite o número de sua agência: ");
							contaP.setAgencia(in.next());
							System.out.print("Digite quanto deseja aplicar na conta: ");
							contaP.setSaldo(in.nextDouble());
							contaPoupanca = true;
							break;
						default:
							System.out.println("Opção inválida.");
							break;
					}
					System.out.println("\n--------------------------------------------------------------------------------");
				}
			}else if(contaPoupanca == true && contaCorrente == false) {  //menu de operações conta poupança
				System.out.println("Menu Conta Poupança");
				System.out.println("1-Conferir informações da conta");
				System.out.println("2-Exibir saldo na tela");
				System.out.println("3-Realizar transferência");
				System.out.println("4-Realizar saque");
				System.out.println("5-Realizar depósito");
				System.out.println("6-Solicitar cartão de débito");
				System.out.println("7-Cadastrar conta Corrente");
				System.out.println("0-Sair");
				System.out.print("Selecione uma das opções acima e tecle ENTER: ");
				x = in.nextInt();
				System.out.println("\n--------------------------------------------------------------------------------");
				switch (x) {
					case 1:
						System.out.println("Informações sobre a conta poupança:");
						System.out.println("Titular da conta: " + contaP.getDono().getNome() + " " + contaC.getDono().getSobrenome());
						System.out.println("CPF do titula da conta: " + contaP.getDono().getCpf());
						System.out.println("CEP do titular da conta: " + contaP.getDono().getEnd().getCep());
						System.out.println("Número da conta: " + contaP.getNumero());
						System.out.println("Agência da conta: " + contaP.getAgencia());
						break;
					case 2:
						contaP.exibirSaldo();
						break;
					case 3:
						ContaCorrente contaD = new ContaCorrente();
						System.out.print("Informe o número da conta que deseja trasnferir: ");
						contaD.setNumero(in.nextInt());
						System.out.print("Informe o valor que deseja transferir: ");
						double valorTransferencia = in.nextDouble();
						contaP.transferencia(contaD, valorTransferencia);
						break;
					case 4:
						System.out.print("Informe aqui o valor que deseja sacar: ");
						double valorSaque = in.nextDouble();
						contaP.sacar(valorSaque);
						break;
					case 5:
						System.out.print("Informe o valor que deseja despositar: ");
						double valorDeposito = in.nextDouble();
						contaC.depositar(valorDeposito);
						break;
					case 6:
						CartaoDebito cartaoD = new CartaoDebito();
						cartaoD.setInfoPoupanca(contaP);
						System.out.print("Informe aqui o número que deseja por no seu cartão: ");
						cartaoD.setNumero(in.nextInt());
						System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
						cartaoD.setSenha(in.nextInt());
						System.out.println("Cartão cadastrado com sucesso na conta corrente.");
						break;
					case 7:
						System.out.println("Você selecionou cadastrar uma conta corrente.");
						contaC.setDono(cliente);
						System.out.print("Digite o número de sua conta: ");
						contaC.setNumero(in.nextInt());
						System.out.print("Digite o número de sua agência: ");
						contaC.setAgencia(in.next());
						System.out.print("Digite quanto deseja aplicar na conta: ");
						contaC.setSaldo(in.nextDouble());
						System.out.print("Digite aqui o seu salário mensal: ");
						contaC.setSalario(in.nextDouble());
						System.out.print("Deseja que sua conta aceite PIX? (1-Sim/0-Não): ");
						int pix = in.nextInt();
						if(pix == 1) {
							contaC.setPix(true);
						}else {
							contaC.setPix(false);
						}
						contaCorrente = true;
						break;
					default:
						System.out.println("Opção inválida.");
						break;
				}
			}else if(contaCorrente == true && contaPoupanca == true) {  //menu de operações conta corrente e poupança
				if(contaC.isPix() == true) {  //menu de operações conta corrente com PIX
					System.out.println("Menu Contas Corrente e Poupança");
					System.out.println("Opções conta corrente");
					System.out.println("1-Conferir informações da conta");
					System.out.println("2-Exibir saldo na tela");
					System.out.println("3-Realizar transferência");
					System.out.println("4-Realizar saque");
					System.out.println("5-Realizar depósito");
					System.out.println("6-Solicitar cartão de crédito");
					System.out.println("7-Solicitar cartão de débito");
					System.out.println("8-Simular empréstimo");
					System.out.println("9-Pagamento via PIX");
					System.out.println("Opções conta poupança");
					System.out.println("10-Conferir informações da conta");
					System.out.println("11-Exibir saldo na tela");
					System.out.println("12-Realizar transferência");
					System.out.println("13-Realizar depósito");
					System.out.println("14-Solicitar cartão de débito");
					System.out.println("0-Sair");
					System.out.print("Selecione uma das opções acima e tecle ENTER: ");
					x = in.nextInt();
					System.out.println("\n--------------------------------------------------------------------------------");
					switch (x) {
						case 1:
							System.out.println("Informações sobre a conta corrente:");
							System.out.println("Titular da conta: " + contaC.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaC.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaC.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaC.getNumero());
							System.out.println("Agência da conta: " + contaC.getAgencia());
							break;
						case 2:
							contaC.exibirSaldo();
							break;
						case 3:
							ContaCorrente contaD = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaD.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferencia = in.nextDouble();
							contaC.transferencia(contaD, valorTransferencia);
							break;
						case 4:
							System.out.print("Informe aqui o valor que deseja sacar: ");
							double valorSaque = in.nextDouble();
							contaC.sacar(valorSaque);
							break;
						case 5:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDeposito = in.nextDouble();
							contaC.depositar(valorDeposito);
							break;
						case 6:
							CartaoCredito cartaoC = new CartaoCredito();
							cartaoC.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoC.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoC.setSenha(in.nextInt());
							double limite = (contaC.getSalario() / 40);
							cartaoC.setLimite(limite);
							System.out.println("O limite do seu cartão de crédito é: " + cartaoC.getLimite());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 7:
							CartaoDebito cartaoD = new CartaoDebito();
							cartaoD.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoD.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoD.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 8:
							System.out.print("Informe aqui o valor que deseja pegar no empréstimo: ");
							double valorEmprestimo = in.nextDouble();
							System.out.println("Informe aqui em quantos meses deseja pagar o empréstimo: ");
							int meses = in.nextInt();
							contaC.emprestimo(valorEmprestimo, meses);
							break;
						case 9:
							System.out.print("Informe o número do PIX destino: ");
							int numPix = in.nextInt();
							System.out.print("Informe o valor da transferência que deseja realizar: ");
							double valorPix = in.nextDouble();
							contaC.pix(valorPix, numPix);
							break;
						case 10:
							System.out.println("Informações sobre a conta poupança:");
							System.out.println("Titular da conta: " + contaP.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaP.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaP.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaP.getNumero());
							System.out.println("Agência da conta: " + contaP.getAgencia());
							break;
						case 11:
							contaP.exibirSaldo();
							break;
						case 12:
							ContaCorrente contaDP = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaDP.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferenciaP = in.nextDouble();
							contaP.transferencia(contaDP, valorTransferenciaP);
							break;
						case 13:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDepositoP = in.nextDouble();
							contaC.depositar(valorDepositoP);
							break;
						case 14:
							CartaoDebito cartaoDP = new CartaoDebito();
							cartaoDP.setInfoPoupanca(contaP);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoDP.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoDP.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso na conta corrente.");
							break;
						default:
							System.out.println("Opção inválida");
							break;
					}
					System.out.println("\n--------------------------------------------------------------------------------");
				}else {  //menu de operações conta corrente sem PIX
					System.out.println("Menu Contas Corrente e Poupança");
					System.out.println("Menu Contas Corrente e Poupança");
					System.out.println("Opções conta corrente");
					System.out.println("1-Conferir informações da conta");
					System.out.println("2-Exibir saldo na tela");
					System.out.println("3-Realizar transferência");
					System.out.println("4-Realizar saque");
					System.out.println("5-Realizar depósito");
					System.out.println("6-Solicitar cartão de crédito");
					System.out.println("7-Solicitar cartão de débito");
					System.out.println("8-Simular empréstimo");
					System.out.println("Opções conta poupança");
					System.out.println("9-Conferir informações da conta");
					System.out.println("10-Exibir saldo na tela");
					System.out.println("11-Realizar transferência");
					System.out.println("12-Realizar depósito");
					System.out.println("13-Solicitar cartão de débito");
					System.out.println("0-Sair");
					System.out.print("Selecione uma das opções acima e tecle ENTER: ");
					x = in.nextInt();
					System.out.println("\n--------------------------------------------------------------------------------");
					switch (x) {
						case 1:
							System.out.println("Informações sobre a conta corrente:");
							System.out.println("Titular da conta: " + contaC.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaC.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaC.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaC.getNumero());
							System.out.println("Agência da conta: " + contaC.getAgencia());
							break;
						case 2:
							contaC.exibirSaldo();
							break;
						case 3:
							ContaCorrente contaD = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaD.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferencia = in.nextDouble();
							contaC.transferencia(contaD, valorTransferencia);
							break;
						case 4:
							System.out.print("Informe aqui o valor que deseja sacar: ");
							double valorSaque = in.nextDouble();
							contaC.sacar(valorSaque);
							break;
						case 5:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDeposito = in.nextDouble();
							contaC.depositar(valorDeposito);
							break;
						case 6:
							CartaoCredito cartaoC = new CartaoCredito();
							cartaoC.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoC.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoC.setSenha(in.nextInt());
							double limite = (contaC.getSalario() / 40);
							cartaoC.setLimite(limite);
							System.out.println("O limite do seu cartão de crédito é: " + cartaoC.getLimite());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 7:
							CartaoDebito cartaoD = new CartaoDebito();
							cartaoD.setInfoCorrente(contaC);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoD.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoD.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso.");
							break;
						case 8:
							System.out.print("Informe aqui o valor que deseja pegar no empréstimo: ");
							double valorEmprestimo = in.nextDouble();
							System.out.println("Informe aqui em quantos meses deseja pagar o empréstimo: ");
							int meses = in.nextInt();
							contaC.emprestimo(valorEmprestimo, meses);
							break;
						case 9:
							System.out.println("Informações sobre a conta poupança:");
							System.out.println("Titular da conta: " + contaP.getDono().getNome() + " " + contaC.getDono().getSobrenome());
							System.out.println("CPF do titula da conta: " + contaP.getDono().getCpf());
							System.out.println("CEP do titular da conta: " + contaP.getDono().getEnd().getCep());
							System.out.println("Número da conta: " + contaP.getNumero());
							System.out.println("Agência da conta: " + contaP.getAgencia());
							break;
						case 10:
							contaP.exibirSaldo();
							break;
						case 11:
							ContaCorrente contaDP = new ContaCorrente();
							System.out.print("Informe o número da conta que deseja trasnferir: ");
							contaDP.setNumero(in.nextInt());
							System.out.print("Informe o valor que deseja transferir: ");
							double valorTransferenciaP = in.nextDouble();
							contaP.transferencia(contaDP, valorTransferenciaP);
							break;
						case 12:
							System.out.print("Informe o valor que deseja despositar: ");
							double valorDepositoP = in.nextDouble();
							contaC.depositar(valorDepositoP);
							break;
						case 13:
							CartaoDebito cartaoDP = new CartaoDebito();
							cartaoDP.setInfoPoupanca(contaP);
							System.out.print("Informe aqui o número que deseja por no seu cartão: ");
							cartaoDP.setNumero(in.nextInt());
							System.out.print("Informe aqui a senha que deseja por no seu cartão: ");
							cartaoDP.setSenha(in.nextInt());
							System.out.println("Cartão cadastrado com sucesso na conta corrente.");
							break;
						default:
							System.out.println("Opção inválida");
							break;
					}
					System.out.println("\n--------------------------------------------------------------------------------");
				}
			}
		}
		
		in.close();
	}
}
