import java.util.Scanner;

public class PlayingGame {
    static MainHero hero;

    public static void main(String[] args) {
        hero = createHero();

        startGame(hero);
    }

    // старт игры
    private static void startGame(MainHero hero) {
        boolean startGame = true;

        while (startGame) {
            int choice = 0;

            Scanner scanner = new Scanner(System.in);
            System.out.println("Куда вы хотите пойти?\n1. К торговцу\n2. В Темный лес\n3. Выход");
            if (scanner.hasNextInt())
                choice = scanner.nextInt();
            else
                System.out.println("Неверный выбор!");


            switch (choice) {
                case (1):
                    saleStart();
                    break;
                case (2):
                    battleStart(hero);
                    if(!hero.isAlive())
                        startGame = false;
                    break;
                case (3):
                    System.out.println("Удачи!");
                    startGame = false;
                    break;
                default:
                    System.out.println("Неверный выбор!");
                    break;
            }

        }
    }

    // создаем нового героя
    static MainHero createHero(){
        String heroName;

        System.out.println("Введите имя персонажа");
        Scanner scanner = new Scanner(System.in);
        heroName = scanner.nextLine();

        MainHero hero = new MainHero(heroName);

        System.out.println(hero);
        return  hero;
    }

    // начало битвы
    static  void battleStart(MainHero hero){
        Battle battle = new Battle(hero);

        battle.BattleShip(battle.getMonster());

    }

    // создание торговца
    static void saleStart(){
        Dealer dealer = new Dealer("Gendalf");
        Sale sale = new Sale(hero, dealer);
        sale.sell(hero);

    }

    // продолжение битвы или возвращение в город
    static void continueBattle(){
        System.out.println("1 - Продолжить бой\n2 - Вернуться в город");
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextInt()){
            case 1:
                battleStart(hero);
                break;
            case 2:
                break;
            default:
                System.out.println("Неверный выбор!");
                break;
        }
    }

}
