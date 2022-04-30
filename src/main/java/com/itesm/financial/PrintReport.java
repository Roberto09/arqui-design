package com.itesm.financial;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class PrintReport extends Report{

    @Override
    private String createTitle(String title){
        return "-----------------" + title + "-----------------\n";
    }

    @Override
    private String createTableHeader() {
        return "TaxiID \t" +
                "Pickup time \t" +
                "Dropoff time \t" +
                "Passenger count \t" +
                "Trip Distance \t" +
                "Total amount \t\n";
    }

    @Override
    private String closeTableFooter() {
        return "";
    }

    @Override
    private String addRide(Ride ride) {
        return  ride.getTaxiId() + ",\t" +
                ride.getPickUpTime() + ",\t" +
                ride.getDropOffTime() + ",\t" +
                ride.getPassengerCount() + ",\t" +
                ride.getTripDistance() + ",\t" +
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
