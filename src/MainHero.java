class MainHero extends FantasyCharacter implements Fighter{


    public MainHero(String heroName) {
        super(heroName);
    }

/*
сила удара зависит от ловкости. Ловкость растет после каждой битвы на 2.
 */
    @Override
    public void attack(FantasyCharacter enemy) {

        // обычный удар
        if(this.getDexterity() * 3 > Math.random()*100) {
            enemy.damage(-this.getCharacterForce());
            System.out.println(this.getCharacterName() + " нанес удар силой " + this.getCharacterForce());

        } else {
            // слабый удар
            enemy.damage(-this.getCharacterForce() / 2);
            System.out.println(this.getCharacterName() + " нанес удар силой " + this.getCharacterForce());
        }
            // если герой еще жив, выводим последствия удара
            if (enemy.isAlive())
                System.out.println("Здоровье " + enemy.getCharacterName() + " " + enemy.getCharacterHealth() + "\n");
            else
            // либо сообщение о гибели
                System.out.println(enemy.getCharacterName() + " убит!\n");
        }
}
