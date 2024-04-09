public class Main {

    public static void main(String[] args) {

        System.out.println("Hidden card number: " + getHiddenCard("2222333344445555", 4));
        System.out.println("Is Leap Year? " + isLeapYear(1800));
        printNameBySymbol("Alex");
        System.out.println("Inverted String: " + reverse("шалаш"));
        System.out.println("Combining numbers into a string: " + joinNumbersFromRange(5, 10));
        System.out.println("The number of occurrences of the selected character: " + countChars("A language that every programmer should know? It's English.", 'E'));
        System.out.println("It's a prime number? " + isPrime(5));
        System.out.println("A cipher word: " + encrypt("Java"));
        System.out.println(fizzBuzz(14, 20));
    }
    public static boolean isPrime(int number) {
        /*
         * Этот метод проверяет, является ли выбранное число простым
         */
        if (number < 2) {
            return false;
        }

        var divider = 2;

        while (divider <= number / 2) {
            if (number % divider == 0) {
                return false;
            }

            divider += 1;
        }

        return true;
    }

    public static String getHiddenCard(String cardNumber, int countOf) {
        /*
         * Этот метод скрывает первые 12 символов номера карты, заменяя их выбранным числом * - countOf.
         */
        return "*".repeat(countOf) + cardNumber.substring(12, 16);
    }

    public static String joinNumbersFromRange(int start, int finish) {
        /*
         * Этот метод соединяет выбранный диапазон чисел в строку
         */
        int i = 1;
        var str = "";
        // BEGIN (write your solution here)
        while (start <= finish) {
            str = str + Integer.parseInt(String.valueOf(start));
            start = i + start;
        }
        // END
        return str;
    }

    public static String fizzBuzz(int begin, int end) {
        /*
         * Это решение популярной задачки fizzBuzz на собеседованиях.
         * Если число кратно 3, то выводится Fizz.
         * Если число кратно 5, то выводится Buzz.
         * Если число кратно и 3, и 5, то выводится FizzBuzz.
         * В противном случае выводится само число.
         */
        var result = "";
        if (begin < end) {
            for (int i = begin; i <= end; i++) {
                if (i % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (i % 5 == 0) {
                    System.out.println("Buzz");
                } else if (i % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(result + i);
                }
            }
        }
        return result;
    }

    public static String encrypt(String str) {
        /*
         * Этот метод шифрует введенную строку таким образом, что каждый второй символ меняется местами с первым
         */
        // BEGIN
        var result = "";
        for (var i = 0; i < str.length(); i += 2) {
            var nextSymbol = (i + 2 > str.length()) ? "" : str.charAt(i + 1);
            result = result + nextSymbol + str.charAt(i);
        }

        return result;
        // END
    }

    public static int countChars(String str, char ch) {
        /*
         * Этот метод считает число вхождений переданных в параметры символов в строке.
         * Вне зависимости от регистра этих символов.
         */
        var i = 0;
        var count = 0;
        while (i < str.length()) {
            if (Character.toLowerCase(str.charAt(i)) == Character.toLowerCase(ch)) {
                // Считаем только подходящие символы
                count = count + 1;
            }
            // Счетчик увеличивается в любом случае
            i += 1;
        }
        return count;
    }

    public static void printNameBySymbol(String name) {
        /*
         * Этот метод выводит на экран посимвольно строку, переданную в параметры.
         */
        var i = 0;
        // Такая проверка будет выполняться до конца строки
        // включая последний символ. Его индекс `length() - 1`.
        while (i < name.length()) {
            // Обращаемся к символу по индексу
            System.out.println(name.charAt(i));
            i += 1;
        }
    }

    public static String reverse(String str) {
        /*
         * Этот метод переворачивает строку таким образом, будто её читают справа налево.
         * Можно дополнить метод, чтобы он определял, является ли введенная строка(слово) палиндромом.
         */
        var i = 0;
        // Нейтральный элемент для строк — это пустая строка
        var result = "";
        while (i < str.length()) {
            // Соединяем в обратном порядке
            result = str.charAt(i) + result;
            i += 1;
        }

        return result;
    }


    public static boolean isLeapYear(int year) {
        /*
         * Этот метод проверяет, является ли введенный год високосным.
         */
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
