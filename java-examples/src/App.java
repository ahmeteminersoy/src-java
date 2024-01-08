import java.text.SimpleDateFormat;
import java.util.Date;

public class App{
    public static void main(String[] args) {
        run();
    }
    public static void run()
    {
        long oneHourMilliseconds = 60 * 60 * 1000;
        Date d1 = new Date();
        Date d2 = new Date(d1.getTime() + oneHourMilliseconds);
        Date d3 = new Date(d1.getTime() + 2 * oneHourMilliseconds);
        Date d4 = new Date(d1.getTime() + 3 * oneHourMilliseconds);
        Date d5 = new Date(d1.getTime() + 4 * oneHourMilliseconds);
        CarPark carPark = new CarPark(10, 5);
        Vehicle v1 = new Vehicle("34KG3916", 4);
        Vehicle v2 = new Vehicle("34GV8993", 2);
        Vehicle v3 = new Vehicle("34AN4876", 1);
        Vehicle v4 = new Vehicle("50FF444", 2);
        Vehicle v5 = new Vehicle("34EDB511", 4);
        Ticket t1 = carPark.parkVehicle(v1, d1);
        Ticket t2 = carPark.parkVehicle(v2, d2);
        Ticket t3 = carPark.parkVehicle(v3, d3);
        Ticket t4 = carPark.parkVehicle(v4, d4);
        Ticket t5 = carPark.parkVehicle(v5, d5);
        carPark.printVehicleList();
        carPark.exitVehicle(t1, new Date(d1.getTime() + 5 * oneHourMilliseconds));
        carPark.exitVehicle(t2, new Date(d2.getTime() + 5 * oneHourMilliseconds));
        carPark.printVehicleList();
        carPark.exitVehicle(t3, new Date(d3.getTime() + 5 * oneHourMilliseconds));
        carPark.exitVehicle(t4, new Date(d4.getTime() + 5 * oneHourMilliseconds));
        System.out.println(carPark.getTotalIncome());
        System.out.printf("Total number of vehicles %d%n", Ticket.numberOfTickets);
        carPark.printTickets();
    }
}
class Vehicle {
    private final String plateNumber;
    private int size;

    public Vehicle(String plateNumber, int size) {
        this.plateNumber = plateNumber;
        if (size == 1 || size == 2 || size == 4)
            this.size = size;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public int getSize() {
        return size;
    }
    public String getVehicleInfo()
    {
        return String.format("Vehicle Info%nPlate Number : %s%nSize : %d", plateNumber, size);
    }
}
class ParkPlace {
    private int size;
    private Vehicle vehicle;


    public ParkPlace(Vehicle vehicle) {
        this.vehicle = vehicle;
        this.size = vehicle.getSize();
    }

    public int getSize() {
        return size;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
}
class Ticket {
    private Vehicle vehicle;
    private Date entryDate;
    private Date exitDate;
    private double totalPrice;
    public static int numberOfTickets;

    private double numberOfHours;

    public Ticket(Vehicle vehicle, Date entryDate) {
        this.vehicle = vehicle;
        this.entryDate = entryDate;
        numberOfTickets += 1;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public double getPrice() {
        return totalPrice;
    }
    public double calculatePrice(double hourlyPrice, Date exitDate)
    {
        this.exitDate = exitDate;
        numberOfHours = (exitDate.getTime() - entryDate.getTime() )/ (60.0 * 60 * 1000);
        numberOfHours = Math.ceil(numberOfHours);
        this.totalPrice = vehicle.getSize() * hourlyPrice * numberOfHours;
        return totalPrice;
    }


    public String getTicketInfo() {
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
        String formattedEntryDate = sdf.format(entryDate);

        Date now = new Date();

        if (now.getTime() > exitDate.getTime())
        {
            return String.format("Ticket Info %nPlate Number : %s%nEntry : %s", vehicle.getPlateNumber(),
                    formattedEntryDate);
        }
        else
        {
            String formattedExitDate = sdf.format(exitDate);
            return String.format("Ticket Info %nPlate Number : %s%nEntry : %s%nExit : %s%nHour : %.1f%nFee : %f TLs%n",
                    vehicle.getPlateNumber(), formattedEntryDate, formattedExitDate, numberOfHours, totalPrice);
        }

    }

}
class CarPark {
    private int capacity;
    public ParkPlace [] parkPlaceArray;
    public Ticket[] ticketArray;

    private final double hourlyPrice;

    public CarPark(int capacity, double hourlyPrice) {
        this.capacity = capacity;
        this.hourlyPrice = hourlyPrice;
        parkPlaceArray = new ParkPlace[capacity];
        ticketArray = new Ticket[capacity];
    }
    public Ticket parkVehicle(Vehicle vehicle, Date entryDate)
    {
        if (vehicle.getSize() > capacity)
        {
            System.out.println("Car park is full!");
            return null;
        }
        capacity -= vehicle.getSize();
        ParkPlace parkPlace = new ParkPlace(vehicle);
        Ticket ticket = new Ticket(vehicle, entryDate);
        System.out.printf("The vehicle with %s plate number is parked.%n", vehicle.getPlateNumber());
        for (int i = 0; i < parkPlaceArray.length; i++)
            if (parkPlaceArray[i] == null)
            {
                parkPlaceArray[i] = parkPlace;
                break;
            }
        return ticket;
    }
    public Vehicle exitVehicle (Ticket ticket, Date exitDate)
    {
        for (int i = 0; i < parkPlaceArray.length; i++)
        {
            if (ticket != null && parkPlaceArray[i] != null && parkPlaceArray[i].getVehicle().getPlateNumber() == ticket.getVehicle().getPlateNumber())
            {
                System.out.printf("The price for vehicle with %s plate number is %s%n",ticket.getVehicle().getPlateNumber(),
                        ticket.calculatePrice(hourlyPrice, exitDate));
                for (int k = 0; k < ticketArray.length; k++)
                {
                    if (ticketArray[k] == null)
                    {
                        ticketArray[k] = ticket;
                        break;
                    }
                }
                parkPlaceArray[i] = null;
                return ticket.getVehicle();
            }
        }
        System.out.println("Car is not in the parking area.");
        return ticket.getVehicle();
    }
    public double getTotalIncome (){
        double totalIncome = 0.0;
        for (Ticket ticket : ticketArray)
            if (ticket != null)
                totalIncome += ticket.getPrice();
        return totalIncome;
    }
    public void printVehicleList()
    {
        for (ParkPlace pp : parkPlaceArray)
            if (pp != null)
                System.out.println(pp.getVehicle().getVehicleInfo());

    }
    public void printTickets()
    {
        for (Ticket t : ticketArray)
            if (t != null)
                System.out.println(t.getTicketInfo());
    }
}