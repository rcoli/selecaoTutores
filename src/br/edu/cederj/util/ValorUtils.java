package br.edu.cederj.util;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;


public class ValorUtils
{
	
	public static final NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "br"));
	
	public static BigDecimal stringToBigDecimal(String valor)
	{
		valor = StringUtils.replace(valor, ".", "");
		valor = StringUtils.replace(valor, ",", ".");
		valor = StringUtils.replace(valor, "R$ ", "");
		
		return new BigDecimal(valor);
	}
	
	
	public static String formatarValor(BigDecimal valor)
	{
		NumberFormat nf = NumberFormat.getCurrencyInstance(new Locale("PT", "br"));
		
		String valorFormatado = nf.format(valor);
		if(valorFormatado.contains("R$")){
			valorFormatado = valorFormatado.replace("R$ ", "");
		}
		
		return valorFormatado;
	}
	
	public static String formatarValor(Double v)
	{
		if(v == null)
			return "";
		
		return formatarValor(new BigDecimal(v));
	}
	
	public static String formatarValorUmaCasaDecimal(Double v)
	{
		nf.setMaximumFractionDigits(1);
		return nf.format(v);
	}
	
}
