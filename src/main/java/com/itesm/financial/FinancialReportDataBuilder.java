package com.itesm.financial;

import java.io.InputStream;
import java.io.InputStreamReader;

public class FinancialReportDataBuilder {
    private InputStream inputStream;
    private InputStreamReader streamReader;
    
    public FinancialReportDataBuilder withInputStream(InputStream inputStream){
        this.inputStream = inputStream;
        return this;
    }

    public FinancialReportDataBuilder withStreamReader(InputStreamReader streamReader){
        this.streamReader = streamReader;
        return this;
    }

    public FinancialReportData build() throws Exception {
        return new FinancialReportData(inputStream, streamReader);
    }
}