public class Room {
    private int id;
    private boolean booked = false;
    private boolean occupied = false;
    private int occupants = 0;

    public Room(int id){ this.id = id; }
    public int getId(){ return id; }
    public boolean isBooked(){ return booked; }
    public boolean isOccupied(){ return occupied; }

    public void book(){ this.booked = true; }
    public void cancel(){ this.booked = false; }

    public void setOccupants(int count){
        this.occupants = count;
        this.occupied = count >= 2;
    }

    @Override
    public String toString(){
        return "Room " + id + " [booked=" + booked + ", occupied=" + occupied + ", occupants=" + occupants + "]";
    }
}
