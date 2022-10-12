package trabalho;

import java.util.ArrayList;

public class No {
	private Cliente item;
	private No esquerda;
	private No direita;
	
	public No(Cliente item) {
		this.item = item;
		this.esquerda = null;
		this.direita = null;
	}

	public Cliente getItem() {
		return item;
	}
	
	public void setItem(Cliente item) {
		this.item = item;
	}
	
	public No getEsquerda() {
		return esquerda;
	}
	
	public void setEsquerda(No esquerda) {
		this.esquerda = esquerda;
	}
	
	public No getDireita() {
		return direita;
	}
	
	public void setDireita(No direita) {
		this.direita = direita;
	}
	
	public void dadosPessoais() {
		System.out.println(this.item);
	}
	
	public int getSomaIdade() {
		int somaIdade = this.item.getIdade();
		
		if (this.esquerda != null) {
			somaIdade += this.esquerda.getSomaIdade();
		}
		
		if (this.direita != null) {
			somaIdade += this.direita.getSomaIdade();
		}
		
		return somaIdade;
	}
	
	public double getSomaSaldo() {
		double somaIdade = this.item.getSaldo();
		
		if (this.esquerda != null) {
			somaIdade += this.esquerda.getSomaSaldo();
		}
		
		if (this.direita != null) {
			somaIdade += this.direita.getSomaSaldo();
		}
		
		return somaIdade;
	}
	
	public int getNumeroNos() {
		int nNos = 1;
		
		if (this.esquerda != null) {
			nNos += this.esquerda.getNumeroNos();
		}
		
		if (this.direita != null) {
			nNos += this.direita.getNumeroNos();
		}
		
		return nNos;
	}
	
	public No encontrarPorNome(String nome) {
		int direcao = nome.compareTo(this.item.getNome());
		
		if (direcao == 0) {
			return this;
		}
		else if (direcao < 0) {
			if (this.esquerda == null) {
				return null;
			}
			
			No buscaEsquerda = this.esquerda.encontrarPorNome(nome);
			
			if (buscaEsquerda != null) {
				return buscaEsquerda;
			}
		}
		else {
			if (this.direita == null) {
				return null;
			}
			
			No buscaDireita = this.direita.encontrarPorNome(nome);
			
			if (buscaDireita != null) {
				return buscaDireita;
			}
		}
		
		return null;
	}
	
	public No encontrarPorCpf(String cpf) {
		if (this.item.getCpf().equals(cpf)) {
			return this;
		}
		
		if (this.esquerda != null) {
			No buscaEsquerda = this.esquerda.encontrarPorCpf(cpf);
			
			if (buscaEsquerda != null) {
				return buscaEsquerda;
			}
		}
		
		if (this.direita != null) {
			No buscaDireita = this.direita.encontrarPorCpf(cpf);
			
			if (buscaDireita != null) {
				return buscaDireita;
			}
		}
		
		return null;		
	}
	
	public ArrayList<Cliente> listarClientesFemininas(ArrayList<Cliente> lista) {
		if (this.esquerda != null) {
			ArrayList<Cliente> buscaEsquerda = this.esquerda.listarClientesFemininas(new ArrayList<>());
			lista.addAll(buscaEsquerda);
		}

		if (this.item.isMulher()) {
			lista.add(item);
		}
		
		if (this.direita != null) {
			ArrayList<Cliente> buscaDireita = this.direita.listarClientesFemininas(new ArrayList<>());
			lista.addAll(buscaDireita);
		}
		
		return lista;
	}
	
	public ArrayList<Cliente> listarClientesComSaldoMaiorQue(ArrayList<Cliente> lista, double saldo) {
		if (this.item.getSaldo() > saldo) {
			lista.add(item);
		}
		
		if (this.esquerda != null) {
			ArrayList<Cliente> buscaEsquerda = this.esquerda.listarClientesComSaldoMaiorQue(new ArrayList<>(), saldo);
			lista.addAll(buscaEsquerda);
		}
		
		if (this.direita != null) {
			ArrayList<Cliente> buscaDireita = this.direita.listarClientesComSaldoMaiorQue(new ArrayList<>(), saldo);
			lista.addAll(buscaDireita);
		}
		
		return lista;
	}
	
	public CodigoInsercao inserirCliente(Cliente cliente) {
		if (encontrarPorNome(cliente.getNome()) != null) {
			return CodigoInsercao.NOME_JA_EXISTE;
		}
		
		if (encontrarPorCpf(cliente.getCpf()) != null) {
			return CodigoInsercao.CPF_JA_EXISTE;
		}
		
		inserirNo(new No(cliente));
		return CodigoInsercao.SUCESSO;
	}
	
	private void inserirNo(No novo) {
		int direcao = novo.item.getNome().compareTo(this.item.getNome());
		
		if (direcao < 0) {
			if (this.esquerda == null) {
				this.esquerda = novo;
			}
			else {
				this.esquerda.inserirNo(novo);
			}
		}
		else {
			if (this.direita == null) {
				this.direita = novo;
			}
			else {
				this.direita.inserirNo(novo);
			}
		}
	}
}
