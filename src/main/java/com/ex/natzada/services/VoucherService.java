package com.ex.natzada.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ex.natzada.entities.Voucher;
import com.ex.natzada.repository.VoucherRepository;

@Service
public class VoucherService {
private VoucherRepository voucherRepository;
	
	@Autowired
	public VoucherService(VoucherRepository voucherRepository) {
		this.voucherRepository = voucherRepository;
	}

	public Voucher getVoucherById(Long id) {
		return voucherRepository.findById(id).orElse(null);
		
	}
	
	public List<Voucher> getAll(){
		return voucherRepository.findAll();
	}
	
	public Voucher saveVoucher(Voucher voucher) {
		return voucherRepository.save(voucher);
	}
	public void deleteVoucherById(Long id) {
		voucherRepository.deleteById(id);
	}
}
