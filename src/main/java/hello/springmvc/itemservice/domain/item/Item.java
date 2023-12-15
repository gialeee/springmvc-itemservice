package hello.springmvc.itemservice.domain.item;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter  // @Data는 포함하는 애노테이션이 많아서 사용하면 위험함 -> 단순 DTO 제외하고는 사용하지 않는 것 추천
public class Item {

    private Long id;
    private String itemName;
    private Integer price;
    private Integer quantity;

    public Item() {
    }

    public Item(String itemName, Integer price, Integer quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}
