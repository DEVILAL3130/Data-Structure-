class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (citations[mid] == n - mid) {
                return n - mid; // perfect match
            } else if (citations[mid] < n - mid) {
                left = mid + 1; // too small, move right
            } else {
                right = mid - 1; // too big, move left
            }
        }
        
        // If no exact match, h-index = n - left
        return n - left;
    }
}