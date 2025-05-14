import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class ClinicalTrial {
    private String title;
    private String protocolNumber;
    private String sponsor;
    private List<StudySubject> subjects;
    private List<ScheduleOfAssessment> schedule;
    private List<AEReport> aeReports;

    public ClinicalTrial(String title, String protocolNumber, String sponsor) {
        this.title = title;
        this.protocolNumber = protocolNumber;
        this.sponsor = sponsor;
        this.subjects = new ArrayList<>();
        this.schedule = new ArrayList<>();
        this.aeReports = new ArrayList<>();
    }

    public void enrollSubject(StudySubject subject) {
        subjects.add(subject);
    }

    public void addAssessment(ScheduleOfAssessment assessment) {
        schedule.add(assessment);
    }

    public void recordAE(AEReport report) {
        aeReports.add(report);
    }

    public void printSummary() {
        System.out.println("Trial Title: " + title);
        System.out.println("Protocol #: " + protocolNumber);
        System.out.println("Sponsor: " + sponsor);
        System.out.println("Total Subjects: " + subjects.size());
        System.out.println("Assessments: " + schedule.size());
        System.out.println("Adverse Events Reported: " + aeReports.size());
    }

    public List<StudySubject> getSubjects() {
        return subjects;
    }

    public String getTitle() {
        return title;
    }

    public String getProtocolNumber() {
        return protocolNumber;
    }

    public String getSponsor() {
        return sponsor;
    }

    // ✅ Export all subjects' visit data to a CSV file
    public void exportAllSubjectsToCSV(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Subject ID,Visit Name,Day,Procedures,Results\n");

            for (StudySubject subject : subjects) {
                for (VisitRecord visit : subject.getVisitHistory()) {
                    writer.write(String.format("%s,%s,%d,%s,%s\n",
                        subject.getSubjectId(),
                        visit.getVisitName(),
                        visit.getDay(),
                        visit.getProcedures(),
                        visit.getResults()));
                }
            }

            System.out.println("✅ All subject visits exported to: " + filePath);
        } catch (IOException e) {
            System.err.println(" Error writing CSV: " + e.getMessage());
        }
    }
}
