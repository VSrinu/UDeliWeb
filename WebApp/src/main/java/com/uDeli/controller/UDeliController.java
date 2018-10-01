package com.uDeli.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.uDeli.model.CarrierDetails;
import com.uDeli.model.GetUserProfile;
import com.uDeli.model.MerchantDetails;
import com.uDeli.model.NewOrderDetailsList;
import com.uDeli.model.OrderDetails;
import com.uDeli.model.OrderDetailsList;
import com.uDeli.respository.UDeliRepository;

import ch.qos.logback.core.net.SyslogOutputStream;

@Controller
@SessionAttributes("userName")
public class UDeliController {

	@Autowired
	UDeliRepository udeliRepo;

	List<GetUserProfile> userDetailsList = null;
	List<MerchantDetails> merchantList = null;
	List<CarrierDetails> carriersList = null;
	List<OrderDetailsList> ordersList = null;
	List<NewOrderDetailsList> newOrdersList = null;
	/* List<OrderDetails> orderDetails = null; */
	String redirectTo = "";

	/*
	 * @RequestMapping("/") public String welcome(Map<String, Object> model) {
	 * return UDeliConstants.HTML_WELCOME; }
	 */

	@RequestMapping("/")
	/* @RequestMapping(UDeliConstants.PATH_LOGIN) */
	public String login(Model model) {
		model.addAttribute("getuserprofile", new GetUserProfile());
		return /* UDeliConstants.HTML_LOGIN */"login";
	}

	@RequestMapping("/logout")
	/* @RequestMapping(UDeliConstants.PATH_LOGOUT) */
	public String logout(Model model) {
		model.addAttribute("getuserprofile", new GetUserProfile());
		return /* UDeliConstants.HTML_LOGOUT */ "logout";
	}

	@RequestMapping("/addmerchant")
	public String addMerchant(Model model) {
		model.addAttribute("merchantdetails", new MerchantDetails());
		return "addmerchant";
	}

	@RequestMapping("/viewmerchant")
	public String viewMerchant(Model model) {
		merchantList = udeliRepo.getAllMerchants();
		model.addAttribute("merchantList", merchantList);
		return "viewmerchant";
	}

	@RequestMapping("/orderdetails")
	public String orderDetails(Map<String, Object> model) {
		return "orderdetails";
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView loginPage(@Valid @ModelAttribute("getuserprofile") GetUserProfile getuserprofile,
			BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes, HttpSession session) {

		System.out.println("---------- Inside UdeliController-loginPage- Enter---------- ");

		if (bindingResult.hasErrors()) {
			redirectTo = "login";
		}

		/*** Getting User Records ***********/
		if (getuserprofile.getUsername() != null && getuserprofile.getPlaintextpass() != null
				&& !getuserprofile.getUsername().equals("") && !getuserprofile.getPlaintextpass().equals("")) {
			userDetailsList = udeliRepo.getUserProfile(getuserprofile);
			model.addAttribute("userType", userDetailsList.get(0).getUsertype());
			redirectAttributes.addFlashAttribute("userName", userDetailsList.get(0).getName());
			System.out.println("User Name" + userDetailsList.get(0).getName());
			if (userDetailsList != null && userDetailsList.size() > 0) {
				if (userDetailsList.get(0).getUsertype().equals('a'))
					redirectTo = "redirect:/viewmerchant";
				else if (userDetailsList.get(0).getUsertype().equals('m'))
					redirectTo = "redirect:/vieworders";
			}
		}

		System.out.println("---------- Inside UdeliController-loginPage- Exit----------" + redirectTo);

		return new ModelAndView(redirectTo);
		// return "login";
	}

	/*
	 * HttpSession session = request.getSession(); session.setAttribute("user",
	 * user);
	 */
	@RequestMapping(value = "/addmerchant", params = "save", method = RequestMethod.POST)
	public ModelAndView addMerchant(@Valid @ModelAttribute("merchantdetails") MerchantDetails merchantdetails,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {

		System.out.println(" Inside UdeliController ..addMerchant-------- Enter------");

		if (bindingResult.hasErrors()) {
			redirectTo = "addmerchant";
		} else {
			if (merchantdetails.getMerchantid() == null) {
				System.out.println(" Insert New Record");
				udeliRepo.insertMerchantDetails(merchantdetails, "insert");
				redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", " Record inserted Successfully ");
			} else {
				System.out.println(" Update existing Record");
				udeliRepo.insertMerchantDetails(merchantdetails, "update");
				redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", " Record updated Successfully ");
			}
			redirectTo = "redirect:/viewmerchant";
		}

		System.out.println(" Inside UdeliController..addMerchant --------- Exit------");
		return new ModelAndView(redirectTo);
	}

	@RequestMapping(value = "/deletemerchant", method = RequestMethod.GET)
	public ModelAndView deleteMerchant(HttpServletRequest request, MerchantDetails merchantdetails) {

		System.out.println(" Inside UdeliController ..deleteMerchant-------- Enter------");
		int merchantid = Integer.parseInt(request.getParameter("merchantid"));
		udeliRepo.deleteMerchantDetails(merchantid);
		System.out.println(" Inside UdeliController..addMerchant --------- Exit------");

		return new ModelAndView("redirect:/viewmerchant");
	}

	@RequestMapping(value = "/addmerchant", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelMerchant() {
		return new ModelAndView("redirect:/viewmerchant");
	}

	@RequestMapping(value = "/editmerchant", method = RequestMethod.GET)
	public String editMerchant(HttpServletRequest request, Model model, MerchantDetails merchantdetails) {

		System.out.println(" Inside UdeliController ..editMerchant-------- Enter------");

		int merchantid = Integer.parseInt(request.getParameter("merchantid"));
		List<MerchantDetails> merchantList = udeliRepo.editMerchantDetails(merchantid);

		MerchantDetails mDetails = new MerchantDetails();
		mDetails.setMerchantid(merchantList.get(0).getMerchantid());
		mDetails.setName(merchantList.get(0).getName());
		mDetails.setAddress(merchantList.get(0).getAddress());
		mDetails.setState(merchantList.get(0).getState());
		mDetails.setCity(merchantList.get(0).getCity());
		mDetails.setZip(merchantList.get(0).getZip());
		mDetails.setCountry(merchantList.get(0).getCountry());
		mDetails.setPhonenumber(merchantList.get(0).getPhonenumber());
		mDetails.setFirstname(merchantList.get(0).getFirstname());
		mDetails.setLastname(merchantList.get(0).getLastname());
		mDetails.setEmail(merchantList.get(0).getEmail());
		mDetails.setUsername(merchantList.get(0).getUsername());
		mDetails.setPlaintextpass(merchantList.get(0).getPlaintextpass());
		mDetails.setDeliveryhours(merchantList.get(0).getDeliveryhours());
		mDetails.setDescription(merchantList.get(0).getDescription());
		model.addAttribute("merchantdetails", mDetails);

		System.out.println(" Inside UdeliController --------- Exit------");

		return "addmerchant";
	}

	@RequestMapping("/viewCarrierDetails")
	public String viewCarrier(Model model) {
		carriersList = udeliRepo.getCarriers(userDetailsList.get(0).getMerchantid());
		model.addAttribute("carriersList", carriersList);
		return "viewCarrierDetails";
	}

	@RequestMapping(value = { "/approvecarrier", "/denycarrier" }, method = RequestMethod.GET)
	public ModelAndView requestCarrier(HttpServletRequest request, CarrierDetails carrierDetails) {
		int carrierid = Integer.parseInt(request.getParameter("carrierid"));
		int active = Integer.parseInt(request.getParameter("active"));
		udeliRepo.approveCarrier(carrierDetails, carrierid, active);
		return new ModelAndView("redirect:/viewCarrierDetails");
	}

	@RequestMapping("/viewApproveCarrierDetails")
	public String approveCarrier(Model model) {
		carriersList = udeliRepo.getApproveCarriers(userDetailsList.get(0).getMerchantid());
		model.addAttribute("carriersList", carriersList);
		return "viewApproveCarrierDetails";
	}

	@RequestMapping("/viewDenyCarrierDetails")
	public String denyCarrier(Model model) {
		carriersList = udeliRepo.getDenyCarriers(userDetailsList.get(0).getMerchantid());
		model.addAttribute("carriersList", carriersList);
		return "viewDenyCarrierDetails";
	}

	@RequestMapping(value = { "/denyapprovedcarrier" }, method = RequestMethod.GET)
	public ModelAndView approveCarrier(HttpServletRequest request, CarrierDetails carrierDetails) {
		int carrierid = Integer.parseInt(request.getParameter("carrierid"));
		int active = Integer.parseInt(request.getParameter("active"));
		udeliRepo.approveCarrier(carrierDetails, carrierid, active);
		return new ModelAndView("redirect:/viewApproveCarrierDetails");

	}

	@RequestMapping(value = { "/approvedenyedcarrier" }, method = RequestMethod.GET)
	public ModelAndView denyCarrier(HttpServletRequest request, CarrierDetails carrierDetails) {
		int carrierid = Integer.parseInt(request.getParameter("carrierid"));
		int active = Integer.parseInt(request.getParameter("active"));
		udeliRepo.approveCarrier(carrierDetails, carrierid, active);
		return new ModelAndView("redirect:/viewDenyCarrierDetails");
	}

	// View all added Orders.
	@RequestMapping("/vieworders")
	public String viewOrders(Model model) {
		newOrdersList = udeliRepo.getNewOrders(userDetailsList.get(0).getMerchantid());
		model.addAttribute("newOrdersList", newOrdersList);
		return "vieworders";
	}

	@RequestMapping("/viewApprovedOrders")
	public String viewApprovedOrders(Model model) {
		ordersList = udeliRepo.getApprovedOrders(userDetailsList.get(0).getMerchantid());
		model.addAttribute("ordersList", ordersList);
		return "viewApprovedOrders";
	}

	@RequestMapping("/viewClosedOrders")
	public String viewClosedOrders(Model model) {
		ordersList = udeliRepo.getClosedOrders(userDetailsList.get(0).getMerchantid());
		model.addAttribute("ordersList", ordersList);
		return "viewClosedOrders";
	}

	@RequestMapping(value = "/addorders", method = RequestMethod.GET)
	public String addOrders(HttpServletRequest request, Model model, OrderDetails orderdetails) {
		System.out.println(orderdetails + "==========Start Add Orders details======================"
				+ userDetailsList.get(0).getMerchantid());
		model.addAttribute("orderdetails", orderdetails);
		return "addorders";
	}

	// Cancel Order Details.
	@RequestMapping(value = "/addorders", params = "cancel", method = RequestMethod.POST)
	public ModelAndView cancelOrders() {
		System.out.println("================Cancel add orders===================");
		return new ModelAndView("redirect:/vieworders");
	}

	@RequestMapping(value = "/addorders", params = "save", method = RequestMethod.POST)
	public ModelAndView addOrdersDetails(HttpServletRequest request, Model model, OrderDetails orderdetails,
			BindingResult bindingResult, RedirectAttributes redirectAttributes) {
		System.out.println("==========Save Add Orders details======================"
				+ userDetailsList.get(0).getMerchantid()/* +"========"+merchantid */);
		if (bindingResult.hasErrors()) {
			redirectTo = "addorders";
		} else if (orderdetails.getOrderid() == null) {
			udeliRepo.insertOrderDetails(orderdetails, "insert", userDetailsList.get(0).getMerchantid());
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", " Record inserted Successfully ");
		} else {
			udeliRepo.insertOrderDetails(orderdetails, "update", userDetailsList.get(0).getMerchantid());
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", " Record inserted Successfully ");
		}

		System.out.println("==========End Add Orders details======================");
		model.addAttribute("orderdetails", orderdetails);
		return new ModelAndView("redirect:/vieworders");
	}

	// Edit Order Details.
	@RequestMapping(value = "/editorders", method = RequestMethod.GET)
	public String editOrder(HttpServletRequest request, Model model, OrderDetails orderdetails) {

		System.out.println("==========Enter Edit Orders details======================");

		int orderid = Integer.parseInt(request.getParameter("orderid"));
		List<OrderDetails> orderDetailsList = udeliRepo.editOrderDetails(orderid);

		orderdetails.setOrderid(orderDetailsList.get(0).getOrderid());
		orderdetails.setMerchantid(orderDetailsList.get(0).getMerchantid());
		orderdetails.setOrdertitle(orderDetailsList.get(0).getOrdertitle());
		orderdetails.setOrderdetails(orderDetailsList.get(0).getOrderdetails());
		orderdetails.setCustomername(orderDetailsList.get(0).getCustomername());
		orderdetails.setAddress(orderDetailsList.get(0).getAddress());
		orderdetails.setCity(orderDetailsList.get(0).getCity());
		orderdetails.setState(orderDetailsList.get(0).getState());
		orderdetails.setZip(orderDetailsList.get(0).getZip());
		orderdetails.setPhonenumber(orderDetailsList.get(0).getPhonenumber());
		orderdetails.setEmail(orderDetailsList.get(0).getEmail());
		orderdetails.setNumberofbags(orderDetailsList.get(0).getNumberofbags());
		orderdetails.setTotalitems(orderDetailsList.get(0).getTotalitems());
		orderdetails.setTotalweight(orderDetailsList.get(0).getTotalweight());
		orderdetails.setPerishable(orderDetailsList.get(0).getPerishable());
		orderdetails.setFragile(orderDetailsList.get(0).getFragile());
		System.out.println("value of fragile:" + orderDetailsList.get(0).getFragile());
		orderdetails.setPreferreddeliverytime(orderDetailsList.get(0).getPreferreddeliverytime());
		System.out.println("values  :" + orderDetailsList.get(0).getPreferreddeliverytime());
		model.addAttribute("orderdetails", orderdetails);

		return "addorders";
	}

	// Delete the Order details.
	@RequestMapping(value = "/deleteorder", method = RequestMethod.GET)
	public ModelAndView deleteorder(HttpServletRequest request, OrderDetails orderdetails) {

		int orderid = Integer.parseInt(request.getParameter("orderid"));
		udeliRepo.deleteOrderDetails(orderid);

		return new ModelAndView("redirect:/vieworders");
	}

	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody String uploadFileHandler(@RequestParam("file") MultipartFile file, Model model,
			OrderDetails orderdetails) throws IOException {

		String name = file.getOriginalFilename();
		if (!file.isEmpty()) {
			System.out.println("file data details===========================" + name);
			long excelCount = 0;
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = System.getProperty("catalina.home");
				File dir = new File(rootPath + File.separator + "tmpFiles");
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				File serverFile = new File(dir.getAbsolutePath() + File.separator + name);
				BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();

				System.out.println("Server File Location=" + serverFile.getAbsolutePath());

				File file1 = new File(serverFile.getAbsolutePath());
				System.out.println("get server file name in the file========" + file1);
				FileInputStream excelFile = new FileInputStream(new File(serverFile.getAbsolutePath()));
				Workbook workbook = new XSSFWorkbook(excelFile);
				Sheet datatypeSheet = workbook.getSheetAt(0);
				Iterator<Row> iterator = datatypeSheet.iterator();
				Cell currentCell = null;
				List orderList = null;

				while (iterator.hasNext()) {
					Row currentRow = iterator.next();
					Iterator<Cell> cellIterator = currentRow.iterator();
					orderList = new ArrayList();
					while (cellIterator.hasNext()) {
						currentCell = cellIterator.next();
						if (excelCount != 0) {
							// getCellTypeEnum shown as deprecated for version 3.15
							// getCellTypeEnum ill be renamed to getCellType starting from version 4.0
							switch (currentCell.getCellType()) {
							case Cell.CELL_TYPE_BOOLEAN:
								System.out.print(currentCell.getBooleanCellValue() + "\t\t");
								break;
							case Cell.CELL_TYPE_NUMERIC:
								if (DateUtil.isCellDateFormatted(currentCell)) {
									System.out.println(currentCell.getDateCellValue() + "\t\t");
									orderList.add(currentCell.getDateCellValue());
								} else {
									System.out.println((int) Math.abs(currentCell.getNumericCellValue()) + "\t\t");
									orderList.add((int) Math.abs(currentCell.getNumericCellValue()));
								}
								break;
							case Cell.CELL_TYPE_STRING:
								System.out.print(currentCell.getStringCellValue() + "\t\t");
								orderList.add(currentCell.getStringCellValue());
								break;
							case Cell.CELL_TYPE_FORMULA:
								System.out.println(currentCell.getCellFormula() + "\t\t");
								break;
							case Cell.CELL_TYPE_BLANK:
								System.out.println();
								break;
							}

						}

					}
					
					System.out.println(excelCount);
					if(excelCount!=0) {
						orderdetails.setOrdertitle(orderList.get(0).toString());
						orderdetails.setOrderdetails(orderList.get(1).toString());
						orderdetails.setCustomername(orderList.get(2).toString());
						orderdetails.setAddress(orderList.get(3).toString());
						orderdetails.setCity(orderList.get(4).toString());
						orderdetails.setState(orderList.get(5).toString());
						orderdetails.setZip(orderList.get(6).toString());
						orderdetails.setPhonenumber(orderList.get(7).toString());
						orderdetails.setEmail(orderList.get(8).toString());
						orderdetails.setNumberofbags(Integer.parseInt(orderList.get(9).toString()));
						orderdetails.setTotalitems(Integer.parseInt(orderList.get(10).toString()));
						orderdetails.setTotalweight(Integer.parseInt(orderList.get(11).toString()));
						orderdetails.setPerishable(Integer.parseInt(orderList.get(12).toString()));
						orderdetails.setFragile(Integer.parseInt(orderList.get(13).toString()));
						String sDate = orderList.get(14).toString();
						String date = orderList.get(14).toString();
						DateFormat dateFormat = new SimpleDateFormat("E MMM dd HH:mm:ss z yyyy");
						Date strDate = dateFormat.parse(date);
						long millis = strDate.getTime();
						Timestamp ts = new Timestamp(millis);
						orderdetails.setPreferreddeliverytime(ts);
						orderdetails.setStoretocustlocation(10);
						System.out.println("Order List Details======="+orderList);
						udeliRepo.insertOrderDetails(orderdetails, "insert", userDetailsList.get(0).getMerchantid());
					}
					excelCount++;
					System.out.println("get recordes list==="+excelCount);
					orderList = null;
					System.out.println();

				}

				return "vieworders";
			} catch (Exception e) {
				System.out.println("catch block details" + e.getMessage());
				return "vieworders";
			}
		} else {
			return "vieworders";
		}
	}

}
