import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();

        if (s.length() < p.length()) {
            return result;
        }

        int[] pFreq = new int[26];
        int[] windowFreq = new int[26];

        // Frequency of p
        for (char ch : p.toCharArray()) {
            pFreq[ch - 'a']++;
        }

        int left = 0;

        for (int right = 0; right < s.length(); right++) {

            // Add right character
            windowFreq[s.charAt(right) - 'a']++;

            // Keep window size equal to p.length()
            if (right - left + 1 > p.length()) {
                windowFreq[s.charAt(left) - 'a']--;
                left++;
            }

            // Check if current window is an anagram
            if (Arrays.equals(pFreq, windowFreq)) {
                result.add(left);
            }
        }

        return result;
    }
}