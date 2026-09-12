package palindrome_partitioning2;

public class PalindromePartitioning2TabulationOptimized {

    public static void main(String[] args) {
        String s = "aab";
        int n = s.length();

        boolean[][] palindrome = new boolean[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)
                        && (j - i <= 1 || palindrome[i + 1][j - 1])) {
                    palindrome[i][j] = true;
                }
            }
        }

        int[][] dp = new int[n][n];

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {

                if (palindrome[i][j]) {
                    dp[i][j] = 0;
                    continue;
                }

                int min = Integer.MAX_VALUE;

                for (int k = i + 1; k <= j; k++) {
                    if (palindrome[i][k - 1]) {
                        int cuts = 1 + dp[k][j];
                        min = Math.min(min, cuts);
                    }
                }

                dp[i][j] = min;
            }
        }

        System.out.println(dp[0][n - 1]);
    }
}

