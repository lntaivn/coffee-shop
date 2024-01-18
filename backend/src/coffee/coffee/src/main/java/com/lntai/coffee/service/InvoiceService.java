package com.lntai.coffee.service;

import com.lntai.coffee.dao.InvoiceRepository;
import com.lntai.coffee.dao.TableOrderRepository;
import com.lntai.coffee.dao.EmployeeRepository;
import com.lntai.coffee.entity.Invoice;
import com.lntai.coffee.entity.TableOrder;
import com.lntai.coffee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    @Autowired
    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    public void createInvoice(Integer tableOrderId, BigDecimal totalAmount, String paymentStatus, Integer employeeId) {
        // Tạo một đối tượng Invoice
        Invoice invoice = new Invoice();

        // Set các giá trị cho đối tượng Invoice
        invoice.setTableOrderId(new TableOrder(tableOrderId));
        invoice.setTotalAmount(totalAmount);
        invoice.setPaymentStatus(paymentStatus);
        invoice.setEmployeeId(new Employee(employeeId));

        // Lưu đối tượng vào cơ sở dữ liệu
        invoiceRepository.save(invoice);
    }

    public void updateInvoice(Integer invoiceId, BigDecimal totalAmount, String paymentStatus, Integer employeeId) {
        // Kiểm tra xem hóa đơn có tồn tại không
        Invoice existingInvoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new RuntimeException("Invoice not found with id: " + invoiceId));

        // Cập nhật thông tin hóa đơn
        existingInvoice.setTotalAmount(totalAmount);
        existingInvoice.setPaymentStatus(paymentStatus);
        existingInvoice.setEmployeeId(new Employee(employeeId)); // Giả sử bạn có constructor cho Employee nhận employeeId

        // Lưu hóa đơn đã cập nhật vào cơ sở dữ liệu
        invoiceRepository.save(existingInvoice);
    }
}