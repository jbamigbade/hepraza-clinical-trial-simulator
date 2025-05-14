import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudySubject {
    private String subjectId;
    private int age;
    private double bmi;
    private boolean consented;
    private List<VisitRecord> visits;

    public StudySubject(String subjectId, int age, double bmi, boolean consented) {
        this.subjectId = subjectId;
        this.age = age;
        this.bmi = bmi;
        this.consented = consented;
        this.visits = new ArrayList<>();
    }

    public boolean isEligible() {
        return age >= 30 && age <= 65 && bmi >= 25.0 && bmi <= 40.0 && consented;
    }

    public String getSubjectId() {
        return subjectId;
    }

    public List<VisitRecord> getVisitHistory() {
        return visits;
    }

    public void addVisit(VisitRecord visit) {
        visits.add(visit);
    }

    public void printVisitHistory() {
        for (VisitRecord visit : visits) {
            System.out.println(visit.getVisitInfo());
        }
    }

    // ✅ Export subject's visits to CSV
    public void exportVisitsToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Subject ID,Visit Name,Day,Procedures,Results\n");
            for (VisitRecord visit : visits) {
                writer.write(String.format("%s,%s,%d,%s,%s\n",
                    subjectId,
                    visit.getVisitName(),
                    visit.getDay(),
                    visit.getProcedures(),
                    visit.getResults()));
            }
            System.out.println("✅ CSV exported to: " + filePath);
        } catch (IOException e) {
            System.err.println(" Error writing CSV: " + e.getMessage());
        }
    }
}
