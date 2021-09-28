import java.util.Random;
import java.util.Scanner;

public class Battle {
    //Запрос команды
    Scanner scanner = new Scanner(System.in);
    private String command;
    public String getCommand() {
        return command;
    }
    public void setCommand(String command) {
        this.command = command;
    }

    //Старт
    public void start() {
        boolean isContinue = false;
        boolean isReturn = false;
        Random random = new Random();
        Monster monster;

        System.out.println("---Начало боя!---");

        do {
            //Случайный выбор противника
            int chooseMonster = random.nextInt(2);
            switch (chooseMonster) {
                case 0:
                    monster = new Goblin(30, 6);
                    break;
                case 1:
                    monster = new Skeleton(20, 10);
                    break;
                default:
                    monster = new Goblin(30, 6);
                    break;
            }

            //Бой
            fight(monster);

            //Выбор дальнейших действий
            do {
                System.out.println("\nВ бой!(1)   Таверна(2)   Герой(3)   Зелье(4)");
                System.out.print("Команда: ");
                setCommand(scanner.next());
                switch (getCommand()) {
                    case "1":
                        isContinue = true;
                        isReturn = false;
                        break;
                    case "2":
                        World.getTavern().go();
                        isContinue = false;
                        isReturn = false;
                        break;
                    case "3":
                        World.getHero().info();

                        //Выбор действия
                        System.out.println("Назад(1)");
                        System.out.print("Команда:");
                        setCommand(scanner.next());
                        if (getCommand().equals("1")) isReturn = true;
                        break;
                    case "4":
                        if (World.getHero().isHasHealthPotion()) {World.getHero().setHp(World.getHero().getHp() + 30); System.out.println("Вы использовали живительное зелье!\nВосстановлено 30 единиц здоровья"); isReturn = true;}
                        else {System.out.println("У вас нет зелья! Купите его у торговца"); isReturn = true;}
                        break;
                    default:
                        System.out.println("Что-что?");
                }
            } while (isReturn);
        } while (isContinue);
    }

    //Бой
    private void fight(Monster monster) {
        boolean isEnemyDead = false;
        boolean isHeroDead = false;
        boolean isInfo = false;

        System.out.println("На вас напал " + monster.getName());
        do {
            if (!isInfo) monster.attack(World.getHero()); //Если в предыдущей итерации игрой вызывал инфо, то монстр не бьет, так как это все еще ход игрока
            isInfo = false;

            if (World.getHero().getHp() <= 0) {
                isHeroDead = true;
                System.out.println("Вы погибли...");
                System.out.println("Игра окончена.");
            }//Смерть игрока

            //Выбор действия
            System.out.println("Атака(1)   Сбежать(2)   Герой(3)   Зелье(4)");
            System.out.println("Команда:");
            setCommand(scanner.next());

            //Действия в зависимости от выбора
            switch (getCommand()) {
                case "1":
                    World.getHero().attack(monster);
                    if (monster.getHp() >= 0) System.out.println("Здровье " + monster.getName() + ": " + monster.getHp());
                    if (monster.getHp() <= 0) {
                        isEnemyDead = true;
                        monster.scream();
                        System.out.println(monster.getName() + " убит!\nПолучено 15 монет и 10 опыта");
                        World.getHero().setGold(World.getHero().getGold() + 15);
                        World.getHero().setExp(World.getHero().getExp() + 10);
                        return;
                    }//Смерть супостата
                    break;
                case "2":
                    if (World.getHero().getGold() >= 10) {
                        System.out.println("Вы смогли сбежать, но по дороге потеряли 10 монет");
                        World.getHero().setGold(World.getHero().getGold() - 10);
                    } //Отнимаем 10 монет, если они есть
                    World.getTavern().go(); //Идем в таверну
                    break;
                case "3":
                    World.getHero().info();

                    //Выбор действия
                    System.out.println("Назад(1)");
                    System.out.print("Команда:");
                    setCommand(scanner.next());
                    if (getCommand().equals("1")) isInfo = true;
                    break;
                case "4":
                    if (World.getHero().isHasHealthPotion()) World.getHero().setHp(World.getHero().getHp() + 30);
                    else System.out.println("У вас нет зелья! Купите его у торговца");
                    break;
                default:
                    System.out.println("Что-что?");
            }
        } while (!isEnemyDead || !isHeroDead);
    }
}
