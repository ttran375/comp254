class CreditCard:
    def __init__(self, cust, bk, acnt, lim, initialBal=0.0):
        self.customer = cust
        self.bank = bk
        self.account = acnt
        self.limit = lim
        self.balance = initialBal

    def getCustomer(self):
        return self.customer

    def getBank(self):
        return self.bank

    def getAccount(self):
        return self.account

    def getLimit(self):
        return self.limit

    def getBalance(self):
        return self.balance

    def charge(self, price):
        if price + self.balance > self.limit:
            return False
        self.balance += price
        return True

    def makePayment(self, amount):
        self.balance -= amount

    @staticmethod
    def printSummary(card):
        print("Customer =", card.customer)
        print("Bank =", card.bank)
        print("Account =", card.account)
        print("Balance =", card.balance)
        print("Limit =", card.limit)
