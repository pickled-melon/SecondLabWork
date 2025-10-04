public class Sentence {
    // Определение строковых констант с сообщениями об ошибках
    private final String MSG_SNTNC_CANT_BE_EMPTY = "Предложение не может быть пустым!";
    private final String MSG_SNTNC_REQUIRES_MIN_TWO_WORDS = "В предложение должно быть 2 и более слов!";
    private final String MSG_SNTNC_REQUIRES_MIN_THREE_WORDS = "В предложение должно быть 3 и более слов!";

    /** Поле строка-предложение*/
    private String sentence;
    /** Поле массив слов предложения */
    private String[] words;

    /**
     * Конструктор - создание нового объекта
     * @see Sentence#Sentence(String) Sentence
     * @see Sentence#Sentence(Sentence)  Sentence
     * */
    public Sentence() {
        this.sentence = "";
    }

    /**
     * Конструктор - создание нового объекта на основе строки
     * @param sentence Строка-предложение
     *
     * @see Sentence#Sentence()  Sentence
     * @see Sentence#Sentence(Sentence)  Sentence
     * */
    public Sentence(String sentence) {
        this.sentence = sentence;
        this.words = sentenceToWords();
    }

    /**
     * Конструктор - создание нового объекта на основе уже существующего объекта
     * @param other Объект класса Sentence
     *
     * @see Sentence#Sentence() Sentence
     * @see Sentence#Sentence(String)  Sentence
     * */
    public Sentence(Sentence other) {
        this.sentence = other.sentence;
        this.words = other.words.clone();
    }

    /**
     * Процедура определения строки-предложения {@link Sentence#sentence}
     * @param sentence Строка-предложение
     * */
    public void setSentence(String sentence) {
        if (sentence.isEmpty()) {
            System.out.println(MSG_SNTNC_CANT_BE_EMPTY);
            System.exit(1);
        }

        this.sentence = sentence;
        this.words = sentenceToWords();
    }

    /**
     * Функция получения значения поля {@link Sentence#sentence}
     * @return Строка-предложение
     * */
    public String getSentence() {
        return sentence;
    }

    /**
     * Функция получения значеняия поля {@link Sentence#sentence}
     * @return Массив слов
     * */
    public String[] getWords() {
        return words.clone();
    }

    /**
     * Процедура печати на экран слов предложения
     * */
    public void printWords() {
        for (int i = 0; i < words.length; i++)
            System.out.print(words[i] + " ");

        System.out.println();
    }

    /**
     * Функция разбиения предложения на слова
     * @return Массив слов
     * */
    public String[] sentenceToWords() {
        return removeRedundantCharsFromString(sentence).split("\\s+");
    }

    /**
     * Функция очистки строки от специальных символов
     * @param rawString Строка, из которой нужно удалить специальные символы
     *
     * @return Строка, содержащая только буквы и пробельные символы
     * */
    private String removeRedundantCharsFromString (String rawString) {
        StringBuilder clearString = new StringBuilder();

        for (char ch: rawString.toCharArray()) {
            if (Character.isLetter(ch) || Character.isSpaceChar(ch))
                clearString.append(ch);
        }

        return clearString.toString();
    }

    /**
     * Функция получения комбинаций из двух слов
     * @return Массив строк, состоящих из 2 слов, разделённых пробелом
     * */
    public String[]  getArrayOfCombinationsOfTwoWords() {
        int countOfCombinations = getCountOfCombinationsOfNWords(2);

        String[] arrayOfCombinationsOfTwoWords = new String[countOfCombinations];

        int combinationNumber = 0;

        for (int i = 0; i < words.length; i++)
            for (int j = 0; j < words.length; j++)
                if (i != j) {
                    arrayOfCombinationsOfTwoWords[combinationNumber] = words[i] + " " + words[j];
                    combinationNumber++;
                }

        return arrayOfCombinationsOfTwoWords;
    }

    /**
     * Функция подсчёта и получения количества комбинаций из N слов
     * @return Количество комбинаций из N слов
     * */
    public int getCountOfCombinationsOfNWords(int n) {
        int wordsLength = words.length;

        if (wordsLength < n) {
            System.out.println(MSG_SNTNC_REQUIRES_MIN_TWO_WORDS);
            System.exit(1);
        }

        int countOfCombinations = wordsLength;

        for (int i = 1; i < n; i++) {
            countOfCombinations *= (wordsLength - i);
        }

        return countOfCombinations;
    }

    /**
     * Функция подсчёта и подсчёта количества согласных букв в предложении
     * @return Количество согласных букв
     * */
    public int getCountOfConsonantLetters() {
        int countOfConsonantLetters = 0;

        for (int i=0; i < sentence.length(); i++) {
            if (isConsonantLetter(Character.toLowerCase(sentence.charAt(i))))
                countOfConsonantLetters++;
        }

        return countOfConsonantLetters;
    }

    /**
     * Функция определения, является ли символ согласной буквой
     * @param checkChar Символ для проверки
     *
     * @return true, если символ является согласной буквой, и false, если не является
     * */
    private boolean isConsonantLetter(char checkChar) {
        String consonantLetterSet = "бвгджзйклмнпрстфхцчшщbcdfgjklmnpqstvxzhrwy";

        boolean flag = false;
        int i = 0;
        while (i < consonantLetterSet.length() && !flag) {
            if (consonantLetterSet.charAt(i) == checkChar)
                flag = true;
            i++;
        }

        return flag;
    }
}
