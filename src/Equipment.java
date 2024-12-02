// === Classes for Equipment, Weapons, Armors, Magic Accessories ===
class Equipment {
    private String name;
    private int level;

    public Equipment(String name, int level) {
        this.name = name;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public void levelUp() {
        level++;
    }
}

// === Weapons ===

class Sword extends Equipment implements Weapon {
    private int durability; // เพิ่มตัวแปร durability

    public Sword(String name, int level) {
        super(name, level);
        this.durability = 100 + 20 * this.getLevel(); // กำหนดค่าเริ่มต้นให้ durability
    }

    @Override
    public int getAttackPower() {
        return 10 + 5 * this.getLevel();
    }

    @Override
    public double getAttackSpeed() {
        return 1.0 + 0.1 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void enhance() {
        this.levelUp();
        System.out.println("Sword enhanced to level " + this.getLevel() + "!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}

class Axe extends Equipment implements Weapon {
    private int durability; // เพิ่มตัวแปร durability

    public Axe(String name, int level) {
        super(name, level);
        this.durability = 150 + 30 * this.getLevel(); // กำหนดค่าเริ่มต้นให้ durability
    }

    @Override
    public int getAttackPower() {
        return 20 + 10 * this.getLevel();
    }

    @Override
    public double getAttackSpeed() {
        return 0.8 + 0.05 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void enhance() {
        this.levelUp();
        System.out.println("Axe enhanced to level " + this.getLevel() + "!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}

class Bow extends Equipment implements Weapon {
    private int durability; // เพิ่มตัวแปร durability

    public Bow(String name, int level) {
        super(name, level);
        this.durability = 100 + 15 * this.getLevel(); // กำหนดค่าเริ่มต้นให้ durability
    }

    @Override
    public int getAttackPower() {
        return 15 + 7 * this.getLevel();
    }

    @Override
    public double getAttackSpeed() {
        return 1.2 + 0.15 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void enhance() {
        this.levelUp();
        System.out.println("Bow enhanced to level " + this.getLevel() + "!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}

// === Armors ===

interface Armor {
    int getDefensePower();
    int getWeight();
    int getDurability(); // เพิ่มเมธอด getDurability() ใน interface
    void repair();
}

class Shield extends Equipment implements Armor {
    private int durability;

    public Shield(String name, int level) {
        super(name, level);
        this.durability = 50 + 10 * this.getLevel();
    }

    @Override
    public int getDefensePower() {
        return 5 + 2 * this.getLevel();
    }

    @Override
    public int getWeight() {
        return 10 + 5 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void repair() {
        this.durability = 50 + 10 * this.getLevel();
        System.out.println("Shield repaired!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}

class PlateArmor extends Equipment implements Armor {
    private int durability;

    public PlateArmor(String name, int level) {
        super(name, level);
        this.durability = 200 + 40 * this.getLevel();
    }

    @Override
    public int getDefensePower() {
        return 15 + 7 * this.getLevel();
    }

    @Override
    public int getWeight() {
        return 30 + 10 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void repair() {
        this.durability = 200 + 40 * this.getLevel();
        System.out.println("Plate Armor repaired!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}

class LeatherArmor extends Equipment implements Armor {
    private int durability;

    public LeatherArmor(String name, int level) {
        super(name, level);
        this.durability = 80 + 10 * this.getLevel();
    }

    @Override
    public int getDefensePower() {
        return 8 + 3 * this.getLevel();
    }

    @Override
    public int getWeight() {
        return 5 + 2 * this.getLevel();
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void repair() {
        this.durability = 80 + 10 * this.getLevel();
        System.out.println("Leather Armor repaired!");
    }

    // เพิ่ม setter method สำหรับ durability
    public void setDurability(int durability) {
        this.durability = durability;
    }
}