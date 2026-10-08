
public class Item {

    private int id;
    private String name;
    private String description;
    private String location;
    private String type;
    private String status;

    public Item(int id, String name, String description,
                String location, String type) {

        this.id = id;
        this.name = name;
        this.description = description;
        this.location = location;
        this.type = type;
        this.status = "Active";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void display() {
        System.out.println("--------------------------------");
        System.out.println("Item ID     : " + id);
        System.out.println("Item Name   : " + name);
        System.out.println("Description : " + description);
        System.out.println("Location    : " + location);
        System.out.println("Type        : " + type);
        System.out.println("Status      : " + status);
        System.out.println("--------------------------------");
    }

    public String toString() {
        return id + "|" + name + "|" + description + "|"
                + location + "|" + type + "|" + status;
    }
}
