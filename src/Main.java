public class Main {
    public static void main(String[] args) {
        // === สร้างตัวละครสายกายภาพ ===
        RPGCharacter warrior = new RPGCharacter("Warrior", 1, 20, 10, 100, 15, 12, 15, 8, 8, 8);
        Sword warriorSword = new Sword("Iron Sword", 1);
        PlateArmor warriorArmor = new PlateArmor("Steel Plate Armor", 1);
        warrior.equipWeapon(warriorSword);
        warrior.equipArmor(warriorArmor);

        // === สร้างตัวละครสายเวทย์ ===
        RPGCharacter mage = new RPGCharacter("Mage", 1, 8, 5, 100, 8, 10, 10, 15, 12, 15);
        Staff mageStaff = new Staff("Wooden Staff", 1);
        LeatherArmor mageArmor = new LeatherArmor("Mage Robe", 3);
        mage.equipMagicAccessory(mageStaff);
        mage.equipArmor(mageArmor);

        // === แสดงสถานะเริ่มต้น ===
        System.out.println("=== Initial Stats ===");
        System.out.println(warrior);
        System.out.println(mage);

        // === ตัวละครสายกายภาพโจมตี ===
        System.out.println("\n=== Warrior Attacks ===");
        warrior.attack(mage);

        // === ตัวละครสายเวทย์ร่ายเวทย์ ===
        System.out.println("\n=== Mage Casts Spell ===");
        Spell fireball = new Spell();
        mage.castSpell(fireball, warrior);

        // === ตัวละครสายกายภาพใช้ Skill ===
        System.out.println("\n=== Warrior Uses Skill ===");
        Skill heavySlash = new HeavySlash();
        warrior.useSkill(heavySlash, mage);
        System.out.println(mage);

        // === ตัวละครสายเวทย์ฟื้นฟู Mana ===
        System.out.println("\n=== Mage Meditates ===");
        mage.meditate();

        // === แสดงสถานะหลังจากต่อสู้ ===
        System.out.println("\n=== Stats After Battle ===");
        System.out.println(warrior);
        System.out.println(mage);
    }
}