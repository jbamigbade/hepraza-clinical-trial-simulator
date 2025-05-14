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
