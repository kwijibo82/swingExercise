/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package escuchadores;

import interfaz.Ventana;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

/**
 *
 * @author Javi
 */
public class ComboBoxTrigoItemListener implements ItemListener{
    private Ventana ventana;

    public ComboBoxTrigoItemListener(Ventana ventana) {
        this.ventana = ventana;
    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        
    }
    
    
}
