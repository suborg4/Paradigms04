/**
* Корреляция
* ● Контекст
* Корреляция - статистическая мера, используемая для оценки
* связи между двумя случайными величинами.
* ● Ваша задача
* Написать скрипт для расчета корреляции Пирсона между
* двумя случайными величинами (двумя массивами). Можете
* использовать любую парадигму, но рекомендую использовать
* функциональную, т.к. в этом примере она значительно
* упростит вам жизнь.
* 
* Используется функционально-императивный стиль программирования
* 
*/

public static double pearsonCorrelationCoefficient(int[] dataset1, int[] dataset2) {
    if (dataset1.length != dataset2.length) {
        return 0.0;
    }

    int length = dataset1.length;
    double sum1 = IntStream.of(dataset1).sum();
    double sum2 = IntStream.of(dataset2).sum();
    double sum1Squared = IntStream.of(dataset1).mapToDouble(i -> i * i).sum();
    double sum2Squared = IntStream.of(dataset2).mapToDouble(i -> i * i).sum();
    double productSum = IntStream.range(0, length).mapToDouble(i -> dataset1[i] * dataset2[i]).sum();

    double covariance = length * productSum - sum1 * sum2;
    double standardDeviation1 = Math.sqrt((length * sum1Squared - sum1 * sum1));
    double standardDeviation2 = Math.sqrt((length * sum2Squared - sum2 * sum2));

    if (standardDeviation1 == 0 || standardDeviation2 == 0) {
        return 0.0;
    }

    return covariance / (standardDeviation1 * standardDeviation2);
}