public class Hero {
    //Переменные
    private String name; //Имя
    private int hp; //Здоровье
    private int gold; //Золото
    private int skill; //Ловкость
    private int exp; //Опыт
    private int power; //Сила
    private boolean hasHealthPotion; //Имеет ли живительное зелье

    public Hero(String name, int hp, int gold, int skill, int exp, int power, boolean hasHealthPotion) {
        this.name = name;
        this.hp = hp;
        this.gold = gold;
        this.skill = skill;
        this.exp = exp;
        this.power = power;
        this.hasHealthPotion = hasHealthPotion;
    }

    //Геттеры
    public String getName() {
        return name;
    }
    public int getHp() {
        return hp;
    }
    public int getGold() {
        return gold;
    }
    public int getSkill() {
        return skill;
    }
    public int getExp() {
        return exp;
    }
    public int getPower() {
        return power;
    }
    public boolean isHasHealthPotion() {
        return hasHealthPotion;
    }

    //Сеттеры
    public void setName(String name) {
        this.name = name;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setSkill(int skill) {
        this.skill = skill;
    }
    public void setExp(int exp) {
        this.exp = exp;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setHasHealthPotion(boolean hasHealthPotion) {
        this.hasHealthPotion = hasHealthPotion;
    }

    //Методы
    public void attack(Monster monster) {
        monster.setHp(monster.getHp() - getPower());
        System.out.println("Вы нанесли " + getPower() + " урона " + monster.getName());
    } //Атака

    public void info() {
        System.out.println("---Герой---\n" +
                "Имя: " + getName() + "\n" +
                "Здоровье: " + getHp() + "\n" +
                "Золото: " + getGold() + "\n" +
                "Ловкость: " + getSkill() + "\n" +
                "Опыт: " + getExp() + "\n" +
                "Сила: " + getPower());
        System.out.println("-----------");
    }
}
