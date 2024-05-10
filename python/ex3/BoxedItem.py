from Sellable import Sellable
from Transportable import Transportable


class BoxedItem(Sellable, Transportable):
    def __init__(self, desc, p, w, h):
        self.descript = desc  # description of this item
        self.price = p  # list price in cents
        self.weight = w  # weight in grams
        self.haz = h  # true if object is hazardous
        self.height = 0  # box height in centimeters
        self.width = 0  # box width in centimeters
        self.depth = 0  # box depth in centimeters

    def description(self):
        return self.descript

    def listPrice(self):
        return self.price

    def lowestPrice(self):
        return self.price // 2

    def weight(self):
        return self.weight

    def isHazardous(self):
        return self.haz

    def insuredValue(self):
        return self.price * 2

    def setBox(self, h, w, d):
        self.height = h
        self.width = w
        self.depth = d


def main():
    # Sellable s1 = new BoxedItem("Glass", 50, 20, false);
    # System.out.println(s1.listPrice());

    # System.out.println(s1.isHazardous());

    s1 = BoxedItem("Glass", 50, 20, False)
    print(s1.listPrice())


if __name__ == "__main__":
    main()
