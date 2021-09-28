import java.util.Scanner;

public class Tavern {
    Scanner scanner = new Scanner(System.in);

    //Переменные
    private String command;

    //Геттеры
    public String getCommand() {
        return command;
    }

    //Сеттеры
    public void setCommand(String act) {
        this.command = act;
    }

    public void go() {
        boolean isCorrect = false;

        System.out.println("---Вы в таверне---\n" +
                "Дядя Люк (1)[Пока не работает]   Торговец (2)   В бой(3)   Герой(4)\n" +
                "--------------------------------");

        do {
            System.out.print("Команда: ");

            setCommand(scanner.next());

            switch (getCommand()) {
                /*case "1":
                    uncleLouk();
                    isCorrect = true;
                    break;*/
                case "2":
                    trader();
                    isCorrect = true;
                    break;
                case "3":
                    World.getBattle().start();
                    isCorrect = true;
                    break;
                case "4":
                    World.getHero().info();

                    //Выбор действия
                    System.out.println("Назад(1)");
                    System.out.print("Команда:");
                    setCommand(scanner.next());
                    if (getCommand().equals("1")) World.getTavern().go();

                    isCorrect = true;
                    break;

                default:
                    System.out.println("Я не расслышал..Повтори ка еще разок?");
                    isCorrect = false;
                    break;
            }
        } while (!isCorrect);
    }

    //Варианты
    private void uncleLouk() {
        System.out.println("Ооо, здравствуй, мальчик мой! Садись, расскажу тебе историю...");
        //Разные истории, реализовать не успел еще
    }

    private void trader() {
        System.out.println("------------Торговец------------\n" +
                "Здравствуй храбрый герой! Чего желаешь?\n" +
                "--------------------------------\n" +
                "Живительное зелье(1)[20 золота]   Зелье силы(2)[Пока не работает]   Зелье удачи(3)[Пока не работает]\n" +
                "Назад(4)\n" +
                "--------------------------------");
        //Выбор действия
        System.out.print("Команда: ");
        setCommand(scanner.next());

        switch (getCommand()) {
            case "1":
                if ((World.getHero().getGold() >= 20) && (!World.getHero().isHasHealthPotion())) World.getHero().setHasHealthPotion(true);
                else {System.out.println("Нет-нет, друг, так не пойдет."); trader();}
                break; //Даем зелье герою, если у него хвататет золота и еще нет этого зелья (может хранить только одно, карманы маленькие)
            case "2": break;
            case "3": break;
            case "4": go();
        }
/*
        System.out.println("--------------------------------\n" +
                "Назад(1)\n" +
                "--------------------------------");

        //Выбор действия
        System.out.print("Команда: ");
        setCommand(scanner.next());

        switch (getCommand()) {
            case "1": World.getTavern().go(); break;
            case "2": //Остаться
        }*/
    }
}
