public class Converter {
    public int convertToKm(int sumSteps) {
        int sumStepsInKm = sumSteps * 75 / 1000;
        return sumStepsInKm;
    }
    public int convertStepsToKilocalories(int sumSteps) {
        int sumStepsInKkal = sumSteps * 50 / 100;
        return sumStepsInKkal;
    }
}
