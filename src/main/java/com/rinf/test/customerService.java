package com.rinf.test;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.rinf.test.model.Customer;
import com.rinf.test.model.ErrorMessage;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.ApiResponse;



@Path("customers")
@Api( value = "/")
public class customerService {

    
	List<Customer> customers= new ArrayList<>();
	
	public customerService() {

        for (int x = 0; x < 100; x++)
        {
            Customer customer = new Customer();
            
            customer.setId(Long.parseLong(String.valueOf(x)));
            customer.setName("Customer No "+x);
            customer.setEmail("email_"+x+"@email.com");
            customer.setPhoneNo("07232"+x);
            customers.add(customer);
        }
        
	}
	
	
	
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success")
    		})
    @ApiOperation(value="Hello")
    public Response sayHello(@ApiParam(name = "name", value = "Specify your name", required = false) @PathParam("name") String name) {
    
    	return Response.ok().entity("Hello "+name).build();
    	
    }
    
    
    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    @ApiResponses(value= {
    		@ApiResponse(code=200, message="Success")
    		})
    @ApiOperation(value="Get all customers")
    public Response getAllCustomers() {
        return Response.ok().entity(customers).build();
    }
    
    
    @GET
    @Path("/{email}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomerByEmail(@PathParam("email") String email) {
    	
    	for (Customer customer : customers) {
            if (customer.getEmail().equals(email)) {
            	return Response.ok().entity(customers.get(1)).build();
            }
        }
    	
    	
    	return Response.status(Response.Status.NOT_FOUND).entity("").build();
    	
        
    }
    
    
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addCustomer(Customer newCustomer) {
    	ErrorMessage err= new ErrorMessage();
    	if (newCustomer==null)
    	{ 
    		err.setCode(1);
    		err.setMessage("Request payload is empty");
    		return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    		
    	}
    	
    	
    	if(newCustomer.getEmail()==null||newCustomer.getEmail().isEmpty())
    	{
    		err.setCode(2);
    		err.setMessage("Email must be provided");
    		return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    		
    	}
    	
    	if(newCustomer.getName()==null||newCustomer.getName().isEmpty())
    	{
    		err.setCode(3);
    		err.setMessage("Name must be provided");
    		return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
    		
    	}
    	
    	for (Customer c : customers) {
            if (c.getEmail().equals(newCustomer.getEmail())) {
            	err.setCode(4);
        		err.setMessage("The email allready exists");
        		return Response.status(Response.Status.BAD_REQUEST).entity(err).build();
            }
        }
    	
    	newCustomer.setId(customers.get(customers.size()-1).getId()+1);
    	customers.add(newCustomer);
    	
        return Response.ok().entity(newCustomer).build();
    }
    
    
    
}
