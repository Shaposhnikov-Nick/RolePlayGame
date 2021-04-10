import java.util.Scanner;

class Sale implements Sell {
    private MainHero hero;
    private Dealer dealer;

    // конструктор
    public Sale(MainHero hero, Dealer dealer) {
        this.hero = hero;
        this.dealer = dealer;
    }

    // покупка восстановления здоровья
    public void sell(MainHero hero) {
        int treatment = 0;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Восстановление здоровья стоит 20 золота. У вас есть " + hero.getCharacterGold());
        System.out.println("Купить лечение?\n1 - Да\n2 - Нет");

        if (scanner.hasNextInt())
            treatment = scanner.nextInt();
        else
            System.out.println("Неверное значение!");

        switch (treatment) {
            case (1):
                // если у героя достаточно золота
                if (hero.getCharacterGold() > 20) {
                    hero.setCharacterHealth(100 - hero.getCharacterHealth()); // увеличивааем жизнь до 100
                    hero.setCharacterGold(-20); // отдаем золото
                    System.out.println("Здоровье " + hero.getCharacterName() + " восстановлено!");
                    System.out.println("У вас осталось " + hero.getCharacterGold() + " золота");
                } else
                    // иначе не покупаем
                    System.out.println("Недостаточно золота!");
                break;
            case (2): // возвращаемся в город
            default:
                break;
        }
    }
}
