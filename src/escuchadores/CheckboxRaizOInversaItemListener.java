package escuchadores;


import interfaz.Ventana;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Javi
 */
public class CheckboxRaizOInversaItemListener implements ItemListener {

    private Ventana ventana;

    public CheckboxRaizOInversaItemListener(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        if (e.getStateChange() == ItemEvent.SELECTED) {
            JOptionPane.showMessageDialog(ventana, "Se calculará la inversa.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
        } else{
            JOptionPane.showMessageDialog(ventana, "Se calculará la raíz cuadrada.", "Información",
					JOptionPane.INFORMATION_MESSAGE);
        }
    }    
}
