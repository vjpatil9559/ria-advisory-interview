package com.interview.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.PurchaseVO;
import com.interview.demo.service.PurchaseService;

@RestController
public class PurchaseColtroller {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseColtroller.class);

	@Autowired
	private PurchaseService purchaseService;

	@GetMapping(path = "/purchases")
	public List<PurchaseVO> getPurchases(@RequestParam(value = "prod_id", required = true) Long prodId,
			@RequestParam(value = "purch_Date", required = true) Long purchDate, Pageable pageable)
			throws DataNotFoundException {
		LOGGER.info(
				"Request received to find the purchase list on the basis of prodId : {}, purchDate : {}, pageable : {}",
				prodId, purchDate, pageable);
		return purchaseService.getPurchases(prodId, purchDate, pageable);
	}
	
}
