package views;


import javax.swing.JOptionPane;

import models.Currency;


public class Launcher {

	final static Currency dolar = new Currency(0.27, "$", "Dólares");
	static Currency euro = new Currency(0.25, "€", "Euros");
	static Currency libra = new Currency(0.21, "£", "Libras");
	static Currency won = new Currency(39.32, "₩", "Won Coreano");
	static Currency yen = new Currency(361.01, "¥", "Yens");


	final static Currency[] currencies = new Currency[] { dolar,euro,libra,won,yen};


	final static String[] currencyOptions = { "De Soles a Dólar", "De Soles a Euro", "De Soles a Libras",
			"De Soles a Yen", "De soles a Won Coreano", "De Dólar a Soles", "De Euro a Soles", "De Libras a Soles",
			"De Yen a Soles", "De Won Coreano a Soles" };

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
				handleCurrencyConversion();
				break;
			case "Conversion de Temperatura":
				JOptionPane.showMessageDialog(null, "En desarrollo...");
				break;

			}
		}else {
			exitProgram();
		}
	}

	/**
	 * Componente para crear una alerta con opciones
	 * @param message cuerpo del componente
	 * @param title titulo del componente
	 * @param options String[] opciones que se enviara para rellenar el componente
	 * @return retorna el componente
	 */
	static String showOptionsDialog(String message, String title, String[] options) {
		return (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, options,
				null);
	}


/**
 * Inicia un componente JOptionPane con las opciones de la moneda
 */
	static void handleCurrencyConversion() {
		String optionCurrency = showOptionsDialog("Elija la moneda a que deseas convertir tu dinero", null,
				currencyOptions);
		if (optionCurrency != null) {
			try {
				convertCurrency(optionCurrency);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else {
			exitProgram();
		}
	}

	/**
	 * Funcion para convertir el dato ingresao
	 * @param currencyOption tipo String que es la opcion que se escogio en el tipo de moneda
	 */
	static void convertCurrency(String currencyOption) {
		String optinSelected = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");

		Double currentCurrency = (double) 0;
		try {
			currentCurrency = Double.valueOf(optinSelected);
			String message = "";
			Double valueConverted = (double) 0;

			/**A partir de que ocpion se escoja se hara la conversion**/
			/*De Soles a Euros*/
			if (currencyOption.equals(currencyOptions[0])) {
				valueConverted =  dolar.multiplyCoin(currentCurrency);
				message = dolar.messageConverted(valueConverted);
			}
			//De Soles a Euros
			if (currencyOption.equals(currencyOptions[1])) {
				valueConverted =  euro.multiplyCoin(currentCurrency);
				message = euro.messageConverted(valueConverted);
			}
			// De Soles a Libras
			if (currencyOption.equals(currencyOptions[2])) {
				valueConverted =  libra.multiplyCoin(currentCurrency);
				message = libra.messageConverted(valueConverted);
			}
			//De Soles a Won
			if (currencyOption.equals(currencyOptions[3])) {
				valueConverted = won.multiplyCoin(currentCurrency);
				message = won.messageConverted(valueConverted);
			}
			//De soles a Yen
			if (currencyOption.equals(currencyOptions[4])) {
				valueConverted =  dolar.multiplyCoin(currentCurrency);
				message = dolar.messageConverted(valueConverted);
			}
			//De Dolares a Soles
			if (currencyOption.equals(currencyOptions[5])) {
				valueConverted =  dolar.divideCoin(currentCurrency);
				message = dolar.messageConvertedToSoles(valueConverted);

			}
			//De Euro a Soles
			if (currencyOption.equals(currencyOptions[6])) {
				valueConverted =  euro.divideCoin(currentCurrency);
				message = euro.messageConvertedToSoles(valueConverted);

			}
			//De Libras a Soles
			if (currencyOption.equals(currencyOptions[7])) {
				valueConverted =  libra.divideCoin(currentCurrency);
				message = libra.messageConvertedToSoles(valueConverted);
			}
			//De Won a Soles

			if (currencyOption.equals(currencyOptions[8])) {
				valueConverted =  won.divideCoin(currentCurrency);
				message = won.messageConvertedToSoles(valueConverted);
			}
			//De Yen a Soles
			if (currencyOption.equals(currencyOptions[9])) {
				valueConverted =  yen.divideCoin(currentCurrency);
				message = yen.messageConvertedToSoles(valueConverted);
			}

			JOptionPane.showMessageDialog(null, message);

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor no válido");
		} finally {
			int canContinue = JOptionPane.showConfirmDialog(null, "Deseas continuar?");
			if (canContinue == 0) {
				initLauncher();
			} else {
				exitProgram();
			}
		}

	}

	public static  void exitProgram() {
		JOptionPane.showMessageDialog(null, "Programa terminado");
		System.exit(1);
	}

	public static void main(String[] args) {
		initLauncher();

	}
}
