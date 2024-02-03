import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // 1. Знайти суму всіх елементів двовимірного масиву.
        int sum = sumOfElements(array);
        System.out.println("Сума елементів масиву: " + sum);

        // 2. Знайти середнє арифметичне значення всіх елементів масиву.
        double average = averageOfElements(array);
        System.out.println("Середнє арифметичне елементів масиву: " + average);

        // 3. Знайти найбільший елемент в кожному рядку масиву.
        findMaxInEachRow(array);

        // 4. Знайти найменший елемент в кожному стовпці масиву.
        findMinInEachColumn(array);

        // 5. Знайти суму елементів кожного рядка масиву.
        sumOfElementsInEachRow(array);

        // 6. Перевірити, чи є усі елементи головної діагоналі масиву додатними.
        checkDiagonalElements(array);

        // 7. Поміняти місцями два рядки масиву.
        swapRows(array, 0, 2);

        // 8. Знайти суму елементів в рядках, де є хоча б одне від'ємне число.
        sumOfRowsWithNegativeElements(array);

        // 9. Знайти кількість парних чисел в масиві.
        int evenNumbersCount = countEvenNumbers(array);
        System.out.println("Кількість парних чисел в масиві: " + evenNumbersCount);

        // 10. Знайти кількість від'ємних чисел в масиві.
        int negativeNumbersCount = countNegativeNumbers(array);
        System.out.println("Кількість від'ємних чисел в масиві: " + negativeNumbersCount);

        // 11. Замінити всі нульові елементи масиву на числа, починаючи з 1.
        replaceZeros(array);

        // 12. Визначити, чи є сума лівої і правої діагоналі масива однаковими.
        boolean isEqualDiagonalSum = isEqualDiagonalSum(array);
        System.out.println("Сума лівої і правої діагоналі однакова: " + isEqualDiagonalSum);

        // 13. Знайти суму елементів, розташованих на лівій діагоналі масиву.
        int sumOfLeftDiagonal = sumOfLeftDiagonal(array);
        System.out.println("Сума елементів лівої діагоналі: " + sumOfLeftDiagonal);

        // 14. Знайти кількість елементів, які менше заданого числа.
        int targetNumber = 5;
        int countLessThanTarget = countElementsLessThan(array, targetNumber);
        System.out.println("Кількість елементів, менших за " + targetNumber + ": " + countLessThanTarget);

        // 15. Перевірити, чи є всі елементи масиву унікальними.
        boolean areAllElementsUnique = areAllElementsUnique(array);
        System.out.println("Усі елементи унікальні: " + areAllElementsUnique);
    }

    private static int sumOfElements(int[][] array) {
        int sum = 0;
        for (int[] row : array) {
            for (int element : row) {
                sum += element;
            }
        }
        return sum;
    }

    private static double averageOfElements(int[][] array) {
        int totalElements = array.length * array[0].length;
        int sum = sumOfElements(array);
        return (double) sum / totalElements;
    }

    private static void findMaxInEachRow(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int max = array[i][0];
            for (int j = 1; j < array[i].length; j++) {
                if (array[i][j] > max) {
                    max = array[i][j];
                }
            }
            System.out.println("Найбільший елемент у рядку " + i + ": " + max);
        }
    }

    private static void findMinInEachColumn(int[][] array) {
        for (int j = 0; j < array[0].length; j++) {
            int min = array[0][j];
            for (int i = 1; i < array.length; i++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                }
            }
            System.out.println("Найменший елемент у стовпці " + j + ": " + min);
        }
    }

    private static void sumOfElementsInEachRow(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
            System.out.println("Сума елементів у рядку " + i + ": " + sum);
        }
    }

    private static void checkDiagonalElements(int[][] array) {
        boolean allPositive = true;
        for (int i = 0; i < array.length; i++) {
            if (array[i][i] <= 0) {
                allPositive = false;
                break;
            }
        }
        if (allPositive) {
            System.out.println("Усі елементи головної діагоналі додатні.");
        } else {
            System.out.println("Не всі елементи головної діагоналі додатні.");
        }
    }

    private static void swapRows(int[][] array, int row1, int row2) {
        int[] temp = array[row1];
        array[row1] = array[row2];
        array[row2] = temp;
        System.out.println("Рядки " + row1 + " і " + row2 + " були обмінені місцями.");
    }

    private static void sumOfRowsWithNegativeElements(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            boolean hasNegative = false;
            int sum = 0;
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < 0) {
                    hasNegative = true;
                    break;
                }
                sum += array[i][j];
            }
            if (hasNegative) {
                System.out.println("Сума елементів у рядку " + i + ": " + sum);
            }
        }
    }

    private static int countEvenNumbers(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element % 2 == 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static int countNegativeNumbers(int[][] array) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    private static void replaceZeros(int[][] array) {
        int replacement = 1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] == 0) {
                    array[i][j] = replacement;
                    replacement++;
                }
            }
        }
    }

    private static boolean isEqualDiagonalSum(int[][] array) {
        int leftDiagonalSum = 0;
        int rightDiagonalSum = 0;
        int n = array.length;

        for (int i = 0; i < n; i++) {
            leftDiagonalSum += array[i][i];
            rightDiagonalSum += array[i][n - 1 - i];
        }

        return leftDiagonalSum == rightDiagonalSum;
    }

    private static int sumOfLeftDiagonal(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i][i];
        }
        return sum;
    }

    private static int countElementsLessThan(int[][] array, int target) {
        int count = 0;
        for (int[] row : array) {
            for (int element : row) {
                if (element < target) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean areAllElementsUnique(int[][] array) {
        int totalElements = array.length * array[0].length;
        HashSet<Integer> uniqueElements = new HashSet<>();

        for (int[] row : array) {
            for (int element : row) {
                uniqueElements.add(element);
            }
        }

        return uniqueElements.size() == totalElements;
    }
}
