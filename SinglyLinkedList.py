class Node:
    def __init__(self, element, next=None):
        self.element = element
        self.next = next

    def get_element(self):
        return self.element

    def get_next(self):
        return self.next

    def set_next(self, next_node):
        self.next = next_node

class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def size(self):
        return self.size

    def is_empty(self):
        return self.size == 0

    def first(self):
        if self.is_empty():
            return None
        return self.head.get_element()

    def last(self):
        if self.is_empty():
            return None
        return self.tail.get_element()

    def add_first(self, element):
        self.head = Node(element, self.head)
        if self.size == 0:
            self.tail = self.head
        self.size += 1

    def add_last(self, element):
        newest = Node(element, None)
        if self.is_empty():
            self.head = newest
        else:
            self.tail.set_next(newest)
        self.tail = newest
        self.size += 1

    def remove_first(self):
        if self.is_empty():
            return None
        answer = self.head.get_element()
        self.head = self.head.get_next()
        self.size -= 1
        if self.size == 0:
            self.tail = None
        return answer

    def __eq__(self, other):
        if other is None or not isinstance(other, SinglyLinkedList):
            return False
        if self.size != other.size:
            return False
        walk_a = self.head
        walk_b = other.head
        while walk_a is not None:
            if walk_a.get_element() != walk_b.get_element():
                return False
            walk_a = walk_a.get_next()
            walk_b = walk_b.get_next()
        return True

    def __copy__(self):
        other = SinglyLinkedList()
        if self.size > 0:
            other.head = Node(self.head.get_element(), None)
            walk = self.head.get_next()
            other_tail = other.head
            while walk is not None:
                newest = Node(walk.get_element(), None)
                other_tail.set_next(newest)
                other_tail = newest
                walk = walk.get_next()
        return other

    def __hash__(self):
        h = 0
        walk = self.head
        while walk is not None:
            h ^= hash(walk.get_element())
            h = (h << 5) | (h >> 27)
            walk = walk.get_next()
        return h

    def __str__(self):
        elements = []
        walk = self.head
        while walk is not None:
            elements.append(str(walk.get_element()))
            walk = walk.get_next()
        return '(' + ', '.join(elements) + ')'

    def remove_last(self):
        if self.is_empty():
            return None
        walk = self.head
        while walk.get_next() != self.tail:
            walk = walk.get_next()
        self.tail = walk
        walk.set_next(None)
        self.size -= 1

    def search(self, element):
        walk = self.head
        found = False
        while walk is not None:
            if walk.get_element() == element:
                found = True
            walk = walk.get_next()
        return found

    def concatenate(self, other_list):
        if self.is_empty():
            self.head = other_list.head
        else:
            self.tail.set_next(other_list.head)
        self.size += other_list.size
        self.tail = other_list.tail

if __name__ == "__main__":
    list1 = SinglyLinkedList()
    list1.add_first("MSP")
    list1.add_last("ATL")
    list1.add_last("BOS")
    list1.add_first("LAX")
    print(list1)
    list1.remove_last()
    print(list1)
    print(list1.search("LAM"))

    list2 = SinglyLinkedList()
    list2.add_first("YYZ")
    list2.add_first("YVR")
    print(list2)

    list1.concatenate(list2)
    print(list1)
