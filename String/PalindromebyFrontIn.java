package String;
public class PalindromebyFrontIn {
     static class manacher {
        // array to store palindrome lengths centered 
        // at each position
        int[] p;
        // modified string with separators and sentinels
        String ms;

        manacher(String s) {
            StringBuilder sb = new StringBuilder("@");
            for (char c : s.toCharArray()) {
                sb.append("#").append(c);
            }
            sb.append("#$");
            ms = sb.toString();
            runManacher();
        }

        // core Manacher's algorithm
        void runManacher() {
            int n = ms.length();
            p = new int[n];
            int l = 0, r = 0;

            for (int i = 1; i < n - 1; ++i) {
                if (i < r)
                    p[i] = Math.min(r - i, p[r + l - i]);

                // expand around the current center
                while (ms.charAt(i + 1 + p[i]) == ms.charAt(i - 1 - p[i]))
                    p[i]++;

                // update center if palindrome goes beyond 
                // current right boundary
                if (i + p[i] > r) {
                    l = i - p[i];
                    r = i + p[i];
                }
            }
        }

        // returns the length of the longest palindrome 
        // centered at given position
        int getLongest(int cen, int odd) {
            int pos = 2 * cen + 2 + (odd == 0 ? 1 : 0);
            return p[pos];
        }

        // checks whether substring s[l...r] is a palindrome
        boolean check(int l, int r) {
            int len = r - l + 1;
            int longest = getLongest((l + r) / 2, len % 2);
            return len <= longest;
        }
    }

    // returns the minimum number of characters to add at the 
    // front to make the given string a palindrome
    static int minChar(String s) {
        int n = s.length();
        manacher m = new manacher(s);

        // scan from the end to find the longest 
        // palindromic prefix
        for (int i = n - 1; i >= 0; --i) {
            if (m.check(0, i))
                return n - (i + 1);
        }

        return n - 1;
    }

    public static void main(String[] args) {
        String s = "aacecaaaa";
        System.out.println(minChar(s));
    }
}
