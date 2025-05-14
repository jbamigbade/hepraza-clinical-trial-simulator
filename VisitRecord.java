public class VisitRecord {
    public String visitName;
    public int day;
    public String procedures;
    public String resultSummary;

    public VisitRecord(String visitName, int day, String procedures, String resultSummary) {
        this.visitName = visitName;
        this.day = day;
        this.procedures = procedures;
        this.resultSummary = resultSummary;
    }

    public String getVisitInfo() {
        return "Visit: " + visitName + ", Day: " + day + ", Procedures: " + procedures + ", Results: " + resultSummary;
    }

    public String getVisitName() {
        return visitName;
    }

    // ✅ Add missing getters for CSV and other logic
    public int getDay() {
        return day;
    }

    public String getProcedures() {
        return procedures;
    }

    public String getResults() {
        return resultSummary;
    }
}
