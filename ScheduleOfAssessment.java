public class ScheduleOfAssessment {
    private String visit;
    private int day;
    private String procedures;

    public ScheduleOfAssessment(String visit, int day, String procedures) {
        this.visit = visit;
        this.day = day;
        this.procedures = procedures;
    }

    public String getVisitDetails() {
        return "Visit: " + visit + ", Day: " + day + ", Procedures: " + procedures;
    }
}
