# 🔗 Generic Linked List — Built from Scratch in Java

A clean, generic singly-linked list implementation in Java with no external dependencies. Built as a learning exercise to understand data structures, generics, and pointer-based collections at a low level.

## 🛠️ Tech Stack

| | Technology | Purpose |
|---|---|---|
| ☕ | **Java 8+** | Core language (generics, type safety) |
| 📦 | **JDK (javac)** | Compilation |
| 🖥️ | **Terminal / CLI** | Run & test |

## 📚 API

| Method | Description |
|---|---|
| `append(data)` | Add an element at the end of the list |
| `display()` | Print all elements to stdout |
| `pop()` | Remove the last element |
| `delete(index)` | Remove the element at a given index |
| `insertAtBeginning(data)` | Insert an element at the head |
| `clear()` | Remove all elements |

## 🚀 Compile & Run

```bash
# Compile
javac LinkedList.java

# Run
java Main
```

### Expected Output

```
--- After appending 5, 50, 55, 505 ---
5
50
55
505

--- After appending 100 ---
5
50
55
505
100

--- After pop() and delete(1) ---
5
55
505

--- After insertAtBeginning(88) ---
88
5
55
505

--- After clear() and append(4) ---
4

Caught expected error: Empty List
```

## 🐛 Known Issues

- **No `size()` method** — there is no way to query the length of the list without traversing it.
- **O(n) append** — every `append` walks the entire list; a tail pointer would make it O(1).
- **Not thread-safe** — concurrent access is unsupported.
- **No iterator support** — the class does not implement `Iterable<T>`, so enhanced for-loops won't work.

## 📄 License

[MIT](LICENSE)
