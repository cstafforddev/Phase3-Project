package com.example.demo;



import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SportyShoesController {
	@Autowired
	AdminDAO admindao;
	@Autowired
	UserDAO userdao;
	@Autowired
	Mens_Running_ShoesDAO mrsdao;
	@Autowired
	Mens_Stylish_ShoesDAO mssdao;
	@Autowired
	Womens_Running_ShoesDAO wrsdao;
	@Autowired
	Womens_Stylish_ShoesDAO wssdao;
	@Autowired
	PurchaseHistoryDAO phdao;
	@Autowired
	Admin currentAdmin;
	@Autowired
	User currentUser;
	
	Logger log = Logger.getAnonymousLogger();
	
	@GetMapping("/")
	public ModelAndView home() {
		currentUser = new User();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/welcomescreen.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@GetMapping("/homescreen")
	public ModelAndView homescreen() {
		currentUser = new User();
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/welcomescreen.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@GetMapping("/adminlogin")
	public ModelAndView adminlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/adminlogin.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@GetMapping("/userlogin")
	public ModelAndView userlogin() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/userlogin.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/register.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/insertuser")
	public ModelAndView insert(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		User u=new User();
		u.setName(request.getParameter("name"));
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		User uu=userdao.insert(u);
		if(uu!=null) {
			mv.setViewName("/userhomescreen.jsp");
			currentUser = u;
		}

		return mv;

	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/checkadmin")
	public ModelAndView checkAdmin(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("failedadminlogin.jsp");
		Admin a = new Admin();
		a.setEmail(request.getParameter("email"));
		a.setPassword(request.getParameter("password"));
		List<Admin> adminList = admindao.getAll();
		for(Admin aa:adminList) {
			if(a.getEmail().equals(aa.getEmail()) && a.getPassword().equals(aa.getPassword())) {
				mv.setViewName("/adminhomescreen.jsp");
				currentAdmin = a;
				log.info(currentAdmin.getPassword());
			}
		}
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/checkuser")
	public ModelAndView checkUser(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();
		mv.setViewName("/faileduserlogin.jsp");
		User u = new User();
		u.setEmail(request.getParameter("email"));
		u.setPassword(request.getParameter("password"));
		List<User> userList = userdao.getAll();
		for(User uu:userList) {
			if(u.getEmail().equals(uu.getEmail()) && u.getPassword().equals(uu.getPassword())) {
				mv.setViewName("/userhomescreen.jsp");
				currentUser = u;
			}
		}
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/getusers")
	public ModelAndView userGetAllUsers(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();	
		List<User> userList=userdao.getAll();
		mv.setViewName("/displayusers.jsp");
		mv.addObject("list",userList);
		return mv;

	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/searchusers")
	public ModelAndView searchUsers(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mv=new ModelAndView();	
		List<User> userList=userdao.getAll();
		List<User> filteredList = new ArrayList();
		User u = new User();
		u.setEmail(request.getParameter("email"));
		for(User uu:userList) {
			if(uu.getEmail().equals(u.getEmail())){
				filteredList.add(uu);
			}
		}
		mv.setViewName("/displayfilteredusers.jsp");
		mv.addObject("list",filteredList);
		return mv;

	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/usermrs")
	public ModelAndView userGetAllMRS() {
		ModelAndView mv=new ModelAndView();	
		List<Mens_Running_Shoes> mrsList= mrsdao.getAll();
		mv.setViewName("usermrs.jsp");
		mv.addObject("list",mrsList);
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/usermss")
	public ModelAndView userGetAllMSS() {
		ModelAndView mv=new ModelAndView();	
		List<Mens_Stylish_Shoes> mssList= mssdao.getAll();
		mv.setViewName("usermss.jsp");
		mv.addObject("list",mssList);
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/userwrs")
	public ModelAndView userGetAllWRS() {
		ModelAndView mv=new ModelAndView();	
		List<Womens_Running_Shoes> wrsList= wrsdao.getAll();
		mv.setViewName("userwrs.jsp");
		mv.addObject("list",wrsList);
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/userwss")
	public ModelAndView userGetAllWSS() {
		ModelAndView mv=new ModelAndView();	
		List<Womens_Stylish_Shoes> wssList= wssdao.getAll();
		mv.setViewName("userwss.jsp");
		mv.addObject("list",wssList);
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/adminmrs")
		public ModelAndView adminGetAllMRS() {
			ModelAndView mv=new ModelAndView();	
			List<Mens_Running_Shoes> mrsList= mrsdao.getAll();
			mv.setViewName("/adminmrs.jsp");
			mv.addObject("list",mrsList);
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/adminmss")
		public ModelAndView adminGetAllMSS() {
			ModelAndView mv=new ModelAndView();	
			List<Mens_Stylish_Shoes> mssList= mssdao.getAll();
			mv.setViewName("/adminmss.jsp");
			mv.addObject("list",mssList);
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/adminwrs")
		public ModelAndView adminGetAllWRS() {
			ModelAndView mv=new ModelAndView();	
			List<Womens_Running_Shoes> wrsList= wrsdao.getAll();
			mv.setViewName("/adminwrs.jsp");
			mv.addObject("list",wrsList);
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/adminwss")
		public ModelAndView adminGetAllWSS() {
			ModelAndView mv=new ModelAndView();	
			List<Womens_Stylish_Shoes> wssList= wssdao.getAll();
			mv.setViewName("/adminwss.jsp");
			mv.addObject("list",wssList);
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/purchase/{category}/{size}")
	public ModelAndView purchase(@PathVariable String category, @PathVariable String size) {
		ModelAndView mv=new ModelAndView();	
		Date date = new Date();
		Timestamp timestamp = new Timestamp(date.getTime());
		if(category.equals("mrs")){
			mrsdao.buy(size);
		}
		else if(category.equals("mss")){
			mssdao.buy(size);
		}
		else if(category.equals("wrs")){
			wrsdao.buy(size);
		}
		else if(category.equals("wss")){
			wssdao.buy(size);
		}
		phdao.add(category, size, currentUser.getName(), currentUser.getEmail(), timestamp.toString());
		mv.setViewName("/purchased.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/editinventory/{category}/{size}")
	public ModelAndView editInventory(@PathVariable String category, @PathVariable String size, HttpServletRequest request) {
		ModelAndView mv=new ModelAndView();	
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		if(category.equals("mrs")){
			mrsdao.edit(size,quantity);
		}
		else if(category.equals("mss")){
			mssdao.edit(size,quantity);
		}
		else if(category.equals("wrs")){
			wrsdao.edit(size,quantity);
		}
		else if(category.equals("wss")){
			wssdao.edit(size,quantity);
		}
		log.info("inventory updated");
		mv.setViewName("/inventoryupdated.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
	@RequestMapping("/userback")
	public ModelAndView userBack() {
		ModelAndView mv=new ModelAndView();	
		mv.setViewName("/userhomescreen.jsp");
		return mv;
	}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/adminback")
		public ModelAndView adminBack() {
			ModelAndView mv=new ModelAndView();	
			mv.setViewName("/adminhomescreen.jsp");
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/logout")
		public ModelAndView userHomeBack() {
			currentUser = new User();
			ModelAndView mv=new ModelAndView();	
			mv.setViewName("/welcomescreen.jsp");
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/editinven")
		public ModelAndView editInventory() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/editinventory.jsp");
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/getnewpassword")
		public ModelAndView getNewPassword() {
			ModelAndView mv = new ModelAndView();
			mv.setViewName("/getnewpassword.jsp");
			return mv;
		}
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/changepassword")
		public ModelAndView changePassword(HttpServletRequest request) {
			ModelAndView mv = new ModelAndView();
			String password = request.getParameter("password");
			admindao.updatePassword(currentAdmin, password);
			mv.setViewName("/passwordupdated.jsp");
			return mv;
		}		
	//----------------------------------------------------------------------------------------------------------------
		@RequestMapping("/purchhist")
		public ModelAndView purchaseHistory() {
			ModelAndView mv = new ModelAndView();
			List<PurchaseHistory> phList=phdao.getAll();
			mv.setViewName("/purchasehistory.jsp");
			mv.addObject("list",phList);
			return mv;
		}
		
}
