package Grafica.Controladores;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;



public class LengthCheckingDateFormat extends SimpleDateFormat {

  public LengthCheckingDateFormat(String pattern) { super(pattern); }

  @Override
  public Date parse(String s, ParsePosition p) {
    if (s == null || (s.length() - p.getIndex()) < toPattern().length()) {
      p.setErrorIndex(p.getIndex());
      return null;
    }
    return super.parse(s, p);
  }
}