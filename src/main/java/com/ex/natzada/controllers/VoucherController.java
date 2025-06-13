package com.ex.natzada.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ex.natzada.entities.Voucher;
import com.ex.natzada.service.VoucherService;

@RestController
@RequestMapping("/voucher")
@CrossOrigin(origins = "http://localhost:3000") // Libera acesso para o front-end React
public class VoucherController {

    private final VoucherService voucherService;

    public VoucherController(VoucherService voucherService) {
        this.voucherService = voucherService;
    }

    @GetMapping("/")
    public ResponseEntity<List<Voucher>> findAll() {
        List<Voucher> vouchers = voucherService.getAll();
        return ResponseEntity.ok(vouchers);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voucher> findVoucherById(@PathVariable Long id) {
        Voucher voucher = voucherService.getVoucherById(id);
        if (voucher != null) {
            return ResponseEntity.ok(voucher);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<Voucher> createVoucher(@RequestBody Voucher voucher) {
        Voucher newVoucher = voucherService.saveVoucher(voucher);
        return ResponseEntity.status(HttpStatus.CREATED).body(newVoucher);
    }

    @DeleteMapping("/{id}")
    public void deleteVoucherById(@PathVariable Long id) {
        voucherService.deleteVoucherById(id);
    }

    @PostMapping("/daily")
    public ResponseEntity<Object> generateDailyVoucher(@RequestParam Long userId) {
        Object result = voucherService.generateDailyVoucher(userId);
        return ResponseEntity.ok(result);
    }
}