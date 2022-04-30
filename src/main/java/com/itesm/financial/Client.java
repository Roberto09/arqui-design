package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Client {
    private static final String CSV_FILENAME = "taxi-data.csv";

    public static void main(String[] args) throws Exception {
        System.out.println("Financial Report Generation");
        InputStream inputStream = Client.class.getClassLoader().getResourceAsStream(CSV_FILENAME);
        InputStreamReader streamReader = new InputStreamReader(inputStream, StandardCharsets.UTF_8);
        FinancialReportData data = new FinancialReportDataBuilder().withInputStream(inputStream).withStreamReader(streamReader);        

        Report webReport = ReportFactory.createReport("web", data);
        String htmlReport = webReport.createContent(result);
        Report.createFile("financial-report.html", htmlReport);
        // System.out.println(htmlReport);
        
        Report printReport = ReportFactory.createReport("print", data);
        String textReport = printReport.createContent(result);
        Report.createFile("financial-report.txt", textReport);
        System.out.println(textReport)
    }
}
