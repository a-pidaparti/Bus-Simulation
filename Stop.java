//written by pidap008

public class Stop {
    public Q<Passenger> eastBound;
    public Q<Passenger> westBound;
    public String stop;
    public Bus eastBus;
    public Bus westBus;

    public Stop(boolean east, boolean west, String name){
        eastBound = new Q();
        westBound = new Q();
        stop = name;

    }
    public String getStop(){
        return stop;
    }

    public String toString(){
        return stop;
    }

    public void setEastBus(Bus bus){
        eastBus = bus;
    }

    public void setWestBus(Bus bus){
        westBus = bus;
    }
}
