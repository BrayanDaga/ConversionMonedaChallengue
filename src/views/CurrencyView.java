package views;

import javax.swing.JOptionPane;

import models.Currency;

public class CurrencyView extends JOptionComponent {

	final static Currency dolar = new Currency(0.27, "$", "Dólares");
	static Currency euro = new Currency(0.25, "€", "Euros");
	static Currency libra = new Currency(0.21, "£", "Libras");
	static Currency won = new Currency(39.32, "₩", "Won Coreano");
	static Currency yen = new Currency(361.01, "¥", "Yens");

	final static String[] currencyOptions = { "De Soles a Dólar", "De Soles a Euro", "De Soles a Libras",
			"De Soles a Yen", "De soles a Won Coreano", "De Dólar a Soles", "De Euro a Soles", "De Libras a Soles",
			"De Yen a Soles", "De Won Coreano a Soles" };

	static void handleCurrencyConversion() {
		String optionCurrency = showOptionsDialog("Elija la moneda a que deseas convertir tu dinero",
				null, currencyOptions);
		if (optionCurrency != null) {
			try {
				convertCurrency(optionCurrency);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {

			exitProgram();
		}
	}

	static void convertCurrency(String currencyOption) {
		String optinSelected = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");

		Double currentCurrency = (double) 0;
		try {
			currentCurrency = Double.valueOf(optinSelected);
			String message = "";
			Double valueConverted = (double) 0;

			/** A partir de que ocpion se escoja se hara la conversion **/
			/* De Soles a Euros */
			if (currencyOption.equals(currencyOptions[0])) {
				message = obtenerResultado(currentCurrency, dolar, false);
			}
			// De Soles a Euros
			if (currencyOption.equals(currencyOptions[1])) {

				message = obtenerResultado(currentCurrency, euro, false);
			}
			// De Soles a Libras
			if (currencyOption.equals(currencyOptions[2])) {
				message = obtenerResultado(currentCurrency, libra, false);

			}
			// De Soles a Won
			if (currencyOption.equals(currencyOptions[3])) {
				message = obtenerResultado(currentCurrency, won, false);

			}
			// De soles a Yen
			if (currencyOption.equals(currencyOptions[4])) {
				message = obtenerResultado(currentCurrency, yen, false);
			}
			// De Dolares a Soles
			if (currencyOption.equals(currencyOptions[5])) {
				message = obtenerResultado(currentCurrency, dolar, true);

			}
			// De Euro a Soles
			if (currencyOption.equals(currencyOptions[6])) {
				message = obtenerResultado(currentCurrency, euro, true);

			}
			// De Libras a Soles
			if (currencyOption.equals(currencyOptions[7])) {
				message = obtenerResultado(currentCurrency, libra, true);

			}
			// De Won a Soles

			if (currencyOption.equals(currencyOptions[8])) {
				message = obtenerResultado(currentCurrency, won, true);

			}
			// De Yen a Soles
			if (currencyOption.equals(currencyOptions[9])) {
				message = obtenerResultado(currentCurrency, yen, true);

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
	
	private static String obtenerResultado(Double currentCurrency, Currency currency, boolean soles) {
		String message;
		Double valueConverted;
		if(soles) {
			valueConverted =  currency.divideCoin(currentCurrency);
			message = currency.messageConvertedToSoles(valueConverted);

		}else {
			valueConverted =  currency.multiplyCoin(currentCurrency);
			message = currency.messageConverted(valueConverted);

		}
		return message;
	}
}
