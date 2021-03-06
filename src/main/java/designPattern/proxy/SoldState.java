package designPattern.proxy;


/**
 * Created by chenxiaoxue on 8/1/16.
 */
public class SoldState implements State {
    transient GumballMachine gumballMachine;
    public SoldState(GumballMachine gumballMachine){
        this.gumballMachine = gumballMachine;
    }
    @Override
    public void insertQuarter() {
        System.out.println("Please wait, we're already giving you a gumball");
    }

    @Override
    public void ejectQuater() {
        System.out.println("Sorry, you already turned the crank");
    }

    @Override
    public void turnCrank() {
        System.out.println("Turning twice doesn't get you another gumball");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();

        if(gumballMachine.getCount()>0){
            gumballMachine.setState(gumballMachine.getState());
        }else{
            System.out.println("opps, out of gumballs");
            gumballMachine.setState(gumballMachine.getState());

        }
    }
    public String toString(){
        return "SoldState";
    }

}
