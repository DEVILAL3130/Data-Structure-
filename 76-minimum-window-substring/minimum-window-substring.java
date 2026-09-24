import java.util.*;

class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        // Frequency of characters required from t
        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int required = need.size();
        int formed = 0;

        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            window.put(ch, window.getOrDefault(ch, 0) + 1);

            // Character requirement just became satisfied
            if (need.containsKey(ch)
                    && window.get(ch).intValue() == need.get(ch).intValue()) {

                formed++;
            }

            // Try to shrink the window
            while (left <= right && formed == required) {

                // Update minimum window
                if (right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                window.put(leftChar, window.get(leftChar) - 1);

                // Window is no longer satisfying this character
                if (need.containsKey(leftChar)
                        && window.get(leftChar) < need.get(leftChar)) {

                    formed--;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(startIndex, startIndex + minLength);
    }
}