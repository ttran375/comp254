class ArrayMax:
    @staticmethod
    def array_max(data):
        n = len(data)  # 1 assignment, 1 array length access
        current_max = data[0]  # 1 assignment, 1 array access
        for j in range(1, n):  # 1 assignment, (n-1) comparisons, (n-1) increments
            if data[j] > current_max:  # (n-1) array accesses, (n-1) comparisons
                current_max = data[j]  # at most (n-1) assignments
        return current_max  # 1 return
