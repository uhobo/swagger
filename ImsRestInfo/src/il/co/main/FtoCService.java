package il.co.main;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang3.StringUtils;

import il.co.main.model.Generated;
import il.co.main.model.GeneratorInput;
import il.co.main.model.ResponseCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.ws.rs.core.Response;


@Path("/hello")
@Api(value = "hello")
//@Produces({"application/json", "application/xml"})
public class FtoCService {
	
	
	
	
	@ApiOperation(value="Say Hello", response=String.class)
	@GET
	@Path("/sayXMLHello")
	@Produces(MediaType.TEXT_XML)
	public String sayXMLHello() {
		return "<?xml version=\"1.0\"?>" + "<hello> Hello Jersey" + "</hello>";
  }
	// This method is called if TEXT_PLAIN is request
	 @ApiOperation(value="Say Hello", response=String.class)
	 @GET
	 @Path("/sayPlainTextHello")
	 @Produces(MediaType.TEXT_PLAIN)
	  public String sayPlainTextHello() {
	    return "Hello Jersey";
	  }
	 
	  // This method is called if XML is request
	 	
//
//	  // This method is called if HTML is request
	 @ApiOperation(value="Say Hello2", response=String.class)
	  @GET
	  @Path("/sayHtmlHello")
	  @Produces(MediaType.TEXT_HTML)
	 	public String sayHtmlHello() {
	 			return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
	  }
	 
	 @POST
	 @Path("/clients/{language}")
	 @ApiOperation(
	            value = "Generates a client library",
	            notes = "Accepts a `GeneratorInput` options map for spec location and generation options",
	            response = ResponseCode.class, tags = "clients")
	 public Response generateClient(
			 	@Context HttpServletRequest request,
	            @ApiParam(value = "The target language for the client library", required = true) @PathParam("language") String language
	            /*@ApiParam(value = "Configuration for building the client library", required = true) GeneratorInput opts*/)
	            throws Exception  {
		
		 GeneratorInput opts = new GeneratorInput();
		 opts.setSwaggerUrl("http://localhost:8080/ImsRestInfo/rest/swagger.json");
		 String filename = Generator.generateClient(language, opts);
		 
		 String host = System.getenv("GENERATOR_HOST");

	        if (StringUtils.isBlank(host)) {
	            String scheme = request.getHeader("X-SSL");
	            String port = "";
	            if ("1".equals(scheme)) {
	                scheme = "https";
	            } else {
	                scheme = request.getScheme();
	                port = ":" + request.getServerPort();
	            }
	            host = scheme + "://" + request.getServerName() + port;
	        }

	        if (filename != null) {
	            String code = String.valueOf(UUID.randomUUID().toString());
	            Generated g = new Generated();
	            g.setFilename(filename);
	            g.setFriendlyName(language + "-client");
	           // fileMap.put(code, g);
	            System.out.println(code + ", " + filename);
	            String link = host + "/api/gen/download/" + code;
	            return Response.ok().entity(new ResponseCode(code, link)).build();
	        } else {
	            return Response.status(500).build();
	        }
		 
	 }
	 
//	 private static Swagger parseAndPrepareSwagger(String path) {
//	        Swagger swagger = new SwaggerParser().read(path);
//	        CodegenConfig codegenConfig = new JavaClientCodegen();
//	        codegenConfig.set
//	        // resolve inline models
//	        new InlineModelResolver().flatten(swagger);
//	        return swagger;
//	  }
	  
}