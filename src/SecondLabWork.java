public class SecondLabWork {
    static final String MSG_NOT_ENOUGH_ARGS = "Недостаточно аргументов!";
    static final String MSG_WRONG_TASK_NUMBER = "Некорректный номер задания! Допустимый набор номеров заданий: {a, b, c ,d}";

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println(MSG_NOT_ENOUGH_ARGS);
            System.exit(1);
        }

        Sentence sentence = new Sentence();

        switch (args[0]) {
            case "a":
                System.out.println("Текст задания\nВыпишите все возможные комбинации, состоящие из двух слов заданного предложения");

                sentence.setSentence(args[1]);

                System.out.println("Возможные комбинации из 2 слов:");
                sentence.printCombinationsOfTwoWords();
                break;
            case "b":
                System.out.println("Текст задания\nОпределите количество возможных комбинаций из трех слов заданного предложения");

                sentence.setSentence(args[1]);

                System.out.println("Число возможных комбинациий из трёх слов (число размещений) равно " + sentence.getCountOfCombinationsOfThreeWords());
                break;
            case "c":
                System.out.println("Текст задания\nДан одномерный числовой вещественный массив, определить число всевозможных комбинаций из двух элементов данного массива таким образом чтобы первый элемент в паре был меньше второго более чем в два раза");

                DoubleArray doubleArray = new DoubleArray(args[1]);

                System.out.println("Количество подходящих пар: " + doubleArray.getPairsCount());
                break;
            case "d":
                System.out.println("Текст задания\nНайдите число согласных букв в предложении");

                sentence.setSentence(args[1]);

                System.out.println("Число согласных букв в предложении \"" + sentence.getSentence() + "\" равно " + sentence.getCountOfConsonantLetters());
                break;
            default:
                System.out.println(MSG_WRONG_TASK_NUMBER);
        }
    }
}
