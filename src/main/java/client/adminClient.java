/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:restResource [vehicle]<br>
 * USAGE:
 * <pre>
 *        adminClient client = new adminClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author KHUSHI
 */
public class adminClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/vehicle/resources";

    public adminClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("vehicle");
    }

    public <T> T findallrequest(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallrequest");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findallbooking(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallbooking");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeArea(int areaIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeArea/{0}", new Object[]{areaIDPK})).request().delete();
    }

    public <T> T getRequest(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getrequest");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getGallery(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getgallery");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String username, String address, String email, String mobileno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addUser/{0}/{1}/{2}/{3}", new Object[]{username, address, email, mobileno})).request().post(null);
    }

    public <T> T getUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getuser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateMechanic(String mechanicIDPK, String image, String serviceIDFK, String servicename, String mechanicname, String gender, String areaIDFK, String areaname, String skill, String experience, String costperhour, String ratings) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateMechanic/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{mechanicIDPK, image, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings})).request().put(null);
    }

    public <T> T getBooking(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getbooking");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findallgallery(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallgallery");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addArea(String areaname, String pincode) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addArea/{0}/{1}", new Object[]{areaname, pincode})).request().post(null);
    }

    public <T> T findallservice(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallservice");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void removeUser(int userIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeUser/{0}", new Object[]{userIDPK})).request().delete();
    }

    public void removeService(int serviceIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeService/{0}", new Object[]{serviceIDPK})).request().delete();
    }

    public void addService(String image, String servicename, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addService/{0}/{1}/{2}", new Object[]{image, servicename, description})).request().post(null);
    }

    public <T> T findallarea(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallarea");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getMechanic(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getmechanic");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T findalluser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findalluser");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public String getJson() throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public void addBooking() throws ClientErrorException {
        webTarget.path("addBooking/requestIDFK/requestname/status/date/time").request().post(null);
    }

    public void updateBooking(String bookingIDPK, String areaIDFK, String areaname, String serviceIDFK, String servicename, String requestname, String userIDFK, String username, String mechanicIDFK, String mechanicname, String payemnt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateBooking/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{bookingIDPK, areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname, payemnt})).request().put(null);
    }

    public void removeGallery(int galleryIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeGallery/{0}", new Object[]{galleryIDPK})).request().delete();
    }

    public void addRequest(String areaIDFK, String areaname, String serviceIDFK, String servicename, String requestname, String userIDFK, String username, String mechanicIDFK, String mechanicname, String status, String payemnt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRequest/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname, status, payemnt})).request().post(null);
    }

    public void updateRequest(String requestIDPK, String areaIDFK, String areaname, String serviceIDFK, String servicename, String requestname, String userIDFK, String username, String mechanicIDFK, String mechanicname, String status, String payemnt) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRequest/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}/{11}", new Object[]{requestIDPK, areaIDFK, areaname, serviceIDFK, servicename, requestname, userIDFK, username, mechanicIDFK, mechanicname, status, payemnt})).request().put(null);
    }

    public void updateArea(String areaIDPK, String areaname, String pincode) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateArea/{0}/{1}/{2}", new Object[]{areaIDPK, areaname, pincode})).request().put(null);
    }

    public <T> T findallmechanic(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("findallmechanic");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String userIDPK, String username, String address, String email, String mobileno) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateUser/{0}/{1}/{2}/{3}/{4}", new Object[]{userIDPK, username, address, email, mobileno})).request().put(null);
    }

    public void removeBooking(int bookingIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeBooking/{0}", new Object[]{bookingIDPK})).request().delete();
    }

    public void removeMechanic(int mechanicIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeMechanic/{0}", new Object[]{mechanicIDPK})).request().delete();
    }

    public void updateGallery() throws ClientErrorException {
        webTarget.path("updateGallery/galleryIDPK/image/mechanicIDFK/mechanicname").request().put(null);
    }

    public <T> T getService(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getservice");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public void updateService(String serviceIDPK, String image, String servicename, String description) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateService/{0}/{1}/{2}/{3}", new Object[]{serviceIDPK, image, servicename, description})).request().put(null);
    }

    public void addGallery() throws ClientErrorException {
        webTarget.path("addGallery/image/mechanicIDFK/mechanicname").request().post(null);
    }

    public void removeRequest(int requestIDPK) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("removeRequest/{0}", new Object[]{requestIDPK})).request().delete();
    }

    public <T> T getArea(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("getarea");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addMechanic(String image, String serviceIDFK, String servicename, String mechanicname, String gender, String areaIDFK, String areaname, String skill, String experience, String costperhour, String ratings) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addMechanic/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}/{8}/{9}/{10}", new Object[]{image, serviceIDFK, servicename, mechanicname, gender, areaIDFK, areaname, skill, experience, costperhour, ratings})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
