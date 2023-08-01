package com.tugceozcakir.qualifierannotationexample;

import org.springframework.stereotype.Component;

@Component
public class ExcelFileReader implements Reader{
    @Override
    public String readFile() {
        return "Excel File";
    }
}
