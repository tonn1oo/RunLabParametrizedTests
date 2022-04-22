package runLab.wrapper;

public enum MenuItem {
    MAN("Мужчины"),
    WMAN("Женщины"),
    NUTR("Питание"),
    PHAR("Спортивная аптека"),
    ACCE("Аксессуары"),
    WATC("Спортивные часы"),
    SERT("Сертификаты"),
    TREN("Тренды");
    public final String rusName;

    MenuItem(String rusName) {
        this.rusName = rusName;
    }
}
