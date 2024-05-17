from Box import Box

my_int = 5
box1 = Box()

# place an integer in the box
box1.set(my_int)

# place a string in the box
s = "hello"
box1.set(s)

# get the string from the box
print(box1.get())

# try to get an integer from the box
# res = int(box1.get())  # error
