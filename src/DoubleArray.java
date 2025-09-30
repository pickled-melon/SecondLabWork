/**
 * Класс массива с вещественными числами
 * */
public class DoubleArray {
    // Определение строковых констант с сообщениями об ошибках
    private final String MSG_STRING_CANT_BE_EMPTY = "Строка с числами не может быть пустой!";
    private final String MSG_ARRAY_ELEM_MUST_BE_A_REAL_NUMBER = "Элемент массива должен быть вещественным числом!";

    /** Поле массив вещественных чисел */
    private double[] array;

    /**
     * Конструктор - создание нового объекта
     * @see DoubleArray#DoubleArray(String)  DoubleArray
     * @see DoubleArray#DoubleArray(double[])  DoubleArray
     * @see DoubleArray#DoubleArray(DoubleArray)  DoubleArray
     * */
    public DoubleArray() {
        this.array = new double[0];
    }

    /**
     * Конструктор - создание нового объекта на основе cтроки с числами
     * @param numberString Строка вещественных чисел, разделённых пробелами
     *
     * @see DoubleArray#DoubleArray()  DoubleArray
     * @see DoubleArray#DoubleArray(double[])  DoubleArray
     * @see DoubleArray#DoubleArray(DoubleArray)  DoubleArray
     */
    public DoubleArray(String numberString) {
        this.array = stringArrToDoubleArr(numberString);
    }

    /**
     * Конструктор - создание нового объекта на основе массива вещественных чисел
     * @param array Массив вещественных чисел
     *
     * @see DoubleArray#DoubleArray()  DoubleArray
     * @see DoubleArray#DoubleArray(String)  DoubleArray
     * @see DoubleArray#DoubleArray(DoubleArray)  DoubleArray
     */
    public DoubleArray(double[] array) {
        this.array = array;
    }

    /**
     * Конструктор - создание нового объекта на основе уже существующего объекта
     * @param other Объект класса DoubleArray
     *
     * @see DoubleArray#DoubleArray()  DoubleArray
     * @see DoubleArray#DoubleArray(String)  DoubleArray
     * @see DoubleArray#DoubleArray(double[])  DoubleArray
     */
    public DoubleArray(DoubleArray other) {
        this.array = other.array.clone();
    }

    /**
     * Процедура определения массива вещественных чисел {@link DoubleArray#array}
     * @param numberString Строка вещественных чисел, разделённых пробелами
     * */
    public void setArray(String numberString) {
        if (numberString.isEmpty()) {
            System.out.println(MSG_STRING_CANT_BE_EMPTY);
            System.exit(1);
        }

        this.array = stringArrToDoubleArr(numberString);
    }

    /**
     * Функция получения значения поля {@link DoubleArray#array}
     * @return Массив вещественных чисел
     * */
    public double[] getArray() {
        return this.array.clone();
    }

    /**
     * Функция превращения строки чисел в массив вещественных чисел {@link DoubleArray#array}
     * @param numberString Строка вещественных чисел, разделённых пробелами
     *
     * @return Массив вещественных чисел
     * */
    private double[] stringArrToDoubleArr(String numberString) {
        String[] strArray = numberString.split("\\s+");

        array = new double[strArray.length];

        for (int i = 0; i < strArray.length; i++) {
            try {
                array[i] = Double.parseDouble(strArray[i]);
            }
            catch (NumberFormatException e) {
                System.out.println(MSG_ARRAY_ELEM_MUST_BE_A_REAL_NUMBER);
                System.exit(1);
            }
        }

        return array;
    }

    /**
     * Функция подсчёта количества пар, в которых первое число меньше второго более, чем в 2 раза
     * @return Количество пар
     * */
    public int getPairsCount() {
        int pairsCount = 0;

        for (int i=0; i < array.length; i++) {
            for (int j=0; j < array.length; j++) {
                if (i != j && array[i] * array[j] > 0 && array[i] < array[j] / 2)
                    pairsCount++;
            }
        }

        return pairsCount;
    }

    /**
     * Процедура вывода на экран элементов массива {@link DoubleArray#array}
     * */
    public void printArray() {
        for (int i=0; i < array.length; i++)
            System.out.print(array[i] + " ");

        System.out.println();
    }
}
