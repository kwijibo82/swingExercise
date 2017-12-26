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
public class BotonElevarAlCuadradoActionListener implements ActionListener{
    
	private Ventana ventana;

	/**
	 * Contructora del escuchador
	 * 
	 * @param ventana
	 */
	public BotonElevarAlCuadradoActionListener(Ventana ventana) {
		this.ventana = ventana;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String datoEntrada = ventana.leerDatosDeEntrada();
		if (datoEntrada.isEmpty()) {
			JOptionPane.showMessageDialog(ventana, "No hay datos de"
                                + " entrada en la caja de texto", "Información",
					JOptionPane.INFORMATION_MESSAGE);
		} else {

			int datoEntradaEntero = 0;
			try {
				datoEntradaEntero = Integer.parseInt(datoEntrada);
				ventana.escribirDatosDeSalida(String.format("[INFO] El cuadrado de %s es %s", datoEntrada,
						datoEntradaEntero * datoEntradaEntero));

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(ventana,
						"No se puede elevar al cuadrado el valor recibido: Se espera un valor entero", "Error",
						JOptionPane.ERROR_MESSAGE);
				ventana.escribirDatosDeSalida(
						String.format("[ERROR] Se produjo un error al calcular el cuadrado del valor %s", datoEntrada));
				ventana.establecerFocoEnDatosDeEntrada();
			}

		}

	}

    
}
