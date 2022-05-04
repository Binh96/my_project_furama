package modules;

public class House extends Facility{
    private String roomStandard;
    private Integer numberOfFloor;

    public House(){

    }

    public House(String roomStandard, Integer numberOfFloor){
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public House(String serviceCode, String serviceName, Double areaUse,
                 Integer feeArent, Integer maximumPerson, String typeOfRent, String roomStandard, Integer numberOfFloor){
        super(serviceCode, serviceName, areaUse, feeArent, maximumPerson, typeOfRent);
        this.roomStandard = roomStandard;
        this.numberOfFloor = numberOfFloor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public Integer getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(Integer numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", room standard= " + roomStandard+
                ", number of floor= " + numberOfFloor;
    }
}
