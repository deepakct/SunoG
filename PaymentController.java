package com.example.MI.controller;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MI.entity.Users;
import com.example.MI.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Utils;

import jakarta.servlet.http.HttpSession;

@Controller

public class PaymentController {
	
	@Autowired
	UserService us;
	
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder() {
		Order order = null;
		
		try {
			RazorpayClient razorpay = new RazorpayClient("rzp_test_IJj06hzIKS6VU5","AaO8G3MAZ6cZm5X8w3Bgp4Xz");

			JSONObject orderRequest = new JSONObject();
			orderRequest.put("amount",50000);
			orderRequest.put("currency","INR");
			orderRequest.put("receipt", "receipt#1");
			JSONObject notes = new JSONObject();
			notes.put("notes_key_1","Tea, Earl Grey, Hot");
			orderRequest.put("notes",notes);

			order = razorpay.orders.create(orderRequest);
		}
		
		catch(Exception e) {
			System.out.println("Exception while payment");
		}
		
		return order.toString();
		
	}
	
	@PostMapping("/verify")
	@ResponseBody
	public boolean verifyPayment(@RequestParam  String orderId, @RequestParam String paymentId, @RequestParam String signature) {
	    try {
	        // Initialize Razorpay client with your API key and secret
	        RazorpayClient razorpayClient = new RazorpayClient("rzp_test_IJj06hzIKS6VU5", "AaO8G3MAZ6cZm5X8w3Bgp4Xz");
	        // Create a signature verification data string
	        String verificationData = orderId + "|" + paymentId;

	        // Use Razorpay's utility function to verify the signature
	        boolean isValidSignature = Utils.verifySignature(verificationData, signature, "AaO8G3MAZ6cZm5X8w3Bgp4Xz");

	        return isValidSignature;
	    } catch (RazorpayException e) {
	        e.printStackTrace();
	        return false;
	    }
	}
	
	@GetMapping("/payment-success")
	public String PaymentSuccess(HttpSession session) {
		
		String email=(String) session.getAttribute("email");
		
		Users u=us.getUser(email);
		u.setPremium(true);
		us.updateUser(u);
		
		return "login";
	}
	
	
	@GetMapping("/payment-failure")
	public String PaymentFailure() {
		
		
		
		return "PaymentFailed";
	}

}
