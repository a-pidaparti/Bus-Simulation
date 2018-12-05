//written by pidap008

public class BusSim {

    public static PQ agenda = new PQ(); // static so can be accessed anywhere
    public static Stop twentySeventhSt = new Stop(false, true, "University Ave and 27th Street");
    public static Stop raymondAve = new Stop(true, true, "Raymond Ave");
    public static Stop fairviewAve = new Stop(true, true, "University Ave and Fairview Ave");
    public static Stop snellingAve = new Stop(true, true, "University Ave and Snelling Ave");
    public static Stop lexingtonPkwy = new Stop(true, true, "University Ave and Lexington Parkway");
    public static Stop daleSt = new Stop(true, true, "University Ave and Dale Street");
    public static Stop marionSt = new Stop(true, true, "University Ave and Marion Street");
    public static Stop cedarSt = new Stop(true, true, "Cedar Street and 5th Street");
    public static Stop minnesotaSt = new Stop(true, true, "Minnesota Street and 4th Street");
    public static Stop unionDepot = new Stop(true, false, "Union Depot");

    public static Stop[] stopList = new Stop[10];

    public static void main(String[] args) {
        stopList[0] = twentySeventhSt;
        stopList[1] = raymondAve;
        stopList[2] = fairviewAve;
        stopList[3] = snellingAve;
        stopList[4] = lexingtonPkwy;
        stopList[5] = daleSt;
        stopList[6] = marionSt;
        stopList[7] = cedarSt;
        stopList[8] = minnesotaSt;
        stopList[9] = unionDepot;

        Bus b = new Bus(true, false, "b", twentySeventhSt);
        BusEvent e10 = new BusEvent(b, twentySeventhSt);
        agenda.add(e10,0);

        Bus b1 = new Bus(true, false, "b", snellingAve);
        BusEvent e11 = new BusEvent(b1, snellingAve);
        agenda.add(e11,0);

        Bus b2 = new Bus(true, false, "b", marionSt);
        BusEvent e12 = new BusEvent(b2, marionSt);
        agenda.add(e12,0);

        Bus b3 = new Bus(true,true, "b", unionDepot);
        BusEvent e13 = new BusEvent(b3, unionDepot);
        agenda.add(e13,0);

        Bus b4 = new Bus(true, true, "b", marionSt);
        BusEvent e14 = new BusEvent(b4, marionSt);
        agenda.add(e14, 0);

        Bus b5 = new Bus(true, true, "b", snellingAve);
        BusEvent e15 = new BusEvent(b5, snellingAve);
        agenda.add(e15, 0);

        //first 6

        Bus b6 = new Bus(true, false, "b", raymondAve);
        BusEvent e16 = new BusEvent(b6, raymondAve);
        agenda.add(e16, 0);

        Bus b7 = new Bus(true,  true, "b", lexingtonPkwy);
        BusEvent e17 = new BusEvent(b7, lexingtonPkwy);
        agenda.add(e17, 0);

        Bus b8 = new Bus(true,  true, "b", cedarSt);
        BusEvent e18 = new BusEvent(b8, cedarSt);
        agenda.add(e18, 0);

        Bus b9 = new Bus(true, false, "b", minnesotaSt);
        BusEvent e19 = new BusEvent(b9, minnesotaSt);
        agenda.add(e19, 0);

        Bus b10 = new Bus(true,  false, "b", daleSt);
        BusEvent e20 = new BusEvent(b10, daleSt);
        agenda.add(e20, 0);

        Bus b11 = new Bus(true, false, "b", fairviewAve);
        BusEvent e21 = new BusEvent(b11, fairviewAve);
        agenda.add(e21, 0);

        //second 6

     /*   Bus b12 = new Bus(true,true, "b", fairviewAve);
        BusEvent e22 = new BusEvent(b12, fairviewAve);
        agenda.add(e22, 0);

        Bus b13 = new Bus(true,  true, "b", daleSt);
        BusEvent e23 = new BusEvent(b13, daleSt);
        agenda.add(e23, 0);

        Bus b14 = new Bus(true, true, "b", minnesotaSt);
        BusEvent e24 = new BusEvent(b14, minnesotaSt);
        agenda.add(e24, 0);

        Bus b15 = new Bus(true,  false, "b", cedarSt);
        BusEvent e25 = new BusEvent(b15, cedarSt);
        agenda.add(e25, 0);

        Bus b16 = new Bus(true,false, "b", lexingtonPkwy);
        BusEvent e26 = new BusEvent(b16, lexingtonPkwy);
        agenda.add(e26, 0);

        Bus b17 = new Bus(true, false, "b", raymondAve);
        BusEvent e27 = new BusEvent(b17,raymondAve);
        agenda.add(e27, 0);*/

        //BEGIN PASSENGER EVENTS

        Passenger p = new Passenger(false, twentySeventhSt,raymondAve,0);
        PassengerEvent e = new PassengerEvent(p, twentySeventhSt);
        agenda.add(e,0);

        Passenger p1 = new Passenger(false, raymondAve,fairviewAve,0);
        PassengerEvent e1 = new PassengerEvent(p1, raymondAve);
        agenda.add(e1,0);

        Passenger p2 = new Passenger(false, fairviewAve,snellingAve,0);
        PassengerEvent e2 = new PassengerEvent(p2, fairviewAve);
        agenda.add(e2,0);

        Passenger p3 = new Passenger(false, snellingAve,lexingtonPkwy,0);
        PassengerEvent e3 = new PassengerEvent(p3, snellingAve);
        agenda.add(e3,0);

        Passenger p4 = new Passenger(false, lexingtonPkwy,daleSt,0);
        PassengerEvent e4 = new PassengerEvent(p4, lexingtonPkwy);
        agenda.add(e4,0);

        Passenger p5 = new Passenger(false, daleSt,marionSt,0);
        PassengerEvent e5 = new PassengerEvent(p5, daleSt);
        agenda.add(e5,0);

        Passenger p6 = new Passenger(false, marionSt,cedarSt,0);
        PassengerEvent e6 = new PassengerEvent(p6, marionSt);
        agenda.add(e6,0);

        Passenger p7 = new Passenger(false, cedarSt,minnesotaSt,0);
        PassengerEvent e7 = new PassengerEvent(p7, cedarSt);
        agenda.add(e7,0);

        Passenger p8 = new Passenger(false, minnesotaSt,unionDepot,0);
        PassengerEvent e8 = new PassengerEvent(p8, minnesotaSt);
        agenda.add(e8,0);

        Passenger p9 = new Passenger(true, unionDepot,fairviewAve,0);
        PassengerEvent e9 = new PassengerEvent(p9, unionDepot);
        agenda.add(e9,0);

        while (agenda.getCurrentTime() <= 57600) {
            agenda.remove().run();
        }

   /*     int totalTime = (int) (b.totalWait + b1.totalWait + b2.totalWait + b3.totalWait + b4.totalWait + b5.totalWait+b6.totalWait + b7.totalWait + b8.totalWait + b9.totalWait + b10.totalWait + b11.totalWait);//+ b12.totalWait+ b13.totalWait+ b14.totalWait+ b15.totalWait+ b16.totalWait+ b17.totalWait);
        double totalPass = b.totalPassengers + b1.totalPassengers+ b2.totalPassengers + b3.totalPassengers + b4.totalPassengers+ b5.totalPassengers + b6.totalPassengers + b7.totalPassengers + b8.totalPassengers + b9.totalPassengers + b10.totalPassengers+ b11.totalPassengers;// + b12.totalPassengers+ b13.totalPassengers+ b14.totalPassengers+ b15.totalPassengers+ b16.totalPassengers+ b17.totalPassengers;
        double totalBoarding = b.totalBoarding + b1.totalBoarding+ b2.totalBoarding+ b3.totalBoarding+ b4.totalBoarding+ b5.totalBoarding+ b6.totalBoarding + b7.totalBoarding+ b8.totalBoarding+ b9.totalBoarding+ b10.totalBoarding+ b11.totalBoarding;//+ b12.totalBoarding+ b13.totalBoarding+ b14.totalBoarding+ b15.totalBoarding+ b16.totalBoarding+ b17.totalBoarding;
        double totalOccupancy = b.totalOccupancy + b1.totalOccupancy+ b2.totalOccupancy+ b3.totalOccupancy+ b4.totalOccupancy+ b5.totalOccupancy+ b6.totalOccupancy + b7.totalOccupancy+ b8.totalOccupancy+ b9.totalOccupancy+ b10.totalOccupancy+ b11.totalOccupancy;//+ b12.totalOccupancy+ b13.totalOccupancy+ b14.totalOccupancy+ b15.totalOccupancy+ b16.totalOccupancy+ b17.totalOccupancy;
        double totalWait = b.maxWait + b1.maxWait + b2.maxWait+ b3.maxWait + b4.maxWait + b5.maxWait+b6.maxWait + b7.maxWait + b8.maxWait + b9.maxWait + b10.maxWait + b11.maxWait;//+b12.maxWait + b13.maxWait + b14.maxWait + b15.maxWait + b16.maxWait + b17.maxWait;
        double totalLine = b.maxLength + b1.maxLength + b2.maxLength+ b3.maxLength + b4.maxLength + b5.maxLength+b6.maxLength + b7.maxLength + b8.maxLength + b9.maxLength + b10.maxLength + b11.maxLength;//+b12.maxWait + b13.maxWait + b14.maxWait + b15.maxWait + b16.maxWait + b17.maxWait;
        System.out.println(totalTime);

        System.out.println(totalPass);

        System.out.println(totalBoarding);

        System.out.println(totalOccupancy);

        System.out.println(totalWait/12);

        System.out.println(totalLine/12);

        System.out.println("\n\n\n");

        System.out.println(totalTime/totalPass);    */ //used only for importing to excel, ignore

    }
}
