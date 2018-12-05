//written by pidap008

public class BusEvent implements IEvent{
    private Bus bus;
    private Stop stop;
    private Stop[] stopList = new Stop[10];

    public BusEvent(Bus curBus, Stop curStop){
        bus = curBus;
        stop = curStop;

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
    }

    public void run(){
        int waitTime;
        bus.updateBus();
        int deboard = bus.deboard(stop);
        int board = bus.board(stop);
        if((board * 3) + (deboard * 2) > 15){   // if wait time is greater than 15 seconds
            waitTime = (board * 3) + (deboard * 2);
        }
        else{
            waitTime = 15;
        }
        bus.board(stop);


        int i;
        if(bus.direction){
            i = bus.stopIndex - 1;
        }
        else {
            i = bus.stopIndex + 1;
        }

        waitTime += bus.checkTwoStops();        //TO TURN OFF CLUMPING COMPENSATION, COMMENT THIS LINE
        BusEvent event = new BusEvent(bus,stopList[i]);
        BusSim.agenda.add(event, 180 + waitTime);
    }
}
