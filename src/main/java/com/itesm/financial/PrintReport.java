package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


/* INHERITANCE */
public class PrintReport extends Report{

    public PrintReport(FinancialReportData financialReportData) {
        super(financialReportData);
    }

    @Override
    protected String getFileName(){
        return "financial-report.txt";
    }

    @Override
    protected String createTitle(String title){
        return "-----------------" + title + "-----------------\n";
    }

    @Override
    protected String createTableHeader() {
        return "TaxiID \t" +
                "Pickup time \t\t\t\t\t" +
                "Dropoff time \t\t\t\t\t" +
                "Passenger count \t" +
                "Trip Distance \t" +
                "Total amount \t\n";
    }

    @Override
    protected String createTableFooter() {
        return "";
    }

    @Override
    protected String addRide(Ride ride) {
        return  ride.getTaxiId() + ",\t" +
                ride.getPickUpTime() + ",\t" +
                ride.getDropOffTime() + ",\t" +
                ride.getPassengerCount() + ",\t\t\t\t\t" +
                ride.getTripDistance() + ",\t\t\t" +
                formatAmount(ride.getTollsAmount()) +
                "\n";
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "(" + amount + ")";
        }
        return Double.toString(amount);
    }
}
