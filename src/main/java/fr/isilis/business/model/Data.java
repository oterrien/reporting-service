package fr.isilis.business.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Data {

    private static final String CSV_TEMPLATE = "%s;%s";

    private String firstName;
    private String lastName;

    public String toCsv(){
        return String.format(CSV_TEMPLATE, firstName, lastName);
    }
}
