import java.io.*;
import java.util.Scanner;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import static java.lang.System.out;





class Main {

    private static final String alphabet = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя.,\":-!? ";
    private static final String reAlphabet = " ?!-:\",.яюэьыъщшчцхфутсрпонмлкйизжёедгвба";
    private static final String[] words = {"робот", "работа", "сомне", "желание", "ребенок", "никуда", "элемент", "соврем", "голова", "равно", "исслед", "паста", "почему", "процесс", "самый", "сегодня", "стать", "большой", "интерес", "другой", "место", "пример", "источник", "горовор", "оказаться", "источн", "программа", "наблюд", "сделать", "сказа", "чтобы", "смотреть", "пользовател", "новый", "проект", "жизнь", "первый", "день", "спрос", "хотеть", "ничто", "потом", "очень", "вместе", "хотеть", "почти", "существ", "голова", "надо", "хорошо", "видеть", "идти", "теперь", "тоже", "стоять", "сторон", "главный", "сейчас", "можно", "после", "слово", "здесь", "думать"};


    private static char symbol_right_shift(char symbol, int shift) {
        if (alphabet.indexOf(symbol) != -1) {
            return alphabet.charAt((alphabet.indexOf(symbol) + shift) % alphabet.length());
        } else {
            return symbol;
        }
    }

    private static char symbol_left_shift(char symbol, int shift) {
        if (reAlphabet.indexOf(symbol) != -1) {
            return reAlphabet.charAt((reAlphabet.indexOf(symbol) + shift) % reAlphabet.length());
        } else {
            return symbol;
        }
    }

    public static void main(String[] args) {
        String content = null;
        String pathName0 = null;
        String pathName1 = null;
        Scanner console = new Scanner(System.in);


        out.println("Выберите действие: 1) Шифр 2) Дешифр 3) Brute Force");
        int choise = console.nextInt();
        console.nextLine();

        if (choise == 1) {
            out.println("Введите название файла который вы хотите зашифровать или нажмите ENTER чтобы использовать файл по умолчанию(input.txt): ");
            pathName0 = console.nextLine();
            out.println("Введите название файла куда вы хотите зашифровать или нажмите ENTER чтобы использовать файл по умолчанию(encoded.txt): ");
            pathName1 = console.nextLine();

            if (pathName0 == "") {

                String filePath = "input.txt";

                try {
                    content = readFile(filePath, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (pathName0 != "") {

                    String filePath = pathName0;

                    try {
                        content = readFile(filePath, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (pathName1 == ""){
                pathName1 = "encoded.txt";
            }else {
                if (pathName1 != ""){
                    pathName1 = pathName1;
                }
            }
        }
        if (choise == 2) {
            out.println("Введите название файла который вы хотите разшифровать или нажмите ENTER чтобы использовать файл по умолчанию(encoded.txt): ");
            pathName0 = console.nextLine();
            out.println("Введите название файла куда вы хотите зашифровать или нажмите ENTER чтобы использовать файл по умолчанию(output.txt): ");
            pathName1 = console.nextLine();

            if (pathName0 == "") {

                String filePath = "encoded.txt";

                try {
                    content = readFile(filePath, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (pathName0 != "") {

                    String filePath = pathName0;

                    try {
                        content = readFile(filePath, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (pathName1 == ""){
                pathName1 = "output.txt";
            }else {
                if (pathName1 != ""){
                    pathName1 = pathName1;
                }
            }
        }
        if (choise == 3) {
            out.println("Введите название файла который вы хотите разшифровать или нажмите ENTER чтобы использовать файл по умолчанию(encoded.txt): ");
            pathName0 = console.nextLine();
            out.println("Введите название файла куда вы хотите сохранить разшифровку или нажмите ENTER чтобы использовать файл по умолчанию(output.txt): ");
            pathName1 = console.nextLine();

            if (pathName0 == "") {

                String filePath = "encoded.txt";

                try {
                    content = readFile(filePath, StandardCharsets.UTF_8);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                if (pathName0 != "") {

                    String filePath = pathName0;

                    try {
                        content = readFile(filePath, StandardCharsets.UTF_8);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (pathName1 == ""){
                pathName1 = "output.txt";
            }else {
                if (pathName1 != ""){
                    pathName1 = pathName1;
                }
            }
        }

        out.println("Ваш текст: ");
        out.println(content);

        if ((choise == 1) || (choise == 2)) {
            out.println("Смещение 1) Вправо  2) Влево");
            int choiseSide = console.nextInt();
            console.nextLine();
            if (choise == 1) {
                out.println("Насколько символов вы хотите сместить?: ");
                int keyCode0 = Integer.parseInt(console.nextLine());
                int keyCode = keyCode0 + 1;
                Code(content, keyCode, choiseSide, pathName1);
            } else {
                out.println("Введите ключ: ");
                int keyCode0 = Integer.parseInt(console.nextLine());
                int keyCode = keyCode0 + 1;
                DeCode(content, keyCode, choiseSide, pathName1);
            }
        } else {
            BruteForce(content, pathName1);

        }
    }

    private static String readFile(String path, Charset encoding) throws IOException {
        return Files.readString(Paths.get(path), encoding);
    }

    private static void Code1(String content, int keyCode, String pathName1) {
        int kc = keyCode - 1;
        File file = new File(pathName1);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bf)) {
            content = content.toLowerCase();
            for (int i = kc; i < keyCode; i++) {
                for (int j = 0; j < content.length(); j++) {
                    out.print(symbol_right_shift(content.charAt(j), i));
                }
            }
            System.out.println("Ваш текст готов!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Code2(String content, int keyCode, String pathName1) {

        int kc = keyCode - 1;
        File file = new File(pathName1);

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bf)) {
            content = content.toLowerCase();
            for (int i = kc; i < keyCode; i++) {
                for (int j = 0; j < content.length(); j++) {
                    out.print(symbol_left_shift(content.charAt(j), i));
                }
            }
            System.out.println("Ваш текст готов!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void Code3(String content, int keyCode, String pathName1) {
        int kc = keyCode - 1;
        File file = new File(pathName1);
        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bf = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bf)) {
            content = content.toLowerCase();
            for (int i = kc; i < keyCode; i++) {
                for (int j = 0; j < content.length(); j++) {
                    out.print(symbol_right_shift(content.charAt(j), i));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = pathName1;

        try {
            content = readFile(filePath, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        BruteForce(content, pathName1);
    }

    private static void Code(String content, int keyCode, int choiseSide, String pathName1) {
        content = content.toLowerCase();
        if (choiseSide == 1) {
            Code1(content, keyCode, pathName1);
        } else {
            Code2(content, keyCode, pathName1);
        }

    }

    private static void DeCode(String content, int keyCode, int choiseSide, String pathName1) {
        content = content.toLowerCase();
        if (choiseSide == 1) {
            Code1(content, keyCode, pathName1);
        } else {
            Code2(content, keyCode, pathName1);
        }
    }

    private static void BruteForce(String content, String pathName1) {
        boolean b = false;
        int c = -1;
        do {
            c++;
            b = content.contains(words[c]);
        } while ((b != true) && (c < 62));
        if (c == 62) {
            Code3(content, 2 , pathName1);
        } else {
            Code1(content, 1, pathName1);
        }
    }
}