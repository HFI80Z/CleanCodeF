public class Exercise3 {

    /**
     * @param amount Price
     * @param type Account status (NotRegistered = 1, SimpleCustomer = 2, ValuableCustomer = 3, MostValuableCustomer = 4)
     * @param years Time in years that the client is our customer
     * @return The final price
     */
    public double calculate(double amount, int type, int years) {
        double discount = (years > 5) ? 0.05 : (double) years / 100;

        switch (type) {
            case 1: // NotRegistered
                return amount;

            case 2: // SimpleCustomer
                return applyDiscount(amount, 0.1, discount);

            case 3: // ValuableCustomer
                return applyDiscount(amount, 0.3, discount);

            case 4: // MostValuableCustomer
                return applyDiscount(amount, 0.5, discount);

            default:
                throw new IllegalArgumentException("Invalid account type: " + type);
        }
    }

    private double applyDiscount(double amount, double typeDiscount, double loyaltyDiscount) {
        double discountedAmount = amount * (1 - typeDiscount);
        return discountedAmount * (1 - loyaltyDiscount);
    }
}
