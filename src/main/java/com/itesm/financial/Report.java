

abstract public class Report {
    private FinancialReportData financialReportData;
    
    public Report(financialReportData){
        this.financialReportData = financialReportData;
    }

    private static createFile(String filename, String content) throws IOException{
        FileWriter fileWriter = new FileWriter(filename);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        printWriter.print(content);
        printWriter.close();
    }

    public String createContent() {
        StringBuilder builder = new StringBuilder();
        builder.append(createTitle("Taxi Report"));
        builder.append(createTableHeader());
        rides = this.financialReportData.getRides();
        rides.forEach( ride -> {
            builder.append(addRide(ride));
        });
        builder.append(createTableFooter());

        return builder.toString();
    }

    abstract private createTitle(String title);
    abstract private createTableHeader();
    abstract private createTableFooter();
    abstract private addRide(Ride ride);
}