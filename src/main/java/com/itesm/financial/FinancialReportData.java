package com.itesm.financial;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FinancialReportData {
    private List<Ride> rides;
    public FinancialReportData(InputStream inputStream, InputStreamReader streamReader) throws Exception {
        this.rides = new ArrayList<>();
        BufferedReader reader = new BufferedReader(streamReader);

        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            /* ENCAPSULATION */
            List<String> line = CSVUtils.parseLine(rawLine);

            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                this.rides.add(newRide);
            }
        }
    }
    public List<Ride> getRides(){
        return this.rides;
    }
}