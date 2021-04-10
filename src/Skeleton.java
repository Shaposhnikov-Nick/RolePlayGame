class Skeleton extends FantasyCharacter implements Fighter{

    public Skeleton(String characterName, int characterHealth, int characterExperience, int characterGold,
                    int characterForce, int characterDexterity) {
        super(characterName, characterHealth, characterExperience, characterGold, characterForce, characterDexterity);
    }

    @Override
    public void attack(FantasyCharacter hero) {
        // обычный удар
        if(this.getDexterity() * 3 > Math.random()*100) {
            hero.damage(-this.getCharacterForce());
            System.out.println(this.getCharacterName() + " нанес удар силой " + this.getCharacterForce());
        } else {
            // слабый удар
            hero.damage(-this.getCharacterForce() / 2);
            System.out.println(this.getCharacterName() + " нанес удар силой " + this.getCharacterForce() / 2);
        }

        // если герой еще жив, выводим последствия удара
            if (hero.isAlive())
                System.out.println("Здоровье " + hero.getCharacterName() + " " + hero.getCharacterHealth() + "\n");
            else
                // либо сообщение о гибели
                System.out.println(hero.getCharacterName() + " убит!\n");

        }
    }

