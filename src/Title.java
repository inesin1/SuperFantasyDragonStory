import java.util.Scanner;

public class Title {
    Scanner scanner = new Scanner(System.in);

    private String command;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void start(Tavern tavern) {
        boolean isCorrect = false;

        System.out.println("--------------------------------\n" +
                "---Super Fantasy Dragon Story---\n" +
                "--------------------------------\n" +
                "------------Старт(1)------------\n" +
                "------------Выход(2)------------\n" +
                "--------------------------------");

        do {
            System.out.print("Команда: ");
            setCommand(scanner.next());

            switch (command) {
                case "1":
                    createHero();
                    story();
                    tavern.go();
                    isCorrect = true;
                    break;
                case "2":
                    isCorrect = true;
                    return;

                default:
                    System.out.println("Неизвестная команда");
                    isCorrect = false;
                    break;
            }
        } while (!isCorrect);
    }

    private void story() {
        System.out.println("--------------------------------\n" +
                "------------История-------------\n" +
                "--------------------------------\n" +
                "Дракон захватил короля, освободите его!\n" +
                "--------------------------------\n" +
                "----------Продолжить(1)---------\n" +
                "--------------------------------");

        System.out.print("Команда: ");
        setCommand(scanner.next());

        if (getCommand() == "1") return;
    }

    private void createHero() {
        System.out.print("--------------------------------\n" +
                "------------Имя героя: ");
        World.getHero().setName(scanner.next());
    }
}
