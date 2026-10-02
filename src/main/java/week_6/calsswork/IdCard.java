class IdCard {
    String name;
    int booksIssued;

    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }

    public static void main(String[] args) {
        // Step 1 & 2: Create object and assign second reference variable
        IdCard ravi = new IdCard("Ravi", 0);
        IdCard duplicate = ravi;

        // Step 3: Modify through second reference variable
        duplicate.booksIssued = 3;

        // Step 4: Print field via first variable and reference equality check
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));

        // Step 5: Create a third, separate object with identical values
        IdCard separate = new IdCard("Ravi", 3);
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}