import javax.swing.*;
import java.awt.*;

class VentanaInicio extends JFrame{
	GridBagConstraints gbc = new GridBagConstraints();
	GridBagLayout gbl= new GridBagLayout();
	String[] encuesta= new String[10];

	public void llenadoArray() {

		for (int i=0; i< encuesta.length; i++) {
			double num=(double) Math.random();

			if(num<0.6) {
				encuesta[i]="si";
			}else
				encuesta[i]="no";
		}

		for (int i = 0; i < encuesta.length; i++) {
			System.out.print(encuesta[i]+" ");
		}

	}


	public VentanaInicio() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Twitter");
		setSize(300, 300);
		setLocationRelativeTo(null);
		setVisible(true);


		JLabel lbl1 = new JLabel("SI");
		MetodoAcomodo(lbl1, 0, 0, 2, 1);

		JLabel lbl2 = new JLabel("NO");
		MetodoAcomodo(lbl2, 3, 0, 2, 1);

		JLabel lbl3 = new JLabel(" ");
		MetodoAcomodo(lbl3, 2, 1, 1, 3);
		String cadFin="";
		String cad="";
		for (int i = 0; i < encuesta.length; i++) {
			cad=cad+""+ encuesta[i];
			if(cad.equals("si")) {
				cadFin+=cad;
			}
		}
		JTextArea PersonasSi= new JTextArea();
		PersonasSi.setText(cadFin);
		PersonasSi.setLineWrap(true);
		PersonasSi.setWrapStyleWord(true);
		JScrollPane scroll1 = new JScrollPane(PersonasSi);
		PersonasSi.setEditable(false);

		MetodoAcomodo(PersonasSi, 0, 1, 2, 3);

		JTextArea PersonasNo= new JTextArea();
		PersonasNo = new JTextArea();
		PersonasNo.setLineWrap(true);
		PersonasNo.setWrapStyleWord(true);
		JScrollPane scroll = new JScrollPane(PersonasNo);
		PersonasNo.setEditable(false);
		MetodoAcomodo(PersonasNo, 3, 1, 2, 3);



	}//Constructor

	public void MetodoAcomodo(Component n, int gx, int gy, int gw, int gh) {
		gbc.gridx=gx;
		gbc.gridy=gy;
		gbc.gridwidth=gw;
		gbc.gridheight=gh;
		gbl.setConstraints(n, gbc);
		add(n);
		gbc.fill= GridBagConstraints.BOTH;
	}

}//Class VentanaInicio
public class Prueba {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new VentanaInicio();
			}
		});
		VentanaInicio obj1= new VentanaInicio();
		obj1.llenadoArray();

	}

}