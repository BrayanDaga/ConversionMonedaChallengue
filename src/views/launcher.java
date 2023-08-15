package views;

import javax.swing.JOptionPane;


public class launcher {

	static void initLauncher() {
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

	static String showOptionsDialog(String message, String title, String[] options) {
		return (String) JOptionPane.showInputDialog(null, message, title, JOptionPane.PLAIN_MESSAGE, null, options,
				null);
	}

	final static Double[] solesConvA = new Double[] { 0.27, 0.25, 0.21, 39.32, 361.01 };

	final static String[] currencyOptions = { "De Soles a Dólar", "De Soles a Euro", "De Soles a Libras", "De Soles a Yen",
			"De soles a Won Coreano", "De Dólar a Soles", "De Euro a Soles", "De Libras a Soles", "De Yen a Soles",
			"De Won Coreano a Soles" };


	static void handleCurrencyConversion() {


		String optionCurrency = showOptionsDialog("Elija la moneda a que deseas convertir tu dinero", null,
				currencyOptions);
		if (optionCurrency != null) {
			try {
				convertCurrency(optionCurrency);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	static void convertCurrency(String currencyOption)  {
		String optinSelected = JOptionPane.showInputDialog("Ingresa la cantidad de dinero que deseas convertir:");

		Double currentCurrency = (double) 0;
		try {
			currentCurrency = Double.valueOf(optinSelected);
			String message = "";
			Double valueConverted  = (double) 0;
			if(currencyOption.equals(currencyOptions[0])) {
				valueConverted =  (currentCurrency * solesConvA[0]);
				message = "Tienes $"+ valueConverted + " Dolares";
			}
			if(currencyOption.equals(currencyOptions[1])) {
				valueConverted =   (currentCurrency * solesConvA[1]);
				message = "Tienes $"+  valueConverted + " Euros";
			}
			if(currencyOption.equals(currencyOptions[2])) {
				valueConverted =   (currentCurrency * solesConvA[2]);
				message = "Tienes $"+ valueConverted + " Libras";
			}
			if(currencyOption.equals(currencyOptions[3])) {
				valueConverted =  (currentCurrency * solesConvA[3]);

				message = "Tienes $"+ valueConverted+ " Yens";
			}
			if(currencyOption.equals(currencyOptions[4])) {
				valueConverted =  (currentCurrency * solesConvA[4]);

				message = "Tienes $"+ valueConverted + " Won Coreano";

			}
			if(currencyOption.equals(currencyOptions[5])) {
				valueConverted =  (currentCurrency / solesConvA[0]);
				message = "Tienes S/"+ valueConverted + " Soles";

			}
			if(currencyOption.equals(currencyOptions[6])) {
				valueConverted =  (currentCurrency / solesConvA[1]);
				message = "Tienes S/"+ valueConverted + " Soles";


			}
			if(currencyOption.equals(currencyOptions[7])) {
				valueConverted =  (currentCurrency / solesConvA[2]);
				message = "Tienes S/"+ valueConverted + " Soles";
			}
			if(currencyOption.equals(currencyOptions[8])) {
				valueConverted =   (currentCurrency / solesConvA[3]);
				message = "Tienes S/"+ valueConverted + " Soles";

			}
			if(currencyOption.equals(currencyOptions[9])) {
				valueConverted =  (currentCurrency / solesConvA[4]);
				message = "Tienes S/"+ valueConverted + " Soles";
			}

			getCurrencyMessage(message);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Valor no válido");
		}
		finally {
			int canContinue =  JOptionPane.showConfirmDialog(null, "Deseas continuar?");
			if(canContinue == 0) {
				initLauncher();
			}else {
				JOptionPane.showMessageDialog(null, "Programa terminado");
			}
		}


	}

	public static void getCurrencyMessage(String message) {
		JOptionPane.showMessageDialog(null, "Tienes " + message);
	}

	public static void main(String[] args) {

		initLauncher();


	}
}
