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
public class BotonFactorialActionListener implements ActionListener {

    private Ventana ventana;

    public BotonFactorialActionListener(Ventana ventana) {
        this.ventana = ventana;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String datoEntrada = ventana.leerDatosDeEntrada();
		
        if (datoEntrada.isEmpty()) 
        {	    	
            JOptionPane.showMessageDialog(ventana, "No hay datos de entrada en la caja de texto", "Información",
					JOptionPane.INFORMATION_MESSAGE);
	} 
        else 
        {

            int datoEntradaEntero = 0;
            try 
            {

		datoEntradaEntero = Integer.parseInt(datoEntrada);
                if (datoEntradaEntero<0) {
                    ventana.escribirDatosDeSalida(String.format("[ERROR] El valor debe ser superior a cero"));
                }
                
                
                //Calculo factorial
                for (int i = datoEntradaEntero - 1; i > 0; i--) {
                    datoEntradaEntero = datoEntradaEntero * i;
                }
                
		ventana.escribirDatosDeSalida(String.format("[INFO] El factorial de %s es %s", datoEntrada,
				datoEntradaEntero));

		} 
                catch (NumberFormatException ex) 
                {
                    JOptionPane.showMessageDialog(ventana,
                    "No se puede calcular el factorial del valor recibido: Se espera un valor entero", "Error",
			JOptionPane.ERROR_MESSAGE);
			ventana.escribirDatosDeSalida(
			String.format("[ERROR] Se produjo un error al calcular el factorial de %s", datoEntrada));
			ventana.establecerFocoEnDatosDeEntrada();
		}

        }
    }
    
}
