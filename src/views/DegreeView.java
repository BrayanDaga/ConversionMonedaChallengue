package views;

import javax.swing.JOptionPane;

public class DegreeView extends JOptionComponent {

	final static String[] currencyOptions = { "De Celsius a Fahrenheit", "De Fahrenheit a Celsius" };

	static void handleCurrencyConversion() {
		String optionDegree = showOptionsDialog("Elija el grado que deseas convertir ", null, currencyOptions);
		if (optionDegree != null) {
			try {
				convertDegee(optionDegree);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			exitProgram();
		}
	}

	static void convertDegee(String optionDegree) {
		String optinSelected = JOptionPane.showInputDialog("Ingresa la cantidad de grados que deseas convertir:");

		Double currentDegree = (double) 0;
		try {
			currentDegree = Double.valueOf(optinSelected);
			String message = "";
			Double valueConverted = (double) 0;

			if (optionDegree.equals(currencyOptions[0])) {
				double valor =    (  currentDegree *  1.8) + 32; 
				message =  "°F " + valor;
			}
			if (optionDegree.equals(currencyOptions[1])) {
				double valor =    (  currentDegree - 32) + 0.56; 
				message =  "°F " + valor;
			}

			JOptionPane.showMessageDialog(null, message);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor no válido");
		} finally {
			int canContinue = JOptionPane.showConfirmDialog(null, "Deseas continuar?");
			if (canContinue == 0) {
				Principal.initLauncher();
			} else {
				exitProgram();
			}
		}
	}

}
