import java.util.Scanner;

public class StepTracker {
    int goalByStepsPerDay = 10000;
    Scanner scanner;
    MonthData[] monthToData = new MonthData[12];

    StepTracker(Scanner scan) {
        scanner = scan;
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();
        if (month > 0 && month <= 12) {
            System.out.println("Введите день от 1 до 30 (включительно)");
            int day = scanner.nextInt();
            if (day > 0 && day <= 30) {
                System.out.println("Введите количество шагов");
                int stepsPerDay = scanner.nextInt();
                if (stepsPerDay > 0) {
                    System.out.println("Значение сохранено");
                    MonthData monthData = monthToData[month - 1];
                    // Получение соответствующего объекта MonthData из массива
                    monthData.days[day - 1] = stepsPerDay;
                    // Сохранение полученных данных
                } else {
                    System.out.println("Некорректный формат данных (отрицательное или равное 0 значение");
                }
            } else {
                System.out.println("Некорректный формат даты");
            }
        } else {
            System.out.println("Некорректный формат даты");
        }
    }
    public void changeStepGoal() {
        System.out.println("Введите цель по количеству шагов в день");
        int newGoalByStepsPerDay = scanner.nextInt();
        if (newGoalByStepsPerDay > 0) {
            goalByStepsPerDay = newGoalByStepsPerDay;
            System.out.println("Значение сохранено");
        } else {
            System.out.println("Некорректный формат данных (отрицательное или равное нулю значение)");
        }
    }
    Converter converter = new Converter();
    public void printStatistic() {
        System.out.println("Введите номер месяца");
        int monthStat = scanner.nextInt();
        if (monthStat > 0 && monthStat <= 12) {
            System.out.println("Статистика пройденных шагов по дням:");
            MonthData monthData = monthToData[monthStat - 1];
            monthData.printDaysAndStepsFromMonth(monthStat);
            System.out.println("Общее количество шагов за месяц: " + monthData.sumStepsFromMonth());
            System.out.println("Ваше максимальное число шагов за день: " + monthData.maxSteps());
            System.out.println("В среднем за месяц вы проходили: " + (monthData.sumStepsFromMonth() / 30) + " шагов в день");
            System.out.println("Пройденная дистанция (в км): " + converter.convertToKm(monthData.sumStepsFromMonth()));
            System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(monthData.sumStepsFromMonth()));
            System.out.println("Ваша самая длительная серия: " + monthData.bestSeries(goalByStepsPerDay));
        } else {
            System.out.println("Некорректный формат даты");
        }
    }
}
