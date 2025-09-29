import java.util.*;

public class OfficeManager {
    private static OfficeManager instance;
    private Map<Integer, Room> rooms = new HashMap<>();
    private List<RoomObserver> observers = new ArrayList<>();

    private OfficeManager() {}
    public static synchronized OfficeManager getInstance() {
        if (instance == null) instance = new OfficeManager();
        return instance;
    }

    public void configureRooms(int count) {
        rooms.clear();
        for (int i=1;i<=count;i++) {
            rooms.put(i, new Room(i));
        }
        System.out.println("Office configured with " + count + " meeting rooms.");
    }

    public Room getRoom(int id) { return rooms.get(id); }
    public Collection<Room> getRooms() { return rooms.values(); }

    public void addObserver(RoomObserver o) { observers.add(o); }

    public void notifyObservers(Room r) {
        for (RoomObserver o : observers) o.onStatusChange(r);
    }
}
