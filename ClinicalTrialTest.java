/**
 * Copyright 2025 John Bamigbade
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific
 * language governing permissions and limitations under the License.
 */


import org.junit.Test;
import static org.junit.Assert.*;

public class ClinicalTrialTest {

    @Test
    public void testSubjectEligibility() {
        StudySubject eligible = new StudySubject("SUB001", 45, 32.0, true);
        StudySubject tooYoung = new StudySubject("SUB002", 25, 32.0, true);
        StudySubject tooHeavy = new StudySubject("SUB003", 50, 42.5, true);
        StudySubject notConsented = new StudySubject("SUB004", 50, 32.0, false);

        assertTrue(eligible.isEligible());
        assertFalse(tooYoung.isEligible());
        assertFalse(tooHeavy.isEligible());
        assertFalse(notConsented.isEligible());
    }

    @Test
    public void testAEReportFormatting() {
        AEReport report = new AEReport("SUB001", "Fatigue", false);
        String expected = "Subject: SUB001 | AE: Fatigue | Serious: false";
        assertEquals(expected, report.getReport());
    }

    @Test
    public void testVisitRecordFormatting() {
        VisitRecord visit = new VisitRecord("Week 12", 84, "MRI, Labs", "Fat reduced 15%");
        String expected = "Visit: Week 12, Day: 84, Procedures: MRI, Labs, Results: Fat reduced 15%";
        assertEquals(expected, visit.getVisitInfo());
    }

    @Test
    public void testSubjectVisitHistory() {
        StudySubject subject = new StudySubject("SUB005", 52, 33.0, true);
        subject.addVisit(new VisitRecord("Screening", -14, "Consent, Labs", "Eligible"));
        subject.addVisit(new VisitRecord("Baseline", 0, "Randomized", "Started treatment"));

        assertEquals(2, subject.getVisitHistory().size());
        assertEquals("Screening", subject.getVisitHistory().get(0).visitName);
        assertEquals("Baseline", subject.getVisitHistory().get(1).visitName);
    }
}
