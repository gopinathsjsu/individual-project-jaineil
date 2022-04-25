package model;

public class Order {

    private String item;
    private int quantity;
    private String cardNumber;

    public Order(String item, int quantity, String cardNumber) {
        this.item = item;
        this.quantity = quantity;
        this.cardNumber = cardNumber;
    }

    // getters
    public String getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getCardNumber() {
        return cardNumber;
    }

}
