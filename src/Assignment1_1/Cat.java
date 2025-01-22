public class Cat {
    private String name;

    // Rakentaja asettaa kissan nimen
    public Cat(String name) {
        this.name = name;
    }

    // Meow-metodi, joka tulostaa kissan "Meow!"-äänen
    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Luodaan kaksi kissaa, yksi nimeltä Whiskers ja toinen Rex
        Cat cat1 = new Cat("Whiskers");
        Cat cat2 = new Cat("Rex");

        // Kutsutaan molempien kissojen meow-metodia
        cat1.meow();
        cat1.meow();
        cat2.meow();
        cat1.meow();
    }
}
