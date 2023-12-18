package hello.springmvc.itemservice.web.basic;

import hello.springmvc.itemservice.domain.item.Item;
import hello.springmvc.itemservice.domain.item.ItemRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/basic/items")
@RequiredArgsConstructor // final인 필드에 대하여 생성자 자동 생성
public class BasicItemController {

    private final ItemRepository itemRepository;

//    @Autowired
//    public BasicItemController(ItemRepository itemRepository) {  // @RequiredArgsConstructor 사용하여 생략 가능
//        this.itemRepository = itemRepository;
//    }

    @GetMapping
    public String items(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items", items);
        return "basic/items";
    }
    @GetMapping("/{itemId}")
    public String item(@PathVariable Long itemId, Model model) {
        Item item = itemRepository.findById(itemId);
        model.addAttribute("item", item);
        return "basic/item";
    }

    @GetMapping("/add")
    public String addForm() {
        return "basic/addForm";
    }

//    @PostMapping("/add") // V2를 쓰기 위한 주석 처리
    public String addItemV1(@RequestParam String itemName,
                            @RequestParam int price,
                            @RequestParam Integer quantity,
                            Model model) {
        Item item = new Item();
        item.setItemName(itemName);
        item.setPrice(price);
        item.setQuantity(quantity);

        itemRepository.save(item);

        model.addAttribute("item", item);

        return "basic/item";
    }

    /**
     *  @ModelAttribute("item") Item item
     *  model.addAttribute("item", item); 자동 추가, 생략 가능
     * @ModelAttribute이 자동으로 Item 객체 생성 후 요청 파라미터의 값을 프로퍼티 접근법(setXxx)으로 입력해줌
     */
//    @PostMapping("/add")
    public String addItemV2(@ModelAttribute("item") Item item) {
        itemRepository.save(item);

        return "basic/item";
    }

    /**
     *   @ModelAttribute name 생략 가능
     *  * model.addAttribute(item); 자동 추가, 생략 가능
     *  * 생략시 model에 저장되는 name은 클래스명 첫글자만 소문자로 등록 Item -> item
     */
    @PostMapping("/add")
    public String addItemV3(@ModelAttribute Item item) {
        itemRepository.save(item);

        return "basic/item";
    }


    /**
     * 테스트용 데이터 추가
     */
    @PostConstruct  // 해당 빈의 의존관계가 모두 주입되고 나면 초기화 용도로 호출
    public void init() {
        itemRepository.save(new Item("itemA", 10000, 10));
        itemRepository.save(new Item("itemB", 20000, 20));
    }

}
