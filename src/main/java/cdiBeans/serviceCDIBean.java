/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Service;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.mail.MessagingException;
import javax.servlet.http.Part;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author KHUSHI
 */
@Named(value = "serviceCDIBean")
@SessionScoped
public class serviceCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Service> service;
    GenericType<List<Service>> gservice;
    Collection<Service> s1;
    int serviceIDPK;
    String servicename;
    String image;
    String description;
    Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    /**
     * Creates a new instance of serviceCDIBean
     */
    public serviceCDIBean() {
        servicename = "";
        image = "";
        description = "";
    }

    public int getServiceIDPK() {
        return serviceIDPK;
    }

    public void setServiceIDPK(int serviceIDPK) {
        this.serviceIDPK = serviceIDPK;
    }

    public String getServicename() {
        return servicename;
    }

    public void setServicename(String servicename) {
        this.servicename = servicename;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Collection<Service> findallservice() {

        return this.abl.findallservice();
    }

    public String addService() {

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
            abl.addService(image, servicename, description);
            serviceIDPK = 0;
            servicename = "";
            image = "";
            description = "";
            return "showService.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }

    }

    public String deleteService(int serviceIDPK) {
        this.ac.removeService(serviceIDPK);
        return "showService.xhtml?faces-redirect=true;";
    }

    public String updateService() {
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
            abl.updateService(serviceIDPK, image, servicename, description);
            serviceIDPK = 0;
            servicename = "";
            image = "";
            description = "";
            return "showService.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String editService(int id) {
        Service service1 = abl.getService(id);
        serviceIDPK = service1.getServiceIDPK();
        image = service1.getImage();
        servicename = service1.getServicename();
        description = service1.getDescription();
        return "addService.xhtml?faces-redirect=true;";
    }

    public String goToDisplay() {
        serviceIDPK = 0;
        servicename = "";
        image = "";
        description = "";
        return "showService.xhtml?faces-redirect=true;";
    }

}
