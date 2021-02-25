package com.interview.demo.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.interview.demo.entity.Product;
import com.interview.demo.entity.Purchase;
import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.PurchaseVO;
import com.interview.demo.repository.ProductRepository;
import com.interview.demo.repository.PurchaseRepository;
import com.interview.demo.service.PurchaseService;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseServiceImpl.class);

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private PurchaseRepository purchaseRepository;

	@Override
	public List<PurchaseVO> getPurchases(Long prodId, Long purchDate, Pageable pageable) throws DataNotFoundException {
		List<PurchaseVO> purchaseList = new ArrayList<>();
		LOGGER.info("Finding the product by ID : {}", prodId);
		Optional<Product> optionalProduct = productRepository.findById(prodId);
		if (!optionalProduct.isPresent()) {
			throw new DataNotFoundException("Product Not Found with specified ID");
		} else {
			Product product = optionalProduct.get();
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			String stringDdate = formatter.format(new Date(purchDate));
			Date date = new Date();
			try {
				date = formatter.parse(stringDdate);
			} catch (ParseException e) {
				LOGGER.error("Error occurred while converting date");
			}
			List<Purchase> purchases = purchaseRepository.findByProductAndPurchDate(product, date,
					pageable);
			LOGGER.info("Purcahes data found with size : {}", purchases.size());
			purchases.forEach(purchase -> purchaseList.add(PurchaseVO.toPurchaseVO(purchase)));
		}
		LOGGER.info("Found the purchase list with size : {}", purchaseList.size());
		return purchaseList;
	}

}
