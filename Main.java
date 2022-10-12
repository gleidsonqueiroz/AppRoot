package trabalho;

import java.util.Scanner;

public class Main {
	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("============== BANCO ==============");
		boolean usuarioAutenticado = false;
		
		while (!usuarioAutenticado) {
			usuarioAutenticado = autenticar();
			
			if (!usuarioAutenticado) {
				System.out.println("Erro ao logar!");
			}
		}
		
		System.out.println("Bem vindo(a)!\n");
		
		Arvore clientes = new Arvore();
		
		do {
			int opcao = selecionarAcao();
			
			switch (opcao) {
				case 1:
					cadastrarCliente(clientes);
					break;
				
				case 2:
					consultarDadosCliente(clientes);
					break;
				
				case 3:
					listarClientesFeminino(clientes);
					break;
				
				case 4:
					consultarMediaIdade(clientes);
					break;

				case 5:
					consultarSaldoAcimaMedia(clientes);
					break;

				case 6:
					usuarioAutenticado = false;
					break;
				
				default:
					System.out.println("Ação inválida!");
					break;
			}
		} while (usuarioAutenticado);
		
		System.out.println("Ate mais!");
	}
	
	private static boolean autenticar() {
		System.out.println("Numero da conta: ");
		String login = scan.next();
		System.out.println("Senha: ");
		String senha = scan.next();
		
		return login.equals("101010") && senha.equals("adm");
	}
	
	private static int selecionarAcao() {
		try {
			System.out.println("Escolha uma Opcao:\n" +
				"1. Cadastrar cliente\n"+
				"2. Consultar dados pessoais de um cliente\n"+
				"3. Listar clientes do sexo feminino\n" +
				"4. Consultar a media de idades dos clientes\n" +
				"5. Listar clientes com saldo maior que a media de saldos\n" +
				"6. Sair\n");
			
			int opcao = scan.nextInt();
			return opcao;
		} catch (Exception e) {
			scan.nextLine();
			return -1;
		}
	}
	
	private static void cadastrarCliente(Arvore arvore) {
		System.out.println("********* NOVO CLIENTE *********");
		
		try {
			System.out.println("Nome: ");
			String nome = scan.next();
			System.out.println("CPF: ");
			String cpf = scan.next();
			System.out.println("Idade: ");
			int idade = scan.nextInt();
			System.out.println("Sexo [(M)asculino | (F)eminino | (O)utro]: ");
			char sexoChar = Character.toUpperCase(scan.next().charAt(0));
			Genero sexo = sexoChar == 'M' ? Genero.MASCULINO : (sexoChar == 'F' ? Genero.FEMININO : Genero.OUTRO);
			System.out.println("Saldo: ");
			double saldo = scan.nextDouble();
			
			Cliente novo = new Cliente(nome, cpf, idade, sexo, saldo);
			arvore.inserirCliente(novo);		
		} catch (Exception e) {
			scan.nextLine();
			System.out.println("Cadastro falhou!\n");
		}
	}
	
	private static void consultarDadosCliente(Arvore arvore) {
		System.out.println("********* CONSULTAR CLIENTE *********");
		
		System.out.println("Nome: ");
		String nome = scan.next();
	
		
		arvore.dadosDoCliente(nome);
	}
	
	private static void listarClientesFeminino(Arvore arvore) {
		arvore.listarClientesFeminino();
	}
	
	private static void consultarMediaIdade(Arvore arvore) {
		arvore.mediaIdade();
	}
	
	private static void consultarSaldoAcimaMedia(Arvore arvore) {
		arvore.listarClientesSaldoAcimaMedia();
	}
}
