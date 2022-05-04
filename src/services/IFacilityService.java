package services;

import modules.Facility;

public interface IFacilityService extends IServices<Facility>{
    void addMap(Facility facility);
    void displayMaintain();
    void updateMaintain(Facility facility);
    String typeOfRent();
    String chooseTypeOfRent(int num);
}
