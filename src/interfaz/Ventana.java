package interfaz;

import escuchadores.CalcularTrigoButtonActionListener;
import escuchadores.CalcularCambioBaseActionListener;
import static com.sun.glass.ui.Cursor.setVisible;
import escuchadores.BotonElevarAlCuadradoActionListener;
import escuchadores.BotonFactorialActionListener;
import escuchadores.BotonRaizOInversaActionListener;
import escuchadores.CheckboxRaizOInversaItemListener;
import escuchadores.RadioButtonGradosItemListener;
import escuchadores.RadioButtonRadianesItemListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.Border;
import javax.swing.border.TitledBorder;

/**
 *
 * @author Javi
 */
public class Ventana extends JFrame {
    
	private static final long serialVersionUID = 1L;
	private final String TITULO = "Trabajando con eventos";

	// Seccion de declaración
	private JPanel panelEntrada;
	private JLabel etiquetaEntrada;
	private JTextField cajaTextoEntrada;

	private JPanel panelSalida;
	private JScrollPane panelScrollSalida;
	private JTextArea cajaTextoSalida;

	private JPanel panelComponentes;
	private JButton botonElevarAlCuadrado;
        
        private JPanel panelExtensionUno;
        private TitledBorder borderExtensionUno;
        private JButton botonFactorial;
        
        private JPanel panelExtensionDos;
        private TitledBorder borderExtensionDos;
        private JButton botonRaizOInversa;
        private JCheckBox checkBoxRaizOInversa;
        
        private JPanel panelExtensionTres;
        private TitledBorder borderExtensionTres;
        private JRadioButton radioButtonGrados;
        private JLabel radioLabelGrados;
        private JRadioButton radioButtonRadianes;
        private JLabel radioLabelRadianes;
        private JComboBox comboBoxTrigo;
        private JButton calcularTrigoButton;
        
        private JPanel panelExtensionCuatro;
        private TitledBorder borderExtensionCuatro;
        private JLabel labelBaseOrigen;
        private JSpinner spinnerBaseOrigen;
        private JLabel labelBaseACalcular;
        private JSpinner spinnerBaseACalcular;
        private JButton calcularBaseButton;

	public Ventana() {
		setTitle(TITULO);
		inicializarComponentes();
		registrarEscuchadores();
		pack();
		setVisible(true);;
                setResizable(false);
	}

	private void inicializarComponentes() {

		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));

		panelEntrada = new JPanel();
		panelEntrada.setLayout(new FlowLayout(FlowLayout.CENTER));
		etiquetaEntrada = new JLabel("Entrada de datos:");
		cajaTextoEntrada = new JTextField();
		cajaTextoEntrada.setColumns(15);
		panelEntrada.add(etiquetaEntrada);
		panelEntrada.add(cajaTextoEntrada);

		panelSalida = new JPanel();
		panelSalida.setLayout(new BorderLayout(0, 0));
		panelScrollSalida = new JScrollPane();
		panelSalida.add(panelScrollSalida);
		cajaTextoSalida = new JTextArea(20, 5);
		cajaTextoSalida.setEditable(false);
		panelScrollSalida.setViewportView(cajaTextoSalida);

		panelComponentes = new JPanel();
		panelComponentes.setLayout(new FlowLayout(FlowLayout.CENTER));
		botonElevarAlCuadrado = new JButton("x²");
		panelComponentes.add(botonElevarAlCuadrado);
                
                //Extensión 1
                panelExtensionUno = new JPanel();
                panelExtensionUno.setLayout(new FlowLayout(FlowLayout.CENTER));
                borderExtensionUno = BorderFactory.createTitledBorder("Extensión 1");
                panelExtensionUno.setBorder(borderExtensionUno);
                botonFactorial = new JButton("x!");
                panelExtensionUno.add(botonFactorial);
                
                //Extensión 2
                panelExtensionDos = new JPanel();
                panelExtensionDos.setLayout(new FlowLayout(FlowLayout.CENTER));
                borderExtensionDos = BorderFactory.createTitledBorder("Extensión 2");
                panelExtensionDos.setBorder(borderExtensionDos);
                botonRaizOInversa= new JButton("√ ó 1/x");
                checkBoxRaizOInversa = new JCheckBox();
                panelExtensionDos.add(checkBoxRaizOInversa);
                panelExtensionDos.add(botonRaizOInversa);
                
                //Extensión 3
                panelExtensionTres = new JPanel();
                panelExtensionTres.setLayout(new FlowLayout(FlowLayout.CENTER));
                borderExtensionTres = BorderFactory.createTitledBorder("Extensión 3");
                panelExtensionTres.setBorder(borderExtensionTres);
                radioButtonGrados = new JRadioButton();
                radioLabelGrados = new JLabel("grados");
                radioButtonRadianes = new JRadioButton();
                radioLabelRadianes = new JLabel("radianes");
                String[] trigoValues = {"sin", "cos", "tan"}; //TODO: Set as enumeration type
                comboBoxTrigo = new JComboBox(trigoValues);
                calcularTrigoButton = new JButton("Calcular");
                panelExtensionTres.add(radioButtonGrados);
                panelExtensionTres.add(radioLabelGrados);
                panelExtensionTres.add(radioButtonRadianes);
                panelExtensionTres.add(radioLabelRadianes);
                panelExtensionTres.add(comboBoxTrigo);
                panelExtensionTres.add(calcularTrigoButton);
                
                //Extensión 4
                panelExtensionCuatro = new JPanel();
                panelExtensionTres.setLayout(new FlowLayout(FlowLayout.CENTER));
                borderExtensionCuatro = BorderFactory.createTitledBorder("Extensón 4");
                panelExtensionCuatro.setBorder(borderExtensionCuatro);
                labelBaseOrigen = new JLabel("De base");
                spinnerBaseOrigen = new JSpinner();
                spinnerBaseOrigen.setPreferredSize(new Dimension(50, 20));
                labelBaseACalcular = new JLabel("a base");
                spinnerBaseACalcular = new JSpinner();
                spinnerBaseACalcular.setPreferredSize(new Dimension(50, 20));
                calcularBaseButton = new JButton("Calcular");
                panelExtensionCuatro.add(labelBaseOrigen);
                panelExtensionCuatro.add(spinnerBaseOrigen);
                panelExtensionCuatro.add(labelBaseACalcular);
                panelExtensionCuatro.add(spinnerBaseACalcular);
                panelExtensionCuatro.add(calcularBaseButton);

		getContentPane().add(panelEntrada);
		getContentPane().add(panelComponentes);
                getContentPane().add(panelExtensionUno);
                getContentPane().add(panelExtensionDos);
                getContentPane().add(panelExtensionTres);
                getContentPane().add(panelExtensionCuatro);
		getContentPane().add(panelSalida);
                
		// propiedades generales
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(640, 480));

	}

	private void registrarEscuchadores() {
		
            botonElevarAlCuadrado.addActionListener(new BotonElevarAlCuadradoActionListener(this));
            botonFactorial.addActionListener(new BotonFactorialActionListener(this));
            checkBoxRaizOInversa.addItemListener(new CheckboxRaizOInversaItemListener(this));
            botonRaizOInversa.addActionListener(new BotonRaizOInversaActionListener(this));               
            radioButtonGrados.addItemListener(new RadioButtonGradosItemListener(this));
            radioButtonRadianes.addItemListener(new RadioButtonRadianesItemListener(this));
            calcularTrigoButton.addActionListener(new CalcularTrigoButtonActionListener(this));
            calcularBaseButton.addActionListener(new CalcularCambioBaseActionListener(this));                 
            
	} 

	/*
	 * Métodos para la lectura y escritura de datos
	 */

	public String leerDatosDeEntrada() {
		return cajaTextoEntrada.getText();
	}

	public void escribirDatosDeSalida(String texto) {
		String formato = "hh:mm:ss a";
		DateFormat dateFormat = new SimpleDateFormat(formato);
		String tiempo = dateFormat.format(new GregorianCalendar().getTime());
		cajaTextoSalida.append(tiempo + " :: " + texto + "\n");
	}

	/*
	 * Otros metodos de interes
	 */

	public void establecerFocoEnDatosDeEntrada() {
		cajaTextoEntrada.requestFocus();
	}

    //Métodos accesores para acceder al comportamiento de algunos controles
    public JRadioButton getRadioButtonRadianes() {
        return radioButtonRadianes;
    }

    public void setRadioButtonRadianes(JRadioButton radioButtonRadianes) {
        this.radioButtonRadianes = radioButtonRadianes;
    }    

    public JRadioButton getRadioButtonGrados() {
        return radioButtonGrados;
    }

    public void setRadioButtonGrados(JRadioButton radioButtonGrados) {
        this.radioButtonGrados = radioButtonGrados;
    } 

    public JCheckBox getCheckBoxRaizOInversa() {
        return checkBoxRaizOInversa;
    }  

    public JComboBox getComboBoxTrigo() {
        return comboBoxTrigo;
    }

    public JSpinner getSpinnerBaseOrigen() {
        return spinnerBaseOrigen;
    }

    public JSpinner getSpinnerBaseACalcular() {
        return spinnerBaseACalcular;
    }   
    
}
