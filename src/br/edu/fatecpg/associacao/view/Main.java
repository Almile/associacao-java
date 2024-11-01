package br.edu.fatecpg.associacao.view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import br.edu.fatecpg.associacao.model.Cliente;
import br.edu.fatecpg.associacao.model.Empresa;
import br.edu.fatecpg.associacao.model.Funcionario;

public class Main extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtNome;
    private JTextField txtEmail; 
    private JTextField txtCargo; 
    private JTextField txtSalario; 
    private JPanel inputPanel; 
    private JPanel displayPanel; 
    private CardLayout cardLayout; 
    private Empresa empresa; 

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Main frame = new Main();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Main() {
        empresa = new Empresa("FATEC");
        
       Funcionario fun1 = new Funcionario("Marcos", "Gerente", 4000);
	   Funcionario fun2 = new Funcionario("Paulo", "Analista", 2000);
	   empresa.adicionarFuncionario(fun1);
       empresa.adicionarFuncionario(fun2);
	       
        setTitle("Sistema da Empresa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        contentPane = new JPanel(new BorderLayout());
        setContentPane(contentPane);

        // Painel dos botões
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1));
        contentPane.add(buttonPanel, BorderLayout.WEST);

        // Painel de entrada e exibição
        JPanel mainPanel = new JPanel();
        cardLayout = new CardLayout();
        mainPanel.setLayout(cardLayout);
        contentPane.add(mainPanel, BorderLayout.CENTER);

        // Painel de entrada
        inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.Y_AXIS));
        inputPanel.setBorder(new EmptyBorder(20, 40, 20, 40));
        mainPanel.add(inputPanel, "InputPanel");


        // Painel de exibição de resultados
        displayPanel = new JPanel();
        displayPanel.setBackground(new Color(245, 245, 245));
        displayPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        mainPanel.add(displayPanel, "DisplayPanel");

        // Botão para adicionar cliente
        JButton btnAdicionarCliente = new JButton("Adicionar Cliente");
        btnAdicionarCliente.setBackground(new Color(255, 204, 255));
        btnAdicionarCliente.addActionListener(e -> mostrarCamposCliente());
        buttonPanel.add(btnAdicionarCliente);

        // Botão para exibir clientes
        JButton btnExibirClientes = new JButton("Exibir Clientes");
        btnExibirClientes.setBackground(new Color(255, 204, 204));
        btnExibirClientes.addActionListener(e -> {
            String clientes = empresa.exibirClientes();
            mostrarInformacao(clientes);
            esconderCampos();
        });
        buttonPanel.add(btnExibirClientes);

        // Botão para adicionar funcionário
        JButton btnAdicionarFuncionario = new JButton("Adicionar Funcionário");
        btnAdicionarFuncionario.setBackground(new Color(255, 204, 255));
        btnAdicionarFuncionario.addActionListener(e -> mostrarCamposFuncionario());
        buttonPanel.add(btnAdicionarFuncionario);

        // Botão para exibir funcionários
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        btnExibirFuncionarios.setBackground(new Color(255, 204, 204));
        btnExibirFuncionarios.addActionListener(e -> {
        	
            String funcionarios = empresa.exibirFuncionarios();
            mostrarInformacao(funcionarios);
            esconderCampos();
        });
        buttonPanel.add(btnExibirFuncionarios);

        // Botão para exibir média salarial
        JButton btnExibirMediaSalarial = new JButton("Exibir Média Salarial");
        btnExibirMediaSalarial.setBackground(new Color(255, 204, 255));
        btnExibirMediaSalarial.addActionListener(e -> {
            double mediaSalarial = empresa.calcularMediaSalarial();
            mostrarInformacao("Média salarial: " + mediaSalarial);
            esconderCampos();
        });
        buttonPanel.add(btnExibirMediaSalarial);
    }

    private void mostrarCamposCliente() {
        inputPanel.removeAll();
        inputPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField(20);
        txtNome.setSize(new Dimension(200, 50));
        txtNome.setMaximumSize(new Dimension(500, 30)); 
        inputPanel.add(txtNome);
        
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        inputPanel.add(new JLabel("Email:"));
        txtEmail = new JTextField(20); 
        txtEmail.setMaximumSize(new Dimension(500, 30));
        inputPanel.add(txtEmail);
        
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> adicionarCliente());
        inputPanel.add(btnAdicionar);
        inputPanel.revalidate();
        inputPanel.repaint();
        cardLayout.show(inputPanel.getParent(), "InputPanel");
    }

    // Método para adicionar cliente
    private void adicionarCliente() {
        String nome = txtNome.getText();
        String email = txtEmail.getText();

        if (nome != null && email != null && !nome.trim().isEmpty() && !email.trim().isEmpty()) {
            Cliente cli = new Cliente(nome, email);
            empresa.adicionarCliente(cli);
            mostrarInformacao("Cliente " + nome + " adicionado com sucesso!");
            txtNome.setText("");
            txtEmail.setText(""); 
        } else {
            mostrarInformacao("Nome ou email inválido!");
        }
    }

    private void mostrarCamposFuncionario() {
        inputPanel.removeAll();
        inputPanel.add(new JLabel("Nome:"));
        txtNome = new JTextField(20); 
        txtNome.setMaximumSize(new Dimension(500, 30)); 
        inputPanel.add(txtNome);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        inputPanel.add(new JLabel("Cargo:"));
        txtCargo = new JTextField(20); 
        txtCargo.setMaximumSize(new Dimension(500, 30));
        inputPanel.add(txtCargo);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        inputPanel.add(new JLabel("Salário:"));
        txtSalario = new JTextField(20); 
        txtSalario.setMaximumSize(new Dimension(500, 30)); 
        inputPanel.add(txtSalario);
        inputPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        JButton btnAdicionar = new JButton("Adicionar");
        btnAdicionar.addActionListener(e -> adicionarFuncionario());
        inputPanel.add(btnAdicionar);
        inputPanel.revalidate();
        inputPanel.repaint();
        cardLayout.show(inputPanel.getParent(), "InputPanel"); 
    }

    // Método para adicionar funcionário
    private void adicionarFuncionario() {
        String nome = txtNome.getText();
        String cargo = txtCargo.getText();
        String salarioStr = txtSalario.getText();

        if (nome != null && cargo != null && salarioStr != null && !nome.trim().isEmpty() && !cargo.trim().isEmpty()) {
            try {
                double salario = Double.parseDouble(salarioStr);
                Funcionario fun = new Funcionario(nome, cargo, salario);
                empresa.adicionarFuncionario(fun);
                mostrarInformacao("Funcionário " + nome + " adicionado com sucesso!");
                txtNome.setText("");
                txtCargo.setText("");
                txtSalario.setText("");
            } catch (NumberFormatException ex) {
                mostrarInformacao("Salário inválido!");
            }
        } else {
            mostrarInformacao("Nome, cargo ou salário inválido!");
        }
    }

    // Método para mostrar informações
    private void mostrarInformacao(String mensagem) {
        displayPanel.removeAll();
        displayPanel.add(new JLabel("<html><p style='width:200px'>" + mensagem + "</p></html>"));
        displayPanel.revalidate();
        displayPanel.repaint();
        cardLayout.show(displayPanel.getParent(), "DisplayPanel");
    }

    // Método para esconder campos de entrada
    private void esconderCampos() {
        inputPanel.removeAll();
        inputPanel.revalidate();
        inputPanel.repaint();
    }
}
