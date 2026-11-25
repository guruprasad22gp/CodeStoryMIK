package Minimum_Number_of_Moves_to_Seat_Everyone;

import java.util.Arrays;

public class Solution1 {
	public int minMovesToSeat(int[] seats, int[] students) {
		Arrays.sort(seats);
		Arrays.sort(students);

		int total = 0;

		for (int i = 0; i < seats.length; i++) {
			total += Math.abs(seats[i] - students[i]);
		}

		return total;
	}

	public static void main(String[] args) {
		int[] seats = { 3, 1, 5 };
		int[] students = { 2, 7, 4 };

		Solution1 sol1 = new Solution1();
		System.out.println("Output: " + sol1.minMovesToSeat(seats, students));
	}
}
