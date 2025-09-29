public class BookRoomCommand implements Command {
    private int roomId;
    public BookRoomCommand(int id){ this.roomId = id; }
    public void execute(){
        OfficeManager mgr = OfficeManager.getInstance();
        Room r = mgr.getRoom(roomId);
        if (r == null){ System.out.println("Invalid room."); return; }
        if (r.isBooked()) { System.out.println("Room " + roomId + " already booked."); return; }
        r.book();
        System.out.println("Room " + roomId + " booked successfully.");
    }
}
