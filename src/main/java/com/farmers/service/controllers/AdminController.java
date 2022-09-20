package com.farmers.service.controllers;

import com.farmers.service.dao.*;
import com.farmers.service.dto.BasicResponseDTO;
import com.farmers.service.dto.PaginationDTO;
import com.farmers.service.enums.UserRoleEnum;
import com.farmers.service.models.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("api/admin")
public class AdminController {
    @Autowired
    UserDAO userDAO;

    @Autowired
    VehicleDAO vehicleDAO;
    @Autowired
    ProductOrderDAO productOrderDAO;

    @Autowired
    ProductDAO productDAO;

    @Autowired
    FeedbackDAO feedbackDAO;

    private ModelMapper mapper = new ModelMapper();

    @Operation( description = "Manage users/show all users", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/all-users")
    public ResponseEntity<BasicResponseDTO<Page<User>>> getUsers(@RequestBody PaginationDTO request){
        BasicResponseDTO<Page<User>> response = new BasicResponseDTO<>(true, "No records found", null);
        Page<User> userPage = userDAO.findAllByRoleNot(UserRoleEnum.ADMIN, PageRequest.of(request.getPage(), request.getSize()));
        response.setMessage(userPage.getContent().isEmpty() ?"No records": "record found" );
        response.setData(userPage);
        return ResponseEntity.ok(response);
    }
    @Operation( description = "Manage transport/show all vehicles", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/all-transports")
    public ResponseEntity<BasicResponseDTO<Page<Vehicle>>> getVehicles(@RequestBody PaginationDTO request){
        BasicResponseDTO<Page<Vehicle>> response = new BasicResponseDTO<>(true, "No records found", null);
        Page<Vehicle> vehicles = vehicleDAO.findAll(PageRequest.of(request.getPage(), request.getSize()));
        response.setMessage(vehicles.getContent().isEmpty() ?"No records": "record found" );
        response.setData(vehicles);
        return ResponseEntity.ok(response);
    }

    @Operation( description = "Manage Orders/show all orders", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/all-orders")
    public ResponseEntity<BasicResponseDTO<Page<ProductOrder>>> getOrders(@RequestBody PaginationDTO request){
        BasicResponseDTO<Page<ProductOrder>> response = new BasicResponseDTO<>(true, "No records found", null);
        Page<ProductOrder> orders = productOrderDAO.findAll(PageRequest.of(request.getPage(), request.getSize()));
        response.setMessage(orders.getContent().isEmpty() ?"No records": "record found" );
        response.setData(orders);
        return ResponseEntity.ok(response);
    }

    @Operation( description = "Manage products/show all products", security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping("/all-products")
    public ResponseEntity<BasicResponseDTO<Page<Product>>> getProducts(@RequestBody PaginationDTO request){
        BasicResponseDTO<Page<Product>> response = new BasicResponseDTO<>(true, "No records found", null);
        Page<Product> products = productDAO.findAll(PageRequest.of(request.getPage(), request.getSize()));
        response.setMessage(products.getContent().isEmpty() ?"No records": "record found" );
        response.setData(products);
        return ResponseEntity.ok(response);
    }

    @Operation( description = "Delete order", security = @SecurityRequirement(name = "bearerAuth"))
    @Transactional
    @DeleteMapping("/delete-order/{orderId}")
    public ResponseEntity<BasicResponseDTO<ProductOrder>> deleteOrder(@PathVariable Long orderId){
        BasicResponseDTO<ProductOrder> response = new BasicResponseDTO<>(true, "Order deleted", null);
        Optional<ProductOrder> _order = productOrderDAO.findById(orderId);
        if(_order.isEmpty()){
            response.setMessage("Order not found");
            response.setSuccess(false);
            return ResponseEntity.ok(response);
        }
        vehicleDAO.deleteAllByProductOrder(_order.get());
        productOrderDAO.delete(_order.get());
        return ResponseEntity.ok(response);
    }

    @Operation( description = "Delete product", security = @SecurityRequirement(name = "bearerAuth"))
    @Transactional
    @DeleteMapping("/delete-product/{productId}")
    public ResponseEntity<BasicResponseDTO<Product>> deleteProduct(@PathVariable Long productId){
        BasicResponseDTO<Product> response = new BasicResponseDTO<>(true, "Product deleted", null);
        Optional<Product> _product = productDAO.findById(productId);

        if(_product.isEmpty()){
            response.setMessage("Product not found");
            response.setSuccess(false);
            return ResponseEntity.ok(response);
        }
        Product product = _product.get();
        vehicleDAO.deleteAllByProductOrderProduct(product);
        feedbackDAO.deleteAllByProduct(product);
        productOrderDAO.deleteAllByProduct(product);
        productDAO.delete(product);
        return ResponseEntity.ok(response);
    }

    @Operation( description = "Delete Feedback", security = @SecurityRequirement(name = "bearerAuth"))
    @Transactional
    @DeleteMapping("/delete-feedback/{feedbackId}")
    public ResponseEntity<BasicResponseDTO<Feedback>> deleteFeedback(@PathVariable Long feedbackId){
        BasicResponseDTO<Feedback> response = new BasicResponseDTO<>(true, "Feedback deleted", null);
        Optional<Feedback> _feedback = feedbackDAO.findById(feedbackId);
        if(_feedback.isEmpty()){
            response.setMessage("Feedback not found");
            response.setSuccess(false);
            return ResponseEntity.ok(response);
        }
        feedbackDAO.delete(_feedback.get());
        return ResponseEntity.ok(response);
    }
}
