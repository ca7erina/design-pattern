package designPattern.proxy;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class GumballMachine extends UnicastRemoteObject implements GumballMachineRemote {

    String location;
    State soldOutState;
    State noQuarterState;
    State hasQuarterState;
    State soldState;

    State state = soldOutState;
    int count =0;


    public GumballMachine(String location, int numberGumballs)throws RemoteException{
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        this.count = numberGumballs;
        if(numberGumballs>0){
            state = noQuarterState;
        }
        this.location = location;
    }

    public void insertQuarter(){
        state.insertQuarter();
    }

    public void ejectQuarter(){
        state.ejectQuater();
    }

    public void turnCrank(){
        state.turnCrank();
        state.dispense();
    }

    void setState(State state){
        this.state = state;
    }

    void releaseBall(){
        System.out.println("A gumball comes rolling out the slot");
        if(count!=0){
            count--;
        }

    }

    public State getSoldOutState(){
        return this.soldOutState;
    }

    public State getNoQuarterState(){
        return this.noQuarterState;
    }

    public State getHasQuarterState(){
        return this.hasQuarterState;
    }

    public State getSoldState(){
        return this.soldState;
    }

    public int getCount(){
        return this.count;
    }

    public String toString(){
        return "Machine state:" + state;
    }


    public String getLocation(){
        return location;
    }

    public State getState(){
       return this.state;
    }


}
