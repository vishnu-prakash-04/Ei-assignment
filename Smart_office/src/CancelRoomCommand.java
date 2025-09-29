public class CancelRoomCommand implements Command {
    private int roomId;
    public CancelRoomCommand(int id){ this.roomId = id; }
    public void execute(){
        OfficeManager mgr = OfficeManager.getInstance();
        Room r = mgr.getRoom(roomId);
        if (r == null){ System.out.println("Invalid room."); return; }
        if (!r.isBooked()) { System.out.println("Room " + roomId + " not booked."); return; }
        r.cancel();
        System.out.println("Booking for Room " + roomId + " cancelled.");
    }
}
