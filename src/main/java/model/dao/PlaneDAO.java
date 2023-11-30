package model.dao;

import model.entity.Plane;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlaneDAO extends AbstractDAO<Plane> {
    @Override
    public void create(Plane entity) throws SQLException {
        Connection con = getConnection();
        String sql = "INSERT INTO plane(seats_available, total_seats, model) VALUES (?,?,?)";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getSeats_available());
        pst.setInt(2, entity.getTotal_seats());
        pst.setString(3, entity.getModel());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public Plane read(int ID) throws SQLException {
        Connection con = getConnection();
        String sql = "SELECT * FROM plane WHERE id_plane = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, ID);
        ResultSet rs = pst.executeQuery();
        Plane readPlane = new Plane();
        if(rs.next()) {
            readPlane.setID(rs.getInt("id_plane"));
            readPlane.setSeats_available(rs.getInt("seats_available"));
            readPlane.setTotal_seats(rs.getInt("total_seats"));
            readPlane.setModel(rs.getString("model"));
        }
        return readPlane;
    }

    @Override
    public void delete(Plane entity) throws SQLException {
        Connection con = getConnection();
        String sql = "DELETE FROM plane WHERE id_plane = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getID());
        pst.executeUpdate();
        con.close();
    }

    @Override
    public void update(Plane entity) throws SQLException {
        Connection con = getConnection();
        String sql = "UPDATE plane SET seats_available = ?, total_seats = ?, model = ? WHERE id_plane = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, entity.getSeats_available());
        pst.setInt(2, entity.getTotal_seats());
        pst.setString(3, entity.getModel());
        pst.setInt(4, entity.getID());
        pst.executeUpdate();
        con.close();
    }

    public List<Plane> list() throws SQLException {
        Connection con = getConnection();
        String sql = "SELECT * FROM plane ORDER BY id_plane";
        ArrayList<Plane> planeList = new ArrayList<>();
        PreparedStatement pst = con.prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        while(rs.next()) {
            Plane p = new Plane();
            p.setID(rs.getInt("id_plane"));
            p.setSeats_available(rs.getInt("seats_available"));
            p.setTotal_seats(rs.getInt("total_seats"));
            p.setModel(rs.getString("model"));
            planeList.add(p);
        }
        return planeList;
    }
}
