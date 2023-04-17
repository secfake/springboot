package vn.tuananh.products.dto;

import lombok.Data;


public record ProductRecord(String name, int price, String brand, int count) {
}
