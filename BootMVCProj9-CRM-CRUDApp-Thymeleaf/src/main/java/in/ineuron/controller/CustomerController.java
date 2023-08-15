package in.ineuron.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.ineuron.model.Customer;
import in.ineuron.service.ICustomerService;

@Controller
@RequestMapping(value = "/customer")
public class CustomerController {

	@Autowired
	private ICustomerService service;

	@GetMapping(value = "/list")
	public String listCustomer(Map<String, Object> model) {
		System.out.println("CustomerController.listCustomer()");
		List<Customer> customers = service.getCustomers();
		customers.forEach(System.out::println);
		model.put("customerList", customers);

		return "/customers/list-customers";
	}

//	@GetMapping(value = "/showForm")
//	public String showFormForAdd(@ModelAttribute("cstmr") Customer customer) {
//		System.out.println("CustomerController.showFormForAdd()");
//
//		return "/customers/customer-form";
//	}

	@GetMapping(value = "/showForm") // both are same
	public String showFormForAdd(Map<String, Object> model) {
		System.out.println("CustomerController.showFormForAdd()");
		Customer customer = new Customer();
		model.put("cstmr", customer);
		return "/customers/customer-form";
	}

	@PostMapping(value = "/saveCustomer")
	public String saveCustomer(@ModelAttribute("cstmr") Customer customer) {
		System.out.println("CustomerController.saveCustomer()");
		System.out.println(customer);

		service.saveCustomer(customer);
		return "redirect:/customer/list";
	}
	
	@PostMapping(value = "/showUpdateForm")
	public String showFormForUpdate(@RequestParam Integer customerId, Map<String, Object> model) {
		System.out.println("CustomerController.showFormForUpdate()");
		
		Customer customer = service.getCustomerById(customerId);
		model.put("cstmr", customer);
		System.out.println(customer);
		
		return "/customers/customer-form";
	}
	
	@PostMapping(value = "/showDeleteForm")
	public String showFormForDelete(@RequestParam Integer customerId) {
		System.out.println("CustomerController.showFormForDelete()");
		
		service.deleteCustomer(customerId);
		
		return "redirect:/customer/list";
	}
}
