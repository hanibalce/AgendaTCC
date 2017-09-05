package br.ufc.qx.agtcc.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AgendaTccUtil {

	public static Date criarData(String dia, String mes, String ano, String hora, String min) throws ParseException {
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		String dateInString = dia + "/" + mes + "/" + ano + " " + hora + ":" + min;
		date = formatter.parse(dateInString);
		return date;
	}
}
