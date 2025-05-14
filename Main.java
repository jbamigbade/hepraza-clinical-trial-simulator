import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ClinicalTrial trial = new ClinicalTrial(
            "Hepraza in Adults with NAFLD",
            "HPZ-2025-NAFLD-P2",
            "Hepraza Biotech, Inc."
        );

        System.out.println("Enter number of subjects to enroll:");
        int count = scanner.nextInt();
        scanner.nextLine(); // consume newline

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Enter Details for Subject #" + (i + 1) + " ---");
            System.out.print("Subject ID: ");
            String id = scanner.nextLine();

            System.out.print("Age: ");
            int age = scanner.nextInt();

            System.out.print("BMI: ");
            double bmi = scanner.nextDouble();

            System.out.print("Has the subject consented? (true/false): ");
            boolean consented = scanner.nextBoolean();
            scanner.nextLine(); // consume newline

            StudySubject subject = new StudySubject(id, age, bmi, consented);

            if (subject.isEligible()) {
                subject.addVisit(new VisitRecord("Screening", -14, "Labs, MRI, Consent", "Eligible"));
                subject.addVisit(new VisitRecord("Baseline", 0, "Randomization, Drug Dispensation", "Randomized to Hepraza"));
                subject.addVisit(new VisitRecord("Week 12", 84, "MRI, Final Labs", "Liver fat reduced by 18%"));

                trial.enrollSubject(subject);
                System.out.println("✅ Subject " + id + " enrolled and visits recorded.");
            } else {
                System.out.println(" Subject " + id + " is not eligible for enrollment.");
            }
        }

        // Output to console
        System.out.println("\n=== Trial Summary ===");
        trial.printSummary();

        System.out.println("\n=== Visit Histories ===");
        for (StudySubject s : trial.getSubjects()) {
            s.printVisitHistory();
        }

        // Optional: Save to file
        try (PrintWriter writer = new PrintWriter(new FileWriter("trial_summary.txt"))) {
            writer.println("=== Trial Summary ===");
            writer.println("Trial Title: " + trial.getTitle());
            writer.println("Protocol #: " + trial.getProtocolNumber());
            writer.println("Sponsor: " + trial.getSponsor());
            writer.println("Total Subjects: " + trial.getSubjects().size());
            writer.println("Assessments: 0");
            writer.println("Adverse Events Reported: 0\n");

            writer.println("=== Visit Histories ===");
            for (StudySubject s : trial.getSubjects()) {
                for (VisitRecord v : s.getVisitHistory()) {
                    writer.println("Visit: " + v.visitName + ", Day: " + v.day +
                            ", Procedures: " + v.procedures + ", Results: " + v.resultSummary);
                }
            }

            System.out.println("📄 trial_summary.txt file has been saved.");
        } catch (IOException e) {
            System.out.println(" Failed to write file: " + e.getMessage());
        }

        scanner.close();
    }
}
