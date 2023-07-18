/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package cdiBeans;

import client.adminClient;
import ejb.adminBeanLocal;
import entity.Gallery;
import entity.Gallery;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.nio.file.Files;
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
@Named(value = "galleryCDIBean")
@SessionScoped
public class galleryCDIBean implements Serializable {

    @EJB
    adminBeanLocal abl;
    adminClient ac = new adminClient();
    Response rs;
    List<Gallery> gallery;
    GenericType<List<Gallery>> ggallery;
    Collection<Gallery> s1;
    int galleryIDPK;
    String image;
    int mechanicIDFK;
    String mechanicname;
    Part file;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    /**
     * Creates a new instance of galleryCDIBean
     */
    public galleryCDIBean() {
        galleryIDPK = 0;
        image = "";
        mechanicIDFK = 0;
        mechanicname = "";
    }

    public int getGalleryIDPK() {
        return galleryIDPK;
    }

    public void setGalleryIDPK(int galleryIDPK) {
        this.galleryIDPK = galleryIDPK;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getMechanicIDFK() {
        return mechanicIDFK;
    }

    public void setMechanicIDFK(int mechanicIDFK) {
        this.mechanicIDFK = mechanicIDFK;
    }

    public String getMechanicname() {
        return mechanicname;
    }

    public void setMechanicname(String mechanicname) {
        this.mechanicname = mechanicname;
    }

    public Collection<Gallery> findallgallery() {

        return this.abl.findallgallery();
    }

    public String addGallery() {

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
            abl.addGallery(image, mechanicIDFK, mechanicname);
            //   galleryIDPK = 0;
            image = "";
            mechanicIDFK = 0;
            mechanicname = "";
            return "showGallery.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }

    }

    public String deleteGallery(int galleryIDPK) {
        this.ac.removeGallery(galleryIDPK);
        return "showGallery.xhtml?faces-redirect=true;";
    }

    public String updateGallery() {
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
            abl.updateGallery(galleryIDPK, image, mechanicIDFK, mechanicname);
            galleryIDPK = 0;
            image = "";
            mechanicIDFK = 0;
            mechanicname = "";
            return "showGallery.xhtml?faces-redirect=true;";
        } catch (IOException ex) {
            return ex.getMessage();
        }
    }

    public String editGallery(int id) {
        Gallery gallery1 = abl.getGallery(id);
        galleryIDPK = gallery1.getGalleryIDPK();
        image = gallery1.getImage();
        mechanicIDFK = gallery1.getMechanicIDFK().getMechanicIDPK();
        mechanicname = gallery1.getMechanicname();
        return "addGallery.xhtml?faces-redirect=true;";
    }

    public String goToDisplay() {
        galleryIDPK = 0;
        image = "";
        mechanicIDFK = 0;
        mechanicname = "";
        return "showGallery.xhtml?faces-redirect=true;";
    }

}
