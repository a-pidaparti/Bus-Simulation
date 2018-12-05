//written by pidap008

public class Passenger {
    private boolean direction;
    private Stop arrival;
    private Stop destination;
    private int arrivalTime;

    public Passenger(boolean dir, Stop arrival, Stop destination, int time){
        this.direction = dir;   //if dir is true, passenger is traveling east, if false, traveling west
        this.arrival = arrival;
        this.destination = destination;
        this.arrivalTime = time;
    }

    public boolean getDirection(){
        return direction;
    }

    public Stop getDestination(){
        return destination;
    }

    public Stop getArrival(){
        return arrival;
    }

    public int getTimeAtStation(){
       return (int) BusSim.agenda.getCurrentTime() - arrivalTime;
    }
}
