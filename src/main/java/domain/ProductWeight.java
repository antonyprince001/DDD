package domain;

public class ProductWeight {

    private float weight;

    private String weightUnit;

    public float getWeight() {
        return weight;
    }



    public ProductWeight(float weight, String weightUnit) {
        this.weight = weight;
        this.weightUnit = weightUnit;
    }
}
