
class FinancialReporDatatBuilder {
    private InputStream inputStream;
    private InputStreamReader streamReader;
    
    public FinancialReportBuilder withInputStream(InputStream inputStream){
        this.inputStream = inputStream;
    }

    public FinancialReportBuilder withStreamReader(InputStreamReader streamReader){
        this.streamReader = streamReader;
    }

    public FinancialReportData build(){
        return new FinancialReportData(inputStream, streamReader);
    }
}