/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Area;
import entity.Mechanic;
import entity.Service;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
import java.sql.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import javax.ejb.EJB;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "mechanicCDIBean")
@SessionScoped
public class mechanicCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Mechanic> mechanic;
    GenericType<List<Mechanic>> gmechanic;
    Collection<Mechanic> m1;
    int mechanicIDPK;
    String image;
    int serviceIDFK;
    String servicename;
    String mechanicname;
    String gender;
    int areaIDFK;
    String areaname;
    String skill;
    String experience;
    String costperhour;
    int ratings;
    Part file;
    
    List<String> genderoptions;

    public List<String> getGenderoptions() {
        return genderoptions;
    }

    public void setGenderoptions(List<String> genderoptions) {
        this.genderoptions = genderoptions;
    }

    /**
     * Creates a new instance of mechanicCDIBean
     */
    public mechanicCDIBean() {
        image = "";
        serviceIDFK = 0;
        servicename = "";
        mechanicname = "";
        gender = "";
        areaIDFK = 0;
        areaname = "";
        skill = "";
        experience = "";
        costperhour = "";
        ratings = 0;
        genderoptions=Arrays.asList("Male","Female");
    }

    public int getMechanicIDPK() {
        return mechanicIDPK;
    }

    public void setMechanicIDPK(int mechanicIDPK) {
        this.mechanicIDPK = mechanicIDPK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getServiceIDFK() {
        return serviceIDFK;
    }

    public void setServiceIDFK(int serviceIDFK) {
        this.serviceIDFK = serviceIDFK;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAreaIDFK() {
        return areaIDFK;
    }

    public void setAreaIDFK(int areaIDFK) {
        this.areaIDFK = areaIDFK;
    }

    public String getAreaname() {
        return areaname;
    }

    public void setAreaname(String areaname) {
        this.areaname = areaname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getCostperhour() {
        return costperhour;
    }

    public void setCostperhour(String costperhour) {
        this.costperhour = costperhour;
    }

    public int getRatings() {
        return ratings;
    }

    public void setRatings(int ratings) {
        this.ratings = ratings;
    }

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

     public Collection<Mechanic> findallmechanic() {

        return this.abl.findallmechanic();
    }

    
    public String addMechanic() {
        try {
            InputStream input = file.getInputStream();
            String path = "D:\\Sem 8\\Project 2023 OVS\\vehicle\\src\\main\\webapp\\uploads";
            Random random = new Random();
            StringBuilder sb = new StringBuilder();

            sb.append(random.nextInt(9) + 1);
            for (int i = 0; i < 11; i++) {
                sb.append(random.nextInt(10));
            }
            String temp = sb.toString();

            image = "IMG_" + temp + file.getSubmittedFileName();
            Files.copy(input, new File(path, image).toPath());
            abl.addMechanic(image, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings);
            mechanicIDPK = 0;
            image = "";
            serviceIDFK = 0;
            servicename = "";
            mechanicname = "";
            gender = "";
            areaIDFK = 0;
            areaname = "";
            skill = "";
            experience = "";
            costperhour = "";
            ratings = 0;
            return "showMechanic.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String updateMechanic() {
        try {
            if (file != null) {
                InputStream input = file.getInputStream();
                String path = "D:\\Sem 8\\Project 2023 OVS\\vehicle\\src\\main\\webapp\\uploads";
                Random random = new Random();
                StringBuilder sb = new StringBuilder();

                sb.append(random.nextInt(9) + 1);
                for (int i = 0; i < 11; i++) {
                    sb.append(random.nextInt(10));
                }
                String temp = sb.toString();
                image = "IMG_" + temp + file.getSubmittedFileName();
                Files.copy(input, new File(path, image).toPath());
            }
            abl.updateMechanic(mechanicIDPK, image, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings);
            mechanicIDPK = 0;
            image = "";
            serviceIDFK = 0;
            servicename = "";
            mechanicname = "";
            gender = "";
            areaIDFK = 0;
            areaname = "";
            skill = "";
            experience = "";
            costperhour = "";
            ratings = 0;
            return "showMechanic.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String editMechanic(int id) {
        Mechanic m1 = abl.getMechanic(id);
        mechanicIDPK = m1.getMechanicIDPK();
        image = m1.getImage();
        serviceIDFK = m1.getServiceIDFK().getServiceIDPK();
        servicename = m1.getServicename();
        mechanicname = m1.getMechanicname();
        gender = m1.getGender();
        areaIDFK = m1.getAreaIDFK().getAreaIDPK();
        areaname = m1.getAreaname();
        skill = m1.getSkill();
        experience = m1.getExperience();
        costperhour = m1.getCostperhour();
        ratings = m1.getRatings();
        return "addMechanic.xhtml?faces-redirect=true;";
    }

    public String deleteMechanic(int mechanicIDPK) {
        this.ac.removeMechanic(mechanicIDPK);
        return "showMechanic.xhtml?faces-redirect=true;";
    }

    public String goToDisplay() {
        mechanicIDPK = 0;
        image = "";
        serviceIDFK = 0;
        servicename = "";
        mechanicname = "";
        gender = "";
        areaIDFK = 0;
        areaname = "";
        skill = "";
        experience = "";
        costperhour = "";
        ratings = 0;
        return "showMechanic.xhtml?faces-redirect=true;";
    }
}
