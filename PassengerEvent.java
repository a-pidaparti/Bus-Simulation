//written by pidap008

public class PassengerEvent implements IEvent{
    private Passenger p;
    Stop[] destinationArray = new Stop[13];
    private Stop stop;

    public PassengerEvent(Passenger tmp, Stop stop){
        p = tmp;
        this.stop = stop;
        destinationArray[0] = BusSim.twentySeventhSt;  // array to select random destination for next passenger
        destinationArray[1] = BusSim.raymondAve;
        destinationArray[2] = BusSim.fairviewAve;
        destinationArray[3] = BusSim.snellingAve;
        destinationArray[4] = BusSim.lexingtonPkwy;
        destinationArray[5] = BusSim.daleSt;
        destinationArray[6] = BusSim.marionSt;
        destinationArray[7] = BusSim.cedarSt;
        destinationArray[8] = BusSim.minnesotaSt;
        destinationArray[9] = BusSim.cedarSt;
        destinationArray[10] = BusSim.unionDepot;
        destinationArray[11] = BusSim.minnesotaSt;
        destinationArray[12] = BusSim.unionDepot;
    }

    public void run(){
        if(p.getDirection()){   //adds passenger to appropriate Q
            stop.eastBound.add(p); }
        else{
            stop.westBound.add(p); }

       // System.out.println("Passenger arrived at " + stop + " at " + BusSim.agenda.getCurrentTime());

        int index = (int) (Math.random() * 13); // selects random index for destination selection
        while(destinationArray[index] == stop){ //recalculates if same stop
            index = (int) (Math.random() * 13);
        }
        Stop destination = destinationArray[index];



        boolean direction = Math.random() < .5;
        if(stop.getStop().equals("University Ave and 27th Street")){   //overrides direction based on stop
            direction = false; }
        else if(stop.getStop().equals("Union Depot")){     // overrides direction based on stop
            direction = true; }


        Passenger newPass = new Passenger(direction, destination, stop, (int) BusSim.agenda.getCurrentTime());

        PassengerEvent event = new PassengerEvent(newPass, stop);
        if(stop.equals(BusSim.cedarSt) || stop.equals(BusSim.minnesotaSt) || stop.equals(BusSim.unionDepot)){   //makes downtown arrival more frequent
            BusSim.agenda.add(event, 140);
        }
        else{
            BusSim.agenda.add(event, 210);
        }
    }
}
