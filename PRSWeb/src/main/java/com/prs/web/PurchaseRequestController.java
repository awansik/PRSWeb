package com.prs.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.prs.business.purchaserequest.PurchaseRequest;
import com.prs.business.purchaserequest.PurchaseRequestRepository;
import com.prs.util.JsonResponse;

@CrossOrigin
@Controller
@RequestMapping("/PurchaseRequests")
public class PurchaseRequestController {

	@Autowired
	private PurchaseRequestRepository purchaseRequestRepository;
	
	@GetMapping("/List")
	public @ResponseBody JsonResponse getAllPurchaseRequests() {
		try {
			return JsonResponse.getInstance(purchaseRequestRepository.findAll());
		}
		catch (Exception e) {
			return JsonResponse.getErrorInstance("Purchase Request list failure:"+e.getMessage(), e);
		}
	}

	@GetMapping("/Get{id}")
	public @ResponseBody JsonResponse getPurchaseRequest(@PathVariable int id) {
		try {
				Optional<PurchaseRequest> purchaserequest = purchaseRequestRepository.findById(id);
				if (purchaserequest.isPresent())
						return JsonResponse.getInstance(purchaserequest.get());
				else
					return JsonResponse.getErrorInstance("Purchase Request not found for id: "+id, null);
		}
		catch (Exception e) {
			return JsonResponse.getErrorInstance("Error getting purchase request: "+e.getMessage(), null);
		}
	}
	
	@PostMapping("/Add")
	public @ResponseBody JsonResponse addPurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		return savePurchaseRequest(purchaserequest);
	}
	
	@PostMapping("/Change")
	public @ResponseBody JsonResponse updatePurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		return savePurchaseRequest(purchaserequest);
	}
	
	private @ResponseBody JsonResponse savePurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		try {
			purchaseRequestRepository.save(purchaserequest);
			return JsonResponse.getInstance(purchaserequest);
		} catch (DataIntegrityViolationException ex) {
			return JsonResponse.getErrorInstance(ex.getRootCause().toString(), ex);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}
	
	@PostMapping("/Remove")
	public @ResponseBody JsonResponse removePurchaseRequest(@RequestBody PurchaseRequest purchaserequest) {
		try {
			purchaseRequestRepository.delete(purchaserequest);
			return JsonResponse.getInstance(purchaserequest);
		} catch (Exception ex) {
			return JsonResponse.getErrorInstance(ex.getMessage(), ex);
		}
	}
}
