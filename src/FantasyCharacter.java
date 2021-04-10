abstract class FantasyCharacter {
    private String characterName;
    private int characterHealth;
    private int characterExperience;
    private int characterGold;
    private int characterForce;
    private int characterDexterity;

    // конструктор для главного героя
    public FantasyCharacter(String heroName) {
        if (heroName == "")
            this.characterName = "Hero";
        else
            this.characterName = heroName;

        this.characterHealth = 100;
        this.characterExperience = 0;
        this.characterGold = 5;
        this.characterForce = 10;
        this.characterDexterity = 8;
    }

    // конструктор для монстров
    public FantasyCharacter(String characterName, int characterHealth, int characterExperience, int characterGold, int characterForce, int characterDexterity) {
        this.characterName = characterName;
        this.characterHealth = (int) (characterHealth + Math.random() * 50);
        this.characterExperience = (int) (characterExperience + Math.random() * 10);
        this.characterGold = (int) (characterGold + Math.random() * 10);
        this.characterForce = (int) (characterForce + Math.random() * 10);
        this.characterDexterity = (int) (characterDexterity + Math.random() * 10);
    }

    // Геттеры
    public String getCharacterName() {
        return characterName;
    }

    public int getCharacterHealth() {
        return characterHealth;
    }

    public int getCharacterExperience() {
        return characterExperience;
    }

    public int getCharacterGold() {
        return characterGold;
    }

    public int getCharacterForce() {
        return characterForce;
    }

    public int getDexterity() {
        return characterDexterity;
    }

    // Сеттеры

    public void setCharacterHealth(int value) {
        this.characterHealth += value;
    }

    public void setCharacterExperience(int characterExperience) {
        this.characterExperience += characterExperience;
    }

    public void setCharacterGold(int characterGold) {
        this.characterGold += characterGold;
    }

    public void setCharacterForce(int characterForce) {
        this.characterForce += characterForce;
    }

    public void setCharacterDexterity(int characterDexterity) {
        this.characterDexterity += characterDexterity;
    }

    // проверям, жив ли персонаж
    public boolean isAlive() {
        return this.getCharacterHealth() > 0;
    }

    // атака
    public abstract void attack(FantasyCharacter fantasyCharacter);

    // урон
    void damage(int force) {
        this.setCharacterHealth(force);
    }

    @Override
    public String toString() {
        return
                "Имя: " + characterName +
                        ", Жизнь: " + characterHealth +
                        ", Опыт: " + characterExperience +
                        ", Золото: " + characterGold +
                        ", Сила: " + characterForce +
                        ", Ловкость: " + characterDexterity;
    }


}
