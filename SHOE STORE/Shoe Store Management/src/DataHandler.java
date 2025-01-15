import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DataHandler {
    private static final String USER_FILE = "data/users.txt";
    private static final String SHOE_FILE = "data/shoes.txt";

    public static List<User> loadUsers() {
        return loadData(USER_FILE);
    }

    public static List<Shoe> loadShoes() {
        return loadData(SHOE_FILE);
    }

    public static void saveUsers(List<User> users) {
        saveData(users, USER_FILE);
    }

    public static void saveShoes(List<Shoe> shoes) {
        saveData(shoes, SHOE_FILE);
    }

    @SuppressWarnings("unchecked")
    private static <T> List<T> loadData(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (List<T>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    private static <T> void saveData(List<T> data, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
