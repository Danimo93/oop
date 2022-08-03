public class BikeRegistering extends BikeReg{
    private String Component;
    private String ComponentA;
    private String ComponentB;
    private String ComponentC;
    private String Answer;

    public BikeRegistering(){
    }

    public BikeRegistering(String Componet,String ComponentA, String ComponentB, String ComponentC) {
        this.Component = Component;
        this.ComponentA = ComponentA;
        this.ComponentB = ComponentB;
        this.ComponentC = ComponentC;
        this.Answer = Answer;
    }

    public String getComponent() {
        return Component;
    }

    public void setComponent(String component) {
        Component = component;
    }

    public String getComponentA() {
        return ComponentA;
    }

    public void setComponentA(String componentA) {
        ComponentA = componentA;
    }

    public String getComponentB() {
        return ComponentB;
    }

    public void setComponentB(String componentB) {
        ComponentB = componentB;
    }

    public String getComponentC() {
        return ComponentC;
    }

    public void setComponentC(String componentC) {
        ComponentC = componentC;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    @Override
    void showQuestion() {

    }

    @Override
    void isCorrectAnswer(String answer) {

    }
}
