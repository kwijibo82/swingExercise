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
public class CalcularCambioBaseActionListener implements ActionListener {

    private Ventana ventana;

    public CalcularCambioBaseActionListener(Ventana ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
      
       String datoEntrada = ventana.leerDatosDeEntrada();

       String baseOrigen = Integer.toString(Integer.parseInt(datoEntrada),
               Integer.parseInt(ventana.getSpinnerBaseOrigen()
                       .getValue().toString()));

       String baseACalcular = Integer.toString(Integer.parseInt(datoEntrada), 
               Integer.parseInt(ventana.getSpinnerBaseACalcular()
                       .getValue().toString()));
              
       ventana.escribirDatosDeSalida(String.format("(%s) --> de base %s"
               + " a base %s --> (%s)",baseOrigen, 
               ventana.getSpinnerBaseOrigen().getValue().toString(),
               ventana.getSpinnerBaseACalcular().getValue().toString(), 
               baseACalcular));

    }
    
}
