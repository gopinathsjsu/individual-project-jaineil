public class Billing {
    public static void main(String[] args) throws Exception {

        // SINGLETON INITIALIZATION
        Main main = Main.getInstance();

        main.startMarket();
        main.orderValidation();
        main.generateOutput();
        main.addNewCardToDatabase();
    }
}
