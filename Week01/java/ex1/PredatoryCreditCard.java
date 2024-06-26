public class PredatoryCreditCard extends CreditCard {
    private double apr;

    public PredatoryCreditCard(String cust, String bk, String acnt, int lim,
            double initialBal, double rate) {
        super(cust, bk, acnt, lim, initialBal);
        apr = rate;
    }

    public void processMonth() {
        if (balance > 0) {
            double monthlyFactor = Math.pow(1 + apr, 1.0 / 12);
            balance *= monthlyFactor;
        }
    }

    @Override
    public boolean charge(double price) {
        boolean isSuccess = super.charge(price);
        if (!isSuccess)
            balance += 5;
        return isSuccess;
    }

    public static void main(String[] args) {
        PredatoryCreditCard card = new PredatoryCreditCard("Michael", "Payday", "1111 1111 1111 1111", 2500, 0, 0.0825);
        card.charge(100);
        CreditCard.printSummary(card);
        card.processMonth();
        CreditCard.printSummary(card);
        card.charge(10000);
        CreditCard.printSummary(card);
    }
}
