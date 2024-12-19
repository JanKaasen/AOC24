input = '../input.txt'

def open_file (file_path):
    with open(file_path, 'r', encoding = 'utf-8') as file:
        return file.read().strip()

def is_strictly_increasing(a):
    prev_num = a[0]
    for i in range(1, len(a)):
        curr_num = a[i]
        if prev_num >= curr_num:
            return False
        prev_num = curr_num
    return True

def is_strictly_decreasing(a):
    prev_num = a[0]
    for i in range(1, len(a)):
        curr_num = a[i]
        if prev_num <= curr_num:
            return False
        prev_num = curr_num
    return True

def make_num_list(input):
    number_list = []
    s = open_file(input)
    report_list = s.splitlines()
    for entry in report_list:
        number_list.append(list(map(int, entry.split())))

    return number_list

def is_safe(input):
    num_list = make_num_list(input)
    for entry in num_list:
        if is_strictly_increasing(entry) or is_strictly_decreasing(entry):
            if all(1 <= abs(entry[i] - entry[i + 1]) <= 3 for i in range(len(entry)-1)):
               return True 


def safe_reports(input):
    safe = 0
    number_list = make_num_list(input)
    for entry in number_list:
        if is_strictly_increasing(entry) or is_strictly_decreasing(entry):
            if all(1 <= abs(entry[i] - entry[i + 1]) <= 3 for i in range(len(entry) - 1)):
                safe += 1
            
    return safe

def safe_part2(input):
    safe = 0
    number_list = make_num_list(input)
    for entry in number_list:
        unsafe_count = 0
        if is_strictly_increasing(entry) or is_strictly_decreasing(entry):
            for i in range(len(entry) - 1):
                if not (1 <= abs(entry[i] - entry[i + 1]) <= 3):
                    unsafe_count += 1
                    if unsafe_count > 1:
                        break
        if unsafe_count <= 1:
            safe += 1
    return safe



print(safe_reports(input))
print(safe_part2(input))

