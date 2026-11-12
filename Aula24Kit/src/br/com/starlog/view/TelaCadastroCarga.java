package br.com.starlog.view;

import br.com.starlog.controller.CargaController;

import javax.swing.*;
import java.awt.*;


public class TelaCadastroCarga extends JFrame {

    private final JTextField txtCodigo;
    private final JComboBox<String> cbCategoria;
    private final JTextField txtPeso;
    private final JTextField txtValor;
    private final JTextArea areaRelatorio;
    private final JButton btnCadastrar;
    private final JButton btnLimpar;

    
    private final CargaController controller;

    public TelaCadastroCarga(CargaController controller) {
        super("StarLog Logistics - Sistema de Despacho Operacional");
        this.controller = controller;

       
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650, 480);
        this.setLocationRelativeTo(null); // Centraliza na tela
        this.setLayout(new BorderLayout(10, 10));

        JPanel painelCabecalho = new JPanel();
        painelCabecalho.setBackground(new Color(24, 43, 73));
        JLabel lblTitulo = new JLabel("PAINEL DE CONTROLE DE CARGAS • STARLOG-ZERO");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("SansSerif", Font.BOLD, 15));
        painelCabecalho.add(lblTitulo);
        this.add(painelCabecalho, BorderLayout.NORTH);

        
        JPanel painelFormulario = new JPanel(new GridLayout(4, 2, 8, 8));
        painelFormulario.setBorder(BorderFactory.createEmptyBorder(15, 20, 10, 20));

        painelFormulario.add(new JLabel("Código de Rastreio (ex: CARG-01):"));
        txtCodigo = new JTextField();
        painelFormulario.add(txtCodigo);

        painelFormulario.add(new JLabel("Categoria da Carga:"));
        cbCategoria = new JComboBox<>(new String[]{"GERAL", "PERIGOSA", "ALIMENTAR", "TECNOLOGICA"});
        painelFormulario.add(cbCategoria);

        painelFormulario.add(new JLabel("Peso da Carga (kg):"));
        txtPeso = new JTextField();
        painelFormulario.add(txtPeso);

        painelFormulario.add(new JLabel("Valor Declarado (R$):"));
        txtValor = new JTextField();
        painelFormulario.add(txtValor);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 15, 10));
        btnLimpar = new JButton("Limpar Campos");
        btnCadastrar = new JButton("Cadastrar no Sistema");
        btnCadastrar.setBackground(new Color(40, 167, 69));
        btnCadastrar.setForeground(Color.WHITE);
        btnCadastrar.setFont(new Font("SansSerif", Font.BOLD, 12));

        painelBotoes.add(btnLimpar);
        painelBotoes.add(btnCadastrar);

        JPanel painelCentralAgrupado = new JPanel(new BorderLayout(5, 5));
        painelCentralAgrupado.add(painelFormulario, BorderLayout.NORTH);

        areaRelatorio = new JTextArea();
        areaRelatorio.setEditable(false);
        areaRelatorio.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scroll = new JScrollPane(areaRelatorio);
        scroll.setBorder(BorderFactory.createTitledBorder("Cargas Registradas na Memória da Estação:"));
        painelCentralAgrupado.add(scroll, BorderLayout.CENTER);

        this.add(painelCentralAgrupado, BorderLayout.CENTER);
        this.add(painelBotoes, BorderLayout.SOUTH);

        configurarEventos();
    }

    private void configurarEventos() {
        btnLimpar.addActionListener(e -> limparCampos());

        btnCadastrar.addActionListener(e -> {
            String codigo = txtCodigo.getText();
            String categoria = (String) cbCategoria.getSelectedItem();
            String pesoStr = txtPeso.getText();
            String valorStr = txtValor.getText();

           
            controller.cadastrarCarga(codigo, categoria, pesoStr, valorStr, this);
        });
    }

    public void exibirMensagemSucesso(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        limparCampos();
    }

    public void exibirMensagemErro(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Erro de Validação", JOptionPane.ERROR_MESSAGE);
    }

    public void atualizarRelatorio(String textoCompleto) {
        this.areaRelatorio.setText(textoCompleto);
    }

    private void limparCampos() {
        txtCodigo.setText("");
        txtPeso.setText("");
        txtValor.setText("");
        cbCategoria.setSelectedIndex(0);
        txtCodigo.requestFocus();
    }
}
