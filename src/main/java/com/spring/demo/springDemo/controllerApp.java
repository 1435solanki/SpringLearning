package com.spring.demo.springDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.demo.springDemo.service.dataBuilderImp;
import com.spring.demo.springDemo.esDao.ESDaoQuery;
import com.spring.demo.springDemo.request.StudentRequest;
import com.spring.demo.springDemo.request.StudentRequestImp;
import com.spring.demo.springDemo.request.StudentRequestWrapper;
import com.spring.demo.springDemo.service.dataBuilder;
import com.spring.demo.springDemo.service.dataBuilder.InfoData;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(value = "/SpringDemo")
@Api(value = "SpringDemo", description = "operations on SpringDemo")
public class controllerApp {
	@Autowired
	private springData spdata;
	@Autowired
	private dataBuilderImp dataimp;
	@Autowired
	private StudentRequestImp studentImp;
	@Autowired
	private ESDaoQuery esDaoquery;
	
	private static final Logger LOG = LoggerFactory.getLogger(controllerApp.class);

	@RequestMapping(value = "/Info", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<?> getInfo() throws Exception {
		// springData spdata = new springData();
		return ResponseEntity.ok(spdata.getInfo());
	}

	@RequestMapping(value = "/Entity", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found") })
	public ResponseEntity<?> getEntityInfo() throws Exception {
		return ResponseEntity.ok(dataimp.retriveData());
	}
	
	@RequestMapping(value = "/StudentInfo", method = RequestMethod.GET)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list")})
	public ResponseEntity<?> getStudentInfo() throws Exception {
		return ResponseEntity.ok(studentImp.getStudentInfoWrapper());
	}
	
	@RequestMapping(value = "/StudentInfoPost", method = RequestMethod.POST)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list")})
	public ResponseEntity<?> getStudentInfoPost(@RequestBody StudentRequestWrapper request) throws Exception {
		LOG.info("Request body for studentinfo "+ request);
		return ResponseEntity.ok(request.getStrequest());
	}
	
	@RequestMapping(value = "/StudentInfoESDB", method = RequestMethod.POST)
	@ApiOperation(value = "View a list of available products")
	@ApiResponses(value = { @ApiResponse(code = 200, message = "Successfully retrieved list")})
	public ResponseEntity<?> getStudentInfoES(@RequestBody StudentRequest request) throws Exception {
		LOG.info("Request body for studentinfo "+ request);
		return ResponseEntity.ok(esDaoquery.ESResponse(request));
	}
	
	
	@ApiOperation("Login.")
	@PostMapping("/login")
	public void fakeLogin(@ApiParam("User") @RequestParam String email, @ApiParam("Password") @RequestParam String password) {
	    throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
	}

	@ApiOperation("Logout.")
	@PostMapping("/logout")
	public void fakeLogout() {
	    throw new IllegalStateException("This method shouldn't be called. It's implemented by Spring Security filters.");
	}
	
	
}
