package com.spring.demo.springDemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/SpringDemo")
@Api(value = "SpringDemo", description = "operations on SpringDemo")
public class controllerApp {
	@Autowired
	private springData spdata;
	/*@Autowired(required = true)
	public controllerApp(springData spdata){
		this.spdata = spdata;
	}*/
	
	
	@RequestMapping(value = "/Info", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<?> getInfo() throws Exception {
		//springData spdata = new springData();
		return ResponseEntity.ok(spdata.getInfo());
	}
}
