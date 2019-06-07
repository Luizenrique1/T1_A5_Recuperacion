import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Calculadora extends JFrame{
	GridBagConstraints configuracion = new GridBagConstraints();
	GridBagLayout gbl = new GridBagLayout();
	JPanel botones = new JPanel(gbl);
	
	double valor1=0;
	double valor2=0;
	boolean limpio = true;
	String operacion = "";
	
	public Calculadora() {
		componentes();
	}
	
	public void componentes() {
		getContentPane().setLayout(gbl);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Calculadora");
		setSize(335, 543);
		setLocationRelativeTo(null);
		setVisible(true);
		
		JButton bt0 = new JButton("0");
		JButton bt1 = new JButton("1");
		JButton bt2 = new JButton("2");
		JButton bt3 = new JButton("3");
		JButton bt4 = new JButton("4");
		JButton bt5 = new JButton("5");
		JButton bt6 = new JButton("6");
		JButton bt7 = new JButton("7");
		JButton bt8 = new JButton("8");
		JButton bt9 = new JButton("9");
		JButton btX = new JButton("X");
		JButton btDiv = new JButton("÷");
		JButton btMasMen = new JButton("±");
		JButton btPunt = new JButton(".");
		JButton btIgu = new JButton("=");
		JButton btMas = new JButton("+");
		JButton btMen = new JButton("-");
		JButton btPorciento = new JButton("%");
		JButton btRaiz = new JButton("√");
		JButton btX2 = new JButton("x²");
		JButton bt1X = new JButton("1/x");
		JButton btCE = new JButton("CE");
		JButton btC = new JButton("C");
		JButton btBorrar = new JButton("<<");
		
		
		JPanel menu = new JPanel(gbl);
		menu.setBackground(Color.LIGHT_GRAY);
		JLabel estandar = new JLabel("  Calculadora Estándar");
		estandar.setFont(new Font("Arial",Font.PLAIN, 22));
		configuracion.gridx = 1;
		configuracion.gridy = 0;
		configuracion.gridwidth = 1;
		configuracion.gridheight = 1;
		configuracion.fill = 1;
		configuracion.weighty = 1;
		configuracion.weightx = 5;
		gbl.setConstraints(estandar, configuracion);
		menu.add(estandar);

		JPanel texto = new JPanel(gbl);
		texto.setBackground(Color.LIGHT_GRAY);
		JTextField escritura = new JTextField();
		escritura.setHorizontalAlignment(SwingConstants.RIGHT);
		escritura.setFont(new Font("Calibri", 1, 60));
		configuracion.weighty = 1;
		configuracion.weightx = 1;
		gbl.setConstraints(escritura, configuracion);
		texto.add(escritura);
		
		JPanel barra = new JPanel(gbl);
		barra.setFont(new Font("Calibri", 1, 50));
		barra.setBackground(Color.LIGHT_GRAY);
		configuracion.weighty = 1;
		configuracion.weightx = 1;
		
		barra.add(new JLabel("      MC      "));
		barra.add(new JLabel("      MR      "));
		barra.add(new JLabel("      M+      "));
		barra.add(new JLabel("      M-      "));
		barra.add(new JLabel("      MS      "));
		barra.add(new JLabel("      Mv      "));

		metodoAcomodarBotones(btPorciento, 0, 0, 1, 1, 1);
		metodoAcomodarBotones(btRaiz, 1, 0, 1, 1, 1);
		metodoAcomodarBotones(btX2, 2, 0, 1, 1, 1);
		metodoAcomodarBotones(bt1X, 3, 0, 1, 1, 1);
		metodoAcomodarBotones(btCE, 0, 1, 1, 1, 1);
		metodoAcomodarBotones(bt7, 0, 2, 1, 1, 1);
		metodoAcomodarBotones(bt4, 0, 3, 1, 1, 1);
		metodoAcomodarBotones(bt1, 0, 4, 1, 1, 1);
		metodoAcomodarBotones(btMasMen, 0, 5, 1, 1, 1);
		metodoAcomodarBotones(btC, 1, 1, 1, 1, 1);
		metodoAcomodarBotones(bt8, 1, 2, 1, 1, 1);
		metodoAcomodarBotones(bt5, 1, 3, 1, 1, 1);
		metodoAcomodarBotones(bt2, 1, 4, 1, 1, 1);
		metodoAcomodarBotones(bt0, 1, 5, 1, 1, 1);
		metodoAcomodarBotones(btBorrar, 2, 1, 1, 1, 1);
		metodoAcomodarBotones(bt9, 2, 2, 1, 1, 1);
		metodoAcomodarBotones(bt6, 2, 3, 1, 1, 1);
		metodoAcomodarBotones(bt3, 2, 4, 1, 1, 1);
		metodoAcomodarBotones(btPunt, 2, 5, 1, 1, 1);
		metodoAcomodarBotones(btDiv, 3, 1, 1, 1, 1);
		metodoAcomodarBotones(btX, 3, 2, 1, 1, 1);
		metodoAcomodarBotones(btMen, 3, 3, 1, 1, 1);
		metodoAcomodarBotones(btMas, 3, 4, 1, 1, 1);
		metodoAcomodarBotones(btIgu, 3, 5, 1, 1, 1);
		
		
		
		
		configuracion.weighty = 0.9;
		configuracion.weightx = 1;
		metodoMagicoQueAcomodaComponentes(menu, 0, 0, 1, 1, 1);
		configuracion.weighty = 2.5;
		metodoMagicoQueAcomodaComponentes(texto, 0, 1, 1, 1, 1);
		configuracion.weighty = 1;
		metodoMagicoQueAcomodaComponentes(barra, 0, 2, 1, 1, 1);
		configuracion.weighty = 4.5;
		metodoMagicoQueAcomodaComponentes(botones, 0, 3, 1, 1, 1);
		
		//Listeners============
		
		bt0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"0");
			}
		});
		bt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"1");
			}
		});
		bt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"2");
			}
		});
		bt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"3");
			}
		});
		bt4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"4");
			}
		});
		bt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"5");
			}
		});
		bt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"6");
			}
		});
		bt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"7");
			}
		});
		bt8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"8");
			}
		});
		bt9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+"9");
			}
		});
		btC.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText("");
				valor1=0;
				valor2=0;
			}
		});
		btCE.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText("");
				valor1=0;
				valor2=0;
			}
		});
		btPunt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				escritura.setText(escritura.getText()+".");
			}
		});
		btBorrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(escritura.getText().length() != 0) {
					escritura.setText(escritura.getText().substring(0, escritura.getText().length()-1));
				}
			}
		});
		btMasMen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(escritura.getText().substring(0, 1).equalsIgnoreCase("-")) {
					escritura.setText(escritura.getText().substring(1, escritura.getText().length()));
				}else {
					escritura.setText("-"+escritura.getText());
				}
			}
		});
		btMen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(limpio) {
				valor1 = Double.parseDouble(escritura.getText());
				escritura.setText("");
				limpio = false;
				operacion="-";
				}else {
					valor2 = Double.parseDouble(escritura.getText());
					valor1 = valor1-valor2;
					escritura.setText("");
					operacion="-";
					limpio = true;
				}
			}
		});
		btMas.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(limpio) {
				valor1 = Double.parseDouble(escritura.getText());
				escritura.setText("");
				limpio = false;
				operacion="+";
				}else {
					valor2 = Double.parseDouble(escritura.getText());
					valor1 = valor1+valor2;
					escritura.setText("");
					operacion="+";
					limpio = true;
				}
			}
		});
		btX.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(limpio) {
				valor1 = Double.parseDouble(escritura.getText());
				escritura.setText("");
				limpio = false;
				operacion="*";
				}else {
					valor2 = Double.parseDouble(escritura.getText());
					valor1 = valor1*valor2;
					escritura.setText("");
					operacion="*";
					limpio = true;
				}
			}
		});
		btDiv.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(limpio) {
				valor1 = Double.parseDouble(escritura.getText());
				escritura.setText("");
				limpio = false;
				operacion="/";
				}else {
					valor2 = Double.parseDouble(escritura.getText());
					valor1 = valor1/valor2;
					escritura.setText("");
					operacion="/";
					limpio = true;
				}
			}
		});
		btRaiz.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!escritura.getText().isEmpty()) {
					valor1 = Double.parseDouble(escritura.getText());
					escritura.setText(Math.sqrt(valor1)+"");
				}
				valor1=0;
			}
		});
		btX2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!escritura.getText().isEmpty()) {
					valor1 = Double.parseDouble(escritura.getText());
					escritura.setText((valor1*valor1)+"");
				}
				valor1=0;
			}
		});
		bt1X.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!escritura.getText().isEmpty()) {
					valor1 = Double.parseDouble(escritura.getText());
					escritura.setText((1/valor1)+"");
				}
				valor1=0;
			}
		});
		
		
		
		
		
		btIgu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(operacion.equals("-")) {
					valor2=Double.parseDouble(escritura.getText());
					escritura.setText((valor1-valor2)+"");
				}else if(operacion.equals("+")) {
					valor2=Double.parseDouble(escritura.getText());
					escritura.setText((valor1+valor2)+"");
				}else if(operacion.equals("*")) {
					valor2=Double.parseDouble(escritura.getText());
					escritura.setText((valor1*valor2)+"");
				}else if(operacion.equals("/")) {
					valor2=Double.parseDouble(escritura.getText());
					escritura.setText((valor1/valor2)+"");
				}
				
				limpio = true;
			}
		});
		
		
	}
	
	public void metodoMagicoQueAcomodaComponentes(JComponent componente, int gx, int gy, int gw, int gh, int f) {
		configuracion.gridx = gx;
		configuracion.gridy = gy;
		configuracion.gridwidth = gw;
		configuracion.gridheight = gh;
		configuracion.fill = f;
		
		gbl.setConstraints(componente, configuracion);
		add(componente);
	}
	
	public void metodoAcomodarBotones(JComponent com, int gx, int gy, int gw, int gh, int f) {
		configuracion.gridx = gx;
		configuracion.gridy = gy;
		configuracion.gridwidth = gw;
		configuracion.gridheight = gh;
		configuracion.fill = f;
		gbl.setConstraints(com, configuracion);
		botones.add(com);
	}
	

	
	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new Calculadora();
			}
		});

	}

}
