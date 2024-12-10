public class Flowerbed {
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int length = flowerbed.length;

        for (int i = 0; i < length && n > 0; i++) {
            // Check if the current plot is empty and its neighbors (if any) are also empty
            if (flowerbed[i] == 0
                    && (i == 0 || flowerbed[i - 1] == 0)
                    && (i == length - 1 || flowerbed[i + 1] == 0)) {
                // Plant a flower
                flowerbed[i] = 1;
                n--;
                // Skip the next plot
                i++;
            }
        }

        return n == 0;
    }

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 1;
        boolean result = canPlaceFlowers(flowerbed, n);
        System.out.println(result); // Output: true
    }
}
