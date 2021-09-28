abstract public class Monster {
    //Переменные
    private String name;
    protected int hp; //Здоровье
    protected int power; //Сила

    //Геттеры
    public int getHp() {
        return hp;
    }
    public int getPower() {
        return power;
    }
    public String getName() {
        return name;
    }

    //Сеттеры
    public void setHp(int hp) {
        this.hp = hp;
    }
    public void setPower(int power) {
        this.power = power;
    }
    public void setName(String name) {
        this.name = name;
    }

    //Методы
    abstract public void attack(Hero hero); //Атака
    abstract public void scream(); //Крик
}
