package darkRealm;

public class MaximumVacationDays {


//  568. Maximum Vacation Days    :: Complexity   - Time  : O(Cites * Cities * Week),   Space : O(cities * week)
//  To lengthy question, thus not keeping text, use link
// https://leetcode.com/problems/maximum-vacation-days/description/

  public static int maxVacationDays(int[][] flights, int[][] days) {
    if (flights == null || flights.length == 0 || days == null || days.length == 0) return 0;
    int cities = days.length;
    int weeks = days[0].length;
    int maxVacation = Integer.MIN_VALUE;
    int[][] dp = new int[cities][weeks];
    // we do bottom up approach
    // for each week try to get the max vacation days for each city
    for (int w = weeks - 1; w >= 0; w--) {
      for (int curCity = 0; curCity < cities; curCity++) {
        dp[curCity][w] = days[curCity][w];  // initialize this citi*week vacation days
        if(w == weeks - 1) continue;  //dont do this for last week
        // for each city, from which, this city can be reached from previous week, get the max vacation days, but
        for (int c = 0; c < cities; c++) {
          // if same city, or the city can be reached via a flight, can we get max days by spending in prev city, or by
          // staying in same city
          if (curCity == c || flights[curCity][c] > 0) {
            dp[curCity][w] = Math.max(dp[curCity][w], days[curCity][w] + dp[c][w + 1]);
          }
        }
        // if we have reached the start week and Either it is the city 0, which is where we start from OR its a city which
        // we can reach by flight from city 0, which as said is where we start. Then we keep track of max
        if (w == 0 && (curCity == 0 || flights[0][curCity] > 0))
          maxVacation = Math.max(dp[curCity][0], maxVacation);
      }
    }

    return maxVacation;
  }

  public static void main(String[] args) {
    int[][] flights = new int[][]{
        {0, 1, 1},
        {1, 0, 1},
        {1, 1, 0},
    };

    int[][] days = new int[][]{
        {1, 3, 1},
        {6, 0, 3},
        {3, 3, 3},
    };

    int res = maxVacationDays(flights, days);
    System.out.println("R : " + res);
  }
}
