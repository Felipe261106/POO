package br.com.starlog.main;

import br.com.starlog.controller.CargaController;
import br.com.starlog.view.TelaCadastroCarga;

import javax.swing.SwingUtilities;


public class MainApp {
    public static void main(String[] args) {
        
            SwingUtilities.invokeLater(() -> {
            
            CargaController controller = new CargaController();

            
            TelaCadastroCarga tela = new TelaCadastroCarga(controller);

            
            tela.setVisible(true);
        });
    }
}
