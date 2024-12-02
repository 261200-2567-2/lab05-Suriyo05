// === Magic Accessories ===

class Staff implements MagicAccessory {
    private String name;
    private int level;

    public Staff(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }

    @Override
    public int getMagicPower() {
        return 10 * level;
    }

    @Override
    public int getManaCapacity() {
        return 20 * level;
    }

    @Override
    public int getSpellCooldownReduction() {
        return 5 * level;
    }

    @Override
    public void infuseMana(int mana) {
        System.out.println("Staff infused with " + mana + " mana!");
    }

    @Override
    public void enhanceMagicPower() {
        this.levelUp();
        System.out.println("Staff enhanced to level " + this.getLevel() + "!");
    }
}

class Wand extends Equipment implements MagicAccessory {
    public Wand(String name, int level) {
        super(name, level);
    }

    @Override
    public int getMagicPower() {
        return 5 + 3 * this.getLevel();
    }

    @Override
    public int getManaCapacity() {
        return 10 + 5 * this.getLevel();
    }

    @Override
    public int getSpellCooldownReduction() {
        return 2 + this.getLevel();
    }

    @Override
    public void infuseMana(int mana) {
        System.out.println("Wand infused with " + mana + " mana!");
    }

    @Override
    public void enhanceMagicPower() {
        this.levelUp();
        System.out.println("Wand enhanced to level " + this.getLevel() + "!");
    }
}

class Amulet extends Equipment implements MagicAccessory {
    public Amulet(String name, int level) {
        super(name, level);
    }

    @Override
    public int getMagicPower() {
        return 2 + this.getLevel();
    }

    @Override
    public int getManaCapacity() {
        return 5 + 2 * this.getLevel();
    }

    @Override
    public int getSpellCooldownReduction() {
        return 1 + this.getLevel();
    }

    @Override
    public void infuseMana(int mana) {
        System.out.println("Amulet infused with " + mana + " mana!");
    }

    @Override
    public void enhanceMagicPower() {
        this.levelUp();
        System.out.println("Amulet enhanced to level " + this.getLevel() + "!");
    }
}