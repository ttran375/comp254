def print_array(input_array):
    for element in input_array:
        print(element, end=" ")
    print()


integer_array = [1, 2, 3, 4, 5]
double_array = [1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7]
character_array = ["H", "E", "L", "L", "O"]

print("Array integer_array contains: ", end="")
print_array(integer_array)

print("Array double_array contains: ", end="")
print_array(double_array)

print("Array character_array contains: ", end="")
print_array(character_array)
