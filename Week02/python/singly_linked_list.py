class Node:
    def __init__(self, element, next_node=None):
        self.element = element
        self.next_node = next_node


class SinglyLinkedList:
    def __init__(self):
        self.head = None
        self.tail = None
        self.size = 0

    def __len__(self):
        return self.size

    def is_empty(self):
        return self.size == 0

    def first(self):
        if self.is_empty():
            return None
        return self.head.element

    def last(self):
        if self.is_empty():
            return None
        return self.tail.element

    def add_first(self, e):
        newest = Node(e, next_node=self.head)
        self.head = newest
        if self.is_empty():
            self.tail = self.head
        self.size += 1

    def add_last(self, e):
        newest = Node(e)
        if self.is_empty():
            self.head = newest
        else:
            self.tail.next_node = newest
        self.tail = newest
        self.size += 1

    def remove_first(self):
        if self.is_empty():
            return None
        answer = self.head.element
        self.head = self.head.next_node
        self.size -= 1
        if self.is_empty():
            self.tail = None
        return answer

    def __eq__(self, other):
        if not isinstance(other, SinglyLinkedList) or self.size != len(other):
            return False

        node1, node2 = self.head, other.head
        while node1 is not None:
            if node1.element != node2.element:
                return False
            node1, node2 = node1.next_node, node2.next_node

        return True

    def __str__(self):
        result = []
        node = self.head
        while node is not None:
            result.append(str(node.element))
            node = node.next_node
        return "(" + ", ".join(result) + ")"

    def remove_last(self):
        if self.is_empty():
            return None
        if self.size == 1:
            return self.remove_first()
        walk = self.head
        while walk.next_node != self.tail:
            walk = walk.next_node
        answer = self.tail.element
        self.tail = walk
        self.tail.next_node = None
        self.size -= 1
        return answer

    def search(self, element):
        walk = self.head
        while walk is not None:
            if walk.element == element:
                return True
            walk = walk.next_node
        return False

    def concatenate(self, other_list):
        if self.is_empty():
            self.head = other_list.head
        else:
            self.tail.next_node = other_list.head
        self.size += other_list.size
        if other_list.tail:
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
