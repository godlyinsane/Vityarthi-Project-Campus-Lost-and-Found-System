
import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LostAndFound {

    private ArrayList<Item> items = new ArrayList<>();
    private ArrayList<User> users = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    private static final String USER_FILE = "data/users.txt";
    private static final String ITEM_FILE = "data/items.txt";

    private int nextUserId = 1;
    private int nextItemId = 1001;

    public LostAndFound() {
        createDataFolder();
        loadUsers();
        loadItems();
    }

    public static void main(String[] args) {

        LostAndFound system = new LostAndFound();

        system.start();
    }

    public void start() {

        boolean running = true;

        System.out.println();
        System.out.println("======================================");
        System.out.println("       CAMPUS LOST & FOUND");
        System.out.println("======================================");

        while (running) {

            showMenu();

            try {

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    case 1:
                        registerUser();
                        break;

                    case 2:
                        reportLostItem();
                        break;

                    case 3:
                        reportFoundItem();
                        break;

                    case 4:
                        showItems();
                        break;

                    case 5:
                        searchItem();
                        break;

                    case 6:
                        claimItem();
                        break;

                    case 7:
                        removeItem();
                        break;

                    case 8:
                        saveData();
                        break;

                    case 9:
                        saveData();
                        System.out.println("Thank you for using the system.");
                        running = false;
                        break;

                    default:
                        System.out.println("Please choose between 1 and 9.");
                }

            } catch (InputMismatchException e) {

                System.out.println("Please enter a valid number.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private void showMenu() {

        System.out.println();
        System.out.println("------------- MENU -------------");
        System.out.println("1. Register User");
        System.out.println("2. Report Lost Item");
        System.out.println("3. Report Found Item");
        System.out.println("4. View All Items");
        System.out.println("5. Search Item");
        System.out.println("6. Claim Found Item");
        System.out.println("7. Remove Item");
        System.out.println("8. Save Records");
        System.out.println("9. Exit");
        System.out.println("--------------------------------");
    }

    private void registerUser() {

        System.out.println();
        System.out.println("--------- REGISTER USER ---------");

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            System.out.println("Please enter all details.");
            return;
        }

        User user = new User(nextUserId, name, phone, email);

        users.add(user);

        System.out.println("User registered successfully.");
        System.out.println("Your User ID is: " + nextUserId);

        nextUserId++;
    }

    private void reportLostItem() {

        System.out.println();
        System.out.println("--------- REPORT LOST ITEM ---------");

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Where did you lose it? ");
        String location = scanner.nextLine();

        if (name.isEmpty() || description.isEmpty() || location.isEmpty()) {
            System.out.println("Please enter all details.");
            return;
        }

        Item item = new Item(
                nextItemId,
                name,
                description,
                location,
                "Lost"
        );

        items.add(item);

        System.out.println("Lost item reported successfully.");
        System.out.println("Item ID is: " + nextItemId);

        nextItemId++;
    }

    private void reportFoundItem() {

        System.out.println();
        System.out.println("--------- REPORT FOUND ITEM ---------");

        System.out.print("Enter item name: ");
        String name = scanner.nextLine();

        System.out.print("Enter description: ");
        String description = scanner.nextLine();

        System.out.print("Where did you find it? ");
        String location = scanner.nextLine();

        if (name.isEmpty() || description.isEmpty() || location.isEmpty()) {
            System.out.println("Please enter all details.");
            return;
        }

        Item item = new Item(
                nextItemId,
                name,
                description,
                location,
                "Found"
        );

        items.add(item);

        System.out.println("Found item reported successfully.");
        System.out.println("Item ID is: " + nextItemId);

        nextItemId++;
    }

    private void showItems() {

        System.out.println();
        System.out.println("--------- ALL ITEMS ---------");

        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        for (Item item : items) {
            item.display();
        }
    }

    private void searchItem() {

        System.out.println();
        System.out.println("--------- SEARCH ITEM ---------");

        System.out.print("Enter item name: ");
        String search = scanner.nextLine().toLowerCase();

        boolean found = false;

        for (Item item : items) {

            if (item.getName().toLowerCase().contains(search)) {

                item.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching item found.");
        }
    }

    private void claimItem() {

        System.out.println();
        System.out.println("--------- CLAIM ITEM ---------");

        System.out.print("Enter Item ID: ");

        try {

            int id = scanner.nextInt();
            scanner.nextLine();

            for (Item item : items) {

                if (item.getId() == id) {

                    if (item.getType().equals("Found")) {

                        if (item.getStatus().equals("Active")) {

                            item.setStatus("Claimed");

                            System.out.println("Item claimed successfully.");

                        } else {

                            System.out.println("This item has already been claimed.");
                        }

                    } else {

                        System.out.println("Only found items can be claimed.");
                    }

                    return;
                }
            }

            System.out.println("Item ID not found.");

        } catch (InputMismatchException e) {

            System.out.println("Please enter a valid Item ID.");
            scanner.nextLine();
        }
    }

    private void removeItem() {

        System.out.println();
        System.out.println("--------- REMOVE ITEM ---------");

        System.out.print("Enter Item ID: ");

        try {

            int id = scanner.nextInt();
            scanner.nextLine();

            boolean removed = false;

            for (int i = 0; i < items.size(); i++) {

                if (items.get(i).getId() == id) {

                    items.remove(i);
                    removed = true;

                    System.out.println("Item removed successfully.");
                    break;
                }
            }

            if (!removed) {
                System.out.println("Item ID not found.");
            }

        } catch (InputMismatchException e) {

            System.out.println("Please enter a valid Item ID.");
            scanner.nextLine();
        }
    }

    private void createDataFolder() {

        File folder = new File("data");

        if (!folder.exists()) {
            folder.mkdir();
        }
    }

    private void saveData() {

        saveUsers();
        saveItems();

        System.out.println("Records saved successfully.");
    }

    private void saveUsers() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(USER_FILE));

            for (User user : users) {

                writer.write(user.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error while saving users.");
        }
    }

    private void loadUsers() {

        File file = new File(USER_FILE);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 4) {

                    int id = Integer.parseInt(data[0]);

                    User user = new User(
                            id,
                            data[1],
                            data[2],
                            data[3]
                    );

                    users.add(user);

                    if (id >= nextUserId) {
                        nextUserId = id + 1;
                    }
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error while loading users.");
        }
    }

    private void saveItems() {

        try {

            BufferedWriter writer =
                    new BufferedWriter(new FileWriter(ITEM_FILE));

            for (Item item : items) {

                writer.write(item.toString());
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {

            System.out.println("Error while saving items.");
        }
    }

    private void loadItems() {

        File file = new File(ITEM_FILE);

        if (!file.exists()) {
            return;
        }

        try {

            BufferedReader reader =
                    new BufferedReader(new FileReader(file));

            String line;

            while ((line = reader.readLine()) != null) {

                String[] data = line.split("\\|");

                if (data.length == 6) {

                    int id = Integer.parseInt(data[0]);

                    Item item = new Item(
                            id,
                            data[1],
                            data[2],
                            data[3],
                            data[4]
                    );

                    item.setStatus(data[5]);

                    items.add(item);

                    if (id >= nextItemId) {
                        nextItemId = id + 1;
                    }
                }
            }

            reader.close();

        } catch (IOException | NumberFormatException e) {

            System.out.println("Error while loading items.");
        }
    }
}


class User {

    private int id;
    private String name;
    private String phone;
    private String email;

    public User(int id, String name, String phone, String email) {

        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toString() {

        return id + "|" + name + "|" + phone + "|" + email;
    }
}
