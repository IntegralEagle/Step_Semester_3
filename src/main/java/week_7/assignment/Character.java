public class Character {
    private final int maxHealth;
    private int health;

    public Character(int maxHealth) {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount > 0) {
            this.health = Math.max(0, this.health - amount);
        }
    }

    public void heal(int amount) {
        if (amount > 0) {
            this.health = Math.min(this.maxHealth, this.health + amount);
        }
    }

    public int getHealth() {
        return this.health;
    }

    public int getMaxHealth() {
        return this.maxHealth;
    }

    public static void main(String[] args) {
        Character c = new Character(100);
        
        c.takeDamage(30);
        System.out.println("Health after 30 damage: " + c.getHealth()); // Expected: 70

        c.heal(50);
        System.out.println("Health after 50 heal (capped): " + c.getHealth()); // Expected: 100

        c.takeDamage(150);
        System.out.println("Health after 150 damage (floored): " + c.getHealth()); // Expected: 0
    }
}