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
public class BotonRaizOInversaActionListener implements ActionListener{

    private static final int SQRT_VALUE = 2;
    private Ventana ventana;
    
    public BotonRaizOInversaActionListener(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
               
        String datoEntrada = ventana.leerDatosDeEntrada();
        
        try
        {
            double datoEntradaDouble = Double.parseDouble(datoEntrada);
            double resulRaiz = Math.sqrt(datoEntradaDouble);
            double resulInversa = datoEntradaDouble / SQRT_VALUE;
            if (ventana.getCheckBoxRaizOInversa().isSelected()) {
                ventana.escribirDatosDeSalida(String.format("[INFO] La inversa "
                        + "de %s es %s", datoEntrada, resulInversa));
            } else {
                ventana.escribirDatosDeSalida(String.format(""
                        + "[INFO] La raíz cuadrada de %s es %s", 
                        datoEntrada, resulRaiz));
            } 
        } 
        catch (NumberFormatException ex) 
        {
            JOptionPane.showMessageDialog(ventana,
              "No se puede calcular la raíz o la inversa del valor recibido: "
                + "Se espera un valor entero", "Error",
               JOptionPane.ERROR_MESSAGE);
                ventana.escribirDatosDeSalida(
                String.format("[ERROR] Se produjo un error al calcular "
                + "la raíz o inversa de %s", datoEntrada));
                ventana.establecerFocoEnDatosDeEntrada();
	}
    }
    
}
