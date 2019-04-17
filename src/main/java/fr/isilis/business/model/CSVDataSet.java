package fr.isilis.business.model;

import lombok.Data;

import java.util.List;

@Data
public class CSVDataSet {

    private String name;

    private String header;

    private List<String> row;
}
