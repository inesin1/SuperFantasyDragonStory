public class Skeleton extends Monster {
    @Override
    public void attack(Hero hero) {
        hero.setHp(hero.getHp() - getPower());
        System.out.println(getName() + " нанес вам " + getPower() + " урона");
    } //Атака

    @Override
    public void scream() {
        System.out.println("Склхтхт!");
    } //Крик

    public Skeleton(int hp, int power) {
        super.setName("Скелетон");
        super.hp = hp;
        super.power = power;
    }
}
