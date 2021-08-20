package utp.misiontic2022.c2.p77.reto4.vista;

import java.util.ArrayList;

import utp.misiontic2022.c2.p77.reto4.controlador.ControladorRequerimientos;

import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_1;
import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_2;
import utp.misiontic2022.c2.p77.reto4.modelo.vo.Requerimiento_3;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class VistaRequerimientos extends JFrame {
    public static final ControladorRequerimientos controlador = new ControladorRequerimientos();

    private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea textArea;
	private String resultado = "";
	


	public VistaRequerimientos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(450, 200, 800, 650);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reto 5 - Ciclo 2- UTP");
		lblNewLabel.setBounds(28, 6, 208, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("William López - Grupo 77                                         -------EL HOLDING-------");
		lblNewLabel_1.setBounds(28, 34, 408, 16);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 70, 737, 455);
		contentPane.add(scrollPane);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		
		JButton btnconsulta1 = new JButton("Consulta 1");					// boton - Consulta
		btnconsulta1.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {				
				requerimiento1();							
			}
		});
		btnconsulta1.setBounds(24, 537, 117, 29);
		contentPane.add(btnconsulta1);

        JButton btnconsulta2 = new JButton("Consulta 2");					// boton - Consulta
		btnconsulta2.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {				
				requerimiento2();							
			}
		});
		btnconsulta2.setBounds(157, 537, 117, 29);
		contentPane.add(btnconsulta2);

        JButton btnconsulta3 = new JButton("Consulta 3");					// boton - Consulta
		btnconsulta3.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {				
				requerimiento3();							
			}
		});
		btnconsulta3.setBounds(286, 537, 117, 29);
		contentPane.add(btnconsulta3);

        JButton btnLimpiar = new JButton("Limpiar");					// boton - Consulta
		btnLimpiar.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {				
				textArea.setText("");							
			}
		});
		btnLimpiar.setBounds(648, 537, 117, 29);
		contentPane.add(btnLimpiar);
		
		
	}
	
public void requerimiento1(){    

        try{

            ArrayList<Requerimiento_1> Requerimiento1 = controlador.consultarRequerimiento1();

            //Encabezado del resultado
            resultado = "*** Requirimiento 1 ***	\n\nLider\t\tCargo\t\tProyecto\n\n";
            
            //Cada VO cargado, mostrarlo en la vista
            for (Requerimiento_1 solicitud1 : Requerimiento1) {
                
                resultado +=  solicitud1.getNombre();
                resultado += "             \t";
                resultado +=  solicitud1.getCargo();
                resultado += "\t\t";
                resultado +=  solicitud1.getProyectosN();
                resultado += "\n";
                
            }
            textArea.setText(resultado);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
        

    }

public void requerimiento2(){
	
        try{

        ArrayList<Requerimiento_2> Requerimiento2 = controlador.consultarRequerimiento2();

        //Encabezado del resultado
        resultado = "*** Requirimiento 2 ***	\n\nID_MaterialConstruccion\tNombre_Material\tCantidad\tPrecio_Unidad\t\tPrecio_Total\n\n";
        
        //Cada VO cargado, mostrarlo en la vista
        for (Requerimiento_2 solicitud2 : Requerimiento2) {
            
            resultado +=  solicitud2.getID_MaterialConstruccion();
            resultado += "\t\t";
            resultado +=  solicitud2.getNombreMaterial();
            resultado += "\t\t";
            resultado +=  solicitud2.getCantidad();
            resultado += "\t";
            resultado +=  solicitud2.getPrecioU();
            resultado += "\t\t";
            resultado +=  solicitud2.getPrecioT();
            resultado += "\n";
                
            }
            textArea.setText(resultado);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
        }
    

    }
public void requerimiento3(){     

    try{

        ArrayList<Requerimiento_3> Requerimiento3 = controlador.consultarRequerimiento3();

        //Encabezado del resultado
        resultado = "***Requirimiento 3***	\n\nID_Proyecto\t\tCiudad\t\tClasificacion\t\tCosto_Proyecto\n\n";
        
        //Cada VO cargado, mostrarlo en la vista
        for (Requerimiento_3 solicitud3 : Requerimiento3) {
            
            resultado +=  solicitud3.getID_Proyecto();
            resultado += "\t\t";
            resultado +=  solicitud3.getCiudad();
            resultado += "\t\t";
            resultado +=  solicitud3.getClasificacion();
            resultado += "                     \t";
            resultado +=  solicitud3.getCostoP();
            resultado += "\n";
                
            }
            textArea.setText(resultado);

        }catch(SQLException e){
            System.err.println("Ha ocurrido un error!"+e.getMessage());
    }
    
}
}
