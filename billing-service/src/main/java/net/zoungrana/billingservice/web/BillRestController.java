package net.zoungrana.billingservice.web;

import lombok.RequiredArgsConstructor;
import net.zoungrana.billingservice.entities.Bill;
import net.zoungrana.billingservice.entities.ProductItem;
import net.zoungrana.billingservice.model.Customer;
import net.zoungrana.billingservice.model.Product;
import net.zoungrana.billingservice.repository.BillRepository;
import net.zoungrana.billingservice.repository.ProductItemRepository;
import net.zoungrana.billingservice.services.CustomerService;
import net.zoungrana.billingservice.services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BillRestController {

    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductService productService;
    private final CustomerService customerService;

    @GetMapping("/bills/{id}")
    public Bill getBillById(@PathVariable UUID id){
        Bill bill=billRepository.findById(id).get();
        Customer customer=customerService.findCustomerById(bill.getCustomerId());
        bill.setCustomer(customer);

        List<ProductItem> billProductItems=productItemRepository.findByBillId(bill.getId());

        billProductItems.forEach(productItem->{
            Product product=productService.findProductById(productItem.getProductId());
            productItem.setProduct(product);
        });

        bill.setProductItems(billProductItems);

        return bill;

    }

}
