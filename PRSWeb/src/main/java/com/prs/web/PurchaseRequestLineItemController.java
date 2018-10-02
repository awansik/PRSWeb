package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.purchaserequest.PurchaseRequestLineItem;
import com.prs.business.purchaserequest.PurchaseRequestLineItemRepository;

public class PurchaseRequestLineItemController {

	@Autowired
	private PurchaseRequestLineItemRepository purchaseRequestLineItemRepository;
	
	@GetMapping(path="/List")
	public @ResponseBody Iterable<PurchaseRequestLineItem> getAllPurchaseRequests() {
			Iterable<PurchaseRequestLineItem> purchaserequestlineitems = purchaseRequestLineItemRepository.findAll();
			return purchaserequestlineitems;
	}

	@GetMapping(path="/Get")
	public @ResponseBody Optional<PurchaseRequestLineItem> getPurchaseRequestLineItem(@RequestParam int id) {
		Optional<PurchaseRequestLineItem> purchaserequestlineitem = purchaseRequestLineItemRepository.findById(id);
		return purchaserequestlineitem;
	}
	
	@PostMapping(path="/Add")
	public @ResponseBody PurchaseRequestLineItem addPurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaserequestlineitem) {
		return purchaseRequestLineItemRepository.save(purchaserequestlineitem);
	}
	
	@PostMapping(path="/Change")
	public @ResponseBody PurchaseRequestLineItem updatePurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaserequestlineitem) {
		return purchaseRequestLineItemRepository.save(purchaserequestlineitem);
	}
	
	@PostMapping(path="/Remove")
	public @ResponseBody String removePurchaseRequestLineItem(@RequestBody PurchaseRequestLineItem purchaserequestlineitem) {
		purchaseRequestLineItemRepository.delete(purchaserequestlineitem);
		return purchaserequestlineitem + " deleted";
	}
}
