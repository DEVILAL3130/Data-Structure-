class Solution {
    public int minimizedMaximum(int n, int[] quantities) {

        int left = 1;
        int right = 0;

        for (int q : quantities) {
            right = Math.max(right, q);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(n, quantities, mid)) {
                right = mid;   // try smaller max
            } else {
                left = mid + 1; // increase max
            }
        }

        return left;
    }

    private boolean canDistribute(int n, int[] quantities, int maxAllowed) {

        int storesNeeded = 0;

        for (int q : quantities) {
            storesNeeded += (q + maxAllowed - 1) / maxAllowed; // ceil(q / maxAllowed)

            if (storesNeeded > n) return false;
        }

        return true;
    }
}