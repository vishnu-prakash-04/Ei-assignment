import java.util.*;

public class Main {
    public static void main(String[] args) {
        OfficeManager mgr = OfficeManager.getInstance();
        mgr.addObserver(new SensorObserver());
        Scanner sc = new Scanner(System.in);
        System.out.println("Smart Office Facility. Type 'help' for commands.");

        while(true){
            System.out.print("cmd> ");
            String line = sc.nextLine().trim();
            if(line.isEmpty()) continue;
            String[] parts = line.split(" ");
            String cmd = parts[0].toLowerCase();

            switch(cmd){
                case "help":
                    System.out.println("Commands:");
                    System.out.println(" configrooms N");
                    System.out.println(" book roomId");
                    System.out.println(" cancel roomId");
                    System.out.println(" occupancy roomId count");
                    System.out.println(" list");
                    System.out.println(" exit");
                    break;
                case "configrooms":
                    if(parts.length<2){ System.out.println("Usage: configrooms N"); break; }
                    int n = Integer.parseInt(parts[1]);
                    mgr.configureRooms(n);
                    break;
                case "book":
                    if(parts.length<2){ System.out.println("Usage: book id"); break; }
                    new BookRoomCommand(Integer.parseInt(parts[1])).execute();
                    break;
                case "cancel":
                    if(parts.length<2){ System.out.println("Usage: cancel id"); break; }
                    new CancelRoomCommand(Integer.parseInt(parts[1])).execute();
                    break;
                case "occupancy":
                    if(parts.length<3){ System.out.println("Usage: occupancy id count"); break; }
                    new OccupancyCommand(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])).execute();
                    break;
                case "list":
                    for(Room r : mgr.getRooms()) System.out.println(r);
                    break;
                case "exit":
                    System.out.println("Exiting.");
                    return;
                default:
                    System.out.println("Unknown command.");
            }
        }
    }
}
