package trabalho;

public class Cliente {
	private String nome;
	private String cpf;
	private int idade;
	private Genero sexo;
	private double saldo;
	
	public Cliente(String nome, String cpf, int idade, Genero sexo, double saldo) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
		this.saldo = saldo;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
	
	public Genero getSexo() {
		return sexo;
	}
	
	public void setSexo(Genero sexo) {
		this.sexo = sexo;
	}
	
	public double getSaldo() {
		return saldo;
	}
	
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	
	public boolean isMulher() {
		return this.sexo == Genero.FEMININO;
	}

	@Override
	public String toString() {
		return "Cliente {\n  nome: " + nome + ",\n  cpf: " + cpf + ",\n  idade: " + idade + ",\n  sexo: " + sexo + ",\n  saldo: " + saldo + "\n}";
	}
}
