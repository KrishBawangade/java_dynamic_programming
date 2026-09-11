package boolean_evaluation_true;

public class BooleanEvaluationTrueTabulation {

    public static int evalWays(String evalStr) {

        int n = evalStr.length();

        int[][][] dp = new int[n][n][2];

        for (int i = 0; i < n; i++) {

            if (evalStr.charAt(i) == 'T') {
                dp[i][i][1] = 1;
                dp[i][i][0] = 0;
            } else {
                dp[i][i][1] = 0;
                dp[i][i][0] = 1;
            }
        }


        // i moves from right to left
        for (int i = n - 1; i >= 0; i--) {

            // j moves from left to right
            for (int j = i + 2; j < n; j += 2) {

                // Try every operator
                for (int k = i + 1; k <= j - 1; k += 2) {

                    int lT = dp[i][k - 1][1];
                    int lF = dp[i][k - 1][0];

                    int rT = dp[k + 1][j][1];
                    int rF = dp[k + 1][j][0];

                    char ch = evalStr.charAt(k);

                    if (ch == '&') {

                        dp[i][j][1] += lT * rT;

                        dp[i][j][0] += (lT * rF)
                                     + (lF * rT)
                                     + (lF * rF);
                    }

                    else if (ch == '|') {

                        dp[i][j][1] += (lT * rT)
                                     + (lT * rF)
                                     + (lF * rT);

                        dp[i][j][0] += lF * rF;
                    }

                    else if (ch == '^') {

                        dp[i][j][1] += (lT * rF)
                                     + (lF * rT);

                        dp[i][j][0] += (lT * rT)
                                     + (lF * rF);
                    }
                }
            }
        }

        return dp[0][n - 1][1];
    }

    public static void main(String[] args) {

        String evalStr = "T|F&T";

        System.out.println(evalWays(evalStr));
    }
}

