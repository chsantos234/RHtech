import java.util.ArrayList;
import java.util.Scanner;

// Classe Empresa
class Empresa{
	String nome, endereco, telefone, cnpj, email, dono;
	
	// Constructor da classe empresa
	public Empresa(String nome, String endereco, String telefone, String cnpj, String email, String dono) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone =  telefone;
		this.cnpj = cnpj;
		this.email = email;
		this.dono = dono;
	}
	
	// Métodos set e get da classe Empresa
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

// Enumerator de todos os setores
enum Setor{
	REQUISITOS("requisitos",0,0),
	MODELAGENS("modelagens",0,0),
	CODIFICACAO("codificação",0,0),
	TESTES("testes",0,0),
	RECURSOSHUMANOS("recursos_humanos",0,0);
	
	private String setor;
	private int funcionarios;
	private int chefe;
	
	Setor(String setor,int funcionarios,int chefe){
		this.setor = setor;
		this.funcionarios = funcionarios;
		this.chefe = chefe;
	}

	public String getSetorString() {
		return setor;
	}

	public void setSetorString(String setor) {
		this.setor = setor;
	}
	
	public int getFuncionarios() {
		return this.funcionarios;
	}
	
	public void setFuncionarios(int funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	public int getChefe() {
		return this.chefe;
	}
	
	public void setChefe(int chefe) {
		this.chefe = chefe;
	}
}

// Classe Contrato
class Contrato{
	public static ArrayList<Contrato> listaContratos = new ArrayList<Contrato>();
	public static ArrayList<Funcionario> listaFuncionarios = new ArrayList<Funcionario>();
	Setor setor;
	String cargo;
	int id;
	float salario;
	
	// Constructor da classe Contrato
	public Contrato(Setor setor,String cargo,int id,float salario) {
		this.setor = setor;
		this.cargo = cargo;
		this.id = id;
		this.salario = salario;
	}
	
	// Métodos set e get da classe Contrato

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
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
	
	// função PrintList (imprime a lista de todos os funcionários com suas informações pessoais)
	static void PrintList() {
		for(Funcionario i : listaFuncionarios) {
			System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%d%n",i.getNome(),i.getSobrenome(),i.getEndereco().getBairro(),i.getEndereco().getCidade(),i.getEndereco().getEstado(),i.getSexo(),i.getEmail(),i.getCpf(),i.getTelefone(),i.getIdade());
			System.out.printf("%d,%s,%s,%.3f%n",i.getContrato().getId(),i.getContrato().getSetor().getSetorString(),i.getContrato().getCargo(),i.getContrato().getSalario());
		}
	}
	
	// Início da função ConsultarLista (Consulta um funcionário específico por meio de nome ou cpf, retornando suas informações pessoais e contratuais)
	static void ConsultarLista(int Num,String Input) {
		boolean Status = false;

		if(Num == 1) {
			for(Funcionario i : listaFuncionarios) {
				if(i.getNome().equals(Input)) {

					System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%d.%n",i.getNome(),i.getSobrenome(),i.getEndereco().getBairro(),i.getEndereco().getCidade(),i.getEndereco().getEstado(),i.getSexo(),i.getEmail(),i.getCpf(),i.getTelefone(),i.getIdade());
					Status = true;
					
					if(Status == true) {
						System.out.printf("%d,%s,%s,%.3f%n",i.getContrato().getId(),i.getContrato().getSetor().getSetorString(),i.getContrato().getCargo(),i.getContrato().getSalario());
					}
				}
			}if(Status == false) {System.out.println("funcionário não encontrado");}
		}
		else if(Num == 2) {
			for(Funcionario i : listaFuncionarios) {
				if(i.getCpf().equals(Input)) {

					System.out.printf("%s,%s,%s,%s,%s,%s,%s,%s,%s,%d.%n",i.getNome(),i.getSobrenome(),i.getEndereco().getBairro(),i.getEndereco().getCidade(),i.getEndereco().getEstado(),i.getSexo(),i.getEmail(),i.getCpf(),i.getTelefone(),i.getIdade());
					Status = true;
					if(Status == true) {
						System.out.printf("%d,%s,%s,%.3f%n",i.getContrato().getId(),i.getContrato().getSetor().getSetorString(),i.getContrato().getCargo(),i.getContrato().getSalario());
					}
				}
			}if(Status == false) {System.out.println("funcionário não encontrado");}
		}
	}// fim da função ConsultarLista
	
	// função DemitirFuncinario (demite um funcionário específico pelo seu cpf)
	static void DemitirFuncinario(String cpf) {
		boolean Status = false;
		
		Funcionario remover = null;
		Contrato removerContrato = null;
		
		for(Funcionario i : listaFuncionarios) {
			if(i.getCpf().equals(cpf)) {
				remover = i;
				removerContrato = i.getContrato();
				Status = true;
			}
		}
		if(Status == true) {
			listaFuncionarios.remove(remover);
			listaContratos.remove(removerContrato);
			System.out.println("Funcionário removido");
		}
		else {
			System.out.println("Funcionário não encontrado");
		}

	}// fim da função DemitirFuncinario
	
	// função AddContrato (Adiciona um contrato a listaContratos)
	void AddContrato(Contrato contrato) {listaContratos.add(contrato);}
}

class Endereco{
	String bairro,cidade,estado;
	public Endereco(String bairro,String cidade,String estado) {
		this.bairro = bairro;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}

// Classe Funcionario
class Funcionario{
	Contrato contrato;
	private Endereco endereco;
	private String nome, sobrenome,sexo,email,cpf,telefone;
	private int idade;
	
	// constructor da classe Funcionario
	public Funcionario(String nome, String sobrenome, Endereco endereco, String sexo, String email, String cpf, String telefone, int idade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.endereco = endereco;
		this.sexo = sexo;
		this.email = email;
		this.idade = idade;
		this.cpf = cpf;
		this.telefone = telefone;
	}
	
	// Métodos set e get da classe Funcionario
	public Contrato getContrato() {
		return contrato;
	}
	public void setContrato(Contrato contrato) {
		this.contrato = contrato;
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
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
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
	
	// função AddFuncionario (adiciona um funcionário a listaFuncionarios)
	void AddFuncionario(Funcionario funcionario) {
		Contrato.listaFuncionarios.add(funcionario);
	}
	
	// função ProcurarSetor (retorna o setor com maior ou menor número de funcionários)
	static void ProcurarSetor(int escolha) {
		ArrayList<Setor> Setores = new ArrayList<Setor>();
		Setor setor = null;
		float maior = Integer.MIN_VALUE;
		float menor = Integer.MAX_VALUE;
		
		Setores.add(Setor.CODIFICACAO);
		Setores.add(Setor.MODELAGENS);
		Setores.add(Setor.RECURSOSHUMANOS);
		Setores.add(Setor.REQUISITOS);
		Setores.add(Setor.TESTES);
		
		if(escolha == 1) {
			for(Setor i : Setores) {
				if(i.getFuncionarios() > maior) {
					maior = i.getFuncionarios();
					setor = i;
				}
			}
			System.out.printf("O setor com maior número de funcionários é o %s com %d funcionários.%n",setor.getSetorString(),setor.getFuncionarios());
		}
		else if(escolha == 2) {
			for(Setor i : Setores) {
				if(i.getFuncionarios() < menor) {
					menor = i.getFuncionarios();
					setor = i;
				}
			}
			System.out.printf("O setor com menor número de funcionários é o %s com %d funcionário(s).%n",setor.getSetorString(),setor.getFuncionarios());
		}
	}
	
	// função ProcurarSalario (retorna o funcionário com maior ou menor salário)
	static void ProcurarSalario(int escolha) {
		Funcionario funcionario = null;
		float maior = Integer.MIN_VALUE;
		float menor = Integer.MAX_VALUE;
		if(escolha == 1) {
			for(Funcionario i : Contrato.listaFuncionarios) {
				if(i.getContrato().getSalario() > maior) {
					maior = i.getContrato().getSalario();
					funcionario = i;
				}
			}
			System.out.printf("Funcionário %s %s tem o maior salário de: %.3f e trabalha no setor %s como %s.%n",funcionario.getNome(),funcionario.getSobrenome(),funcionario.getContrato().getSalario(),funcionario.getContrato().getSetor().getSetorString(),funcionario.getContrato().getCargo());
		}
		else if(escolha == 2) {
			for(Funcionario i : Contrato.listaFuncionarios) {
				if(i.getContrato().getSalario() < menor) {
					menor = i.getContrato().getSalario();
					funcionario = i;
				}
			}
			System.out.printf("Funcionário %s %s tem o menor salário de: %.3f e trabalha no setor %s como %s.%n",funcionario.getNome(),funcionario.getSobrenome(),funcionario.getContrato().getSalario(),funcionario.getContrato().getSetor().getSetorString(),funcionario.getContrato().getCargo());
		}
	}
}

// Classe main com o método main
public class Main{
	public static void main(String args[]) throws Exception{
		Scanner sc1 = new Scanner(System.in);
		// apresentação das ações que um usuáro pode fazer:
		System.out.println("Adimitir funcionário------------------------[1]\nConsultar funcionário-----------------------[2]\nAtualizar dados de um funcionário-----------[3]\nDemitir funcionário-------------------------[4]\nVisualizar lista de funcionários------------[5]");
		System.out.println("Visualizar funcionários por especificidade--[6]\nIdentificar funcinário por salário----------[7]\nIdentificar setor por funcionários----------[8]\nMétodo com informação valiosa---------------[9]\nSair----------------------------------------[10]");
		
		while(true) {
			System.out.print("(1 a 9):");
			String UserInput = sc1.next();
			
			//(1) Adimitir um novo funcionário:
			if(UserInput.equals("1")) {
				
				System.out.print("Digite o nome do funcionário: ");
				String nome = sc1.next();
				
				System.out.print("Digite o último nome do funcionário: ");
				String sobrenome = sc1.next();
				
				System.out.print("Digite o bairro do funcionário (use _ como espaço): ");
				String BairroInput = sc1.next();
				
				System.out.print("Digite o cidade do funcionário (use _ como espaço): ");
				String CidadeInput = sc1.next();
				
				System.out.print("Digite as ciglas do estado do funcionário: ");
				String EstadoInput = sc1.next();
				
				System.out.print("Diga o sexo do funcionário: masculino[1],feminino[2],não binário[3]: ");
				int SexoInput = sc1.nextInt();
				String sexo = "";
				if(SexoInput == 1) {sexo = "masculino";}
				else if(SexoInput == 2) {sexo = "feminino";}
				else if(SexoInput == 3) {sexo = "não_binário";}
				
				System.out.print("Digite o e-mail do funcionário: ");
				String email = sc1.next();
				
				System.out.print("Digite o CPF do funcionário: ");
				String CPF = sc1.next();
				
				System.out.print("Digite o número de telefone: ");
				String telefone = sc1.next();
				
				System.out.print("Digite a idade do funcionário: ");
				int idade = sc1.nextInt();
				Endereco endereco = new Endereco(BairroInput,CidadeInput,EstadoInput);
				Funcionario funcionario = new Funcionario(nome,sobrenome,endereco,sexo,email,CPF,telefone,idade);
				funcionario.AddFuncionario(funcionario);
				
				System.out.println("Criando contrato...");
				System.out.print("Escolha o setor de atuação: Requisitos[1],Modelagens[2],Codificação[3],Testes[4],Recursos Humanos[5]: ");
				Setor setor = null;
				int SetorType = sc1.nextInt();
				if(SetorType == 1) {setor = Setor.REQUISITOS;}
				else if(SetorType == 2) {setor = Setor.MODELAGENS;}
				else if(SetorType == 3) {setor = Setor.CODIFICACAO;}
				else if(SetorType == 4) {setor = Setor.TESTES;}
				else if(SetorType == 5) {setor = Setor.RECURSOSHUMANOS;}
				
				System.out.print("Escolha o cargo do funcionário: colaborador[1],chefe[2]: ");
				String cargo = "";
				int CargoType = sc1.nextInt();
				
				if(CargoType == 1) {
					cargo = "colaborador";
				}
				else if(CargoType == 2) {
					int NumChefes = setor.getChefe();
					if(NumChefes == 0) {
						cargo = "chefe";
					}
					else {
						System.out.println("Este setor ja apresenta um chefe, o funcionário será contratado como colaborador");
						cargo = "colaborador";
					}
				}
				
				System.out.print("Digite o salário do funcionário: ");
				float salario = sc1.nextFloat();
				
				System.out.print("Gerando o id do funcionário...");
				int id = 0;
				while(true) {
					id = (int)(Math.random()*(9999-1000+1)+1000);
					for(Contrato i : Contrato.listaContratos) {
						if(i.getId() == id) {
							continue;
						}
					}
					break;
				}
				System.out.printf("Id gerado %d%n",id);
				Contrato contrato = new Contrato(setor,cargo,id,salario);
				int NumFuncionarios = contrato.getSetor().getFuncionarios();
				NumFuncionarios++;
				contrato.getSetor().setFuncionarios(NumFuncionarios);
				funcionario.setContrato(contrato);
				contrato.AddContrato(contrato);
				
				if(funcionario.getContrato().getCargo().equals("chefe")) {
					int NumChefe = funcionario.getContrato().getSetor().getChefe();
					NumChefe++;
					funcionario.getContrato().getSetor().setChefe(NumChefe);
				}
				
			}
			
			// (2) Consulta um funcionário específico pelo seu nome ou CPF:
			else if(UserInput.equals("2")) {
				System.out.println("Consulta funcionário por:\nnome[1]\nCPF[2]");
				int ConsultaInput = sc1.nextInt();
				if(ConsultaInput == 1) {
					System.out.print("Digite o nome do funcionário: ");
					String ConsultaNome = sc1.next();
					Contrato.ConsultarLista(1,ConsultaNome);
				}
				else if(ConsultaInput == 2) {
					System.out.print("Digite o CPF do funcionário: ");
					String ConsultaCPF = sc1.next();
					Contrato.ConsultarLista(2,ConsultaCPF);
				}
			}
			
			// (3) Atualizar informações pessoais ou contratuais de um funcionário específico por meio de seu nome:
			else if(UserInput.equals("3")) {
				boolean Status = false;
				Funcionario UpdatedFuncionario = null;
				System.out.print("Digite o nome do funcionário para ser atualizado: ");
				String UpdateNomeFuncionario = sc1.next(); ///// verificar se funcionário existe
				
				for(Funcionario i : Contrato.listaFuncionarios) {
					if(i.getNome().equals(UpdateNomeFuncionario)) {
						UpdatedFuncionario = i;
						Status = true;
					}
				}
				if(Status == true) {
					while(true) {
						
						System.out.print("Atualizar: dados pessoais[1],dados contratuais[2],voltar[3]:");
						int UptadeInfoType = sc1.nextInt();
					// Atualizar dados pessoais
						if(UptadeInfoType == 1) {
							int UpdatePessoal = sc1.nextInt();
							System.out.print("Atualizar:nome[1],sobrenome[2],endereço[3],sexo[4],e-mail[5],CPF[6],telefone[7],idade[8]\n:");
							
							if(UpdatePessoal == 1) {
								System.out.print("Digite um novo nome: ");
								String NovoNome = sc1.next();
								UpdatedFuncionario.setNome(NovoNome);
							}
							else if(UpdatePessoal == 2) {
								System.out.print("Digite um novo último nome: ");
								String NovoSobrenome = sc1.next();
								UpdatedFuncionario.setSobrenome(NovoSobrenome);
							}
							else if(UpdatePessoal == 3) {		
								System.out.print("Digite o nome do bairro (use _ como espaço): ");
								String NovoBairro = sc1.next();
								
								System.out.print("Digite o nome da cidade (use _ como espaço): ");
								String NovaCidade = sc1.next();
								
								
								System.out.print("Digite as siglas do estado");
								String NovoEstado = sc1.next();
								
								Endereco endereco = new Endereco(NovoBairro,NovaCidade,NovoEstado);
								UpdatedFuncionario.setEndereco(endereco);
								
							}
							else if(UpdatePessoal == 4) {
								System.out.print("Atualize o sexo: masculino[1],feminino[2],não binário[3] ");
								int NovoSexoInt = sc1.nextInt();
								if(NovoSexoInt == 1) {
									UpdatedFuncionario.setSexo("masculino");
								}
								else if(NovoSexoInt == 2) {
									UpdatedFuncionario.setSexo("feminino");
								}
								else if(NovoSexoInt == 3) {
									UpdatedFuncionario.setSexo("não_binário");
								}
							}
							else if(UpdatePessoal == 5) {
								System.out.print("Digite um novo e-mail: ");
								String NovoEmail = sc1.next();
								UpdatedFuncionario.setEmail(NovoEmail);
							}
							else if(UpdatePessoal == 6) {
								System.out.print("Digite um novo CPF: ");
								String NovoCpf = sc1.next();
								UpdatedFuncionario.setCpf(NovoCpf);
							}
							else if(UpdatePessoal == 7) {
								System.out.print("Digite um novo telefone: ");
								String NovoTelefone = sc1.next();
								UpdatedFuncionario.setTelefone(NovoTelefone);
							}
							else if(UpdatePessoal == 8) {
								System.out.print("Digite uma nova idade: ");
								int NovaIdade = sc1.nextInt();
								UpdatedFuncionario.setIdade(NovaIdade);
							}
							
						}
					// Atualizar dados contratuais
						else if(UptadeInfoType == 2) {
							Contrato UpdatedContrato = UpdatedFuncionario.getContrato();
							System.out.print("Atualizar:setor[1],cargo[2],sálario[3]\n:");
							
							int UpdateContratual = sc1.nextInt();
							if(UpdateContratual == 1) {
								int NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
								NumFuncionarios--;
								UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								System.out.print("Atualize o setor: Requisitos[1],Modelagens[2],Codificação[3],Testes[4],Recursos Humanos[5]: ");
								int NovoSetor = sc1.nextInt();
								if(NovoSetor == 1) {
									UpdatedContrato.setSetor(Setor.REQUISITOS);
									NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
									NumFuncionarios++;
									UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								}
								else if(NovoSetor == 2) {
									UpdatedContrato.setSetor(Setor.MODELAGENS);
									NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
									NumFuncionarios++;
									UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								}
								else if(NovoSetor == 3) {
									UpdatedContrato.setSetor(Setor.CODIFICACAO);
									NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
									NumFuncionarios++;
									UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								}
								else if(NovoSetor == 4) {
									UpdatedContrato.setSetor(Setor.TESTES);
									NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
									NumFuncionarios++;
									UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								}
								else if(NovoSetor == 5) {
									UpdatedContrato.setSetor(Setor.RECURSOSHUMANOS);
									NumFuncionarios = UpdatedFuncionario.getContrato().getSetor().getFuncionarios();
									NumFuncionarios++;
									UpdatedFuncionario.getContrato().getSetor().setFuncionarios(NumFuncionarios);
								}
							}
							else if(UpdateContratual == 2) {
								int NumChefe = 0;
								Setor setor = null;
								
								System.out.print("Atualiza o cargo: colaborador[1],chefe[2]: ");
								int NovoCargo = sc1.nextInt();
								
								if(NovoCargo == 1) {
									if(UpdatedFuncionario.getContrato().getCargo().equals("chefe")) {
										setor = UpdatedFuncionario.getContrato().getSetor();
										setor.setChefe(0);
									}
									UpdatedContrato.setCargo("colaborador");
								}
								else if(NovoCargo == 2) {
									NumChefe = UpdatedFuncionario.getContrato().getSetor().getChefe();
									setor = UpdatedFuncionario.getContrato().getSetor();
									if(NumChefe == 0) {
										UpdatedContrato.setCargo("chefe");
										NumChefe++;
										setor.setChefe(NumChefe);
									}
									else {
										System.out.println("Cargo de chefe não está vago para o setor deste funcionário");
									}
								}
							}
							else if(UpdateContratual == 3) {
								System.out.print("Digite um novo salário: ");
								float NovoSalário = sc1.nextFloat();
								UpdatedContrato.setSalario(NovoSalário);
							}
						}
						else if(UptadeInfoType == 3) {break;}
					}
				}
				else if(Status == false) {
					System.out.println("funcionário não encontrado");
				}
			}
			
			// (4) Demitir um funcionário por meio de seu CPF:
			else if(UserInput.equals("4")) {
				System.out.print("Digite o CPF do funcionário a ser demitido: ");
				String FireCPF = sc1.next();
				Contrato.DemitirFuncinario(FireCPF);
			}
			
			// (5) Apresentar a lista completa de funcionários e suas informações pessoais:
			else if(UserInput.equals("5")) { 
				Contrato.PrintList();
			}
			
			// (6) Filtrar a lista de funcionários por setor, sexo ou estado:
			else if(UserInput.equals("6")) {
				System.out.println("Visualizar funcionários por:\nsetor[1]\nsexo[2]\nestado[3] ");
				String VisualizarInput = sc1.next();
				if(VisualizarInput.equals("1")) {
					System.out.print("Setores: (indisponível)");
					
				}
				else if(VisualizarInput.equals("2")) {
					System.out.println("masculino[1]\nfeminino[2]\nnão binário[3]");
					String VisualizarSexoInput = sc1.next();
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
					String VisualizarEstadoInput = sc1.next();
					System.out.printf("Visualizando funcionários do estado: %s",VisualizarEstadoInput);
				}
			}
			
			// (7) Identificar funcionário com maior ou menor salário:
			else if(UserInput.equals("7")) {
				System.out.println("Identificar funcionário com:\nmaior salário[1]\nmenor salário[2]");
				String IdentificarInput1 = sc1.next();
				if(IdentificarInput1.equals("1")) {
					System.out.println("Mostrando funcionário com maior salário:");
					Funcionario.ProcurarSalario(1);
				}
				else if(IdentificarInput1.equals("2")) {
					System.out.println("Mostrando funcionário com menor salário:");
					Funcionario.ProcurarSalario(2);
				}
			}
			
			// (8) Identificar setor com maior ou menor número de funcionários
			else if(UserInput.equals("8")) {
				System.out.println("Identificar setor com:\nmaior número de funcionários[1]\nmenor número de funcionários[2]");
				String IdentificarInput2 = sc1.next();
				if(IdentificarInput2.equals("1")) {
					System.out.println("Mostrando setor com maior número de funcionários:");
					Funcionario.ProcurarSetor(1);
				}
				else if(IdentificarInput2.equals("2")) {
					System.out.println("Mostrando setor com menor número de funcionários:");
					Funcionario.ProcurarSetor(1);
				}
			}
			
			// (9) Função em andamento:
			else if(UserInput.equals("9")) {System.out.println("método em construção");}
			else if(UserInput.equals("10")) {System.out.println("Finalizando o programa...");break;}
			else {System.out.println("Comando inválido!");}
			
		}
		sc1.close();
	}
}
