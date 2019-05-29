package ru.elena.zh.passwords.base;

import java.time.DateTimeException;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude = {"entryDate", "active"})
@AllArgsConstructor
public class Password {

    private final String country;
    private final String series;
    private final String number;
    private final String entryDate;
    private String active;

    public LocalDate dateToCompare() throws ArrayIndexOutOfBoundsException, NumberFormatException, DateTimeException {
        
        String[] token = entryDate.split("[^0-9]");
        return LocalDate.of(Integer.parseInt(token[2]),
                Integer.parseInt(token[1]), Integer.parseInt(token[0]));

    }

}
