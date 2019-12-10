package exper.rest.service;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import java.util.*;

import org.json.JSONException;
import org.json.JSONObject;

import com.google.gson.Gson;

import vo.requestDetails;
import vo.resposeDetails;

@Path("PostExampleService")
public class PostExampleService {
    @POST
    @Path("/trancation")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes("application/json")
    public Object getEmpInfo(String payload) {
    	resposeDetails res = new resposeDetails();
    	requestDetails req = new requestDetails();
    	Gson gson = new Gson();
    	String abc = null;
    	 /*JSONObject reqJson = new JSONObject(payload);
		
		if(reqJson.get("name")== null || reqJson.get("name").equals(""))
		{
			res.setMsg("Name missing in request parameter.");	
		}*/
    	req = gson.fromJson(payload, requestDetails.class);
		 
    	if(req.getName()== null || req.getName().equals(""))
    	{
    		res.setMsg("Name missing in request.");
    	}else
    	if(req.getAge()== null || req.getAge().equals(""))
    	{
    		res.setMsg("Age missing in request.");
    	}else
    	{
    		res.setStatus("done");		
    	}	
 
		
		 abc = gson.toJson(res);
    	
        return abc;
        }
}