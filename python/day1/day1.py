file_name = './input.txt'

def open_file (file_path):
    with open(file_path, 'r', encoding = 'utf-8') as file:
        return file.read().strip()


def seperate_lists(file_name):
    numbers = open_file(file_name).strip().split('\n')
    left = []
    right = []

    for entry in numbers:
        first_number, second_number = entry.split()
        left.append(int(first_number))
        right.append(int(second_number))

    left.sort()
    right.sort()

    return left, right


def find_distance (file_name):
    left, right = seperate_lists(file_name)

    return sum(abs(l - r) for l, r in zip(left, right))
    

def find_similarities(file_name):
    left, right = seperate_lists(file_name)

    return sum(a * right.count(a) for a in left) 


print(find_distance(file_name))
print(find_similarities(file_name))
