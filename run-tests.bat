@echo off
javac -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar *.java
java -cp .;junit-4.13.2.jar;hamcrest-core-1.3.jar org.junit.runner.JUnitCore ClinicalTrialTest
pause
