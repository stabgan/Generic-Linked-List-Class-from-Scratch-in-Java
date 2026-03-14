# Generic Linked List — Java from Scratch

A generic singly-linked list implementation written in pure Java with no external dependencies. Supports any reference type via Java generics.

## What It Does

Implements a classic singly-linked list data structure with the following operations:

| Method | Description |
|---|---|
| `append(data)` | Add an element at the end |
| `insertAtBeginning(data)` | Insert an element at the head |
| `pop()` | Remove the last element |
| `delete(index)` | Remove the element at a given 0-based index |
| `display()` | Print all elements to stdout |
| `clear()` | Remove all elements |
| `size()` | Return the number of elements |
| `isEmpty()` | Check whether the list is empty |
| `toString()` | Human-readable representation (e.g. `[5 -> 50 -> 55]`) |

## 🛠 Tech Stack

| | Technology | Purpose |
|---|---|---|
| ☕ | Java (8+) | Language |
| 🧬 | Java Generics | Type-safe container for any reference type |

## Getting Started

```bash
# Compile
javac LinkedList.java

# Run
java Main
```

No external libraries or build tools required.

## Example Output

```
After appending 5, 50, 55, 505:
5
50
55
505

After appending 100:
5
50
55
505
100

After pop() and delete(1):
5
55
505

After insertAtBeginning(88):
88
5
55
505

toString: [88 -> 5 -> 55 -> 505]
```

## Project Structure

```
.
├── LinkedList.java   # Node, LinkedList, and Main classes
├── output.png        # Sample output screenshot
└── README.md
```

## ⚠️ Known Issues

- All classes are in the default package (no `package` declaration) — fine for learning, not for production.
- `display()` and `pop()` throw exceptions on an empty list rather than returning silently; this is intentional for safety.
- No `Iterator` implementation — could be added for `for-each` loop support.

## License

[MIT](LICENSE)
