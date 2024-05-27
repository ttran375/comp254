# -*- coding: utf-8 -*-


class Node:
    def __init__(self, element, next_node=None):
        self.element = element
        self.next_node = next_node


class CircularlyLinkedList:
    def __init__(self):
        self.tail = None
        self.size = 0

    def __len__(self):
        return self.size

    def is_empty(self):
        return self.size == 0

    def first(self):
        if self.is_empty():
            return None
        return self.tail.next_node.element

    def last(self):
        if self.is_empty():
            return None
        return self.tail.element

    def rotate(self):
        if self.tail is not None:
            self.tail = self.tail.next_node

    def add_first(self, e):
        if self.is_empty():
            self.tail = Node(e)
            self.tail.next_node = self.tail  # a new list of one element
        else:
            newest = Node(e)
            newest.next_node = self.tail.next_node
            self.tail.next_node = newest
        self.size += 1

    def add_last(self, e):
        self.add_first(e)
        self.tail = self.tail.next_node

    def remove_first(self):
        if self.is_empty():
            return None
        old_head = self.tail.next_node
        if self.size == 1:
            self.tail = None
        else:
            self.tail.next_node = old_head.next_node
        self.size -= 1
        return old_head.element

    def __str__(self):
        if self.is_empty():
            return "[]"
        result = []
        current = self.tail.next_node
        result.append(str(current.element))
        current = current.next_node
        while current != self.tail.next_node:
            result.append(str(current.element))
            current = current.next_node
        return "[" + ", ".join(result) + "]"

    def concatenate(self, other):
        if self.is_empty():
            self.tail = other.tail
            self.size = other.size
        elif not other.is_empty():
            other_head = other.tail.next_node
            other.tail.next_node = self.tail.next_node
            self.tail.next_node = other_head
            self.tail = other.tail
            self.size += other.size


if __name__ == "__main__":
    circularlyList1 = CircularlyLinkedList()
    circularlyList1.add_first("LAX")
    circularlyList1.add_last("MSP")
    circularlyList1.add_last("ATL")
    circularlyList1.add_last("BOS")

    print(circularlyList1)

    circularlyList2 = CircularlyLinkedList()
    circularlyList2.add_last("YYZ")
    circularlyList2.add_last("YVR")

    print(circularlyList2)

    circularlyList1.concatenate(circularlyList2)

    print(circularlyList1)
    print(circularlyList2)
