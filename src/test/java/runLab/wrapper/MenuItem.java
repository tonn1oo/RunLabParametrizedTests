package runLab.wrapper;

public enum MenuItem {
    Man("Мужчины"),
    Wman("Женщины"),
    Nutr("Питание"),
    Phar("Спортивная аптека"),
    Acce("Аксессуары"),
    Watc("Спортивные часы"),
    Sert("Сертификаты"),
    Tren("Тренды");
    public final String rusName;

    MenuItem(String rusName) {
        this.rusName = rusName;
    }
}
