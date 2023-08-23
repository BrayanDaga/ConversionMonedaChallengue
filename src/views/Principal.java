package views;

import javax.swing.JOptionPane;

import models.Currency;

public class Principal extends JOptionComponent{


/*
 * 
 * °F = (°C × 9/5) + 32

 * °C = (°F - 32) × 5/9

 * 
 * */

	final static String[] optionsMain = { "Conversor de Moneda", "Conversion de Temperatura" };

	/**
	 * Toda la logica esta aqui
	 */
	static void initLauncher() {
		/** Inicia un componente JOptionPane con las opciones de que deeas convertir */
		String optionSelMain = showOptionsDialog("Seleccione una opción de conversión", "Menu", optionsMain);

		if (optionSelMain != null) {
			switch (optionSelMain) {
			case "Conversor de Moneda":
				CurrencyView.handleCurrencyConversion();
				break;
			case "Conversion de Temperatura":
				DegreeView.handleCurrencyConversion();
				break;

			}
		}else {
			exitProgram();
		}
	}

	


	public static void main(String[] args) {
		initLauncher();

	}

}
