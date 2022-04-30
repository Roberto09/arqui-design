package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

abstract class Report {
    private FinancialReportData financialReportData;

    /* DEPENDENCY INJECTION */
    public Report(FinancialReportData financialReportData){
        this.financialReportData = financialReportData;
    }

    public void createFile(String content) throws IOException {
        String filename = this.getFileName();
        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    public String createContent() {

        /* BUILDER DESIGN PATTERN */
        StringBuilder builder = new StringBuilder();
        builder.append(this.createTitle("Taxi Report"));
        builder.append(this.createTableHeader());
        List<Ride> rides = this.financialReportData.getRides();
        rides.forEach( ride -> {
            builder.append(this.addRide(ride));
        });
        builder.append(this.createTableFooter());

        return builder.toString();
    }

    abstract protected String getFileName();
    abstract protected String createTitle(String title);
    abstract protected String createTableHeader();
    abstract protected String createTableFooter();
    abstract protected String addRide(Ride ride);
}