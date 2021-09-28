public class Goblin extends Monster {
    //Абстрактные методы
    @Override
    public void attack(Hero hero) {
        hero.setHp(hero.getHp() - getPower());
        System.out.println(getName() + " нанес вам " + getPower() + " урона");
    } //Атака

    @Override
    public void scream() {
        System.out.println("Гхуууагрх!");
    } //Крик

    public Goblin(int hp, int power) {
        super.setName("Гоблин");
        super.hp = hp;
        super.power = power;
    }
}
