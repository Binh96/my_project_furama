package modules;

public class Room extends Facility{
    private String freeService;

    public Room(){

    }

    public Room(String freeService){
        this.freeService = freeService;
    }

    public Room(String serviceCode, String serviceName, Double areaUse,
                Double feeArent, Integer maximumPerson, String typeOfRent, String freeService){
        super(serviceCode, serviceName, areaUse, feeArent, maximumPerson, typeOfRent);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", free service= " + freeService;
    }
}
