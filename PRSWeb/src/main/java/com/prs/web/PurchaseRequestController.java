package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.purchaserequest.PurchaseRequest;
import com.prs.business.purchaserequest.PurchaseRequestRepository;

@Controller
@RequestMapping(path="/PurchaseRequests")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequest> getAllPurchaseRequests() {
			Iterable<PurchaseRequest> purchaserequests = purchaseRequestRepository.findAll();
			return purchaserequests;
	}

	@GetMapping(path="/Get")
	public @ResponseBody Optional<PurchaseRequest> getPurchaseRequest(@RequestParam int id) {
		Optional<PurchaseRequest> purchaserequest = purchaseRequestRepository.findById(id);
		return purchaserequest;
	}
	
	@PostMapping(path="/Add")
	public @ResponseBody PurchaseRequest addPurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		return purchaseRequestRepository.save(purchaserequest);
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody PurchaseRequest updatePurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		return purchaseRequestRepository.save(purchaserequest);
	}
	
	@PostMapping(path="/Remove")
	public @ResponseBody String removePurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		purchaseRequestRepository.delete(purchaserequest);
		return purchaserequest + " deleted";
	}
}
