input = 'input.txt'

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

def safe_reports(input):
    safe = 0
    s = open_file(input)
    report_list = s.splitlines()
    for entry in report_list:
        number_list = list(map(int, entry.split()))
        if is_strictly_increasing(number_list) or is_strictly_decreasing(number_list):
            if all(1 <= abs(number_list[i] - number_list[i + 1]) <= 3 for i in range(len(number_list) - 1)):
                safe += 1
            
    return safe

def safe_p2(input):



print(safe_reports(input))

