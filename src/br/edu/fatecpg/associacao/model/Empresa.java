package br.edu.fatecpg.associacao.model;

public class Empresa {
    private String nomeEmpresa;
    private Cliente[] clientes;
    private Funcionario[] funcionarios;

    public Empresa(String nome) {
        this.nomeEmpresa = nome;
        this.clientes = new Cliente[5];
        this.funcionarios = new Funcionario[10];
    }

    public String getNomeEmpresa() {
        return nomeEmpresa;
    }

    public void setNomeEmpresa(String nomeEmpresa) {
        this.nomeEmpresa = nomeEmpresa;
    }

    public void adicionarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = cliente;
                return;
            }
        }
        System.out.println("Limite de clientes atingido! Não é possível adicionar mais clientes.");
    }

    public String exibirClientes() {
        if (vazioClientes()) {
            return "Nenhum cliente cadastrado.";
        }

        StringBuilder clienteInfo = new StringBuilder("<html>Clientes cadastrados:<br><br>");
        for (int c = 0; c < 5; c++) {
            if (this.clientes[c] == null) {
                continue;
            }
            clienteInfo.append("Nome: ").append(clientes[c].getNome())
                       .append(", Email: ").append(clientes[c].getEmail()).append(";<br>");
        }
        clienteInfo.append("</html>");
        return clienteInfo.toString();
    }

    
	public boolean vazioClientes() {
		int total = 0;
		for(int c = 0; c<5 ; c++) {
			if(this.clientes[c] == null) {
				total++;
			}
		}
		if(total == 5 ){
			return true;
		}
		else {
			return false;
		}
	}
	

    public void adicionarFuncionario(Funcionario funcionario) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] == null) {
            	funcionarios[i] = funcionario;
                return;
            }
        }
        System.out.println("Limite de funcionarios atingido! Não é possível adicionar mais funcionarios.");

    }

    public String exibirFuncionarios() {
        if (vazioFuncionarios()) {
            return "Nenhum funcionário cadastrado.";
        }

        StringBuilder FuncInfo = new StringBuilder("<html>Funcionarios cadastrados:<br><br>");
        for(int c = 0; c < 10; c++) {
			if(this.funcionarios[c] == null) {
				continue;    
			}
			FuncInfo.append("Nome: ").append(funcionarios[c].getNome()).append("<br> Cargo: ").append(funcionarios[c].getCargo()).append("<br> Salario: ").append(funcionarios[c].getSalario()).append(";<br><br>");
        }
        FuncInfo.append("</html>");
       return FuncInfo.toString();
    }

	public boolean vazioFuncionarios() {
		int total = 0;
		for(int c = 0; c < 10 ; c++) {
			if(this.funcionarios[c] == null) {
				total++;
			}
		}
		if(total == 10){
			return true;
		}
		else {
			return false;
		}
	}
	
    public double calcularMediaSalarial() {
        Calculadora calculadora = new Calculadora();
        double totalSalarios = 0;
        int contadorFuncionarios = 0;

        for(int c = 0; c < 10; c++) {
			if(this.funcionarios[c] != null) {
                totalSalarios = calculadora.somar(totalSalarios, funcionarios[c].getSalario());
                contadorFuncionarios++;
            }
        }

        if (contadorFuncionarios == 0) {
        	return 0;
        }
        else {
        	return calculadora.dividir(totalSalarios, contadorFuncionarios);
        }
    }

    public void exibirMediaSalarial() {
        System.out.println("Média salarial: " + calcularMediaSalarial());
    }
}
