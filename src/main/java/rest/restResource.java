/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package rest;

import ejb.adminBeanLocal;
import entity.Area;
import entity.Auth;
import entity.Booking;
import entity.Gallery;
import entity.Mechanic;
import entity.Request;
import entity.Service;
import entity.User;
import java.math.BigDecimal;
import java.sql.Time;
import java.util.Collection;
import java.util.Date;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.enterprise.context.RequestScoped;
import javax.json.Json;
import javax.json.JsonObject;
import javax.ws.rs.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author KHUSHI
 */
@Path("vehicle")
@RequestScoped

public class restResource {

    @EJB
    adminBeanLocal asb;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of restResource
     */
    public restResource() {
    }

    //for Area
    @GET
    @Path("findallarea")
    @Produces("application/json")
    public Collection<Area> findallarea() {
        return asb.findallarea();
    }

    @GET
    @Path("getarea")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getArea() {
        JsonObject json = null;
        if (asb.findallarea() != null) {
            return Response.ok(asb.findallarea()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }

    }

    @POST
    @Path("addArea/{areaname}/{pincode}")
    public void addArea(@PathParam("areaname") String areaname, @PathParam("pincode") int pincode) {
        asb.addArea(areaname, pincode);
    }

    @DELETE
    @Path("removeArea/{areaIDPK}")
    public void removeArea(@PathParam("areaIDPK") int areaIDPK) {
        asb.removeArea(areaIDPK);
    }

    @PUT
    @Path("updateArea/{areaIDPK}/{areaname}/{pincode}")
    public void updateArea(@PathParam("areaIDPK") int areaIDPK, @PathParam("areaname") String areaname, @PathParam("pincode") int pincode) {
        asb.updateArea(areaIDPK, areaname, pincode);
    }

    //for User
    @GET
    @Path("findalluser")
    @Produces("application/json")
    public Collection<User> findalluser() {
        return asb.findalluser();
    }

    @GET
    @Path("getuser")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getUser() {
        JsonObject json = null;
        if (asb.findalluser() != null) {
            return Response.ok(asb.findalluser()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addUser/{username}/{address}/{email}/{mobileno}")
    public void addUser(@PathParam("username") String username, @PathParam("address") String address, @PathParam("email") String email, @PathParam("mobileno") String mobileno,@PathParam("password") String password,@PathParam("userType") String userType) {
        asb.addUser(username, address, email, mobileno, password, userType);
    }

    @DELETE
    @Path("removeUser/{userIDPK}")
    public void removeUser(@PathParam("userIDPK") int userIDPK) {
        asb.removeUser(userIDPK);
    }

    @PUT
    @Path("updateUser/{userIDPK}/{username}/{address}/{email}/{mobileno}")
    public void updateUser(@PathParam("userIDPK") int userIDPK, @PathParam("username") String username, @PathParam("address") String address, @PathParam("email") String email, @PathParam("mobileno") String mobileno,@PathParam("password") String password,@PathParam("userType") String userType) {
        asb.updateUser(userIDPK, username, address, email, mobileno, password, userType);
    }

    //for service
    @GET
    @Path("findallservice")
    @Produces("application/json")
    public Collection<Service> findallservice() {
        return asb.findallservice();
    }

    @GET
    @Path("getservice")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getService() {
        JsonObject json = null;
        if (asb.findallservice() != null) {
            return Response.ok(asb.findallservice()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addService/{image}/{servicename}/{description}")
    public void addService(@PathParam("image") String image, @PathParam("servicename") String servicename, @PathParam("description") String description) {
        asb.addService(image, servicename, description);
    }

    @DELETE
    @Path("removeService/{serviceIDPK}")
    public void removeService(@PathParam("serviceIDPK") int serviceIDPK) {
        asb.removeService(serviceIDPK);
    }

    @PUT
    @Path("updateService/{serviceIDPK}/{image}/{servicename}/{description}")
    public void updateService(@PathParam("serviceIDPK") int serviceIDPK, @PathParam("image") String image, @PathParam("servicename") String servicename, @PathParam("description") String description) {
        asb.updateService(serviceIDPK, image, servicename, description);
    }

    //for mechanic
    @GET
    @Path("findallmechanic")
    @Produces("application/json")
    public Collection<Mechanic> findallmechanic() {
        return asb.findallmechanic();
    }

    @GET
    @Path("getmechanic")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getMechanic() {
        JsonObject json = null;
        if (asb.findallmechanic() != null) {
            return Response.ok(asb.findallmechanic()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addMechanic/{image}/{serviceIDFK}/{servicename}/{mechanicname}/{gender}/{areaIDFK}/{areaname}/{skill}/{experience}/{costperhour}/{ratings}")
    public void addMechanic(@PathParam("image") int image, @PathParam("serviceIDFK") int serviceIDFK, @PathParam("servicename") String servicename, @PathParam("mechanicname") String mechanicname, @PathParam("gender") String gender, @PathParam("areaIDFK") int areaIDFK, @PathParam("areaname") String areaname,
            @PathParam("skill") String skill, @PathParam("experience") String experience, @PathParam("costperhour") String costperhour, @PathParam("ratings") int ratings) {
        asb.addMechanic(skill, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings);
    }

    @DELETE
    @Path("removeMechanic/{mechanicIDPK}")
    public void removeMechanic(@PathParam("mechanicIDPK") int mechanicIDPK) {
        asb.removeMechanic(mechanicIDPK);
    }

    @PUT
    @Path("updateMechanic/{mechanicIDPK}/{image}/{serviceIDFK}/{servicename}/{mechanicname}/{gender}/{areaIDFK}/{areaname}/{skill}/{experience}/{costperhour}/{ratings}")
    public void updateMechanic(@PathParam("mechanicIDPK") int mechanicIDPK, @PathParam("image") int image, @PathParam("serviceIDFK") int serviceIDFK, @PathParam("servicename") String servicename, @PathParam("mechanicname") String mechanicname, @PathParam("gender") String gender, @PathParam("areaIDFK") int areaIDFK, @PathParam("areaname") String areaname,
            @PathParam("skill") String skill, @PathParam("experience") String experience, @PathParam("costperhour") String costperhour, @PathParam("ratings") int ratings) {
        asb.updateMechanic(mechanicIDPK, skill, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings);
    }

    //for request
    @GET
    @Path("findallrequest")
    @Produces("application/json")
    public Collection<Request> findallrequest() {
        return asb.findallrequest();
    }

    @GET
    @Path("getrequest")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getRequest() {
        JsonObject json = null;
        if (asb.findallrequest()!= null) {
            return Response.ok(asb.findallrequest()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addRequest/{areaIDFK}/{areaname}/{serviceIDFK}/{servicename}/{requestname}/{userIDFK}/{username}/{mechanicIDFK}/{mechanicname}/{status}/{payemnt}/{cost}")
    public void addRequest(@PathParam("areaIDFK") int areaIDFK, @PathParam("areaname") String areaname, @PathParam("serviceIDFK") int serviceIDFK, @PathParam("servicename") String servicename,
            @PathParam("requestname") String requestname, @PathParam("userIDFK") int userIDFK, @PathParam("username") String username, @PathParam("mechanicIDFK") int mechanicIDFK, @PathParam("mechanicname") String mechanicname,@PathParam("status") String status, @PathParam("payemnt") String payemnt,
            @PathParam("cost") String cost) {
        asb.addRequest(areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname,status, payemnt,cost);
    }

    @DELETE
    @Path("removeRequest/{requestIDPK}")
    public void removeRequest(@PathParam("requestIDPK") int requestIDPK) {
        asb.removeRequest(requestIDPK);
    }

    @PUT
    @Path("updateRequest/{requestIDPK}/{areaIDFK}/{areaname}/{serviceIDFK}/{servicename}/{requestname}/{userIDFK}/{username}/{mechanicIDFK}/{mechanicname}/{status}/{payemnt}/{cost}")
    public void updateRequest(@PathParam("requestIDPK") int requestIDPK, @PathParam("areaIDFK") int areaIDFK, @PathParam("areaname") String areaname, @PathParam("serviceIDFK") int serviceIDFK, @PathParam("servicename") String servicename,
            @PathParam("requestname") String requestname, @PathParam("userIDFK") int userIDFK, @PathParam("username") String username, @PathParam("mechanicIDFK") int mechanicIDFK, @PathParam("mechanicname") String mechanicname,@PathParam("status") String status, @PathParam("payemnt") String payemnt,
            @PathParam("cost") String cost) {
        asb.updateRequest(requestIDPK, areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname,status, payemnt,cost);
    }

        //for booking
      @GET
    @Path("findallbooking")
    @Produces("application/json")
    public Collection<Booking> findallbooking() {
        return asb.findallbooking();
    }

    @GET
    @Path("getbooking")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getBooking() {
        JsonObject json = null;
        if (asb.findallbooking()!= null) {
            return Response.ok(asb.findallbooking()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addBooking/requestIDFK/requestname/status/date/time")
    public void addBooking(@PathParam("requestIDFK") int requestIDFK,@PathParam("requestname") String requestname,@PathParam("status") String status,@PathParam("date") Date date,@PathParam("time") Time time) {
        asb.addBooking(requestIDFK, requestname, status, date, time);
    }

    @DELETE
    @Path("removeBooking/{bookingIDPK}")
    public void removeBooking(@PathParam("bookingIDPK") int bookingIDPK) {
        asb.removeBooking(bookingIDPK);
    }

    @PUT
    @Path("updateBooking/{bookingIDPK}/{areaIDFK}/{areaname}/{serviceIDFK}/{servicename}/{requestname}/{userIDFK}/{username}/{mechanicIDFK}/{mechanicname}/{payemnt}")
    public void updateBooking(@PathParam("bookingIDPK") int bookingIDPK,@PathParam("requestIDFK") int requestIDFK,@PathParam("requestname") String requestname,@PathParam("status") String status,@PathParam("date") Date date,@PathParam("time") Time time) {
       asb.updateBooking(bookingIDPK, requestIDFK, requestname, status, date, time);
    }

        //for gallery
       @GET
    @Path("findallgallery")
    @Produces("application/json")
    public Collection<Gallery> findallgallery() {
        return asb.findallgallery();
    }

    @GET
    @Path("getgallery")
    @Produces("application/json")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getGallery() {
        JsonObject json = null;
        if (asb.findallgallery()!= null) {
            return Response.ok(asb.findallgallery()).build();
        } else {
            json = Json.createObjectBuilder().add("error", "Error occured").build();
            return Response.status(404).entity(json).build();
        }
    }

    @POST
    @Path("addGallery/image/mechanicIDFK/mechanicname")
    public void addGallery(@PathParam("image") String image,@PathParam("mechanicIDFK") int mechanicIDFK,@PathParam("mechanicname") String mechanicname) {
        asb.addGallery(image, mechanicIDFK, mechanicname);
    }

    @DELETE
    @Path("removeGallery/{galleryIDPK}")
    public void removeGallery(@PathParam("galleryIDPK") int galleryIDPK) {
        asb.removeGallery(galleryIDPK);
    }

    @PUT
    @Path("updateGallery/galleryIDPK/image/mechanicIDFK/mechanicname")
    public void updateGallery(@PathParam("galleryIDPK") int galleryIDPK,@PathParam("image") String image,@PathParam("mechanicIDFK") int mechanicIDFK,@PathParam("mechanicname") String mechanicname) {
        asb.updateGallery(galleryIDPK, image, mechanicIDFK, mechanicname);
    }

//    //for auth
//    @GET
//    @Path("getauth")
//    @Produces("application/json")
//    @Consumes(MediaType.APPLICATION_JSON)
//    public Response getAuth() {
//        JsonObject json= null;
//        if(asb.getAuth()!=null){
//            return Response.ok(asb.getAuth()).build();
//        }else{
//            json = Json.createObjectBuilder().add("error", "Error occured").build();
//            return Response.status(404).entity(json).build();
//        }
//
//    }
//
    @POST
    @Path("addAuth/{userIDFK}/{username}/{email}/{password}/{usertype}")
    public void addAuth(@PathParam("userIDFK") int userIDFK, @PathParam("username") String username,@PathParam("email") String email,@PathParam("password") String password,@PathParam("usertype") String usertype) {
        asb.addAuth(userIDFK, username, email, password,usertype);
    }
//
//    @DELETE
//    @Path("removeAuth/{authIDPK}")
//    public void removeAuth(@PathParam("authIDPK") int authIDPK,@PathParam("userIDFK") int userIDFK) {
//        asb.removeAuth(authIDPK,userIDFK);
//    }
//
//    @PUT
//    @Path("updateAuth/{authIDPK}/{userIDFK}/{username}/{email}/{usertype}")
//    public void updateAuth(@PathParam("authIDPK") int authIDPK,@PathParam("userIDFK") int userIDFK, @PathParam("username") String username,@PathParam("email") String email,@PathParam("usertype") String usertype) {
//        asb.updateAuth(authIDPK, userIDFK, username, email, usertype);
//    }
//    
//    
      @GET
    @Path("findallauth")
    @Produces("application/json")
    public Collection<Auth> findallauth() {
        return asb.findallauth();
    }

    /**
     * Retrieves representation of an instance of rest.restResource
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of restResource
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
