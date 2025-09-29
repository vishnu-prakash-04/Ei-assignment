public class OccupancyCommand implements Command {
    private int roomId;
    private int occupants;
    public OccupancyCommand(int id, int occ){ this.roomId=id; this.occupants=occ; }
    public void execute(){
        OfficeManager mgr = OfficeManager.getInstance();
        Room r = mgr.getRoom(roomId);
        if (r == null){ System.out.println("Invalid room."); return; }
        r.setOccupants(occupants);
        System.out.println("Room " + roomId + " occupancy updated to " + occupants + ".");
        mgr.notifyObservers(r);
    }
}
