package Project2;

import Controller.PlaneService;
import model.entity.Plane;

import java.util.List;
import java.util.Scanner;

public class CLI {
    private boolean managing = true;
    CLI() {
    }
    public void manage() throws Exception {
        PlaneService ps = new PlaneService();
        System.out.println("Welcome to the plane manager!");
        while(managing) {
            Scanner scan = new Scanner(System.in);
            System.out.println("Select an option by their number\n1. add a plane\n2. delete plane\n3. update plane\n4. view plane by id\n5. view all planes\n6. stop managing");

            Integer option = scan.nextInt();
            scan.nextLine();
            System.out.println("You have selected option " + option);

            if(option == 1) {
                System.out.println("Model of the plane:");
                String model = scan.nextLine();

                System.out.println("Seats available for the plane: ");
                Integer seatsAvailable = scan.nextInt();
                scan.nextLine();

                System.out.println("Total seats for the plane: ");
                Integer totalSeats = scan.nextInt();
                scan.nextLine();

                System.out.println("The plane you have entered has " + seatsAvailable + " seats available " + totalSeats + " total seats and the model is " + model);
                ps.createNewPlane(seatsAvailable, totalSeats, model);
                System.out.println("The plane has been added");
            }
            else if(option == 2) {
                System.out.println("id of plane you want to delete: ");
                Integer id = scan.nextInt();
                scan.nextLine();
                ps.deletePlane(id);
                System.out.println("The plane has been deleted");
            }
            else if(option == 3) {
                System.out.println("Which plane would you like to update (plane id): ");
                Integer id = scan.nextInt();
                scan.nextLine();

                System.out.println("Enter new seats available: ");
                Integer seatsAvailable = scan.nextInt();
                scan.nextLine();

                System.out.println("Enter new total seats: ");
                Integer totalSeats = scan.nextInt();
                scan.nextLine();

                System.out.println("Enter new model: ");
                String model = scan.nextLine();

                ps.updatePlane(id, seatsAvailable, totalSeats, model);
            }
            else if(option == 4) {
                System.out.println("id of the plane you want to look at: ");
                Integer id = scan.nextInt();
                scan.nextLine();
                Plane planeRead = ps.readPlaneById(id);
                System.out.println("plane_id: " + planeRead.getID());
                System.out.println("seats available: " + planeRead.getSeats_available());
                System.out.println("total seats: " + planeRead.getTotal_seats());
                System.out.println("model: " + planeRead.getModel());
                System.out.println("\n");
            }
            else if(option == 5) {
                List<Plane> planeList = ps.getList();
                for(int i = 0; i < planeList.size(); i++) {
                    System.out.println("plane_id: " + planeList.get(i).getID());
                    System.out.println("seats available: " + planeList.get(i).getSeats_available());
                    System.out.println("total seats: " + planeList.get(i).getTotal_seats());
                    System.out.println("model: " + planeList.get(i).getModel());
                    System.out.println("\n");
                }
            }
            else {
                managing = false;
            }
        }
    }
}