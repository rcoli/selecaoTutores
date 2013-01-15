package br.edu.cederj.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

public class DateUtils {
	
	public final static SimpleDateFormat DATE_FORMAT_PT_BR = new SimpleDateFormat("dd/MM/yyyy", new Locale("pt", "BR"));
	public final static String FORMAT_PT_BR = "dd/MM/yyyy";
	
	
	/**
	 * 
	 * @param data(Date)
	 * @return data(String) formatada no padrão brasileiro.
	 */
	public static String dateToString(Date dateString, String pattern) {

		SimpleDateFormat format = new SimpleDateFormat(pattern);

		String date = null;

		try {
			date = format.format(dateString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return date;
	}
	
	/**
	 * 
	 * @param data(Date)
	 * @return data(String) formatada no padrão brasileiro.
	 */
	public static String dateToString(Date date) {

		return dateToString(date, FORMAT_PT_BR );
	}
	
	/**
	 * 
	 * @param data (String) e formato que se deseja impor na data.
	 * @return data(Date) formatada no padrão brasileiro.
	 */
	public static Date strToDate(String dateString, String pattern) {

		SimpleDateFormat format = new SimpleDateFormat(pattern);

		Date date = null;

		try {
			date = new Date(format.parse(dateString).getTime());
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return date;
	}
	
	/**
	 * 
	 * @param  data (String)  no formato dd/MM/yyyy
	 * @return data(Date) formatada no padrão brasileiro.
	 */
	public static Date strToDate(String dateString) {

		return strToDate(dateString, FORMAT_PT_BR );
	}

	public static String converterDataUSParaBR(Date dataUS) {
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		return formato.format(dataUS);
	}

	@SuppressWarnings("static-access")
	public static Integer obterAnoCorrente() {
		Calendar cal = Calendar.getInstance(new Locale("pt", "BR"));
		return cal.get(cal.YEAR);
	}

	@SuppressWarnings("static-access")
	public static Integer obterMesCorrente() {
		Calendar cal = Calendar.getInstance(new Locale("pt", "BR"));
		return cal.get(cal.MONTH) + 1;
	}

	public static Integer obterQuantidadeDiasDaSemanaNoMes(int mes, int ano,
			int diaDaSemana) {
		--mes;
		int qtd = 0;
		Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		calendar.set(ano, mes, 1);
		int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		for (int i = 1; i <= days; i++) {
			calendar.set(ano, mes, i);
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			if (day == diaDaSemana)
				qtd++;

		}
		return qtd;
	}
	
	public static List<Integer> obterListaDeDiasDaSemanaNoMes(int mes, int ano, int diaDaSemana)
	{
		--mes;
		List<Integer> diasDoMesDoDiaDaSemana = new ArrayList<Integer>();
		
		Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		calendar.set(ano, mes, 1);
		int diasDoMes = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		for (int i = 1; i <= diasDoMes; i++) 
		{
			calendar.set(ano, mes, i);
			int day = calendar.get(Calendar.DAY_OF_WEEK);
			if (day == diaDaSemana)
			{
				diasDoMesDoDiaDaSemana.add(i);
			}
			
		}
		return diasDoMesDoDiaDaSemana;
	}
	
	public static Calendar obterCalendar(int dia, int mes, int ano)
	{
		--mes;
		Calendar calendar = Calendar.getInstance(new Locale("pt", "BR"));
		calendar.set(ano, mes, dia);

		return calendar;
	}

	public static boolean isDate(String inDate) {

		Pattern p = Pattern.compile("[0-9]{2,2}/[0-9]{1,2}/[0-9]{4,4}");
		Matcher m = p.matcher(inDate);

		if (StringUtils.isBlank(inDate)) {
			return true;
		}
		if (!m.matches()) {
			return false;
		}

		String[] data = inDate.split("/");
		Integer dia = new Integer(data[0]);
		Integer mes = new Integer(data[1]);
		Integer ano = new Integer(data[2]);

		if (dia > 31) {
			return false;
		} else if (mes > 12) {
			return false;
		} else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)
				&& (dia > 30)) {
			return false;
		} else if (mes == 2) {

			if ((dia > 28) && (ano % 4 != 0)) {
				return false;
			}
			if ((dia > 29) && (ano % 4 == 0)) {
				return false;
			}
		} else if (mes == 0 || dia == 0 || ano == 0) {
			return false;
		} else if (ano < 1900) {
			return false;
		}

		return true;
	}

	public static boolean isValidDate(String inDate) {

		if (StringUtils.isEmpty(inDate)) {
			return false;
		}
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		try {
			dateFormat.parse(inDate.trim());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	/**
	 * Compara duas data e retorna a menor.
	 * 
	 * @param date
	 *            Uma data (Objeto java.util.Date)
	 * @param otherDate
	 *            Uma outra data (Objeto java.util.Date)
	 * 
	 * @return a menor data.
	 */
	public static Date min(Date date, Date otherDate) {
		return date.getTime() < otherDate.getTime() ? date : otherDate;
	}

	/**
	 * Compara duas data e retorna a maior.
	 * 
	 * @param date
	 *            Uma data (Objeto java.util.Date)
	 * @param otherDate
	 *            Uma outra data (Objeto java.util.Date)
	 * 
	 * @return a maior data.
	 */
	public static Date max(Date date, Date otherDate) {
		return date.getTime() > otherDate.getTime() ? date : otherDate;
	}

	public static int getTotalDiasMes(int ano, int mes) {
		GregorianCalendar novaData = new GregorianCalendar(ano, mes, 1);
		novaData.add(GregorianCalendar.DATE, -1);
		return novaData.get(GregorianCalendar.DATE);
	}

	/**
	 * Método para comparar as das e retornar o número de dias de diferença
	 * entre elas
	 * 
	 * 
	 * @param dataLow
	 *            a data menor
	 * @param dataHigh
	 *            a data maior
	 * 
	 * @return int número de dias.
	 */
	public static int dataDiff(java.util.Date dataLow, java.util.Date dataHigh) {

		GregorianCalendar startTime = new GregorianCalendar();
		GregorianCalendar endTime = new GregorianCalendar();

		GregorianCalendar curTime = new GregorianCalendar();
		GregorianCalendar baseTime = new GregorianCalendar();

		startTime.setTime(dataLow);
		endTime.setTime(dataHigh);

		int dif_multiplier = 1;

		// Verifica a ordem de inicio das datas
		if (dataLow.compareTo(dataHigh) < 0) {
			baseTime.setTime(dataHigh);
			curTime.setTime(dataLow);
			dif_multiplier = 1;
		} else {
			baseTime.setTime(dataLow);
			curTime.setTime(dataHigh);
			dif_multiplier = -1;
		}

		int result_years = 0;
		int result_months = 0;
		int result_days = 0;

		// Para cada mes e ano, vai de mes em mes pegar o ultimo dia para import
		// acumulando
		// no total de dias. Ja leva em consideracao ano bissesto
		while ((curTime.get(GregorianCalendar.YEAR) < baseTime
				.get(GregorianCalendar.YEAR))
				|| (curTime.get(GregorianCalendar.MONTH) < baseTime
						.get(GregorianCalendar.MONTH))) {

			int max_day = curTime
					.getActualMaximum(GregorianCalendar.DAY_OF_MONTH);
			result_months += max_day;
			curTime.add(GregorianCalendar.MONTH, 1);

		}

		// Marca que ? um saldo negativo ou positivo
		result_months = result_months * dif_multiplier;

		// Retorna a diferenca de dias do total dos meses
		result_days += (endTime.get(GregorianCalendar.DAY_OF_MONTH) - startTime
				.get(GregorianCalendar.DAY_OF_MONTH));

		return result_years + result_months + result_days;
	}
	
	public static String[] splitMesAndAnoSelecionado(String data){
		String[] datas = data.split("/") ;
		return datas;
	}
	
	public static int getAnoReferencia(){
		Calendar ca = Calendar.getInstance();
		return ca.get(Calendar.YEAR);
	}

}