public class World {
    /*
    Небольшое предисловие для менторов, проверяющих данный код и всех остальных. Я понимаю, что игра еще требует большого количества
    доработок, и здесь даже не реализована финальная битва с драконом, ради победы над которым по сути и играем. Я еще буду это все
    реализовывать обязательно, мне очень понравилось работать над этой игрой и я хочу сделать из данного проекта полноценную рабочую игру,
    хоть и текстовую. Но на это нужно больше времени, я не успел за выделенное время реализовать все, что запланировать и старался
    хотя бы сделать то, что необходимо в задании. Так что прошу не судить строго, я правда очень старался, использовал знания, полученные в модулях
    по максимуму и вложил в это дело душу :)
     */
    //Объекты
    private static Hero hero = new Hero("Ланселот", 100, 0, 50, 0, 10, false);
    private static Title title = new Title();
    private static Tavern tavern = new Tavern();
    private static Battle battle = new Battle();

    //Геттеры
    public static Hero getHero() {
        return hero;
    }
    public static Title getTitle() {
        return title;
    }
    public static Tavern getTavern() {
        return tavern;
    }
    public static Battle getBattle() {
        return battle;
    }

    public void start() {
        title.start(tavern);
    }

    public void end() {
        //Конец игры
    }
}
