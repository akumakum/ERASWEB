package com.eras.erasweb.controller;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;
import com.eras.erasweb.model.FormObject;
import com.eras.erasweb.model.Hospital;
import com.eras.erasweb.model.UserResponse;
import com.eras.erasweb.service.*;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller

public class UserController {
	@Autowired
	private UserTypeService userTypeService;
	
	@Autowired
	private UserPositionService userPositionService;
	@Autowired
	private UserService userService;
	
    @GetMapping("/maintenance/user-new")
    public String CreateUserForm(Model model) {    	
    	//User user = new User()
    	 
    	UserDTO user = new UserDTO();
    	model.addAttribute("user",user);
    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
    	model.addAttribute("userPosition",userPosition);
    	model.addAttribute("userType",userType);
    	return "user-create";
    	
    }
    
    @PostMapping("/maintenance/user-new-save")
    public String SaveUserForm(HttpSession session,@Valid  @ModelAttribute("user")UserDTO user,BindingResult result,
    		 Model model ) {
    	// Retrieve Hospital and User 
    	 String username = (String) session.getAttribute("username");
	     Hospital hospital = (Hospital) session.getAttribute("hospital");
    	
	    // UserTypeDTO userTypeDTO = userTypeService.findById(user.getUserTypeID());
	   //  UserPositionDTO userPositionDTO = userPositionService.findById(user.getUserPositionID());
	     
	   //  user.setUserTypes(userTypeDTO);
	   //  user.setUserPositions(userPositionDTO);
    	// Retrieve Hospital and User
    	
    	if(result.hasErrors())
    		{// UserDTO user = new UserDTO();
	    	model.addAttribute("user",user);
	    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
	    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
	    	model.addAttribute("userPosition",userPosition);
	    	model.addAttribute("userType",userType);
    		return "user-create";}
    	   if (!user.getPassword().equals(user.getConfirmPassword())) {
               result.rejectValue("confirmPassword", "error.user", "Passwords do not match");
		    	model.addAttribute("user",user);
		    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
		    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
		    	model.addAttribute("userPosition",userPosition);
		    	model.addAttribute("userType",userType);
	
           return "user-create";
           }


    	LocalDateTime today =LocalDateTime.now(); 
    	user.setDateCreated(today);
       
        // Audit
        user.setCreatedBy(username);
        user.setHospitalCode(hospital.getHospitalCode());
        user.setHospitalId(hospital.getHospitalID());
        user.setDateCreated(today);
        user.setDateUpdated(today);
        user.setUserPositions(user.getUserPositions());
        user.setUserTypes(user.getUserTypes());
        // Audit	
//    	try {
    		userService.SaveUser(user);
//	    	}
//	    	catch (DataIntegrityViolationException e) {
//	    	    System.out.println("Fullname or UserID already exist");
//	    	    model.addAttribute("errorMessage", e.getMessage());
//	    	    model.addAttribute("user",user);
//	    	    List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
//		    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
//		    	model.addAttribute("userPosition",userPosition);
//		    	model.addAttribute("userType",userType);
//	    	    return "user-create";
//	    		}	    	
    	
    	return "redirect:/maintenance/user-new";
    }
    
    
    @PostMapping("/maintenance/user-edit-save")
    public String SaveEditUserForm(HttpSession session,@Valid  @ModelAttribute("user")UserDTO user,BindingResult result, 
    		  Model model ) {
    	// Retrieve Hospital and User 
    	 String username = (String) session.getAttribute("username");
	     Hospital hospital = (Hospital) session.getAttribute("hospital");
	     
//	     UserTypeDTO userTypeDTO = userTypeService.findById(user.getUserTypeID());
//	     UserPositionDTO userPositionDTO = userPositionService.findById(user.getUserPositionID());
//	     
//	     user.setUserTypes(userTypeDTO);
//	     user.setUserPositions(userPositionDTO);
	     
//    	
    	// Retrieve Hospital and User
    	if(result.hasErrors())
    		{// UserDTO user = new UserDTO();
	    	model.addAttribute("user",user);
	    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
	    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
	    	model.addAttribute("userPosition",userPosition);
	    	model.addAttribute("userType",userType);
    		return "user-view";}
    	   if (!user.getPassword().equals(user.getConfirmPassword())) {
               result.rejectValue("confirmPassword", "error.user", "Passwords do not match");
		    	model.addAttribute("user",user);
		    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
		    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
		    	model.addAttribute("userPosition",userPosition);
		    	model.addAttribute("userType",userType);

           return "redirect: /maintenance/users/userlistall";
           }
    	   
    	LocalDateTime today =LocalDateTime.now(); 
    	user.setHospitalCode(hospital.getHospitalCode());
    	user.setHospitalId(hospital.getHospitalID());
    	user.setCreatedBy(username);
    	
    	//user.setUserPositions(user.getUserPositions());
       // user.setUserTypes(user.getUserTypes());
    	
    	userService.UpdateUser(user,user.getUserID() );
    	
    	return "redirect:/maintenance/user-new";
    }
    
    @GetMapping("/maintenance/user/{userID}/view")
    public String ViewSingleUser(@PathVariable("userID") Long iduser, Model model) {
    	UserDTO user =userService.SearchUserbyID(iduser);
    	// pass id to selectbox for display

    	user.setConfirmPassword(user.getPassword());
    	model.addAttribute( "user",user);
    	List<UserTypeDTO> userType = userTypeService.ListAllUserTypeCreated(); //deparmentService.ListOfDeparments();
    	List<UserPositionDTO> userPosition =userPositionService.SearchAllUserPosition();
    	model.addAttribute("userPosition",userPosition);
    	model.addAttribute("userType",userType);
    	return "user-view.html";
    }
    
	   @GetMapping("/maintenance/users/userlistall")
	    public String ViewAllUsers(
	    		@RequestParam(value="PageNo",required = false )String spageNo ,
	    		@RequestParam(value="PageSize",required = false )String spageSize,
	    		@RequestParam(value = "lastnamequery", required = false) String lastname ,
	    		@RequestParam(value="firstname",required =false) String firstname , 
	    		Model model)
	    {
	  
	    	if (spageNo==null) {spageNo="1";}
	    	if (spageSize==null) {spageSize="5";}
	    	
	    	int pageNo=Integer.parseInt(spageNo.trim());
	    	int pageSize=Integer.parseInt(spageSize.trim());
	    	
	    	UserResponse users = userService.ListAllusers(pageNo, pageSize);
	    	
	    	model.addAttribute( "users",users.getContent());
	    	model.addAttribute("currenPage",users.getPageNO());
	    	model.addAttribute("totalPages",users.getTotalPages());
	    	model.addAttribute("totalItems", users.getTotalElement());
	    	return "ListOfUsers2.html";
	    }
	   
	   


}
