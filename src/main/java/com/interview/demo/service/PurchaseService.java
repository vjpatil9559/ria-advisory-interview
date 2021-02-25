package com.interview.demo.service;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.interview.demo.exception.DataNotFoundException;
import com.interview.demo.model.PurchaseVO;

public interface PurchaseService {

	public List<PurchaseVO> getPurchases(Long prodId, Long purchDate, Pageable pageable) throws DataNotFoundException;

}
