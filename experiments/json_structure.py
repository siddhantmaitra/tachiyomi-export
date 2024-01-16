import json

# Quick script to print the structure of json file
def print_structure(data, indent="", path=""):

    if isinstance(data, dict):
        for key, value in data.items():
            new_path = path + "." + key if path else key
            if isinstance(value, (dict, list)):
                print_structure(value, indent + "  ", new_path)
            else:
                print(f"{indent}- {new_path}: {type(value).__name__}")
    elif isinstance(data, list) and data:
        print_structure(data[0], indent, path + "[0]")

def main():
    
    data_file = input("Enter the file name: ")
    with open(data_file, "r") as file:
        data = json.load(file)
    print_structure(data)

if __name__ == "__main__":
    main()

