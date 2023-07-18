/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Area;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "areaCDIBean")
@SessionScoped
public class areaCDIBean implements Serializable {

    /**
     * Creates a new instance of adminBean
     */
    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Area> area;
    GenericType<List<Area>> garea;
    Collection<Area> area1;
    int areaIDPK;
    String areaname;
    int pincode;

    public areaCDIBean() {
        
        areaname = "";
        pincode = 0;

    }

    public Collection<Area> findallarea() {

        return this.abl.findallarea();
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    public int getAreaIDPK() {
        return areaIDPK;
    }

    public void setAreaIDPK(int areaIDPK) {
        this.areaIDPK = areaIDPK;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    public String addArea() {
        abl.addArea(areaname, pincode);
        areaIDPK=0;
        areaname = "";
        pincode=0;
        return "showArea.xhtml?faces-redirect=true;";

    }

    public String deleteArea(int areaIDPK) {
        this.ac.removeArea(areaIDPK);
        return "showArea.xhtml?faces-redirect=true;";
    }

    public String updateArea() {

        abl.updateArea(areaIDPK, areaname, pincode);
        areaIDPK=0;
        areaname = "";
        pincode=0;
        return "showArea.xhtml?faces-redirect=true;";
    }

    public String editArea(int id) {
        Area area1 = abl.getArea(id);
        areaIDPK = area1.getAreaIDPK();
        areaname = area1.getAreaname();
        pincode = area1.getPincode();
        return "addArea.xhtml?faces-redirect=true;";
    }
    
    public String goToDisplay()
    {
        areaIDPK=0;
        areaname = "";
        pincode=0;
        return "showArea.xhtml?faces-redirect=true;";
    }
}
