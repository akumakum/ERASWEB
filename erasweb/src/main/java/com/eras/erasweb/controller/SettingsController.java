package com.eras.erasweb.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.data.domain.Page;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.eras.erasweb.repository.UserRepository;
import com.eras.erasweb.service.ComorbiditiesReferenceService;
import com.eras.erasweb.service.ComorbiditiesService;
import com.eras.erasweb.service.HospitalService;
import com.eras.erasweb.service.MainPageURLService;
import com.eras.erasweb.service.OralOpioidsAgentsReferenceService;
import com.eras.erasweb.service.OralOpioidsAgentsService;
import com.eras.erasweb.service.PatientRecordService;
import com.eras.erasweb.service.SystemicOpioidsReferenceService;
import com.eras.erasweb.service.SystemicOpioidsService;
import com.eras.erasweb.service.UserPositionService;
import com.eras.erasweb.service.UserService;
import com.eras.erasweb.service.UserTypeService;
import com.eras.erasweb.service.UterotonicAgentReferenceService;
import com.eras.erasweb.service.UterotonicAgentService;
import com.eras.erasweb.service.impl.MrnSequenceService;
import com.eras.erasweb.model.*;
import com.eras.erasweb.dto.PatientRecordDTO;
import com.eras.erasweb.dto.ComorbiditiesDTO;
import com.eras.erasweb.dto.HospitalDTO;
import com.eras.erasweb.dto.MainPageURLDTO;
import com.eras.erasweb.dto.UserDTO;
import com.eras.erasweb.dto.UserPositionDTO;
import com.eras.erasweb.dto.UserTypeDTO;

import org.springframework.ui.Model;

import com.eras.erasweb.utils.ComorbiditiesDTOListWrapper;
import com.eras.erasweb.utils.ModelToDtoDtoToModel;

import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

//import javax.validation.Valid;

import java.time.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SettingsController {

	private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);
	// Paths:
	// /mantenance/{ITEMS}/{operation}/{id}}
	// /patientrecord/{ITEMS}/{operation}/{id}}
	private UserService userService;
	private UserRepository userRepository;
	private UserTypeService userTypeService;
	private UserPositionService userPositionService;
	private HospitalService hospitalService;
	private PatientRecordDTO patientRecordDTO;
	@Autowired
	private PatientRecordService patienRecordService;
	@Autowired
	private ComorbiditiesReferenceService comorbiditiesReferenceService;
	@Autowired
	private SystemicOpioidsReferenceService systemicOpioidsReferenceService;
	@Autowired
	private OralOpioidsAgentsReferenceService oralOpioidsAgentsReferenceService;
	@Autowired
	private UterotonicAgentReferenceService uterotonicAgentReferenceService;
	@Autowired
	private ComorbiditiesService comorbiditiesService;
	@Autowired
	private SystemicOpioidsService systemicOpioidsService;
	@Autowired
	private OralOpioidsAgentsService oralOpioidsAgentsService;
	@Autowired
	private UterotonicAgentService uterotonicAgentService;

	@Autowired
	private MrnSequenceService mrnSequenceService;

	private FormObject formObject = new FormObject();
	private FormObject positionObject = new FormObject();
	private ModelToDtoDtoToModel modelConverter = new ModelToDtoDtoToModel();
	private MainPageURLService mainPageURLService;

	public SettingsController(UserService userService, UserTypeService userTypeService,
			UserPositionService userPositionService, HospitalService hospitalService,
			MainPageURLService mainPageURLService) {
		this.userService = userService;
		this.userTypeService = userTypeService;
		this.userPositionService = userPositionService;
		this.hospitalService = hospitalService;
		this.mainPageURLService = mainPageURLService;

	}

	@GetMapping("/maintenance/home")
	public String erasAdminMain(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");
		MainPageURL mainPageURL = (MainPageURL) session.getAttribute("mainPageURL");
		model.addAttribute("username", username);
		model.addAttribute("hospital", hospital);
		model.addAttribute("mainPageURL", mainPageURL);
		return "Main";
	}
	
	@PostMapping("/maintenance/home")
	public String erasAdminMainp(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");
		MainPageURL mainPageURL = (MainPageURL) session.getAttribute("mainPageURL");
		model.addAttribute("username", username);
		model.addAttribute("hospital", hospital);
		model.addAttribute("mainPageURL", mainPageURL);
		return "Main";
	}

	@GetMapping("/patient/home")
	public String erasPatientMain(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		MainPageURL mainPageURL = (MainPageURL) session.getAttribute("mainPageURL");

		model.addAttribute("username", username);
		model.addAttribute("hospital", hospital);
		model.addAttribute("mainPageURL", mainPageURL);
		return "PatientMain";
	}
	
	@PostMapping("/patient/home")
	public String erasPatientMainp(HttpSession session, Model model) {
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		MainPageURL mainPageURL = (MainPageURL) session.getAttribute("mainPageURL");

		model.addAttribute("username", username);
		model.addAttribute("hospital", hospital);
		model.addAttribute("mainPageURL", mainPageURL);
		return "PatientMain";
	}

	@GetMapping("/maintenance/mainpageurl/set")
	public String MainPageURLSettings(Model model, Long hN) {
		MainPageURL mainPageURL = new MainPageURL();

		mainPageURL = mainPageURLService.ShowIfExist();
		if (mainPageURL.getIntroURL() == null || mainPageURL.getGuideURL() == null) {
			hN = (long) 0;

		} else {

			hN = (long) mainPageURL.getMainPageURLID();
		}

		MainPageURLDTO mainPageURLDTO = modelConverter.mapToMainPageURL(mainPageURL);
		model.addAttribute("mainPageURL", mainPageURLDTO);
		model.addAttribute("hN", hN);
		// return "hospital-edit-or-create";
		return "url-edit-or-create";
	}

	@PostMapping("/maintenance/mainpageurl/save")
	public String SaveMainPageURLSettings(HttpSession session,
			@ModelAttribute("mainPageURL") MainPageURLDTO mainPageURL, @ModelAttribute("hN") Long hN, Model model) {

		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User
		LocalDateTime today = LocalDateTime.now();
		if (hN > 0) {
			// update
			mainPageURLService.UpdateMainPageURL(mainPageURL, hN);

		} else {
			// insert
			mainPageURL.setDateCreated(today);
			mainPageURL.setCreatedBy(username);

			hN = mainPageURL.getMainPageURLID();
			mainPageURLService.SaveMainPageURL(mainPageURL);

		}

		// return "hospital-created";
		return "url-edit-or-create";
	}



	@GetMapping("/maintenance/user/userlistall/pages")
	public String ViewAllUsersPaginated(

			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "page") int pageNo, Model model) {

		int pageSize = 5;
		UserResponse users = userService.ListAllusers(pageNo, pageSize);

		model.addAttribute("users", users.getContent());
		model.addAttribute("currenPage", users.getPageNO());
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("totalItems", users.getTotalElement());
		return "ListOfUsers2.html";
	}



	@PostMapping("/maintenance/user/fullname")
	public String SearchAllByFirstNamePaginated(
			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstnamequery", required = false) String firstname,
			@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize,
			@RequestParam(value = "paged", required = false) String spage, Model model) {

		int paged = 0;

		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}
		if (spage != null) {
			paged = Integer.parseInt(spage.trim());
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		if (paged != 0) {
			pageNo = paged;
		}

		if (pageNo == 0) {
			pageNo = 1;
		}
		int pageSize = Integer.parseInt(spageSize.trim());

		UserResponse users = userService.ListAllByfirstName(firstname, pageNo, pageSize);

		model.addAttribute("firstnamequery", firstname);
		model.addAttribute("users", users.getContent());
		model.addAttribute("currenPage", users.getPageNO());
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("totalItems", users.getTotalElement());

		return "PaginatedListOfUsersPerFullname.html";
	}

	@GetMapping("/maintenance/usersearchbyfullname/pages")
	public String SearchAllByFrstName(@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstnamequery", required = false) String firstname,
			@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize,
			@RequestParam(value = "paged", required = false) String spage, Model model)

	{

		int paged = 0;

		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}
		if (spage != null) {
			paged = Integer.parseInt(spage.trim());
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		if (paged != 0) {
			pageNo = paged;
		}

		int pageSize = Integer.parseInt(spageSize.trim());
		if (pageNo == 0) {
			pageNo = 1;
		}

		UserResponse users = userService.ListAllByfirstName(firstname, pageNo, pageSize);

		// model.addAttribute( "users",users);
		model.addAttribute("lastnamequery", lastname);
		model.addAttribute("firstnamequery", firstname);
		model.addAttribute("users", users.getContent());
		model.addAttribute("currenPage", users.getPageNO());
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("totalItems", users.getTotalElement());
		return "PaginatedListOfUsersPerFullName.html";
	}

	@PostMapping("maintenance/user/usersearchbyid")
	public String SearchAllByLastName(@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize, Model model) {
		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		int pageSize = Integer.parseInt(spageSize.trim());

		UserResponse users = userService.ListAllByLastName(lastname, pageNo, pageSize);

		model.addAttribute("users", users.getContent());
		model.addAttribute("currenPage", users.getPageNO());
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("totalItems", users.getTotalElement());
		model.addAttribute("lastnamequery", lastname);

		return "PaginatedListOfUsersPerID.html";
	}

	@GetMapping("maintenance/user/usersearchbyid/pages")
	public String SearchAllByLastNamePaginated(@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstnamequery", required = false) String firstname,
			@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize,
			@RequestParam(value = "paged", required = false) String spage, Model model) {

		int paged = 0;

		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}
		if (spage != null) {
			paged = Integer.parseInt(spage.trim());
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		if (paged != 0) {
			pageNo = paged;
		}

		int pageSize = Integer.parseInt(spageSize.trim());

		UserResponse users = userService.ListAllByLastName(lastname, pageNo, pageSize);

		model.addAttribute("lastnamequery", lastname);
		model.addAttribute("users", users.getContent());
		model.addAttribute("currenPage", users.getPageNO());
		model.addAttribute("totalPages", users.getTotalPages());
		model.addAttribute("totalItems", users.getTotalElement());

		return "PaginatedListOfUsersPerID.html";
	}

	@GetMapping("/maintenance/hospital/set")
	public String HospitalSettings(Model model, Long hN) {
		Hospital hospital = new Hospital();
		String target = "hospital-edit-or-create";
		hospital = hospitalService.ShowIfExist();
		if (hospital.getHospitalName() == null) {
			hN = (long) 0;
			// target="hospital-create";
		} else {

			target = "hospital-save-edit";
			hN = (long) hospital.getHospitalID();
		}

		HospitalDTO hospitalDTO = modelConverter.mapToHospital(hospital);

		model.addAttribute("hospital", hospitalDTO);
		model.addAttribute("hN", hN);

		return target;

	}

	@PostMapping("/maintenance/hospital/save")
	public String SaveHospitalSettings(HttpSession session, @Valid @ModelAttribute("hospital") HospitalDTO hospital,
			BindingResult bindingResult, @ModelAttribute("hN") Long hN, Model model) {
		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospitalsess = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User
		if (bindingResult.hasErrors()) {

			return "hospital-edit-or-create";
		}
		LocalDateTime today = LocalDateTime.now();
		if (hN > 0) {
			// update
			hospitalService.UpdateHospital(hospital, hN);

		} else {
			// insert
			hospital.setDateCreated(today);
			hospital.setCreatedBy(username);
			hN = hospital.getHospitalID();
			hospitalService.SaveHospital(hospital);

		}

		return "hospital-created";
	}

	@PostMapping("/maintenance/hospital/save-edit")
	public String SaveHospitalSettingsSaveEdit(@ModelAttribute("hospital") HospitalDTO hospital,
			@ModelAttribute("hN") Long hN, Model model) {

		LocalDateTime today = LocalDateTime.now();
		if (hN > 0) {
			// update
			hospitalService.UpdateHospital(hospital, hN);

		} else {
			// insert
			hospital.setDateCreated(today);
			hN = hospital.getHospitalID();
			hospitalService.SaveHospital(hospital);

		}

		return "hospital-created";
	}

	@GetMapping("/maintenance/userType/userType-new")

	public String CreateUserTypeForm(Model model) {
		// User user = new User()
		UserTypeDTO userType = new UserTypeDTO();
		// model.addAttribute("userType",userType);
		model.addAttribute("usertype", userType);
		model.addAttribute("formObject", formObject);
		return "userType-create";

	}

	@PostMapping("/maintenance/userType/userType-new-save")
	public String SaveUserTypeForm(HttpSession session, @Valid @ModelAttribute("usertype") UserTypeDTO userType,
			BindingResult result, @ModelAttribute("formObject") FormObject formObject,
			@ModelAttribute("positionObject") FormObject positionObject, Model model) {
		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User

		if (result.hasErrors()) {
			model.addAttribute("usertype", userType);
			return "userType-create";
		}

		LocalDateTime today = LocalDateTime.now();
		userType.setDateCreated(today);
		userType.setCreatedBy(username);
		userType.setModifiedBy(null);
		userType.setDateUpdated(null);
		try {
			userTypeService.SaveUseType(userType);
		} catch (DataIntegrityViolationException e) {
			System.out.println("Type already exist");
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("usertype", userType);
			return "userType-create";
		}

		return "redirect:/maintenance/userType/userType-new";
	}

	@GetMapping("/maintenance/usertypes/usertypelistall")
	public String ViewAllUserTypesPaginated(@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize,
			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstname", required = false) String firstname, Model model) {
		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		int pageSize = Integer.parseInt(spageSize.trim());

		pageSize = 5;
		UserTypeResponse userTypes = userTypeService.ListAllUserTypes(pageNo, pageSize);

		model.addAttribute("usertype", userTypes.getContent());
		model.addAttribute("currenPage", userTypes.getPageNO());
		model.addAttribute("totalPages", userTypes.getTotalPages());
		model.addAttribute("totalItems", userTypes.getTotalElement());
		return "ListOfUserType.html";
	}

	@GetMapping("/maintenance/usertypesall/pages")
	public String ViewAllUserTypesPaginated(

			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "page") int pageNo, Model model) {

		int pageSize = 5;
		UserTypeResponse userTypes = userTypeService.ListAllUserTypes(pageNo, pageSize); // userService.ListAllusers(pageNo,
																							// pageSize);

		model.addAttribute("usertype", userTypes.getContent());
		model.addAttribute("currenPage", userTypes.getPageNO());
		model.addAttribute("totalPages", userTypes.getTotalPages());
		model.addAttribute("totalItems", userTypes.getTotalElement());
		return "ListOfUserType.html";
	}

	@PostMapping("/maintenance/usertype/usertype-edit-save")
	public String SaveEditUserTypeForm(HttpSession session, @Valid @ModelAttribute("usertype") UserTypeDTO usertypeDTO,
			BindingResult result) {
		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User
		if (result.hasErrors()) {

			return "userTypeView.html";
		}

		LocalDateTime today = LocalDateTime.now();
		// usertypeDTO.setDateUpdated(today);
		usertypeDTO.setDateUpdated(today);
		usertypeDTO.setModifiedBy(username);
		userTypeService.UpdateUserType(usertypeDTO, usertypeDTO.getUserTypeID());

		return "redirect:/maintenance/usertypes/usertypelistall";
	}

	@GetMapping("/maintenance/userType/{userTypeID}/view")
	public String ViewSingleUserType(@PathVariable("userTypeID") Long idTypeuser, Model model) {
		UserTypeDTO userType = userTypeService.SearchUserTypebyID(idTypeuser); // userService.SearchUserbyID(iduser);
		model.addAttribute("usertype", userType);
		return "userTypeView.html";
		       
	}

	@GetMapping("/maintenance/userposition/userposition-new")

	public String CreateUserPositionForm(Model model) {
		// User user = new User()
		UserPositionDTO userPosition = new UserPositionDTO();
		model.addAttribute("userposition", userPosition);
		model.addAttribute("formObject", formObject);
		return "userposition-create";

	}

	@PostMapping("/maintenance/userposition/userposition-new-save")
	public String SaveUserPositionForm(HttpSession session,
			@Valid @ModelAttribute("userposition") UserPositionDTO userPosition, BindingResult result, Model model) {
		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User

		if (result.hasErrors()) {
			model.addAttribute("userposition", userPosition);
			return "userposition-create";
		}

		LocalDateTime today = LocalDateTime.now();
		userPosition.setDateCreated(today);
		userPosition.setCreatedBy(username);
		try {
			userPositionService.SaveUserPosition(userPosition);
		} catch (DataIntegrityViolationException e) {
			System.out.println("history already exist");
			model.addAttribute("errorMessage", e.getMessage());
			model.addAttribute("userposition", userPosition);
			return "userposition-create";
		}
		return "redirect:/maintenance/userposition/userposition-new";
	}

	@GetMapping("/maintenance/userpositionall/pages")
	public String ViewAllUserPositionPaginated(

			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstname", required = false) String firstname,
			@RequestParam(value = "page") int pageNo, Model model) {

		int pageSize = 5;
		UserPositionResponse userPosition = userPositionService.ListAllUserPosition(pageNo, pageSize);
		
	
		model.addAttribute("userpositions", userPosition.getContent());
		
	
		
		
		model.addAttribute("currenPage", userPosition.getPageNO());
		model.addAttribute("totalPages", userPosition.getTotalPages());
		model.addAttribute("totalItems", userPosition.getTotalElement());
		return "ListOfUserPosition.html";
	}

	@GetMapping("/maintenance/userposition/userpositionlistall")
	public String ViewAllUserPositionPaginated(@RequestParam(value = "PageNo", required = false) String spageNo,
			@RequestParam(value = "PageSize", required = false) String spageSize,
			@RequestParam(value = "lastnamequery", required = false) String lastname,
			@RequestParam(value = "firstname", required = false) String firstname, Model model) {
		if (spageNo == null) {
			spageNo = "1";
		}
		if (spageSize == null) {
			spageSize = "5";
		}

		int pageNo = Integer.parseInt(spageNo.trim());
		int pageSize = Integer.parseInt(spageSize.trim());

		pageSize = 5;
		UserPositionResponse userPosition = userPositionService.ListAllUserPosition(pageNo, pageSize);

		model.addAttribute("userpositions", userPosition.getContent());
		model.addAttribute("currenPage", userPosition.getPageNO());
		model.addAttribute("totalPages", userPosition.getTotalPages());
		model.addAttribute("totalItems", userPosition.getTotalElement());
		return "ListOfUserPosition.html";
	}

	@GetMapping("/maintenance/userPosition/{userPositionID}/view")
	public String ViewSingleUserPosition(@PathVariable("userPositionID") Long idTypeuser , Model model) {
		
	
		UserPositionDTO userPosition = userPositionService.SearchUserPositionByID(idTypeuser);
		model.addAttribute("userposition", userPosition);
		return "userposition-view.html";
	}

	@PostMapping("/maintenance/position/userposition-edit-save")
	public String SaveEditUserPositionForm(HttpSession session,
			@Valid @ModelAttribute("userposition") UserPositionDTO userPositionDTO, BindingResult result) {
		// Retrieve Hospital and User
		String username = (String) session.getAttribute("username");
		Hospital hospital = (Hospital) session.getAttribute("hospital");

		// Retrieve Hospital and User

		if (result.hasErrors()) {

			return "userposition-view.html";
		}

		LocalDateTime today = LocalDateTime.now();
		userPositionDTO.setDateUpdated(today);
		userPositionDTO.setModifiedBy(username);
		userPositionService.UpdateUserPosition(userPositionDTO, userPositionDTO.getUserPositionID());

		return "redirect:/maintenance/userposition/userpositionlistall";
	}

	@GetMapping("/patientrecords/patient/add")
	public String addPatientRecordForm(Model model) {
		// ComorbiditiesDTO comorbiditiesDTO = new ComorbiditiesDTO();
		model.addAttribute("variable", "");
		
		PatientRecord patientRecord = new PatientRecord();
		patientRecord.setSurgicalSpecialty("OBGY");
		patientRecord.setSurgicalType("C-Section");
		model.addAttribute("patientRecord", patientRecord);
		model.addAttribute("eRASStatusOptions", Estatus.values());
		model.addAttribute("genderOptions", Gender.values());
		model.addAttribute("eRASStatusYNOptions", EstatusYorN.values());
		model.addAttribute("aSASCOREOptions", ASASCORE.values());
		model.addAttribute("preopEducationOptions", PreopEducation.values());
		model.addAttribute("antibioticProphylaxisOptions", AntibioticProphylaxis.values());
		model.addAttribute("pONVProphylaxisOptions", PONVProphylaxis.values());
		model.addAttribute("pONVProphylaxisAgentsOptions", PONVProphylaxisAgents.values());
		model.addAttribute("anaesthesiaTypeOptions", AnaesthesiaType.values());
		model.addAttribute("iTMUsedOptions", ITMUsed.values());
		model.addAttribute("systemicOpioidsUseddOptions", SystemicOpioidsUsed.values());
		model.addAttribute("skinToSkinOptions", SkinToSkin.values());
		model.addAttribute("trialofVoidOptions", TrialofVoid.values());
		model.addAttribute("recatheterisedOptions", Recatheterised.values());
		model.addAttribute("regularParacetamolOptions", RegularParacetamol.values());
		model.addAttribute("oralOpioidsOptions", OralOpioids.values());
		model.addAttribute("inHospitalComplicationsOptions", InHospitalComplications.values());
		model.addAttribute("day300FollowupOptions", Day300Followup.values());
		model.addAttribute("postDischargeComplicationsOptions", PostDischargeComplications.values());
		model.addAttribute("readmisionOptions", Readmision.values());
		model.addAttribute("pROMneededOptions", PROMneeded.values());
		model.addAttribute("pROMToolUsedOptions", PROMToolUsed.values());
		model.addAttribute("regularNSAIDSOptions", RegularNSAIDS.values());

		// model.addAttribute("uterotonicAgent", patientRecord.getUterotonicAgent());

		return "PatientRecordNew-Main";
	}

	@PostMapping("/patientrecords/patient/add-save")
	public String savePatientForm(HttpSession session, @ModelAttribute("patientRecord") PatientRecord patientRecord) {

		// List<ComorbiditiesDTO> comorbiditiesDTOList = patientRecord;

		// Process comorbidities list if needed
		try {
			for (Comorbidities comorbidity : patientRecord.getComorbidities()) {
				// Ensure the comorbidityDesc is set based on comRefID
				ComorbiditiesReference ref = comorbiditiesReferenceService.findById(comorbidity.getComRefID());
				if (ref != null) {
					comorbidity.setComorbidityDesc(ref.getDescription());
					comorbidity.setComorbiditiesReference(ref);
					comorbidity.setPatient(patientRecord);
					comorbidity.setCreatedBy(session.getAttribute("username").toString());
					comorbidity.setMedicalRecordNo(patientRecord.getMedicalRecordNo());
					comorbidity.setComorbiditiesReference(ref);
					// comorbidity.setHospitalCode(session.getAttribute("shospitalCode").toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (SystemicOpioids systemicOpioids : patientRecord.getSystemicOpioids()) {
				// Ensure the comorbidityDesc is set based on comRefID
				SystemicOpioidsReference ref = systemicOpioidsReferenceService.findById(systemicOpioids.getComRefID());
				if (ref != null) {
					systemicOpioids.setSystemicOpioidsDesc(ref.getSystemicOpioidsDesc());
					systemicOpioids.setSystemicOpioidsReference(ref);

					systemicOpioids.setPatient(patientRecord);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (OralOpioidsAgents oralOpioidsAgents : patientRecord.getOralOpioidsAgents()) {
				// Ensure the comorbidityDesc is set based on comRefID
				OralOpioidsAgentsReference ref = oralOpioidsAgentsReferenceService
						.findById(oralOpioidsAgents.getComRefID());
				if (ref != null) {
					oralOpioidsAgents.setOralOpioidsAgentsDesc(ref.getOralOpioidsAgentsRefDesc());
					oralOpioidsAgents.setPatient(patientRecord);
					oralOpioidsAgents.setOralOpioidsAgentsReference(ref);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (UterotonicAgent uterotonicAgent : patientRecord.getUterotonicAgent()) {
				// Ensure the comorbidityDesc is set based on comRefID
				UterotonicAgentReference ref = uterotonicAgentReferenceService.findById(uterotonicAgent.getComRefID());
				if (ref != null) {
					uterotonicAgent.setUterotonicAgentDescription(ref.getUterotonicAgentDesc()); // setOralOpioidsAgentsDesc(ref.getOralOpioidsAgentsRefDesc());
					uterotonicAgent.setUterotonicAgentReference(ref);
					uterotonicAgent.setPatient(patientRecord);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (patientRecord.getSequenceNo() != 0) {
//			patientRecord.setSequenceNo(mrnSequenceService.getNextSequenceNumber(patientRecord.getMedicalRecordNo()));
//		}

		
		// try to make a new record hoping to insert 
		patienRecordService.saveNewPatientRecord(patientRecord);
		// try to make a new record hoping to insert 
		// patienRecordService.save(patientRecord); // Save patient record
		mrnSequenceService.saveSequence(patientRecord.getMedicalRecordNo(),patientRecord.getSequenceNo());
		return "redirect:/patient/home";
	}

	@GetMapping("/patientrecords/patient/{id}")
	public String getPatientRecord(@PathVariable Long id, Model model) {
		PatientRecord patientRecord = patienRecordService.findById(id);
		List<ComorbiditiesReference> comorbiditiesReferences = comorbiditiesReferenceService.findAll();
		List<SystemicOpioidsReference> systemicOpioidsReference = systemicOpioidsReferenceService.findAll();
		List<OralOpioidsAgentsReference> oralOpioidsAgentsReference = oralOpioidsAgentsReferenceService.findAll();
		List<UterotonicAgentReference> uterotonicAgentReference = uterotonicAgentReferenceService.findAll();

		model.addAttribute("patientRecord", patientRecord);
		model.addAttribute("comorbiditiesReferences", comorbiditiesReferences);
		model.addAttribute("systemicOpioidsReference", systemicOpioidsReference);
		model.addAttribute("oralOpioidsAgentsReference", oralOpioidsAgentsReference);
		model.addAttribute("uterotonicAgentReference", uterotonicAgentReference);
		
		model.addAttribute("patientRecord", patientRecord);
		model.addAttribute("eRASStatusOptions", Estatus.values());
		model.addAttribute("genderOptions", Gender.values());
		model.addAttribute("eRASStatusYNOptions", EstatusYorN.values());
		model.addAttribute("aSASCOREOptions", ASASCORE.values());
		model.addAttribute("preopEducationOptions", PreopEducation.values());
		model.addAttribute("antibioticProphylaxisOptions", AntibioticProphylaxis.values());
		model.addAttribute("pONVProphylaxisOptions", PONVProphylaxis.values());
		model.addAttribute("pONVProphylaxisAgentsOptions", PONVProphylaxisAgents.values());
		model.addAttribute("anaesthesiaTypeOptions", AnaesthesiaType.values());
		model.addAttribute("iTMUsedOptions", ITMUsed.values());
		model.addAttribute("systemicOpioidsUseddOptions", SystemicOpioidsUsed.values());
		model.addAttribute("skinToSkinOptions", SkinToSkin.values());
		model.addAttribute("trialofVoidOptions", TrialofVoid.values());
		model.addAttribute("recatheterisedOptions", Recatheterised.values());
		model.addAttribute("regularParacetamolOptions", RegularParacetamol.values());
		model.addAttribute("oralOpioidsOptions", OralOpioids.values());
		model.addAttribute("inHospitalComplicationsOptions", InHospitalComplications.values());
		model.addAttribute("day300FollowupOptions", Day300Followup.values());
		model.addAttribute("postDischargeComplicationsOptions", PostDischargeComplications.values());
		model.addAttribute("readmisionOptions", Readmision.values());
		model.addAttribute("pROMneededOptions", PROMneeded.values());
		model.addAttribute("pROMToolUsedOptions", PROMToolUsed.values());
		model.addAttribute("regularNSAIDSOptions", RegularNSAIDS.values());

		return "PatientRecordEdit-Main";
	}

	// ------------------------------------------------------------------ Work In
	// progress

	@PostMapping("/patientrecords/patient/edit-save")
	public String saveFromEditPatientForm(HttpSession session,
			@ModelAttribute("patientRecord") PatientRecord patientRecord) {

		// List<ComorbiditiesDTO> comorbiditiesDTOList = patientRecord;

		// Process comorbidities list if needed
		try {
			for (Comorbidities comorbidity : patientRecord.getComorbidities()) {
				// Ensure the comorbidityDesc is set based on comRefID
				ComorbiditiesReference ref = comorbiditiesReferenceService.findById(comorbidity.getComRefID());
				if (ref != null) {
					comorbidity.setComorbidityDesc(ref.getDescription());
					comorbidity.setComorbiditiesReference(ref);
					comorbidity.setPatient(patientRecord);
					comorbidity.setCreatedBy(session.getAttribute("username").toString());
					comorbidity.setMedicalRecordNo(patientRecord.getMedicalRecordNo());
					comorbidity.setComorbiditiesReference(ref);
					// comorbidity.setHospitalCode(session.getAttribute("shospitalCode").toString());
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (SystemicOpioids systemicOpioids : patientRecord.getSystemicOpioids()) {
				// Ensure the comorbidityDesc is set based on comRefID
				SystemicOpioidsReference ref = systemicOpioidsReferenceService.findById(systemicOpioids.getComRefID());
				if (ref != null) {
					systemicOpioids.setSystemicOpioidsDesc(ref.getSystemicOpioidsDesc());
					systemicOpioids.setSystemicOpioidsReference(ref);

					systemicOpioids.setPatient(patientRecord);
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (OralOpioidsAgents oralOpioidsAgents : patientRecord.getOralOpioidsAgents()) {
				// Ensure the comorbidityDesc is set based on comRefID
				OralOpioidsAgentsReference ref = oralOpioidsAgentsReferenceService
						.findById(oralOpioidsAgents.getComRefID());
				if (ref != null) {
					oralOpioidsAgents.setOralOpioidsAgentsDesc(ref.getOralOpioidsAgentsRefDesc());
					oralOpioidsAgents.setPatient(patientRecord);
					oralOpioidsAgents.setOralOpioidsAgentsReference(ref);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			for (UterotonicAgent uterotonicAgent : patientRecord.getUterotonicAgent()) {
				// Ensure the comorbidityDesc is set based on comRefID
				UterotonicAgentReference ref = uterotonicAgentReferenceService.findById(uterotonicAgent.getComRefID());
				if (ref != null) {
					uterotonicAgent.setUterotonicAgentDescription(ref.getUterotonicAgentDesc()); // setOralOpioidsAgentsDesc(ref.getOralOpioidsAgentsRefDesc());
					uterotonicAgent.setUterotonicAgentReference(ref);
					uterotonicAgent.setPatient(patientRecord);

				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		if (patientRecord.getSequenceNo() != 0) {
//			patientRecord.setSequenceNo(mrnSequenceService.getNextSequenceNumber(patientRecord.getMedicalRecordNo()));
//		}

		// Check Add and removed tables

		// Retrieve the existing PatientRecord from the database
		PatientRecord existingPatientRecord = patienRecordService.findById(patientRecord.getPatientID());

		// Update the existing PatientRecord with the new comorbidities list
		List<Comorbidities> newComorbidities = patientRecord.getComorbidities();
		if (newComorbidities != null) {
			Set<Long> newComorbidityIds = newComorbidities.stream().map(Comorbidities::getComorbiditiesId)
					.collect(Collectors.toSet());

			// Remove orphaned comorbidities
			existingPatientRecord.getComorbidities()
					.removeIf(comorbidity -> !newComorbidityIds.contains(comorbidity.getComorbiditiesId()));
			
	          // Clear the existing comorbidities list
            existingPatientRecord.getComorbidities().clear();


			// Add or update comorbidities
			for (Comorbidities newComorbidity : newComorbidities) {
				newComorbidity.setPatient(existingPatientRecord); // Set the bidirectional reference
				if (newComorbidity.getComorbiditiesId() == null) {
					// New comorbidity (not yet saved)
					existingPatientRecord.getComorbidities().add(newComorbidity);
				} else {
					// Existing comorbidity (update if necessary)
					comorbiditiesService.save(newComorbidity);

				}
			}

		} else {
			// not working
			List<Comorbidities> existingComorbidities = existingPatientRecord.getComorbidities();
			if(existingComorbidities != null) {
            for (Comorbidities comorbidity : existingComorbidities) {
                comorbiditiesService.delete(comorbidity);
                comorbiditiesService.save(comorbidity);
                
            }
            
			}
		}
			
		// Systemic Opiods checking

		List<SystemicOpioids> newSystemicOpioids = patientRecord.getSystemicOpioids();
		if (newSystemicOpioids != null) {
			Set<Long> newSystemicOpioidsIds = newSystemicOpioids.stream().map(SystemicOpioids::getSystemicOpioidsId)
					.collect(Collectors.toSet());

			// Remove orphaned SystemicOpioids
			existingPatientRecord.getSystemicOpioids()
					.removeIf(SystemicOpioid -> !newSystemicOpioidsIds.contains(SystemicOpioid.getSystemicOpioidsId()));

			// Add or update SystemicOpioids
			for (SystemicOpioids newSystemicOpioid : newSystemicOpioids) {
				newSystemicOpioid.setPatient(existingPatientRecord); // Set the bidirectional reference
				if (newSystemicOpioid.getSystemicOpioidsId() == null) {
					// New newSystemicOpioid(not yet saved)
					existingPatientRecord.getSystemicOpioids().add(newSystemicOpioid);
				} else {
					// Existing SystemicOpioid (update if necessary)
					systemicOpioidsService.save(newSystemicOpioid);

				}
			}
		} else
		{
			
		}
		// Check oral opiods
		List<OralOpioidsAgents> newOralOpioidsAgents = patientRecord.getOralOpioidsAgents();
		if (newOralOpioidsAgents != null) {
			Set<Long> newOralOpioidsAgentIds = newOralOpioidsAgents.stream()
					.map(OralOpioidsAgents::getOralOpioidsAgentsId).collect(Collectors.toSet());

			// Remove orphaned oral opioids agents
			existingPatientRecord.getOralOpioidsAgents().removeIf(
					oralOpioidsAgent -> !newOralOpioidsAgentIds.contains(oralOpioidsAgent.getOralOpioidsAgentsId()));

			// Add or update oral opioids agents
			for (OralOpioidsAgents newOralOpioidsAgent : newOralOpioidsAgents) {
				newOralOpioidsAgent.setPatient(existingPatientRecord); // Set the bidirectional reference
				if (newOralOpioidsAgent.getOralOpioidsAgentsId() == null) {
					// New oral opioids agent (not yet saved)
					existingPatientRecord.getOralOpioidsAgents().add(newOralOpioidsAgent);
				} else {
					// Existing oral opioids agent (update if necessary)
					oralOpioidsAgentsService.save(newOralOpioidsAgent);
				}
			}
		}

		List<UterotonicAgent> newUterotonicAgents = patientRecord.getUterotonicAgent();
		if (newUterotonicAgents != null) {
			Set<Long> newUterotonicAgentIds = newUterotonicAgents.stream().map(UterotonicAgent::getUterotonicAgentId)
					.collect(Collectors.toSet());

			// Remove orphaned uterotonic agents
			existingPatientRecord.getUterotonicAgent().removeIf(
					uterotonicAgent -> !newUterotonicAgentIds.contains(uterotonicAgent.getUterotonicAgentId()));

			// Add or update uterotonic agents
			for (UterotonicAgent newUterotonicAgent : newUterotonicAgents) {
				newUterotonicAgent.setPatient(existingPatientRecord); // Set the bidirectional reference
				if (newUterotonicAgent.getUterotonicAgentId() == null) {
					// New uterotonic agent (not yet saved)
					existingPatientRecord.getUterotonicAgent().add(newUterotonicAgent);
				} else {
					// Existing uterotonic agent (update if necessary)
					uterotonicAgentService.save(newUterotonicAgent);
				}
			}
		}
		// Save the updated PatientRecord

//		patientRecord.setComorbidities(existingPatientRecord.getComorbidities());
//		patientRecord.setOralOpioidsAgents(existingPatientRecord.getOralOpioidsAgents());
//		patientRecord.setUterotonicAgent(patientRecord.getUterotonicAgent());
//		patientRecord.setSystemicOpioids(patientRecord.getSystemicOpioids());
		
		existingPatientRecord.setHospitalCode(patientRecord.getHospitalCode());
		//where patient_record_id=2existingPatientRecord.setMedicalRecordNo(patientRecord.getMedicalRecordNo());
		existingPatientRecord.setSequenceNo(patientRecord.getSequenceNo());

		existingPatientRecord.setDateofBirth(patientRecord.getDateofBirth());
		existingPatientRecord.setGender(patientRecord.getGender());
		existingPatientRecord.setERASStatus(patientRecord.getERASStatus());

		existingPatientRecord.setAdmissionDate(patientRecord.getAdmissionDate());
		existingPatientRecord.setAdmissionTime(patientRecord.getAdmissionTime());
		existingPatientRecord.setAge(patientRecord.getAge());
		existingPatientRecord.setHeight(patientRecord.getHeight());
		existingPatientRecord.setWeight(patientRecord.getWeight());

		existingPatientRecord.setCalculatedBMI(patientRecord.getCalculatedBMI());

		existingPatientRecord.setSurgicalSpecialty(patientRecord.getSurgicalSpecialty());
		existingPatientRecord.setSurgicalType(patientRecord.getSurgicalType());

		existingPatientRecord.setERASStatusYN(patientRecord.getERASStatusYN());
		existingPatientRecord.setASAScore(patientRecord.getASAScore());

		existingPatientRecord.setPreopEducation(patientRecord.getPreopEducation());
		existingPatientRecord.setPreopLastFluidsDate(patientRecord.getPreopLastFluidsDate());
		existingPatientRecord.setPreopLasFluidsTime(patientRecord.getPreopLasFluidsTime());
		existingPatientRecord.setPreopFastingStatusFluids(patientRecord.getPreopFastingStatusFluids());
		existingPatientRecord.setPreopLastSolidsDate(patientRecord.getPreopLastSolidsDate());
		existingPatientRecord.setPreopLastSolidsTime(patientRecord.getPreopLastSolidsTime());
		existingPatientRecord.setPreopFastingStatusSolids(patientRecord.getPreopFastingStatusSolids());
		existingPatientRecord.setAntibioticProphylaxis(patientRecord.getAntibioticProphylaxis());
		existingPatientRecord.setPONVProphylaxis(patientRecord.getPONVProphylaxis());
		existingPatientRecord.setPONVProphylaxisAgents(patientRecord.getPONVProphylaxisAgents());
		existingPatientRecord.setAnaesthesiaType(patientRecord.getAnaesthesiaType());
		existingPatientRecord.setITMUsed(patientRecord.getITMUsed());
		existingPatientRecord.setSystemicOpioidsUsed(patientRecord.getSystemicOpioidsUsed());

		existingPatientRecord.setSkinToSkin(patientRecord.getSkinToSkin());
		existingPatientRecord.setPostOpOralFluidIntakeDate(patientRecord.getPostOpOralFluidIntakeDate());
		existingPatientRecord.setPostOpOralFluidIntakeTime(patientRecord.getPostOpOralFluidIntakeTime());
		existingPatientRecord.setTimetoOralFluidIntake(patientRecord.getTimetoOralFluidIntake());
		existingPatientRecord.setPostOpOralSolidsIntakeDate(patientRecord.getPostOpOralSolidsIntakeDate());
		existingPatientRecord.setPostOpOralSolidsIntakeTime(patientRecord.getPostOpOralSolidsIntakeTime());
		existingPatientRecord.setTimetoOralSolidsIntake(patientRecord.getTimetoOralSolidsIntake());
		existingPatientRecord.setMobilisationStartDate(patientRecord.getMobilisationStartDate());
		existingPatientRecord.setMobilisationStartTime(patientRecord.getMobilisationStartTime());
		existingPatientRecord.setTimetoMobilisationFromSurgery(patientRecord.getTimetoMobilisationFromSurgery());
		existingPatientRecord.setRemovalUrinaryCatheterDate(patientRecord.getRemovalUrinaryCatheterDate());
		existingPatientRecord.setRemovalUrinaryCatheterTime(patientRecord.getRemovalUrinaryCatheterTime());

		existingPatientRecord.setTrialofVoid(patientRecord.getTrialofVoid());
		existingPatientRecord.setRecatheterised(patientRecord.getRecatheterised());
		existingPatientRecord.setRegularParacetamol(patientRecord.getRegularParacetamol());
		existingPatientRecord.setRegularNSAIDS(patientRecord.getRegularNSAIDS());
		existingPatientRecord.setOralOpioids(patientRecord.getOralOpioids());

		existingPatientRecord.setFirstDoseOralOpioidsDate(patientRecord.getFirstDoseOralOpioidsDate());
		existingPatientRecord.setFirstDoseOralOpioidsTime(patientRecord.getFirstDoseOralOpioidsTime());
		existingPatientRecord.setTotalOralOpioids(patientRecord.getTotalOralOpioids());
		existingPatientRecord.setTotalIVFluidsGivenml(patientRecord.getTotalIVFluidsGivenml());
		existingPatientRecord.setDischargeDate(patientRecord.getDischargeDate());
		existingPatientRecord.setDischargeTime(patientRecord.getDischargeTime());

		existingPatientRecord.setDurationOfStayHrs(patientRecord.getDurationOfStayHrs());
		existingPatientRecord.setLengthOfStayNights(patientRecord.getLengthOfStayNights());

		existingPatientRecord.setInHospitalComplications(patientRecord.getInHospitalComplications());
		existingPatientRecord.setInHospitalComplicationsnotes(patientRecord.getInHospitalComplicationsnotes());

		existingPatientRecord.setDay300Followup(patientRecord.getDay300Followup());
		existingPatientRecord.setPostDischargeComplications(patientRecord.getPostDischargeComplications());
		existingPatientRecord.setPostDischargeComplicationsnotes(patientRecord.getPostDischargeComplicationsnotes());

		existingPatientRecord.setReadmision(patientRecord.getReadmision());
		existingPatientRecord.setReadmisionNotes(patientRecord.getReadmisionNotes());

		existingPatientRecord.setPROMneeded(patientRecord.getPROMneeded());
		existingPatientRecord.setPROMToolUsed(patientRecord.getPROMToolUsed());
		existingPatientRecord.setPROmResults(patientRecord.getPROmResults());
		existingPatientRecord.setIsInactive(patientRecord.getIsInactive());

		existingPatientRecord.setDateCreated(patientRecord.getDateCreated());
		existingPatientRecord.setDateUpdated(patientRecord.getDateUpdated());
		existingPatientRecord.setCreatedBy(patientRecord.getCreatedBy());
		existingPatientRecord.setModifiedBy(patientRecord.getModifiedBy());
		existingPatientRecord.setComplianceCount(patientRecord.getComplianceCount());
		
		
		
		//save new record  existingPatientRecord
		//patienRecordService.save(existingPatientRecord);
		
		// update patient Record
		patienRecordService.updatePatientRecord(existingPatientRecord);
		
		// patienRecordService.save(patientRecord); // Save patient record

		return "redirect:/patient/home";
	}

}
