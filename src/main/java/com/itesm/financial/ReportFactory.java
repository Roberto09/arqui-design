

public class ReportFactory {
    public static Report createReport(String type, FinancialReportData data){
        switch(type){
            case "web":
                return new WebReport(data);
            case "print":
                return new PrintReport(data);
            default:
                throw new IllegalArgumentException("Report type is unknown");
        }
    }
}