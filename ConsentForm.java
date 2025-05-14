public class ConsentForm {
    private String subjectId;
    private String dateSigned;

    public ConsentForm(String subjectId, String dateSigned) {
        this.subjectId = subjectId;
        this.dateSigned = dateSigned;
    }

    public void displayConsent() {
        System.out.println("Subject " + subjectId + " signed consent on " + dateSigned);
    }
}
