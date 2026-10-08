#  Campus Lost & Found Management System

A simple **console-based Java application** designed to help students report, search, and manage lost and found items on campus.

The project demonstrates important Java programming concepts such as **Classes & Objects, Constructors, Methods, Encapsulation, ArrayList, Loops, Conditions, Exception Handling, and File Handling**.

---

## 👨‍💻 Project Information

* **Student Name:** Priyansh Bhatt
* **Registration No.:** 24BCY10077
* **Project:** Campus Lost & Found Management System
* **Programming Language:** Java
* **Course:** Programming in Java (CSE2006)
* **Slot:** C11+C13
* **Project Type:** Console-Based Application

---

##  Project Overview

The **Campus Lost & Found Management System** provides a simple way for students to keep track of items that are lost or found on campus.

Instead of maintaining records manually, users can enter item details through a menu-driven console application.

The system allows users to:

* Register users
* Report lost items
* Report found items
* View all items
* Search for an item
* Claim a found item
* Remove an item
* Save records to files
* Load previously saved records

The project is intentionally kept simple and easy to understand, making it suitable for learning and demonstrating basic Java programming concepts.

---

##  Objectives

The main objectives of this project are:

1. To create a simple menu-driven Java application.
2. To understand and implement Classes and Objects.
3. To use constructors for initializing objects.
4. To understand basic encapsulation.
5. To use ArrayList for storing multiple records.
6. To implement methods for different operations.
7. To use loops and conditions for program control.
8. To handle invalid user input using exception handling.
9. To store and retrieve data using basic file handling.
10. To develop a practical application using Java fundamentals.

---

##  Features

### 1. Register User

Users can register themselves by entering:

* Name
* Phone number
* Email

Each user receives a unique User ID.

### 2. Report Lost Item

A user can report an item that they have lost by entering:

* Item name
* Description
* Location

Each item receives a unique Item ID.

### 3. Report Found Item

A user can report an item they have found by entering:

* Item name
* Description
* Location

The item is stored with the type **Found**.

### 4. View All Items

The system displays all stored lost and found items along with their:

* Item ID
* Item name
* Description
* Location
* Type
* Status

### 5. Search Item

Users can search for an item by entering its name.

The search is case-insensitive, so searches such as:

```text
wallet
Wallet
WALLET
```

can find the same item.

### 6. Claim Found Item

A found item can be marked as **Claimed** using its Item ID.

The system also prevents an already claimed item from being claimed again.

### 7. Remove Item

Items can be removed from the system using their Item ID.

### 8. Save Records

User and item records are stored in text files inside the `data` folder.

### 9. Load Records

When the application starts again, previously saved records are automatically loaded from the files.

---

## 🛠️ Technologies Used

| Technology         | Purpose                    |
| ------------------ | -------------------------- |
| Java               | Main programming language  |
| ArrayList          | Storing users and items    |
| Scanner            | Taking user input          |
| File Handling      | Saving and loading records |
| Exception Handling | Handling invalid input     |
| Console            | User interface             |

---

## 📚 Java Concepts Used

### Classes & Objects

The project uses classes such as:

```text
CampusLostAndFound
Item
User
```

Objects are created from these classes to store and manage information.

### Constructors

Constructors are used to initialize objects.

For example:

```java
User user = new User(nextUserId, name, phone, email);
```

### Encapsulation

Important data members in the `Item` and `User` classes are kept private and accessed through methods where required.

For example:

```java
private int id;
private String name;
```

### ArrayList

The application uses `ArrayList` to store multiple users and items.

```java
private ArrayList<Item> items = new ArrayList<>();
private ArrayList<User> users = new ArrayList<>();
```

### Methods

Different operations are divided into separate methods such as:

```text
registerUser()
reportLostItem()
reportFoundItem()
showItems()
searchItem()
claimItem()
removeItem()
saveData()
```

This keeps the program organized and easier to understand.

### Loops

Loops are used to repeatedly display the menu and search through stored records.

Example:

```java
for (Item item : items)
```

### Conditions

`if`, `else`, and `switch` statements are used to make decisions based on user input.

### Exception Handling

`InputMismatchException` is used to prevent the program from crashing when the user enters an invalid number.

### File Handling

`FileReader`, `FileWriter`, `BufferedReader`, and `BufferedWriter` are used to save and load records.

### `this` Keyword

The `this` keyword is used in constructors to refer to the current object's variables.

### `final` Keyword

The `final` keyword is used for file path constants that should not change during program execution.

---

##  Project Structure

```text
CampusLostAndFound/
│
├── src/
│   ├── CampusLostAndFound.java
│   └── Item.java
│
├── data/
│   ├── users.txt
│   └── items.txt
│
├── Screenshots/
│
├── Project Report.pdf
│
├── README.md
│
└── Statement.md

```

### `src/`

Contains the Java source code.

### `CampusLostAndFound.java`

Contains the main program, menu, user operations, item operations, and file handling.

### `Item.java`

Contains the `Item` class used to represent lost and found items.

### `data/`

Contains the text files used to store application data.

### `users.txt`

Stores registered user information.

### `items.txt`

Stores lost and found item information.

---

##  Requirements

To run this project, you need:

* Java JDK installed
* Command Prompt / PowerShell / Terminal
* A text editor or Java IDE

You can check whether Java is installed using:

```bash
java -version
```

and:

```bash
javac -version
```

---

##  How to Run

### Step 1: Open the Project Folder

Open the terminal inside the main project folder:

```text
CampusLostAndFound
```

### Step 2: Compile the Program

Run:

```bash
javac src/*.java
```

### Step 3: Run the Program

Run:

```bash
java -cp src CampusLostAndFound
```

The program will start with the main menu.

---

##  Main Menu

```text
======================================
       CAMPUS LOST & FOUND
======================================

------------- MENU -------------
1. Register User
2. Report Lost Item
3. Report Found Item
4. View All Items
5. Search Item
6. Claim Found Item
7. Remove Item
8. Save Records
9. Exit
--------------------------------
Enter your choice:
```

---

##  File Handling

The project uses simple text files instead of a database.

User information is stored in:

```text
data/users.txt
```

Item information is stored in:

```text
data/items.txt
```

Records are saved when the user selects:

```text
8. Save Records
```

They are also automatically saved when the user selects:

```text
9. Exit
```

When the program starts again, the saved information is loaded automatically.

---

##  Testing

The application was tested for the following operations:

| Test Case                  | Expected Result                 |
| -------------------------- | ------------------------------- |
| Register a user            | User is registered successfully |
| Report lost item           | Lost item is added              |
| Report found item          | Found item is added             |
| View all items             | All stored items are displayed  |
| Search existing item       | Matching item is displayed      |
| Search non-existing item   | No matching item message        |
| Claim found item           | Item status changes to Claimed  |
| Claim already claimed item | Claim is rejected               |
| Claim lost item            | Claim is rejected               |
| Remove item                | Item is removed                 |
| Invalid menu input         | Error message displayed         |
| Invalid Item ID            | Error message displayed         |
| Save records               | Data is stored in files         |
| Restart application        | Previous data is loaded         |

---

##  Sample Data

### User

```text
Name: Priyansh
Phone: 9876543210
Email: priyansh@gmail.com
```

### Lost Item

```text
Item Name: Black Wallet
Description: Black leather wallet with college ID
Location: Hostel Block 4
Type: Lost
Status: Active
```

### Found Item

```text
Item Name: Blue Water Bottle
Description: Milton blue water bottle
Location: Library
Type: Found
Status: Active
```

---

##  Example Working Flow

```text
Start Program
      ↓
Display Menu
      ↓
Register User
      ↓
Report Lost / Found Item
      ↓
Store Item in ArrayList
      ↓
Search / View Item
      ↓
Claim or Remove Item
      ↓
Save Records
      ↓
Store Data in Text Files
      ↓
Exit
```

---

##  Learning Outcomes

After completing this project, the following concepts were practiced:

* Creating Java classes
* Creating and using objects
* Using constructors
* Basic encapsulation
* Using ArrayList
* Creating and calling methods
* Using loops
* Using conditional statements
* Using switch statements
* Handling exceptions
* Reading and writing files
* Organizing a Java project
* Building a menu-driven console application

---

##  Future Improvements

The project can be extended in the future by adding:

* User login and logout
* Password protection
* Admin panel
* Better item matching
* Date and time of reporting
* Email notifications
* Graphical User Interface
* Database connectivity
* Image upload for lost and found items
* Automatic matching between lost and found items

---

##  Author

**Priyansh Bhatt**
Registration No.: **24BCY10077**
VIT Bhopal University
Course: **Programming in Java (CSE2006)**

---

##  Project Type

**Console-Based Java Application**

The project is developed for academic learning and demonstrates the practical implementation of fundamental Java programming and object-oriented programming concepts.
