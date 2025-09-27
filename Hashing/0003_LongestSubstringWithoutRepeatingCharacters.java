class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0;
        int r = 0;
        int n = s.length();
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < n) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                map.remove(s.charAt(l));
                l++;
            } else {
                map.put(c, r);
                max = Math.max(max, r - l + 1);
                r++;
            }
        }
        return max;
    }
}
