package views;

import javax.swing.JOptionPane;

public class launcher {

	static String showOptionsDialog(String message, String title, String[] options) {
		return (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, options,
				null);
	}

	static void handleCurrencyConversion() {
		String[] optionsCoins = { "De Soles a Dólar", "De Soles a Euro", "De Soles a Libras", "De Soles a Yen",
				"De soles a Won Coreano", "De Dólar a Soles", "De Euro a Soles", "De Libras a Soles", "De Yen a Soles",
				"De Won Coreano a Soles" };

		String optionCurrency = showOptionsDialog("Elija la moneda a que deseas convertir tu dinero", null,
				optionsCoins);
		if (optionCurrency != null) {
			convertCurrency(optionCurrency);
		}
	}

	static void convertCurrency(String optionCurrency)
	{
		double currentCurrency =
				Double.parseDouble(JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:"))
				;
		switch (optionCurrency) {
		case "De Soles a Dólar": {
			String message =  "$"+ (currentCurrency * 0.27)  + " Dólares";
			getCurrencyMessage(message);
		break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + optionCurrency);
		}
	}


	public static void getCurrencyMessage(String message) {
		JOptionPane.showMessageDialog(null, "Tienes " + message  );
	}

	public static void main(String[] args) {

		String[] options = { "Conversor de Moneda", "Conversion de Temperatura" };

		String optionSelMain = showOptionsDialog("Seleccione una opción de conversión", "Menu", options);

		if (optionSelMain != null) {
			switch (optionSelMain) {
			case "Conversor de Moneda":

				handleCurrencyConversion();

				break;
			case "Conversion de Temperatura":
				JOptionPane.showMessageDialog(null, "En desarrollo...");
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + optionSelMain);
			}
		}

	}
}
