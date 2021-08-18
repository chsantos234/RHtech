import java.util.ArrayList;
import java.util.Scanner;
class Empresa{
	String nome, endereco, telefone, cnpj, email, dono;
	
	public Empresa(String nome, String endereco, String telefone, String cnpj, String email, String dono) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone =  telefone;
		this.cnpj = cnpj;
		this.email = email;
		this.dono = dono;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDono() {
		return dono;
	}

	public void setDono(String dono) {
		this.dono = dono;
	}
	
}

enum Setor{
	
}

class Contrato{
	public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	Funcionario funcionario;
	String setor,cargo;
	int id;
	float salario;
	
	public Contrato(Funcionario funcionario,String setor,String cargo,int id,float salario) {
		this.funcionario = funcionario;
		this.setor = setor;
		this.cargo = cargo;
		this.id = id;
		this.salario = salario;
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getSalario() {
		return salario;
	}

	public void setSalario(float salario) {
		this.salario = salario;
	}
}

class Funcionario{
	private String nome, sobrenome, endereco,sexo,email,cpf,telefone;
	private int idade;
	
	public Funcionario(String nome, String sobrenome, String endereco, String sexo, String email, String cpf, String telefone, int idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.email = email;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
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
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}

public class Main{
	public static void main(String args[]) throws Exception{
		Scanner sc1 = new Scanner(System.in);
		System.out.println("Adimitir funcionário------------------------[1]\nConsultar funcionário-----------------------[2]\nAtualizar dados de um funcionário-----------[3]\nDemitir funcionário-------------------------[4]\nVisualizar lista de funcionários------------[5]");
		System.out.println("Visualizar funcionários por especificidade--[6]\nIdentificar funcinário por salário----------[7]\nIdentificar setor por funcionários----------[8]\nMétodo com informação valiosa[9]");
		while(true) {
			String UserInput = sc1.nextLine();
			if(UserInput.equals("1")) {
				System.out.print("Digite o nome do funcionário: ");
				String nome = sc1.nextLine();
				System.out.print("\nDigite o sobrenome do funcionário: ");
				String sobrenome = sc1.nextLine();
				System.out.print("\nDigite o endereço do funcionário: "); // a ser decidido devido a bairro,cidade e estado
				
				System.out.print("\nDigite a idade do funcionário: ");
				int idade = sc1.nextInt();
				System.out.print("\nDiga o sexo do funcionário:\nmasculino[1]\nfeminino[2]\nnão binário[3]");
				String sexo = sc1.nextLine();
				if(sexo.equals("1")) {}
				else if(sexo.equals("2")) {}
				else if(sexo.equals("3")) {}
				System.out.print("\nDigite o CPF do funcionário: ");
				String CPF = sc1.nextLine();
				System.out.print("\nDigite o e-mail do funcionário: ");
				String email = sc1.nextLine();
			}
			else if(UserInput.equals("2")) {
				System.out.println("Consulta funcionário por:\nnome[1]\nCPF[2]");
				String ConsultaInput = sc1.nextLine();
				if(ConsultaInput.equals("1")) {
					System.out.print("Digite o nome do funcionário: ");
					String ConsultaNome = sc1.nextLine();
				}
				else if(ConsultaInput.equals("2")) {
					System.out.print("Digite o CPF do funcionário: ");
					String ConsultaCPF = sc1.nextLine();
				}
			}
			else if(UserInput.equals("3")) {
				System.out.print("Digite o nome do funcionário para ser atualizado: ");
				String UpdateNome = sc1.nextLine();
			}
			else if(UserInput.equals("4")) {
				System.out.print("Digite o CPF do funcionário a ser demitido: ");
				String FireCPF = sc1.nextLine();
			}
			else if(UserInput.equals("5")) { // método de lista a ser programado
				
			}
			else if(UserInput.equals("6")) {
				System.out.println("Visualizar funcionários por:\nsetor[1]\nsexo[2]\nestado[3] ");
				String VisualizarInput = sc1.nextLine();
				if(VisualizarInput.equals("1")) {
					System.out.print("Setores: (indisponível)");
					
				}
				else if(VisualizarInput.equals("2")) {
					System.out.println("masculino[1]\nfeminino[2]\nnão binário[3]");
					String VisualizarSexoInput = sc1.nextLine();
					if(VisualizarSexoInput.equals("1")) {
						System.out.println("Mostrando funcionários do sexo masculino:");
					}
					else if(VisualizarSexoInput.equals("2")) {
						System.out.println("Mostrando funcionários do sexo feminino:");
					}
					else if(VisualizarSexoInput.equals("3")) {
						System.out.println("Mostrando funcionários não binários:");
					}
				}
				else if(VisualizarInput.equals("3")) {
					System.out.print("Digite o nome do estado: ");
					String VisualizarEstadoInput = sc1.nextLine();
					System.out.printf("Visualizando funcionários do estado: %s",VisualizarEstadoInput);
				}
			}
			else if(UserInput.equals("7")) {
				System.out.println("Identificar funcionário com:\nmaior salário[1]\nmenor salário[2]");
				String IdentificarInput1 = sc1.nextLine();
				if(IdentificarInput1.equals("1")) {
					System.out.println("Mostrando funcionário com maior salário:");
				}
				else if(IdentificarInput1.equals("2")) {
					System.out.println("Mostrando funcionário com menor salário:");
				}
			}
			else if(UserInput.equals("8")) {
				System.out.println("Identificar setor com:\nmaior número de funcionários[1]\nmenor número de funcionários[2]");
				String IdentificarInput2 = sc1.nextLine();
				if(IdentificarInput2.equals("1")) {
					System.out.println("Mostrando setor com maior número de funcionários:");
				}
				else if(IdentificarInput2.equals("2")) {
					System.out.println("Mostrando setor com menor número de funcionários:");
				}
			}
			else if(UserInput.equals("9")) {System.out.println("método em construção");}
			else {System.out.println("Comando inválido!");}
		}
	}
}
