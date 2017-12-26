/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchadores;

import interfaz.Ventana;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/**
 *
 * @author Javi
 */
public class RadioButtonGradosItemListener implements ItemListener {

    private Ventana ventana;

    public RadioButtonGradosItemListener(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
       
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(ventana, "Se realizarán los cálculos"
                    + " en grados", "Información",
					JOptionPane.INFORMATION_MESSAGE);
            ventana.getRadioButtonRadianes().setSelected(false);
        } 
    }
    
}
