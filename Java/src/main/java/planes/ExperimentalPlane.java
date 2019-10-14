package planes;

import types.ClassificationTypes;
import types.ExperimentalTypes;

public class ExperimentalPlane extends Plane{

    private ExperimentalTypes type;
    private ClassificationTypes classificationTypes;

    public ExperimentalPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalTypes type, ClassificationTypes classificationTypes) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.type = type;
        this.classificationTypes = classificationTypes;
    }

    public ClassificationTypes getClassificationTypes(){
        return classificationTypes;
    }

    public void setClassificationTypes(ClassificationTypes classificationTypes){
        this.classificationTypes = classificationTypes;
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "ExperimentalPlane{" +
                "model='" + model + '\'' +
                '}';
    }
}
