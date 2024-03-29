public class MonthData {
    int[] days;

    MonthData() {
        days = new int[30];
    }

    public void printDaysAndStepsFromMonth(int monthStat) {
        System.out.println("Число шагов за " + monthStat + " месяц");
        for (int i = 0; i < days.length; i++) {
            System.out.println(i+1 + " день: " + days[i]);
        }
    }

    public int sumStepsFromMonth() {
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps = sumSteps + days[i] ;
        }
        return sumSteps;
    }

    public int maxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxSteps) {
                maxSteps = days[i];
            }
        }
        return maxSteps;
    }

    public int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay) {
                currentSeries++; //если число шагов больше целевого значения currentSeries считает дни
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
            } else {
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
