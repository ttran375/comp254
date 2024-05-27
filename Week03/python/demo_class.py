# Uncomment each block to test the individual cases.

# Block 1
# data = [12]
# backup = data
# data[0] = 11
# print(backup[0])
# print(data is backup)

# Block 2
# data = [12]
# backup = [0]
# data[0] = 11
# print(data == backup)

# Block 3
# data = [1, 2]
# backup = [12]
# print(data == backup)

# Block 4
# data = [[1, 2], [3, 4]]
# backup = [[1, 2], [3, 4]]
# print(data is backup)
# print(data == backup)
# print(all(x == y for x, y in zip(data, backup)))
# print(data == backup)

# Block 5
# data = [1, 2]
# backup = data
# data[0] = 11
# print(backup[0])

# print(data is backup)
# print(data == backup)
# print(data == backup)

# Block 6
# data = [1, 2]
# backup = data.copy()
# data[0] = 11
# print(backup[0])

# print(data is backup)
# print(data == backup)
# print(data == backup)

# Block 7
# data = [[1, 2], [3, 4]]
# backup = copy.deepcopy(data)
# data[0][0] = 11
# print(backup[0][0])

# print(data is backup)
# print(data == backup)
# print(all(x == y for x, y in zip(data, backup)))
# print(data == backup)

# Block 8
data = [[1, 2], [3, 4]]
backup = [row.copy() for row in data]
data[0][0] = 11
print(backup[0][0])

print(data is backup)
print(data == backup)
print(all(x == y for x, y in zip(data, backup)))
# print(data == backup) # This line is similar to Arrays.deepEquals in Java
