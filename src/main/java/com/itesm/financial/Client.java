package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";
    private static final String TYPE = "print"; // "web";
    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");
        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);

        /* BUILDER DESIGN PATTERN */
        FinancialReportData data = (new FinancialReportDataBuilder()).withInputStream(inputStream).withStreamReader(streamReader).build();

        /* SIMPLE FACTORY DESIGN PATTERN */
        /* POLYMORPHYSM */

        Report report = ReportFactory.createReport(TYPE, data);
        String formattedReport = report.createContent();
        report.createFile(formattedReport);
//         System.out.println(htmlReport);
    }
}
