package org.prepare;

/**
 *
 * You parked your car in a parking lot and want to compute the total cost of the ticket. The billing rules are as follows:
 * The entrance fee of the car parking lot is 2; The first full or partial hour costs 3; Each successive full or partial hour (after the first) costs 4. You entered the car parking lot at time E and left at time L. In this task, times are represented as strings in the format "HH:MM" (where "HH" is a two-digit number between 0 and 23, which stands for hours, and "MM" is a two-digit number between 0 and 59, which stands for minutes).
 * Write a function:
 * class Solution { public int solution(String E, String L); }
 * that, given strings E and L specifying points in time in the format "HH:MM", returns the total cost of the parking bill from your entry at time E to your exit at time L. You can assume that E describes a time before L on the same day.
 * For example, given "10:00" and "13:21" your function should return 17, because the entrance fee equals 2, the first hour costs 3 and there are two more full hours and part of a further hour, so the total cost is 2 + 3 + (3 * 4) = 17. Given "09:42" and "11:42" your function should return 9, because the entrance fee equals 2, the first hour costs 3 and the second hour costs 4, so the total cost is 2 + 3 + 4 = 9.
 * Assume that:
 * strings E and L follow the format "HH:MM" strictly; string E describes a time before L on the same day. In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment.
 *
 */
public class ParkingFeeCal {
    public int solution(String E, String L) {
        // Split the input strings into hours and minutes
        String[] entryTime = E.split(":");
        String[] exitTime = L.split(":");

        // Convert hours and minutes to total minutes
        int entryMinutes = Integer.parseInt(entryTime[0]) * 60 + Integer.parseInt(entryTime[1]);
        int exitMinutes = Integer.parseInt(exitTime[0]) * 60 + Integer.parseInt(exitTime[1]);

        // Calculate the total duration in minutes
        int totalDuration = exitMinutes - entryMinutes;

        // Calculate the total hours, rounding up for partial hours
        int totalHours = (totalDuration + 59) / 60; // Add 59 to round up

        // Calculate the cost
        int totalCost = 2; // Entrance fee
        if (totalHours > 0) {
            totalCost += 3; // First hour cost
        }
        if (totalHours > 1) {
            totalCost += (totalHours - 1) * 4; // Additional hours cost
        }

        return totalCost;
    }


    public static void main(String[] args){
        ParkingFeeCal pfc = new ParkingFeeCal();

        System.out.println("The Parking fee is ..."+pfc.solution("10:00", "13:21"));

        System.out.println("The Parking fee is ..."+pfc.solution("09:42", "11:42"));
    }
}
