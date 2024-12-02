class RPGCharacter implements MeleeCharacter, MagicCharacter {
    private final String name;
    private int level;
    private int currentHp;
    private int currentMana;
    private final int baseDamage;
    private final int baseDefense;
    private final double baseRunSpeed;
    private Weapon weapon;
    private Armor armor;
    private int strength;
    private int dexterity;
    private int constitution;
    private int intelligence;
    private int wisdom;
    private int spirit;
    private MagicAccessory magicAccessory;


    public RPGCharacter(String name, int level, int baseDamage, int baseDefense, double baseRunSpeed, int strength,
                        int dexterity, int constitution, int intelligence, int wisdom, int spirit) {
        this.name = name;
        this.level = level;
        this.baseDamage = baseDamage;
        this.baseDefense = baseDefense;
        this.baseRunSpeed = baseRunSpeed;
        this.strength = strength;
        this.dexterity = dexterity;
        this.constitution = constitution;
        this.intelligence = intelligence;
        this.wisdom = wisdom;
        this.spirit = spirit;
        this.currentHp = getMaxHp();
        this.currentMana = getMaxMana();
    }

    public RPGCharacter(String name) {
        this(name, 1, 10, 5, 100, 10, 10, 10, 10, 10, 10);
    }

    public int getMaxHp() {
        return 100 + (10 * level) + (5 * constitution);
    }

    public int getMaxMana() {
        return 50 + (2 * level) + (5 * wisdom);
    }

    public double getDamage() {
        double damage = baseDamage + strength;
        if (weapon != null) {
            damage *= (1 + 0.1 * weapon.getAttackPower());
        }
        return damage;
    }

    public double getDefense() {
        double defense = baseDefense + (constitution / 2);
        if (armor != null) {
            defense *= (1 + 0.05 * armor.getDefensePower());
        }
        return defense;
    }

    public double getRunSpeed() {
        double speed = baseRunSpeed * (0.1 + 0.03 * level) + (dexterity / 5);
        if (weapon != null) {
            speed -= baseRunSpeed * (0.1 + 0.04 * weapon.getAttackSpeed());
        }
        if (armor != null) {
            speed -= baseRunSpeed * (0.1 + 0.08 * armor.getWeight());
        }
        return speed;
    }

    public void levelUp() {
        level++;
        currentHp = getMaxHp();
        currentMana = getMaxMana();
    }

    public void equipWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void equipArmor(Armor armor) {
        this.armor = armor;
    }

    public void equipMagicAccessory(MagicAccessory accessory) {
        this.magicAccessory = accessory;
    }

    @Override
    public String toString() {
        return "RPGCharacter{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", currentHp=" + currentHp +
                ", currentMana=" + currentMana +
                ", damage=" + getDamage() +
                ", defense=" + getDefense() +
                ", runSpeed=" + getRunSpeed() +
                '}';
    }

    // === Implement MeleeCharacter ===
    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public int getConstitution() {
        return constitution;
    }

    @Override
    public void attack(RPGCharacter target) {
        double damageDealt = this.getDamage() - target.getDefense();
        if (damageDealt > 0) {
            target.currentHp -= damageDealt;
            System.out.println(this.getName() + " attacked " + target.getName() + " for " + damageDealt + " damage!");

            // ลดความทนทานของชุดเกราะของ target
            if (target.armor != null) {
                int currentDurability = target.armor.getDurability();
                currentDurability -= damageDealt / 2;
                //  target.armor.setDurability(currentDurability);
                System.out.println(target.getName() + "'s armor durability reduced to " + target.armor.getDurability());
            }

            if (target.currentHp <= 0) {
                System.out.println(target.getName() + " is defeated!");
            }
        } else {
            System.out.println(this.getName() + " attacked " + target.getName() + " but dealt no damage.");
        }
    }

    @Override
    public void defend() {
        System.out.println(this.getName() + " is defending!");
    }

    @Override
    public void useSkill(Skill skill, RPGCharacter target) {
        skill.use(this, target); // เรียกใช้ use() method ของ Skill
    }

    // === Implement MagicCharacter ===
    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getWisdom() {
        return wisdom;
    }

    @Override
    public int getSpirit() {
        return spirit;
    }

    @Override
    public void castSpell(Spell spell, RPGCharacter target) {
        if (currentMana >= spell.getManaCost()) {
            currentMana -= spell.getManaCost();
            spell.cast(this, target); // เรียกใช้ cast() method ของ Spell
        } else {
            System.out.println(this.getName() + " does not have enough mana to cast " + spell.getName() + "!");
        }
    }

    @Override
    public void meditate() {
        currentMana = getMaxMana(); // ฟื้นฟู Mana ให้เต็ม
        System.out.println(this.getName() + " is meditating... Mana restored to full.");
    }

    public String getName() { // เพิ่มเมธอด getName()
        return name;
    }
}

// === Interfaces ===

interface MeleeCharacter {
    int getStrength();
    int getDexterity();
    int getConstitution();
    void attack(RPGCharacter target);
    void defend();
    void useSkill(Skill skill, RPGCharacter target);
}

interface MagicCharacter {
    int getIntelligence();
    int getWisdom();
    int getSpirit();
    void castSpell(Spell spell, RPGCharacter target);
    void meditate();
}

interface Weapon {
    int getAttackPower();
    double getAttackSpeed();
    int getDurability();
    void enhance();
}


interface MagicAccessory {
    int getMagicPower();
    int getManaCapacity();
    int getSpellCooldownReduction();
    void infuseMana(int mana);
    void enhanceMagicPower();
}

// === Skill and Spell Classes ===

// ===  Skill class ===
class Skill {
    private String name;

    public Skill(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // เพิ่มเมธอด use() ใน Skill class
    public void use(RPGCharacter user, RPGCharacter target) {
        System.out.println(user.getName() + " used " + this.getName() + " on " + target.getName() + "!");
        //  ในอนาคต  สามารถเพิ่ม logic การคำนวณ damage,  ผลของ skill  ฯลฯ ได้ที่นี่
    }
}

// ===  HeavySlash class (สืบทอดจาก Skill) ===
class HeavySlash extends Skill {
    public HeavySlash() {
        super("Heavy Slash");
    }
}

// ===  Spell class ===
class Spell {
    private String name;
    private int manaCost;

    public Spell() {
        this.name = "Fireball";
        this.manaCost = 30;
    }

    public int getManaCost() {
        return manaCost;
    }

    public void cast(RPGCharacter caster, RPGCharacter target) {
        System.out.println(caster.getName() + " ร่าย " + name + " ใส่ " + target.getName() + "!");
    }

    public String getName() {
        return name;
    }
}


