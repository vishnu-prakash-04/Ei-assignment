public class SensorObserver implements RoomObserver {
    public void onStatusChange(Room r) {
        if (r.isOccupied()) {
            System.out.println("Room " + r.getId() + " occupied. AC and lights ON.");
        } else {
            System.out.println("Room " + r.getId() + " unoccupied. AC and lights OFF.");
        }
    }
}
