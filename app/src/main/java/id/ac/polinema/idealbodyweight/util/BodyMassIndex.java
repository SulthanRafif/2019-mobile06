package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {

    private int height;
    private int weight;
    private float index;

    public BodyMassIndex(int height, int weight){
        this.height = height;
        this.weight = weight;
        this.index = calculate();
    }

    public float getIndex(){
        return index;
    }

    private float calculate(){
        float hasil;

        hasil = weight / (height * height);

        return hasil;
    }

}
