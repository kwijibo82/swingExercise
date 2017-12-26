/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchadores;

import interfaz.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class CalcularTrigoButton implements ActionListener {

    private Ventana ventana;

    public CalcularTrigoButton(Ventana ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String datoEntrada = ventana.leerDatosDeEntrada();
        double resultGrados = calcularTrigo(Double.parseDouble(datoEntrada));
        
        if (ventana.getRadioButtonGrados().isSelected()) {
            ventana.escribirDatosDeSalida(String.format("[INFO] El valor %s "
                    + "expresado en GRADOS es %s", datoEntrada,
                    Math.toDegrees(resultGrados)));
        }
        else if (ventana.getRadioButtonRadianes().isSelected()) {
            ventana.escribirDatosDeSalida(String.format("[INFO] El valor %s "
                    + "expresado en RADIANES es %s", datoEntrada,
                    Math.toRadians(resultGrados)));           
        }
        else if (!ventana.getRadioButtonGrados().isSelected() &&
                !ventana.getRadioButtonRadianes().isSelected()){
            JOptionPane.showMessageDialog(ventana, 
                    "Debe seleccionarse al menos un valor\nGRADOS | RADIANES", 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    public double calcularTrigo(double value){
        
        double resul = 0;
                
        switch (ventana.getComboBoxTrigo().getSelectedItem().toString())  
        {
            case "sin": 
                resul = Math.sin(value);
                break;
            case "cos":
                resul = Math.cos(value);
                break;  
            case "tan":
                resul = Math.tan(value);
                break;
        }
        
        return resul;
    }
    
}
