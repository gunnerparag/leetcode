import java.util.HashMap;

public class MaxPointsOnALine {
    public int maxPoints(int[][] points) {
        if (points.length <= 2) return points.length;

        int maxPoints = 0;

        for (int i = 0; i < points.length; i++) {
            HashMap<String, Integer> slopeMap = new HashMap<>();
            int duplicate = 1; // Count the base point itself
            int localMax = 0;

            for (int j = 0; j < points.length; j++) {
                if (i == j) continue;

                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    // Overlapping point
                    duplicate++;
                } else {
                    // Reduce the slope to its simplest form
                    int gcd = gcd(dx, dy);
                    dx /= gcd;
                    dy /= gcd;

                    // Ensure a consistent representation of slope
                    if (dx < 0) {
                        dx = -dx;
                        dy = -dy;
                    }

                    String slope = dy + "/" + dx;
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                    localMax = Math.max(localMax, slopeMap.get(slope));
                }
            }

            // Include duplicate points in the count
            maxPoints = Math.max(maxPoints, localMax + duplicate);
        }

        return maxPoints;
    }

    // Helper function to compute the greatest common divisor (GCD)
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Main method for testing
    public static void main(String[] args) {
        MaxPointsOnALine solution = new MaxPointsOnALine();

        // Test cases
        int[][] points1 = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println("Max Points: " + solution.maxPoints(points1)); // Output: 3

        int[][] points2 = {{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}};
        System.out.println("Max Points: " + solution.maxPoints(points2)); // Output: 4
    }
}
