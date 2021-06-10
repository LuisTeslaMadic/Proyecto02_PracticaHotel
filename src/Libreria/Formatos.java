package Libreria;

import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Formatos {
  
	public static String FormatoMoneda(double dinero) {
		Locale region = Locale.getDefault();
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(region);
		return formatoMoneda.format(dinero);
	}
}
