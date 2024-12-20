package com.evalutation.cartcrud.controller;

import com.evalutation.cartcrud.dto.OrderDto;
import com.evalutation.cartcrud.response.Api;
import com.evalutation.cartcrud.services.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:4200")
public class CartController {

    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }


    @GetMapping("/getOrders")
    public ResponseEntity<Api> getAllProducts(){
        try{
            return ResponseEntity.ok(new Api("all orderes", cartService.getAllOrders()));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api(e.getMessage(), null));
        }
    }

    @GetMapping("/{id}/getOrders")
    public ResponseEntity<Api> getByUser(@PathVariable Long id){
        try{
            return ResponseEntity.ok(new Api("all products", cartService.getOrdersByUser(id)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api(e.getMessage(), null));
        }
    }

    @PostMapping("/createOrder")
    public ResponseEntity<Api> addProduct(@RequestBody OrderDto dto, @RequestParam(value = "role", required = true) String role){
        try{
            if (!"user".equalsIgnoreCase(role)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(new Api("you are not user", null));
            }
            return ResponseEntity.ok(new Api("new product added", cartService.createOrder(dto)));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api(e.getMessage(), null));
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Api> updateOrder(@PathVariable Long id, @RequestParam int qty, @RequestParam(value = "role", required = true) String role){
        try{
            if (!"user".equalsIgnoreCase(role)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(new Api("you are not user", null));
            }
            return ResponseEntity.ok(new Api("product updated", cartService.updateOrder(id,  qty )));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api(e.getMessage(), null));
        }
    }

    @PutMapping("/cancelOrder/{id}")
    public ResponseEntity<Api> cancelOrder(@PathVariable Long id, @RequestParam(value = "role", required = true) String role){
        try{
            if (!"user".equalsIgnoreCase(role)) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN)
                        .body(new Api("you are not user", null));
            }
            return ResponseEntity.ok(new Api("product updated", cartService.cancelOrder(id )));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new Api(e.getMessage(), null));
        }
    }
}
