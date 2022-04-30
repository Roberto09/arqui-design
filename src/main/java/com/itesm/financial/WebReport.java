package com.itesm.financial;

/* INHERITANCE */
public class WebReport extends Report{

    public WebReport(FinancialReportData financialReportData) {
        super(financialReportData);
    }

    @Override
    protected String getFileName(){
        return "financial-report.html";
    }

    @Override
    protected String createTitle(String title){
        return "<h1>" + title + "</h1>";
    }

    @Override
    protected String createTableHeader() {
        return "<table>" +
                "<tr>" +
                    "<th> TaxiID </th>" +
                    "<th> Pickup time </th>" +
                    "<th> Dropoff time </th>" +
                    "<th> Passenger count </th>" +
                    "<th> Trip Distance </th>" +
                    "<th> Total amount </th>" +
                "</tr>";
    }

    @Override
    protected String createTableFooter() {
        return "</table>";
    }

    @Override
    protected String addRide(Ride ride) {
        return "<tr>" +
                "<td>" + ride.getTaxiId() + "</td>" +
                "<td>" + ride.getPickUpTime() + "</td>" +
                "<td>" + ride.getDropOffTime() + "</td>" +
                "<td>" + ride.getPassengerCount() + "</td>" +
                "<td>" + ride.getTripDistance() + "</td>" +
                "<td>" + formatAmount(ride.getTollsAmount()) + "</td>" +
                "</tr>";
    }

    private String formatAmount(double amount) {
        if(amount < 0) {
            return "<span style='color:red'>" + amount + "</span>";
        }
        return Double.toString(amount);
    }
}
