import java.util.Scanner;

class User {
    String userId;
    String password;

    User(String userId, String password) {
        this.userId = userId;
        this.password = password;
    }
}

class Booking {
    String userId;
    int roomNumber;

    Booking(String userId, int roomNumber) {
        this.userId = userId;
        this.roomNumber = roomNumber;
    }
}

public class HotelManagementApp{
    static Scanner sc = new Scanner(System.in);
    static final int MAX_USERS = 100;
    static final int MAX_BOOKINGS = 100;

    static User[] users = new User[MAX_USERS];
    static int userCount = 0;

    static Booking[] bookings = new Booking[MAX_BOOKINGS];
    static int bookingCount = 0;

    static int[] bookedRooms = new int[100]; // room numbers 1-100
    static int bookedRoomCount = 0;

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n--- Hotel Management System ---");
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1 -> signUp();
                case 2 -> login();
                case 3 -> {
                    System.out.println("Exiting... Goodbye!");
                    running = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void signUp() {
        if (userCount >= MAX_USERS) {
            System.out.println("User limit reached!");
            return;
        }
        System.out.print("Enter new user ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();
        users[userCount++] = new User(userId, password);
        System.out.println("Sign Up successful!");
    }

    static void login() {
        System.out.print("Enter user ID: ");
        String userId = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for (int i = 0; i < userCount; i++) {
            if (users[i].userId.equals(userId) && users[i].password.equals(password)) {
                System.out.println("Login successful!");
                landingPage(userId);
                return;
            }
        }
        System.out.println("Invalid credentials!");
    }

    static void landingPage(String userId) {
        boolean loggedIn = true;
        while (loggedIn) {
            System.out.println("\n--- Hotel Services ---");
            System.out.println("1. Book a Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. Checkout");
            System.out.println("4. Logout");
            System.out.print("Choose an option: ");
            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1 -> bookRoom(userId);
                case 2 -> cancelBooking(userId);
                case 3 -> checkout(userId);
                case 4 -> {
                    System.out.println("Logging out...");
                    loggedIn = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static boolean isRoomBooked(int roomNumber) {
        for (int i = 0; i < bookedRoomCount; i++) {
            if (bookedRooms[i] == roomNumber) return true;
        }
        return false;
    }

    static void bookRoom(String userId) {
        if (bookingCount >= MAX_BOOKINGS) {
            System.out.println("Booking limit reached!");
            return;
        }

        System.out.print("Enter room number to book (1-100): ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        if (isRoomBooked(roomNumber)) {
            System.out.println("Room already booked!");
            return;
        }

        bookings[bookingCount++] = new Booking(userId, roomNumber);
        bookedRooms[bookedRoomCount++] = roomNumber;
        System.out.println("Room " + roomNumber + " booked successfully!");
    }

    static void cancelBooking(String userId) {
        System.out.print("Enter room number to cancel: ");
        int roomNumber = sc.nextInt();
        sc.nextLine();

        boolean found = false;
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null &&
                bookings[i].userId.equals(userId) &&
                bookings[i].roomNumber == roomNumber) {
                bookings[i] = null;
                removeRoom(roomNumber);
                found = true;
                System.out.println("Booking for room " + roomNumber + " cancelled.");
                break;
            }
        }
        if (!found) {
            System.out.println("No such booking found.");
        }
    }

    static void checkout(String userId) {
        boolean anyBooking = false;
        for (int i = 0; i < bookingCount; i++) {
            if (bookings[i] != null && bookings[i].userId.equals(userId)) {
                removeRoom(bookings[i].roomNumber);
                bookings[i] = null;
                anyBooking = true;
            }
        }
        if (anyBooking) {
            System.out.println("Checked out. All your rooms are released.");
        } else {
            System.out.println("No rooms to checkout.");
        }
    }

    static void removeRoom(int roomNumber) {
        for (int i = 0; i < bookedRoomCount; i++) {
            if (bookedRooms[i] == roomNumber) {
                // Shift elements left
                for (int j = i; j < bookedRoomCount - 1; j++) {
                    bookedRooms[j] = bookedRooms[j + 1];
                }
                bookedRoomCount--;
                break;
            }
        }
    }
}
