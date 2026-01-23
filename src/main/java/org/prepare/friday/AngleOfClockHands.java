package org.prepare.friday;

public class AngleOfClockHands {

    // Function to calculate the angle between the hour and minute hands of a clock for a given time.
    public static double calculateAngle(int hours, int minutes) {
        // Normalize hours to 12-hour format
        hours = hours % 12;

        // Calculate the angles of the hour and minute hands
        double minuteAngle = minutes * 6; // 360 degrees / 60 minutes
        double hourAngle = (hours * 30) + (minutes * 0.5); // 360 degrees / 12 hours + extra for minutes

        // Calculate the difference between the two angles
        double angle = Math.abs(hourAngle - minuteAngle);

        // The angle should be the smaller of the two possible angles
        return Math.min(angle, 360 - angle);
    }


    public static void main(String[] args) {
        int hours = 9;
        int minutes = 00;
        double angle = calculateAngle(hours, minutes);
        System.out.println("The angle between the clock hands at " + hours + ":" + minutes + " is " + angle + " degrees.");
    }
}
