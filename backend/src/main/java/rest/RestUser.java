package rest;

import com.google.gson.Gson;
import entity.User;
import facade.FacadeFactoryUser;
import facade.FacadeUser;
import iFace.IUser;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import static javax.ws.rs.HttpMethod.DELETE;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

@Path("user")
public class RestUser {

    private IUser user;
    private Gson gson;
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu_backend");
    private FacadeUser fu = new FacadeUser(emf);

    public RestUser() {
        user = FacadeFactoryUser.getInstance();
        gson = new Gson();
    }

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllUsers() {
        List<User> glist = user.getAllUsers();
        return gson.toJson(glist);
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getUserById(@PathParam("id") Long id) {
        List<User> u = user.getUser(id);
        return gson.toJson(u);
    }
    
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String createUser(String content) {
        User user = new Gson().fromJson(content, User.class);
        fu.addUser(user);
        return "{\"code\": 200, \"message\":\"User added.\"}";
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String updateUser(String content){
        User user = new Gson().fromJson(content, User.class);
        fu.editUser(user);
        return "{\"code\": 200, \"message\":\"User updated.\"}";
    }
    
    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String deleteUser(String content) {        
        User user = new Gson().fromJson(content, User.class);
        fu.deleteUser(user);
        return "{\"code\": 200, \"message\":\"User deleted.\"}";
    }
}
