import java.util.Scanner;

class Battle {
    MainHero hero;
    FantasyCharacter enemy = getMonster();

    public Battle(MainHero hero) {
        this.hero = hero;
    }


    // метод для определения случайного монстра-противника
    public FantasyCharacter getMonster() {
        FantasyCharacter enemy;

        // создаем монстра-противника случайным образом
        int monsterProbability = (int) (Math.random() * 10);

        if (monsterProbability % 2 == 0)
            enemy = new Goblin("Goblin", 20, 18, 6, 7, 12);
        else
            enemy = new Skeleton("Skeleton", 15, 12, 5, 4, 9);

        return enemy;
    }

    // битва
    void BattleShip(FantasyCharacter enemy) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Ваш противник: " + enemy);
                System.out.println("Битва началась!");

                boolean flag = true;

                // пока герой или монстр живы
                while (hero.isAlive() && enemy.isAlive()) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // если герой еще жив
                    if (hero.isAlive() && flag)
                        // атакует монстра
                        hero.attack(enemy);
                        // иначе выход из боя
                    else
                        flag = false;

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    // если монстр еще жив
                    if (enemy.isAlive() && flag)
                        // атакует героя
                        enemy.attack(hero);
                    else
                        // иначе выход из боя
                        flag = false;
                }
            }
        });

        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        winner();
    }


    // победитель
    void winner() {
        //если победитель - герой
        if (hero.isAlive()) {
            System.out.println(hero.getCharacterName() + " победил!");
            hero.setCharacterExperience(5); // +5 опыта
            hero.setCharacterGold(enemy.getCharacterGold()); // + все золота от противника
            hero.setCharacterDexterity(1); // +1 ловкость
            hero.setCharacterForce(1); // + 1 ловкость
            // выводим новые данные героя
            System.out.println(hero.getCharacterName() +
                    " Здоровье: " + hero.getCharacterHealth() +
                    " Золото: " + hero.getCharacterGold() +
                    " Сила: " + hero.getCharacterForce() +
                    " Ловкость: " + hero.getDexterity() +
                    " Опыт: " + hero.getCharacterExperience());
            // продолжаем битву или возвращаемся в город
            PlayingGame.continueBattle();
        } else {
            // Game over
            System.out.println(enemy.getCharacterName() + " победил!\nИгра окончена!");
        }
    }
}
