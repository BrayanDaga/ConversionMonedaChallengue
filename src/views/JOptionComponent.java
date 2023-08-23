package views;

import javax.swing.JOptionPane;

public abstract class JOptionComponent {
	
	public static String showOptionsDialog(String message, String title, String[] options) {
		return (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, options,
				null);
	}
	
	public static  void exitProgram() {
		JOptionPane.showMessageDialog(null, "Programa terminado");
		System.exit(1);
	}

}
