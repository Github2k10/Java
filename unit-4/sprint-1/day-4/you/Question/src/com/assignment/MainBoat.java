package com.assignment;

import java.util.Scanner;
public class MainBoat {
  static void printTicketDetails(Passenger ps, MotorBoat mb, SpeedBoat sb) {
    System.out.println("Passenger Id: " + ps.getPassengerId());
    System.out.println("Name: " + ps.getName());
    if(mb != null)
      System.out.println("Motor Boat Number: " + ps.getMotorBoat().getMotorBoatNumber());
    else
      System.out.println("Speed Boat Number: " + ps.getSpeedBoat().getSpeedBoatNumber());
}

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    //Create object of MotorBoat
    MotorBoat mb = new MotorBoat("MB001");
    //set the capacity to 5
    mb.setCapacity(5);
    //Create object of SpeedBoat
    SpeedBoat sb = new SpeedBoat("SB001");
    //set the capacity to 3
    sb.setCapacity(3);
    //Create 10 objects of passenger class one by one and take input also
    int counter = 1;  
    Passenger ps = null;
    do {
      System.out.print("Enter name of passenger ");
      ps = new Passenger(sc.next());
      System.out.print("Enter 1 to take motor boat or 2 for speed boat ");
      int choice = sc.nextInt();
      if(choice == 1) {
        //user has opted for Motor Boat
        boolean isAlloted = BoatTicketIssue.issueTicket(ps, mb);
        if(isAlloted == true) {
          printTicketDetails(ps, mb, null);
        }else {
          System.out.println("No motor boat available.. Wait for next round");
        }
      }else if(choice == 2){
        //user has opted for Speed Boat
        boolean isAlloted = BoatTicketIssue.issueTicket(ps, sb);
        if(isAlloted == true) {
          printTicketDetails(ps, null, sb);
        }else {
          System.out.println("No speed boat available.. Wait for next round");
        }
      }
      System.out.println();
    }while(++counter <= 10);
    sc.close();
  }
}