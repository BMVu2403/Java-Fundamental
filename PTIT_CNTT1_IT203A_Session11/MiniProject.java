package PTIT_CNTT1_IT203A_Session11;

public class MiniProject {

    interface ISkill {
        void useUltimate(GameCharacter target);
    }

    static abstract class GameCharacter {
        protected String name;
        protected int hp;
        protected int attackPower;
        public static int count = 0;

        public GameCharacter(String name, int hp, int attackPower) {
            this.name = name;
            this.hp = hp;
            this.attackPower = attackPower;
            count++;
        }

        public String getName() {
            return name;
        }

        public abstract void attack(GameCharacter target);

        public void takeDamage(int amount) {
            hp -= amount;
            if (hp < 0)
                hp = 0;
            if (hp == 0) {
                System.out.println(name + " đã bị hạ gục!");
            }
        }

        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp);
        }
    }

    static class Warrior extends GameCharacter implements ISkill {
        private int armor;

        public Warrior(String name, int hp, int attackPower, int armor) {
            super(name, hp, attackPower);
            this.armor = armor;
        }

        @Override
        public void attack(GameCharacter target) {
            System.out.println("[Chiến binh] " + name + " tấn công " + target.getName() + "!");
            target.takeDamage(attackPower);
        }

        @Override
        public void takeDamage(int amount) {
            int realDamage = amount - armor;
            if (realDamage < 0)
                realDamage = 0;
            super.takeDamage(realDamage);
        }

        @Override
        public void useUltimate(GameCharacter target) {
            System.out.println("[Chiến binh] " + name + " dùng chiêu cuối: Đấm ngàn cân!");
            target.takeDamage(attackPower * 2);
            int lostHp = (int) (hp * 0.1);
            hp -= lostHp;
            System.out.println(name + " mất " + lostHp + " HP do gắng sức.");
        }

        @Override
        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp + " | Giáp: " + armor);
        }
    }

    static class Mage extends GameCharacter implements ISkill {
        private int mana;

        public Mage(String name, int hp, int attackPower, int mana) {
            super(name, hp, attackPower);
            this.mana = mana;
        }

        @Override
        public void attack(GameCharacter target) {
            int damage;
            if (mana >= 5) {
                damage = attackPower;
                mana -= 5;
            } else {
                damage = attackPower / 2;
            }
            System.out.println("[Pháp sư] " + name + " tấn công " + target.getName() + "!");
            target.takeDamage(damage);
        }

        @Override
        public void useUltimate(GameCharacter target) {
            if (mana >= 50) {
                System.out.println("[Pháp sư] " + name + " dùng chiêu cuối: Hỏa cầu!");
                mana -= 50;
                target.takeDamage(attackPower * 3);
            } else {
                System.out.println(name + " không đủ mana để dùng Hỏa cầu!");
            }
        }

        @Override
        public void displayInfo() {
            System.out.println("Tên: " + name + " | HP: " + hp + " | Mana: " + mana);
        }
    }

    public static void main(String[] args) {

        System.out.println("=== ARENA OF HEROES ===");

        Warrior warrior = new Warrior("Yasuo", 500, 50, 20);
        Mage mage = new Mage("Veigar", 300, 40, 200);

        GameCharacter goblin = new GameCharacter("Goblin", 100, 10) {
            @Override
            public void attack(GameCharacter target) {
                System.out.println("[Quái vật] Goblin (Anonymous Class) tấn công!");
                System.out.println("Goblin cắn trộm...");
                target.takeDamage(10);
            }
        };

        System.out.println("Đã khởi tạo " + GameCharacter.count + " nhân vật tham gia đấu trường.\n");

        warrior.attack(goblin);
        mage.useUltimate(warrior);
        goblin.attack(mage);

        System.out.println("\n=== THÔNG SỐ SAU LƯỢT ĐẤU ===");
        warrior.displayInfo();
        mage.displayInfo();
        goblin.displayInfo();
    }
}
