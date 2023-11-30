package Controller;

import model.dao.PlaneDAO;
import model.entity.Plane;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneService {
    public void createNewPlane(Integer seatsAvailable, Integer totalSeats, String model) throws Exception {
        Plane p = new Plane();
        p.setSeats_available(seatsAvailable);
        p.setTotal_seats(totalSeats);
        p.setModel(model);
        PlaneDAO pdao = new PlaneDAO();
        pdao.create(p);
    }
    public void deletePlane(Integer id) throws SQLException {
        PlaneDAO pdao = new PlaneDAO();
        Plane p = new Plane();
        p.setID(id);
        pdao.delete(p);
    }
    public List<Plane> getList() throws SQLException {
        PlaneDAO pdao = new PlaneDAO();
        List<Plane> planeList = pdao.list();
        return planeList;
    }
    public Plane readPlaneById(Integer ID) throws SQLException{
        PlaneDAO pdao = new PlaneDAO();
        Plane planeRead = pdao.read(ID);
        return planeRead;
    }
    public void updatePlane(Integer ID, Integer seatsAvailable, Integer totalSeats, String model) throws SQLException {
        PlaneDAO pdao = new PlaneDAO();
        Plane p = new Plane();
        p.setID(ID);
        p.setSeats_available(seatsAvailable);
        p.setTotal_seats(totalSeats);
        p.setModel(model);
        pdao.update(p);
    }
}
