from GenericBox import GenericBox

box1 = GenericBox[str]()
s = "hello"
box1.set(s)
print(box1.get())
res = box1.get()  # no error
