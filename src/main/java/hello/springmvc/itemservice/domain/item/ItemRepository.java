package hello.springmvc.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ItemRepository {

    // static 선언!!
    private static final Map<Long, Item> store = new HashMap<>(); // 실무에서는 hashmap 사용하면 안 됨 -> 사용하려면 concurrent hashmap 사용해야 함
    private static long sequence = 0L; // 실무에는 long 사용하면 안 됨 -> atomic long 등 동시성 꼬이지 않는 것 사용해야 함

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
        return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
        store.clear();
    }

}
