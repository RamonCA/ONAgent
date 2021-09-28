import jade.core.Agent;
import jade.core.behaviours.OneShotBehaviour;


public class OneShotAgent extends Agent {
    private SLR_Agent testAgent;
    protected void setup() {
        testAgent = new SLR_Agent(this);
        testAgent.showGui();

    }

    public void actionAgent(final int value){
        addBehaviour(new OneShotBehaviour() {
            @Override
            public void action() {
                int [] x = {23,26,30,34,43,48,52,57,58};
                int [] y = {651,762,856,1063,1190,1298,1421,1440,1518};

                beta_calculation testOne = new beta_calculation(x,y, value);
                testOne.point_calculation();
                System.out.println("Agent's action method executed");
            }
        });
    }
}


