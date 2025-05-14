public class AEReport {
    private String subjectId;
    private String description;
    private boolean isSerious;

    public AEReport(String subjectId, String description, boolean isSerious) {
        this.subjectId = subjectId;
        this.description = description;
        this.isSerious = isSerious;
    }

    public String getReport() {
        return "Subject: " + subjectId + " | AE: " + description + " | Serious: " + isSerious;
    }
}
