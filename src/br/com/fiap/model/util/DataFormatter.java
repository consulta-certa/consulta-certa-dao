package br.com.fiap.model.util;

import java.time.format.DateTimeFormatter;
import java.time.format.ResolverStyle;

public class DataFormatter {
    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm").withResolverStyle(ResolverStyle.STRICT);
}
