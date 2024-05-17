from CreditCard import CreditCard


class PredatoryCreditCard(CreditCard):
    def __init__(self, cust, bk, acnt, lim, initialBal, rate):
        super().__init__(cust, bk, acnt, lim, initialBal)
        self.apr = rate

    def processMonth(self):
        if self.balance > 0:
            monthlyFactor = (1 + self.apr) ** (1.0 / 12)
            self.balance *= monthlyFactor

    def charge(self, price):
        isSuccess = super().charge(price)
        if not isSuccess:
            self.balance += 5
        return isSuccess


if __name__ == "__main__":
    wallet = [
        CreditCard("John Bowman", "California Savings", "5391 0375 9387 5309", 5000),
        CreditCard("John Bowman", "California Federal", "3485 0399 3395 1954", 3500),
        CreditCard(
            "John Bowman", "California Finance", "5391 0375 9387 5309", 2500, 300
        ),
    ]

    for val in range(1, 17):
        wallet[0].charge(3 * val)
        wallet[1].charge(2 * val)
        wallet[2].charge(val)

    for card in wallet:
        CreditCard.printSummary(card)
        while card.getBalance() > 200.0:
            card.makePayment(200)
            print("New balance =", card.getBalance())

    predatory_card = PredatoryCreditCard(
        "Michael", "Payday", "1111 1111 1111 1111", 2500, 0, 0.0825
    )
    predatory_card.charge(100)
    CreditCard.printSummary(predatory_card)
    predatory_card.processMonth()
    CreditCard.printSummary(predatory_card)
    predatory_card.charge(10000)
    CreditCard.printSummary(predatory_card)
