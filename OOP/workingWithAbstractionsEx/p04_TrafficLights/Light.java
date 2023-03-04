package workingWithAbstractionsEx.p04_TrafficLights;

public class Light {

    private Color color;

    public Light(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void changeColor() {
        //ако е червен - става зелен
        //ако е зелен - става жълт
        //ако е жълт - става червен

        if (this.color == Color.RED){
            this.color = Color.GREEN;

        } else if (this.color == Color.GREEN){
            this.color = Color.YELLOW;

        } else if(this.color == Color.YELLOW) {
            this.color = Color.RED;
        }
    }
}
