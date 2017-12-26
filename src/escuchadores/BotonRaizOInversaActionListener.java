/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchadores;

import interfaz.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        double datoEntradaDouble = Double.parseDouble(datoEntrada);
        double resulRaiz = Math.sqrt(datoEntradaDouble);
        double resulInversa = datoEntradaDouble / SQRT_VALUE;
               
        if (ventana.getCheckBoxRaizOInversa().isSelected()) {
            ventana.escribirDatosDeSalida(String.format("[INFO] La inversa de %s es %s",
                    datoEntrada, resulInversa));
        } else {
            ventana.escribirDatosDeSalida(String.format("[INFO] La raíz cuadrada de %s es %s",
                    datoEntrada, resulRaiz));
        }
        
    }
    
}
