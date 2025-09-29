Ex2 - Smart Office Facility (plain Java, console app)

Features:
- Configure number of rooms
- Book and cancel bookings
- Detect occupancy (sensor)
- Auto-control AC and Lights based on occupancy
- Logging and validations

Design Patterns:
- Singleton: OfficeManager (single global instance)
- Observer: Sensors trigger AC/Lights
- Command: Booking, Cancellation, OccupancyChange as commands

Compile/Run:
javac src/*.java
java -cp src Main
