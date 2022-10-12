package trabalho;

import java.util.ArrayList;

public class Arvore {
	private No raiz;
	private int nNos;
	
	public Arvore() {
		this.raiz = null;
		this.nNos = 0;
	}

	public No getRaiz() {
		return raiz;
	}
	
	public int getQuantidadeNos() {
		return nNos;
	}
	
	public void inserirCliente(Cliente cliente) {
		if (this.nNos == 0) {
			this.raiz = new No(cliente);
			this.nNos++;
			System.out.println("Cadastro Realizado com Sucesso!\n");
			
		}
		else {
			CodigoInsercao status = this.raiz.inserirCliente(cliente);
			
			switch (status) {
				case CPF_JA_EXISTE:
					System.out.println("CPF ja existe no sistema!");
					break;
				
				case NOME_JA_EXISTE:
					System.out.println("Nome ja existe no sistema!");
					break;

				case SUCESSO: {
					this.nNos++;
					System.out.println("Cliente cadastrado!");
					break;
				}
			}
		}
	}
	
	public void dadosDoCliente(String nome) {
		if (this.nNos > 0) {
			No cliente = this.raiz.encontrarPorNome(nome);
			
			if (cliente != null) {
				cliente.dadosPessoais();
				return;
			}
		}
		
		System.out.println("Cliente nao encontrado!\nFavor cadastrar um cliente.\n");
	}
	
	public void listarClientesFeminino() {
		if (this.nNos > 0) {
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			clientes = this.raiz.listarClientesFemininas(clientes);
			
			
			clientes.forEach(cliente -> {
				System.out.println(cliente.getNome() + " - " + cliente.getCpf());
			});
		} else {
			System.out.println("Nenhum cliente adicionado do sexo fiminino localizado.\n");
		}
		
	}
	
	public void mediaIdade() {
		if (this.nNos > 0) {
			double media = this.raiz.getSomaIdade() / 1.0 / this.nNos;
			System.out.println(media + " anos");
		}
		else {
			System.out.println("Nenhum cliente adicionado\n");			
		}
	}
	
	public void listarClientesSaldoAcimaMedia() {
		if (this.nNos > 0) {
			double media = this.raiz.getSomaSaldo() / this.nNos;
			ArrayList<Cliente> clientes = new ArrayList<>();
			
			clientes = this.raiz.listarClientesComSaldoMaiorQue(clientes, media);
			
			clientes.forEach(cliente -> {
				System.out.println(cliente.getNome() + " - " + cliente.getCpf());
			});
		}
		else {
			System.out.println("Nenhum cliente adicionado\n");			
		}
	}
}
