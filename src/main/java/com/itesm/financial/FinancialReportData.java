public class FinancialReportData {
    private List<Ride> rides;
    public FinancialReportData(InputStream inputStream, InputStreamReader streamReader){
        this.rides = new ArrayList<>();
        BufferedReader reader = new BufferedReader(streamReader);

        for (String rawLine; (rawLine = reader.readLine()) != null;) {
            List<String> line = CSVUtils.parseLine(rawLine);
            Ride newRide = RidesParser.parseFromList(line);
            if(newRide != null) {
                this.rides.add(newRide);
            }
        }
    }
    public getRides(){
        return this.rides;
    }
}