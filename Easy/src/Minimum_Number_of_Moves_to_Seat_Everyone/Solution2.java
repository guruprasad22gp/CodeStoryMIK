package Minimum_Number_of_Moves_to_Seat_Everyone;

public class Solution2 {
	public int minMovesToSeat(int[] seats, int[] students) {
		int[] seat = new int[101];
		int[] student = new int[101];

		for (int ele : seats) {
			seat[ele]++;
		}

		for (int ele : students) {
			student[ele]++;
		}

		int n = seats.length;
		int total = 0;
		int i = 0;
		int j = 0;
		while (n > 0) {
			if (seat[i] == 0) {
				i++;
			}

			if (student[j] == 0) {
				j++;
			}

			if (student[j] != 0 && seat[i] != 0) {
				total += Math.abs(i - j);
				seat[i]--;
				student[j]--;
				n--;
			}
		}

		return total;
	}

	public static void main(String[] args) {
		int[] seats = { 4, 1, 5, 9 };
		int[] students = { 1, 3, 2, 6 };

		Solution2 sol1 = new Solution2();
		System.out.println("Output: " + sol1.minMovesToSeat(seats, students));
	}
}
