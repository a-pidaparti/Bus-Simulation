//written by pidap008

public class Bus {
    public boolean direction;   //true means eastbound, false means westbound
    public  Passenger[] passengers;
    public int size = 0;
    public double maxLength = 0;
    public double totalWait = 0;
    public double totalPassengers = 0;
    public double maxWait = 0;
    public double totalOccupancy = 0;
    public double totalBoarding = 0;


    public String name;
    public int stopIndex;

    public static Stop[] stopList = new Stop[10];
    public Bus(boolean size, boolean dir, String name, Stop initStop){
        if(size) {
            passengers = new Passenger[40]; // if size is true, bus has capacity of 40
        }
        else{
            passengers = new Passenger[60]; // if size is false, bus has capacity of 60
        }
        direction = dir;
        this.name = name;

        stopList[0] = BusSim.twentySeventhSt;
        stopList[1] = BusSim.raymondAve;
        stopList[2] = BusSim.fairviewAve;
        stopList[3] = BusSim.snellingAve;
        stopList[4] = BusSim.lexingtonPkwy;
        stopList[5] = BusSim.daleSt;
        stopList[6] = BusSim.marionSt;
        stopList[7] = BusSim.cedarSt;
        stopList[8] = BusSim.minnesotaSt;
        stopList[9] = BusSim.unionDepot;

        setStopIndex(initStop);
    }

    public int deboard(Stop stop){
        int pass = 0;
        for(int i = 0; i < passengers.length; i++){
            if(passengers[i] == null){  // if a null space is encountered, there are no passengers past that point
                i = passengers.length;
            }
            else if(passengers[i].getDestination() == stop){
                passengers[i] = null;
                pass++;
                size--;
            }
        }// for loop
        extractNull();
        return pass;
    } // deboard

    private void extractNull() {        // Brings non null objects to front of list
        int leader = 0;
        for (int i = 0; i < passengers.length; i++) {
            if (passengers[i] == null) {    // finds null object
                for (leader = i; leader < passengers.length && passengers[leader] == null; leader++) {}     // iterates until it finds a non null object

                if(leader == passengers.length){    // checks if at end of list/prevents IndexOutOfBoundsException
                    i = passengers.length;
                }
                else {
                    passengers[i] = passengers[leader];     // swaps null object with non null object
                    passengers[leader] = null;
                }
            }
        }//first for loop
    }//extract null

    public int board(Stop stop){

        int pass = 0;

        if(direction){  //if eastbound
            if(stopIndex != 9 && stop.eastBound.length() > maxLength){    //records max Q length
                maxLength = stop.eastBound.length();
            }//max Q length
            while(size != passengers.length && stop.eastBound.length() != 0){   //removes passengers from Q and adds to array
                passengers[size] = stop.eastBound.remove();
                totalWait += passengers[size].getTimeAtStation();
                if(passengers[size].getTimeAtStation() > maxWait){
                    maxWait = passengers[size].getTimeAtStation();
                }
                pass++;
                size++;
            }//remove/add
        }//eastbound

        else if(!direction){    //if westbound
            if(stopIndex != 0 && stop.westBound.length() > maxLength){    // records max Q length
                maxLength = stop.westBound.length();
            }// max length
            while(size != passengers.length && stop.westBound.length() != 0){   // removes from Q and adds to array
                passengers[size] = stop.westBound.remove();
                if(passengers[size].getTimeAtStation() > maxWait){
                    maxWait = passengers[size].getTimeAtStation();
                }
                pass++;
                size++;
            }//remove/add

        }//westbound
        totalPassengers += pass;
        totalOccupancy += size;
        totalBoarding ++;
        return pass;
    }//board

    public String toString(){
        return direction + ", " + size + "/" + passengers.length;
    }

    private void setStopIndex(Stop stop){    //finds stop in stop list
        for(int i = 0; i < 10; i++){
            if(stopList[i] == stop){
                stopIndex = i;
            }
        }
    }

    public int checkTwoStops(){
        int time = 0;
        int x = 100;
        if(stopIndex == 1 && direction){
            if(stopList[0].westBus != null){
                time+= Math.max(stopList[0].westBus.passengers.length - size, stopList[0].westBound.length()) * x;
            }
            if(stopList[1].westBus != null){
                time+= Math.max(stopList[1].westBus.passengers.length - size, stopList[1].westBound.length()) * x;
            }
        }
        else if(stopIndex == 8 && !direction){
            if(stopList[9].eastBus != null){
                time+= Math.max(stopList[9].eastBus.passengers.length - size, stopList[9].eastBound.length()) * x;
            }
            if(stopList[8].eastBus != null){
                time+= Math.max(stopList[8].eastBus.passengers.length - size, stopList[8].eastBound.length()) * x;
            }
        }
        else if(stopIndex == 9){
            if(stopList[8].eastBus != null){
                time+= Math.max(stopList[8].eastBus.passengers.length - size, stopList[8].eastBound.length()) * x;
            }
            if(stopList[7].eastBus != null){
                time+= Math.max(stopList[7].eastBus.passengers.length - size, stopList[7].eastBound.length()) * x;
            }
        }
        else if(stopIndex == 0){
            if(stopList[1].westBus != null){
                time+= Math.max(stopList[1].westBus.passengers.length - size, stopList[9].westBound.length()) * x;
            }
            if(stopList[2].westBus != null){
                time+= Math.max(stopList[2].westBus.passengers.length - size, stopList[2].westBound.length()) * x;
            }
        }
        else if(direction){
            if(stopList[stopIndex - 1].eastBus != null){
                time+= Math.max(stopList[stopIndex - 1].eastBus.passengers.length - size, stopList[stopIndex - 1].eastBound.length()) * x;
            }
            if(stopList[stopIndex - 2].eastBus != null){
                time+= Math.max(stopList[stopIndex - 2].eastBus.passengers.length - size, stopList[stopIndex - 2].eastBound.length()) * x;
            }
        }
        else{
            if(stopList[stopIndex + 1].westBus != null){
                time+= Math.max(stopList[stopIndex + 1].westBus.passengers.length - size, stopList[stopIndex + 1].westBound.length()) * x;
            }
            if(stopList[stopIndex + 2].westBus != null){
                time+= Math.max(stopList[stopIndex + 2].westBus.passengers.length - size, stopList[stopIndex + 2].westBound.length()) * x;
            }
        }
        return time;
    }

    public void updateBus(){
        if(direction){
            stopList[stopIndex].setEastBus(null);
            stopIndex--;
            stopList[stopIndex].setEastBus(this);
        }
        else{
            stopList[stopIndex].setWestBus(null);
            stopIndex++;
            stopList[stopIndex].setWestBus(this);
        }
        if(stopIndex == 9){
            direction = true;
        }
        else if(stopIndex == 0){
            direction = false;
        }
    }

}
