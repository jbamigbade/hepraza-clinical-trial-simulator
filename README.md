[![License](https://img.shields.io/badge/license-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)

                                                                                                
                                                                                                Hepraza Clinical Trial Simulator

A Java-based console application that simulates clinical trial subject enrollment, visit scheduling, and data recording for the Hepraza Phase II trial in patients with NAFLD (Non-Alcoholic Fatty Liver Disease).

🔥 Features

✅ Interactive subject enrollment with input validation
✅ Eligibility checks based on age, BMI, and informed consent
✅ Auto-generated visit schedule (Screening, Baseline, Week 12)
✅ Tracks visit history per subject
✅ Console and CSV-compatible text file output (trial_summary.txt)
✅ Unit tests using JUnit 4
✅ Extensible with AE (Adverse Event) and visit schedule support

📁 Project Structure

├── AEResport.java / .class                # Adverse Event reporting
├── ClinicalTrial.java / .class           # Trial info and subject tracking
├── ClinicalTrialTest.java                # Unit tests (JUnit 4)
├── ConsentForm.java / .class             # Consent logic (optional extension)
├── Main.java / .class                    # Program entry point
├── ScheduleOfAssessment.java / .class    # Visit schedule planning
├── StudySubject.java / .class            # Eligibility, visits
├── VisitRecord.java / .class             # Individual visit records
├── run-tests.bat                         # Windows test launcher
├── junit-4.13.2.jar                      # JUnit core
├── hamcrest-core-1.3.jar                 # Matchers for assertions
└── trial_summary.txt                     # Program output

🖥️ How to Compile & Run

🔧 Compile
javac -encoding UTF-8 -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar" *.java

▶️ Run the Program
java Main

🧪 Run Unit Tests
java -cp ".;junit-4.13.2.jar;hamcrest-core-1.3.jar" org.junit.runner.JUnitCore ClinicalTrialTest

🧾 Output
The simulator generates:
      Trial summary printed to the terminal
      Per-subject visit history to the terminal
      trial_summary.txt for record-keeping and CSV-friendly use

📦 Dependencies
      JUnit 4.13.2
      Hamcrest Core 1.3
      Both included locally in the repository.

✅ Contributing
Pull requests are welcome! To contribute:
     1. Fork this repo
     2. Create a feature branch
     3.  Commit your changes
     4. Open a PR with a clear description
For enhancements, please open an issue first to discuss proposed changes.

📄 License
    This project is licensed under the MIT License. You are free to use, modify, and distribute.

🙋‍♂️ AuthorJohn O.Bamigbade
💼 Simulation & Health Informatics Developer
📫 Contact: https://www.linkedin.com/in/john-bamigbade/


🧠 Future Ideas
    Export visit data in CSV/JSON format
    GUI using JavaFX or Swing
    REST API for integration with EHR systems
    Integration of AE reporting workflows
