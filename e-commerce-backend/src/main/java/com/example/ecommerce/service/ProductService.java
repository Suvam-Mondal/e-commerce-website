package com.example.ecommerce.service;

import com.example.ecommerce.entity.ProductDetail;
import com.example.ecommerce.model.Product;
import com.example.ecommerce.repo.ProductRepo;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class ProductService {

    private final ProductRepo productRepo;

    @Autowired
    public ProductService(final ProductRepo productRepo) {
        this.productRepo = productRepo;
    }

    //for firebase
   /* public void storeProducts1() {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = new ArrayList<>();
        Product googlePixel8 = new Product();
        googlePixel8.setDocument_id(UUID.randomUUID().toString());
        googlePixel8.setName("Google Pixel 8");
        googlePixel8.setPrice(70000L);
        googlePixel8.setBrand("Google");
        googlePixel8.setCategory("mobile");
        googlePixel8.setImg("https://lh3.googleusercontent.com/RCpAMtM9AnLkN7ieohtKg8-alFDueYDu6MzF_0URz1pubadrK7jmAnKU_aBv8j5dre7m9iJ_ZgOrSlYJWWUzB7kZ1srvA2qwce4");
        Product googlePixel8Pro = new Product();
        googlePixel8Pro.setDocument_id(UUID.randomUUID().toString());
        googlePixel8Pro.setName("Google Pixel 8 Pro");
        googlePixel8Pro.setPrice(90000L);
        googlePixel8Pro.setBrand("Google");
        googlePixel8Pro.setCategory("mobile");
        googlePixel8Pro.setImg("https://images-cdn.ubuy.co.in/651e1cdf997a536aed735f24-google-pixel-8-pro-unlocked-android.jpg");
        Product samsungS22 = new Product();
        samsungS22.setDocument_id(UUID.randomUUID().toString());
        samsungS22.setName("Samsung S22");
        samsungS22.setPrice(50000L);
        samsungS22.setBrand("Samsung");
        samsungS22.setCategory("mobile");
        samsungS22.setImg("https://image-us.samsung.com/us/smartphones/galaxy-s22/images/gallery/R0-Green/FLRC-214-R0-Green-01-PDP-GALLERY-1600x1200.jpg?$product-details-jpg");
        Product samsungS22Plus = new Product();
        samsungS22Plus.setDocument_id(UUID.randomUUID().toString());
        samsungS22Plus.setName("Samsung S22 Plus");
        samsungS22Plus.setPrice(60000L);
        samsungS22Plus.setBrand("Samsung");
        samsungS22Plus.setCategory("mobile");
        samsungS22Plus.setImg("https://www.smartprix.com/bytes/wp-content/uploads/2022/10/71WdFQHjDwL._SL1500_.jpg");
        Product samsungS22Ultra = new Product();
        samsungS22Ultra.setDocument_id(UUID.randomUUID().toString());
        samsungS22Ultra.setName("Samsung S22 Ultra");
        samsungS22Ultra.setPrice(80000L);
        samsungS22Ultra.setBrand("Samsung");
        samsungS22Ultra.setCategory("mobile");
        samsungS22Ultra.setImg("https://images.samsung.com/is/image/samsung/p6pim/in/2202/gallery/in-galaxy-s22-ultra-s908-413016-sm-s908edrhinu-530969148?$650_519_PNG");
        Product iphone13 = new Product();
        iphone13.setDocument_id(UUID.randomUUID().toString());
        iphone13.setName("Apple iPhone 13");
        iphone13.setPrice(50000L);
        iphone13.setBrand("Apple");
        iphone13.setCategory("mobile");
        iphone13.setImg("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-13-product-red-select-2021?wid=940&hei=1112&fmt=png-alpha&.v=1645572315758");
        Product iphone13Pro = new Product();
        iphone13Pro.setDocument_id(UUID.randomUUID().toString());
        iphone13Pro.setName("Apple iPhone 13 Pro");
        iphone13Pro.setPrice(70000L);
        iphone13Pro.setBrand("Apple");
        iphone13Pro.setCategory("mobile");
        iphone13Pro.setImg("https://m.media-amazon.com/images/I/611ovP2GkrL.jpg");

        Product peterEnglandShirt = new Product();
        peterEnglandShirt.setDocument_id(UUID.randomUUID().toString());
        peterEnglandShirt.setName("Peter England Shirt (Black)");
        peterEnglandShirt.setPrice(1000L);
        googlePixel8.setBrand("Peter England");
        peterEnglandShirt.setCategory("clothing");
        peterEnglandShirt.setImg("https://m.media-amazon.com/images/I/51K2G8wWukL._AC_UL480_FMwebp_QL65_.jpg");
        Product peterEnglandShirt2 = new Product();
        peterEnglandShirt2.setDocument_id(UUID.randomUUID().toString());
        peterEnglandShirt2.setName("Peter England Shirt (White)");
        peterEnglandShirt2.setPrice(1000L);
        googlePixel8.setBrand("Peter England");
        peterEnglandShirt2.setCategory("clothing");
        peterEnglandShirt2.setImg("https://m.media-amazon.com/images/I/51QOcuF8B+L._AC_UL480_FMwebp_QL65_.jpg");

        Product theSouledStore = new Product();
        theSouledStore.setDocument_id(UUID.randomUUID().toString());
        theSouledStore.setName("Super Soldier T-Shirt");
        theSouledStore.setPrice(800L);
        googlePixel8.setBrand("The Souled Store");
        theSouledStore.setCategory("clothing");
        theSouledStore.setImg("https://m.media-amazon.com/images/I/61bPqVAuGOL._AC_UL480_FMwebp_QL65_.jpg");
        Product theSouledStore2 = new Product();
        theSouledStore2.setDocument_id(UUID.randomUUID().toString());
        theSouledStore2.setName("Garfield T-Shirt");
        theSouledStore2.setPrice(800L);
        googlePixel8.setBrand("The Souled Store");
        theSouledStore2.setCategory("clothing");
        theSouledStore2.setImg("https://m.media-amazon.com/images/I/71ck2zlPMLL._AC_UL480_FMwebp_QL65_.jpg");

        Product leeCooper = new Product();
        leeCooper.setDocument_id(UUID.randomUUID().toString());
        leeCooper.setName("Lee Cooper Shirt (Grey)");
        leeCooper.setPrice(800L);
        leeCooper.setBrand("Lee Cooper");
        leeCooper.setCategory("clothing");
        leeCooper.setImg("https://m.media-amazon.com/images/I/61DMgCXRRGL._AC_UL480_FMwebp_QL65_.jpg");

        products.add(googlePixel8);
        products.add(googlePixel8Pro);
        products.add(samsungS22);
        products.add(samsungS22Plus);
        products.add(samsungS22Ultra);
        products.add(iphone13);
        products.add(iphone13Pro);
        products.add(peterEnglandShirt);
        products.add(peterEnglandShirt2);
        products.add(theSouledStore);
        products.add(theSouledStore2);
        products.add(leeCooper);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        for (Product p : products) {
            HttpEntity entity = new HttpEntity(p, headers);
            ResponseEntity<String> response = restTemplate.exchange("https://angular-demo-prj-default-rtdb.firebaseio.com/products.json", HttpMethod.POST, entity, String.class);

        }

    }
    public void storeProducts2() {
        RestTemplate restTemplate = new RestTemplate();
        List<Product> products = new ArrayList<>();

        Product toy1 = new Product();
        toy1.setDocument_id(UUID.randomUUID().toString());
        toy1.setName("Storio Toys Dancing Cactus Talking Toy, Cactus Plush Toy, Wriggle & Singing Recording Repeat What You Say Funny Education Toys for Babies Children Playing, Home Decorate");
        toy1.setPrice(318L);
        toy1.setBrand("Storio");
        toy1.setCategory("toy");
        toy1.setImg("https://m.media-amazon.com/images/I/51kFlytvjAL._SL1481_.jpg");
        Product toy2 = new Product();
        toy2.setDocument_id(UUID.randomUUID().toString());
        toy2.setName("Wembley Dancing Monkey Musical Toy for Kids Baby Spinning Rolling Doll Tumble Toy with Voice Control Musical Light and Sound Effects with Sensor - ISI Mark - Multicolor");
        toy2.setPrice(299L);
        toy2.setBrand("Wembley");
        toy2.setCategory("toy");
        toy2.setImg("https://m.media-amazon.com/images/I/61g9sptTYQL._SL1100_.jpg");
        Product toy3 = new Product();
        toy3.setDocument_id(UUID.randomUUID().toString());
        toy3.setName("GRAPHENE® 6 Slides 48 Patterns Mini Projector Torch Toy Slide Flashlight Projector Torch for Kids Projection Light Toy Slide Flashlight Lamp Education Learning Night Light (Random Slides)");
        toy3.setPrice(189L);
        toy3.setBrand("GRAPHENE");
        toy3.setCategory("toy");
        toy3.setImg("https://m.media-amazon.com/images/I/61fu2vtWH4L._SL1500_.jpg");
        Product toy4 = new Product();
        toy4.setDocument_id(UUID.randomUUID().toString());
        toy4.setName("Brand Conquer Plastic Construction Realistic Engineer Vehicle Pushdozer Excavator Bulldozer Construction Toys Truck Machine for Kids Yellow");
        toy4.setPrice(299L);
        toy4.setBrand("Conquer");
        toy4.setCategory("toy");
        toy4.setImg("https://m.media-amazon.com/images/I/71jxRbW7jDL._SL1500_.jpg");
        Product toy5 = new Product();
        toy5.setDocument_id(UUID.randomUUID().toString());
        toy5.setName("TOYZONE Friction Powered Mini Truck Series | Made in India | Friction Powered Toy | Unbreakable City Service Truck | Pull Back | Push & Go Crawling Toys (City Service Truck Dumper)");
        toy5.setPrice(149L);
        toy5.setBrand("TOY ZONE");
        toy5.setCategory("toy");
        toy5.setImg("https://m.media-amazon.com/images/I/71fxesH-fAL._SL1500_.jpg");
        Product toy6 = new Product();
        toy6.setDocument_id(UUID.randomUUID().toString());
        toy6.setName("Webby Plush Adorable Standing Giraffe Soft Toy for Kids and Adult, 40 CM (Green)");
        toy6.setPrice(459L);
        toy6.setBrand("Webby");
        toy6.setCategory("toy");
        toy6.setImg("https://m.media-amazon.com/images/I/61Kj1RvR-mL._SL1500_.jpg");
        Product toy7 = new Product();
        toy7.setDocument_id(UUID.randomUUID().toString());
        toy7.setName("Toy Imagine™ Lattoo Spinning Launcher Gyro Top with Flashing Led Light Beyblade (Color May Vary)");
        toy7.setPrice(154L);
        toy7.setBrand("Toy Imagine");
        toy7.setCategory("toy");
        toy7.setImg("https://m.media-amazon.com/images/I/61D7d5DjSoL._SL1500_.jpg");
        Product toy8 = new Product();
        toy8.setDocument_id(UUID.randomUUID().toString());
        toy8.setName("Jack Royal Storm Hot Fire Soft Bullet Gun Toy with 10 Safe Soft Foam Bullets, Fun Target Shooting Battle Fight Game for Kids Boys (Storm- Hot Fire)");
        toy8.setPrice(224L);
        toy8.setBrand("Jack Royal");
        toy8.setCategory("toy");
        toy8.setImg("https://m.media-amazon.com/images/I/61Hj3s9tHtL._SL1500_.jpg");
        Product toy9 = new Product();
        toy9.setDocument_id(UUID.randomUUID().toString());
        toy9.setName("Storio Toy Octopus Plushie Reversible Soft Toys for Kids | Plush Soft Toys for Baby Boys and Girls | Octopus Soft Toy for Kids -18cm");
        toy9.setPrice(149L);
        toy9.setBrand("Storio");
        toy9.setCategory("toy");
        toy9.setImg("https://m.media-amazon.com/images/I/517tM2o269L._SL1038_.jpg");
        Product toy10 = new Product();
        toy10.setDocument_id(UUID.randomUUID().toString());
        toy10.setName("VGRASSP Handheld Video Game Console, Retro Mini Game with 400 Classic Sup Game TV Compatible for Kids, Rechargeable 8 Bit Classic");
        toy10.setPrice(649L);
        toy10.setBrand("VGRASSP");
        toy10.setCategory("toy");
        toy10.setImg("https://m.media-amazon.com/images/I/51qC3djhLQL.jpg");

        products.add(toy1);
        products.add(toy2);
        products.add(toy3);
        products.add(toy4);
        products.add(toy5);
        products.add(toy6);
        products.add(toy7);
        products.add(toy8);
        products.add(toy9);
        products.add(toy10);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        for (Product p : products) {
            HttpEntity entity = new HttpEntity(p, headers);
            ResponseEntity<String> response = restTemplate.exchange("https://angular-demo-prj-default-rtdb.firebaseio.com/products.json", HttpMethod.POST, entity, String.class);

        }
    }*/
/*
    for firebase db
    public List<Product> getProducts(String authToken) throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange("https://angular-demo-prj-default-rtdb.firebaseio.com/products.json?auth=" + authToken, HttpMethod.GET, null, String.class);

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Product> productMap = new HashMap<>();
        productMap = mapper.readValue(response.getBody(), HashMap.class);

        List<Product> products = new ArrayList<>();

        for (Map.Entry<String, Product> entry : productMap.entrySet()) {

            Map<String, Object> productData = (Map<String, Object>) entry.getValue();

            Product product = new Product();
            product.setBrand((String) productData.get("brand"));
            product.setCategory((String) productData.get("category"));
            product.setDocument_id((String) productData.get("document_id"));
            product.setImg((String) productData.get("img"));
            product.setName((String) productData.get("name"));
            product.setPrice(Long.valueOf((Integer) productData.get("price")));
            products.add(product);
        }
        return products;
    }

    public List<Product> getProductsForCategory(String category, String authToken) throws ExecutionException, InterruptedException, JsonProcessingException {

        List<Product> productList = getProducts(authToken);
        List<Product> productsForCategory = new ArrayList<>();
        for (Product p : productList) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                productsForCategory.add(p);
            }
        }

        return productsForCategory;
    }

    public List<Product> getProductsForSearchKey(String searchKey, String authToken) throws ExecutionException, InterruptedException, JsonProcessingException {

        List<Product> productList = getProducts(authToken);
        List<Product> productsForSearchKey = new ArrayList<>();
        for (Product p : productList) {
            if (p.getCategory().toLowerCase().contains(searchKey.toLowerCase())
                    || p.getBrand().toLowerCase().contains(searchKey.toLowerCase())
                    || p.getName().toLowerCase().contains(searchKey.toLowerCase())) {
                productsForSearchKey.add(p);
            }
        }
        return productsForSearchKey;
    }
*/

    //for mongo db
    public void storeProducts1_mongo() {
        List<com.example.ecommerce.entity.Product> products = new ArrayList<>();



        com.example.ecommerce.entity.Product googlePixel8 = new com.example.ecommerce.entity.Product();
        googlePixel8.setDocument_id(UUID.randomUUID().toString());
        googlePixel8.setName("Pixel 8 5G, 8GB RAM, 128GB Storage (Rose)");
        googlePixel8.setPrice(70000L);
        googlePixel8.setBrand("Google");
        googlePixel8.setCategory("mobile");
        googlePixel8.setRating(3.0);
        googlePixel8.setImg("https://m.media-amazon.com/images/I/41LRhbf44GL.jpg");
        ProductDetail googlePixel8details1 = new ProductDetail();
        ProductDetail googlePixel8details2 = new ProductDetail();
        ProductDetail googlePixel8details3 = new ProductDetail();
        googlePixel8details1.setKeyText("The fully upgraded Pixel 8 camera uses Google AI to help you create memorable photos and videos, day or night.");
        googlePixel8details1.setImgPath("https://lh3.googleusercontent.com/bYqrYe2Xyld9Owia72FvCZjjJVZKUSCLcAQVPF4I51zmozzBPq89Ag-l63USd3tOS4dsevSuGn8Pnu6lT9lRqKiOECqL0Hcx7TA=s0");
        googlePixel8details2.setKeyText("Built with Google AI, Pixel 8 makes it even easier to search, screen calls, connect in new languages, and more.");
        googlePixel8details2.setImgPath("https://lh3.googleusercontent.com/5fqWdQDgmLtuYqjtBnjcITPTuM-RXxjWVEzWhKB7PltMRJ0WMTrfepr-gQdTww8KFy6fXA90-Mxwc2Z4WDA8cDgshS1WxcmRhko=rw-e365-nu-w1512");
        googlePixel8details3.setKeyText("Pixel helps to keep you and your info safe.");
        googlePixel8details3.setImgPath("https://lh3.googleusercontent.com/cTq7ggkf9gx590YJIFK3yvyZVWRRjru9DRhyPRPFecGlj1lGlEY3NEz37DN92z16oMbO-byOatwwPOZSIN1s6SL-B7qyi7jutw=rw-e365-nu-w1764");
        List<ProductDetail> detailsList1 = new ArrayList<>();
        detailsList1.add(googlePixel8details1);detailsList1.add(googlePixel8details2);detailsList1.add(googlePixel8details3);
        googlePixel8.setDetails(detailsList1);
        products.add(googlePixel8);

        com.example.ecommerce.entity.Product googlePixel8Pro = new com.example.ecommerce.entity.Product();
        googlePixel8Pro.setDocument_id(UUID.randomUUID().toString());
        googlePixel8Pro.setName("Pixel 8 Pro 5G (12GB RAM+ 128GB Storage) (Obsidian Black)");
        googlePixel8Pro.setPrice(90000L);
        googlePixel8Pro.setRating(4.0);
        googlePixel8Pro.setBrand("Google");
        googlePixel8Pro.setCategory("mobile");
        googlePixel8Pro.setImg("https://m.media-amazon.com/images/I/61X4kxP-OnL._SL1500_.jpg");
        ProductDetail googlePixel8Prodetails1 = new ProductDetail();
        ProductDetail googlePixel8Prodetails2 = new ProductDetail();
        ProductDetail googlePixel8Prodetails3 = new ProductDetail();
        googlePixel8Prodetails1.setKeyText("Pixel helps to keep you and your info safe.");
        googlePixel8Prodetails1.setImgPath("https://lh3.googleusercontent.com/5SuvvxhwMUrCDQ8ULEmuCNexoJoryvVpmnrUbN-_dJM0anzf0gKa2eCn7BeUE357CpANbBcaX-ggHuTHo8topBNuxS6jIDTJyJw=rw-e365-nu-w1512");
        googlePixel8Prodetails2.setKeyText("Better low-light photos. It's like night and day.");
        googlePixel8Prodetails2.setImgPath("https://lh3.googleusercontent.com/d6VLLZ4ueY9TGWR1F-o9J24Wt3WOQkGnMvoNf0nFq64szvCseEvzGleVPoiAIonJEhxCW3DJ8TlghYHc2t88YZ25CLyOcz9IRToZ=rw-e365-nu-w756");
        googlePixel8Prodetails3.setKeyText("Four exceptional cameras.\nCompletely upgraded.");
        googlePixel8Prodetails3.setImgPath("https://lh3.googleusercontent.com/5SfKY3I-7YQLl00zImCCFNcCYMyvzByxI5rynBfKk5yqgo6oIAadL_uoZsZ91GCTAKGd3IHiNYut2Q18PmygwlDy4U1410bcVeE=rw-e365-nu-w1512");
        List<ProductDetail> detailsList2 = new ArrayList<>();
        detailsList2.add(googlePixel8Prodetails1);detailsList2.add(googlePixel8Prodetails2);detailsList2.add(googlePixel8Prodetails3);
        googlePixel8Pro.setDetails(detailsList2);

        products.add(googlePixel8Pro);

        com.example.ecommerce.entity.Product samsungS22 = new com.example.ecommerce.entity.Product();
        samsungS22.setDocument_id(UUID.randomUUID().toString());
        samsungS22.setName("Samsung Galaxy S22 5G (Green, 8GB, 128GB Storage)");
        samsungS22.setPrice(50000L);
        samsungS22.setRating(4.0);
        samsungS22.setBrand("Samsung");
        samsungS22.setCategory("mobile");
        samsungS22.setImg("https://m.media-amazon.com/images/I/71qZERyxy6L._SL1500_.jpg");
        ProductDetail samsungS22details1 = new ProductDetail();
        ProductDetail samsungS22details2 = new ProductDetail();
        ProductDetail samsungS22details3 = new ProductDetail();
        samsungS22details1.setKeyText("Go #Galaxy.");
        samsungS22details1.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_BoraPurple_Carousel_ProductKV_PC.jpg?imbypass=true");
        samsungS22details2.setKeyText("Bright sunlight, meet our brightest display.");
        samsungS22details2.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_7_PC.jpg?imbypass=true");
        samsungS22details3.setKeyText("Nightography with #Galaxy");
        samsungS22details3.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_6_PC.jpg?imbypass=true");
        List<ProductDetail> detailsList3 = new ArrayList<>();
        detailsList3.add(samsungS22details1);detailsList3.add(samsungS22details2);detailsList3.add(samsungS22details3);
        samsungS22.setDetails(detailsList3);

        products.add(samsungS22);

        com.example.ecommerce.entity.Product samsungS22Plus = new com.example.ecommerce.entity.Product();
        samsungS22Plus.setDocument_id(UUID.randomUUID().toString());
        samsungS22Plus.setName("Samsung Galaxy S22 Plus 5G (Phantom Black, 8GB, 128GB Storage)");
        samsungS22Plus.setPrice(60000L);
        samsungS22Plus.setRating(4.0);
        samsungS22Plus.setBrand("Samsung");
        samsungS22Plus.setCategory("mobile");
        samsungS22Plus.setImg("https://m.media-amazon.com/images/I/71WdFQHjDwL._SL1500_.jpg");
        ProductDetail samsungS22Plusdetails1 = new ProductDetail();
        ProductDetail samsungS22Plusdetails2 = new ProductDetail();
        ProductDetail samsungS22Plusdetails3 = new ProductDetail();
        samsungS22Plusdetails1.setKeyText("Go #Galaxy.");
        samsungS22Plusdetails1.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_BoraPurple_Carousel_ProductKV_PC.jpg?imbypass=true");
        samsungS22Plusdetails2.setKeyText("Bright sunlight, meet our brightest display.");
        samsungS22Plusdetails2.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_7_PC.jpg?imbypass=true");
        samsungS22Plusdetails3.setKeyText("Nightography with #Galaxy");
        samsungS22Plusdetails3.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_6_PC.jpg?imbypass=true");
        List<ProductDetail> detailsList4 = new ArrayList<>();
        detailsList4.add(samsungS22Plusdetails1);detailsList4.add(samsungS22Plusdetails2);detailsList4.add(samsungS22Plusdetails3);
        samsungS22Plus.setDetails(detailsList4);

        products.add(samsungS22Plus);

        com.example.ecommerce.entity.Product samsungS22Ultra = new com.example.ecommerce.entity.Product();
        samsungS22Ultra.setDocument_id(UUID.randomUUID().toString());
        samsungS22Ultra.setName("Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 512GB Storage)");
        samsungS22Ultra.setPrice(80000L);
        samsungS22Ultra.setRating(4.0);
        samsungS22Ultra.setBrand("Samsung");
        samsungS22Ultra.setCategory("mobile");
        samsungS22Ultra.setImg("https://m.media-amazon.com/images/I/71J8tz0UeJL._SL1500_.jpg");
        ProductDetail samsungS22Ultradetails1 = new ProductDetail();
        ProductDetail samsungS22Ultradetails2 = new ProductDetail();
        ProductDetail samsungS22Ultradetails3 = new ProductDetail();
        samsungS22Ultradetails1.setKeyText("Go #Galaxy.");
        samsungS22Ultradetails1.setImgPath("https://images.samsung.com/is/image/samsung/assets/uk/smartphones/galaxy-s22-ultra/lifestyle-imagery/6_ultra_1440.jpg?imwidth=1366?imbypass=true");
        samsungS22Ultradetails2.setKeyText("One pen, unlimited ways to create.");
        samsungS22Ultradetails2.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_ULTRA_KV_8_PC.jpg?imbypass=true");
        samsungS22Ultradetails3.setKeyText("Super-fast charge that outlasts the day");
        samsungS22Ultradetails3.setImgPath("https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_ULTRA_KV_9_PC.jpg?imbypass=true");
        List<ProductDetail> detailsList5 = new ArrayList<>();
        detailsList5.add(samsungS22Ultradetails1);detailsList5.add(samsungS22Ultradetails2);detailsList5.add(samsungS22Ultradetails3);
        samsungS22Ultra.setDetails(detailsList5);

        products.add(samsungS22Ultra);

        com.example.ecommerce.entity.Product iphone13 = new com.example.ecommerce.entity.Product();
        iphone13.setDocument_id(UUID.randomUUID().toString());
        iphone13.setName("Apple iPhone 13 (128GB) - (Product) RED");
        iphone13.setPrice(50000L);
        iphone13.setRating(3.0);
        iphone13.setBrand("Apple");
        iphone13.setCategory("mobile");
        iphone13.setImg("https://m.media-amazon.com/images/I/71gm8v4uPBL._SL1500_.jpg");
        ProductDetail iphone13details1 = new ProductDetail();
        ProductDetail iphone13details2= new ProductDetail();
        iphone13details1.setKeyText("");
        iphone13details1.setImgPath("https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/iphone-13-finish-unselect-gallery-4-202207?wid=5120&hei=2880&fmt=webp&qlt=70&.v=WGQwVDZoTWdLODlMWERUbVY5M013dFgrSXpWVEhWaW9YTGlWRHFoSHU0L0h3NWdOb0R0dTdZRGI4MUY4Zlpiamd2S3NaRzcrU0dmYjNHTUFiMnlsWFRocXAvNjVVaCtjTTZGTUNzOU8wNkd5NkRVb1VyLzVzTm5uc09VSjV1ZE0=&traceId=1");
        iphone13details2.setKeyText("");
        iphone13details2.setImgPath("https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/iphone-13-finish-unselect-gallery-1-202207_GEO_EMEA?wid=5120&hei=2880&fmt=webp&qlt=70&.v=WGQwVDZoTWdLODlMWERUbVY5M013dFgrSXpWVEhWaW9YTGlWRHFoSHU0OTdiNW5KU1VHNUdNN1hwR2ZLWkZrV3NCckZqMTMrS3dIUWFPL2dFWXJDTmhNQnJMcnc4RkxJd3ZMc3hKZVVFWHZ2UXcrMDFsU2Ixb1NRMEpLZFhXYnlKM3ZXd25kQVFkTmhRSjhQenRTazlBPT0=&traceId=1");
        List<ProductDetail> detailsList6 = new ArrayList<>();
        detailsList6.add(iphone13details1);detailsList6.add(iphone13details2);
        iphone13.setDetails(detailsList6);

        products.add(iphone13);

        com.example.ecommerce.entity.Product iphone13Pro = new com.example.ecommerce.entity.Product();
        iphone13Pro.setDocument_id(UUID.randomUUID().toString());
        iphone13Pro.setName("Apple iPhone 15 Pro (256 GB) - Natural Titanium");
        iphone13Pro.setPrice(70000L);
        iphone13Pro.setRating(4.0);
        iphone13Pro.setBrand("Apple");
        iphone13Pro.setCategory("mobile");
        iphone13Pro.setImg("https://m.media-amazon.com/images/I/81CgtwSII3L._SL1500_.jpg");
        ProductDetail iphone13Prodetails1 = new ProductDetail();
        ProductDetail iphone13Prodetails2 = new ProductDetail();
        ProductDetail iphone13Prodetails3 = new ProductDetail();
        iphone13Prodetails1.setKeyText("Titanium frame.");
        iphone13Prodetails1.setImgPath("https://www.apple.com/in/iphone-15-pro/images/overview/welcome/hero_endframe__ov6ewwmbhiqq_large.jpg");
        iphone13Prodetails2.setKeyText("A camera that captures your wildest imagination.");
        iphone13Prodetails2.setImgPath("https://www.apple.com/v/iphone-15-pro/c/images/overview/camera/camera__bo5k5tfk6cmu_large.jpg");
        iphone13Prodetails3.setKeyText("120 mm of\npure Pro zoom.");
        iphone13Prodetails3.setImgPath("https://www.apple.com/v/iphone-15-pro/c/images/overview/5x-zoom/pro-zoom_endframe__bpmc72f8qwgi_large.jpg");
        List<ProductDetail> detailsList7 = new ArrayList<>();
        detailsList7.add(iphone13Prodetails1);detailsList7.add(iphone13Prodetails2);detailsList7.add(iphone13Prodetails3);
        iphone13Pro.setDetails(detailsList7);

        products.add(iphone13Pro);

        com.example.ecommerce.entity.Product peterEnglandShirt = new com.example.ecommerce.entity.Product();
        peterEnglandShirt.setDocument_id(UUID.randomUUID().toString());
        peterEnglandShirt.setName("Peter England Men's Shirt (White)");
        peterEnglandShirt.setPrice(1000L);
        peterEnglandShirt.setRating(4.0);
        peterEnglandShirt.setBrand("Peter England");
        peterEnglandShirt.setCategory("clothing");
        peterEnglandShirt.setImg("https://m.media-amazon.com/images/I/61ZdMVCSnhL._SY741_.jpg");

        com.example.ecommerce.entity.Product peterEnglandShirt2 = new com.example.ecommerce.entity.Product();
        peterEnglandShirt2.setDocument_id(UUID.randomUUID().toString());
        peterEnglandShirt2.setName("Peter England Men's Slim Fit Shirt");
        peterEnglandShirt2.setPrice(1000L);
        peterEnglandShirt2.setRating(4.0);
        peterEnglandShirt2.setBrand("Peter England");
        peterEnglandShirt2.setCategory("clothing");
        peterEnglandShirt2.setImg("https://m.media-amazon.com/images/I/51ystSbVCQL._SY741_.jpg");

        com.example.ecommerce.entity.Product theSouledStore = new com.example.ecommerce.entity.Product();
        theSouledStore.setDocument_id(UUID.randomUUID().toString());
        theSouledStore.setName("The Souled Store Captain America: The Super Soldier Oversized Full Sleeve T-Shirts");
        theSouledStore.setPrice(800L);
        theSouledStore.setRating(3.0);
        theSouledStore.setBrand("The Souled Store");
        theSouledStore.setCategory("clothing");
        theSouledStore.setImg("https://m.media-amazon.com/images/I/61bPqVAuGOL._SY741_.jpg");

        com.example.ecommerce.entity.Product theSouledStore2 = new com.example.ecommerce.entity.Product();
        theSouledStore2.setDocument_id(UUID.randomUUID().toString());
        theSouledStore2.setName("The Souled Store Men Official Garfield: Made to Lounger White Printed Summer Shirts Shirt for Men Casual Half Sleeves Regular Fit Printed Stylish Latest Cotton Summer Branded Wrinkle Free");
        theSouledStore2.setPrice(800L);
        theSouledStore2.setRating(4.0);
        theSouledStore2.setBrand("The Souled Store");
        theSouledStore2.setCategory("clothing");
        theSouledStore2.setImg("https://m.media-amazon.com/images/I/71ck2zlPMLL._SY879_.jpg");

        com.example.ecommerce.entity.Product leeCooper = new com.example.ecommerce.entity.Product();
        leeCooper.setDocument_id(UUID.randomUUID().toString());
        leeCooper.setName("Van Heusen Men's Shirt");
        leeCooper.setPrice(800L);
        leeCooper.setRating(4.0);
        leeCooper.setBrand("Lee Cooper");
        leeCooper.setCategory("clothing");
        leeCooper.setImg("https://m.media-amazon.com/images/I/91t89qKUjuL._SY879_.jpg");


        products.add(peterEnglandShirt);
        products.add(peterEnglandShirt2);
        products.add(theSouledStore);
        products.add(theSouledStore2);
        products.add(leeCooper);

        for (com.example.ecommerce.entity.Product p : products) {
            productRepo.save(p);
        }

    }

    public void storeProducts2_mongo() {
        List<com.example.ecommerce.entity.Product> products = new ArrayList<>();

        com.example.ecommerce.entity.Product toy1 = new com.example.ecommerce.entity.Product();
        toy1.setDocument_id(UUID.randomUUID().toString());
        toy1.setName("Storio Toys Dancing Cactus Talking Toy, Cactus Plush Toy, Wriggle & Singing Recording Repeat What You Say Funny Education Toys for Babies Children Playing, Home Decorate");
        toy1.setPrice(318L);
        toy1.setRating(4.0);
        toy1.setBrand("Storio");
        toy1.setCategory("toy");
        toy1.setImg("https://m.media-amazon.com/images/I/51kFlytvjAL._SL1481_.jpg");
        com.example.ecommerce.entity.Product toy2 = new com.example.ecommerce.entity.Product();
        toy2.setDocument_id(UUID.randomUUID().toString());
        toy2.setName("Wembley Dancing Monkey Musical Toy for Kids Baby Spinning Rolling Doll Tumble Toy with Voice Control Musical Light and Sound Effects with Sensor - ISI Mark - Multicolor");
        toy2.setPrice(299L);
        toy2.setRating(4.0);
        toy2.setBrand("Wembley");
        toy2.setCategory("toy");
        toy2.setImg("https://m.media-amazon.com/images/I/61g9sptTYQL._SL1100_.jpg");
        com.example.ecommerce.entity.Product toy3 = new com.example.ecommerce.entity.Product();
        toy3.setDocument_id(UUID.randomUUID().toString());
        toy3.setName("GRAPHENE® 6 Slides 48 Patterns Mini Projector Torch Toy Slide Flashlight Projector Torch for Kids Projection Light Toy Slide Flashlight Lamp Education Learning Night Light (Random Slides)");
        toy3.setPrice(189L);
        toy3.setRating(3.0);
        toy3.setBrand("GRAPHENE");
        toy3.setCategory("toy");
        toy3.setImg("https://m.media-amazon.com/images/I/61fu2vtWH4L._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy4 = new com.example.ecommerce.entity.Product();
        toy4.setDocument_id(UUID.randomUUID().toString());
        toy4.setName("Brand Conquer Plastic Construction Realistic Engineer Vehicle Pushdozer Excavator Bulldozer Construction Toys Truck Machine for Kids Yellow");
        toy4.setPrice(299L);
        toy4.setRating(3.0);
        toy4.setBrand("Conquer");
        toy4.setCategory("toy");
        toy4.setImg("https://m.media-amazon.com/images/I/71jxRbW7jDL._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy5 = new com.example.ecommerce.entity.Product();
        toy5.setDocument_id(UUID.randomUUID().toString());
        toy5.setName("TOYZONE Friction Powered Mini Truck Series | Made in India | Friction Powered Toy | Unbreakable City Service Truck | Pull Back | Push & Go Crawling Toys (City Service Truck Dumper)");
        toy5.setPrice(149L);
        toy5.setRating(4.0);
        toy5.setBrand("TOY ZONE");
        toy5.setCategory("toy");
        toy5.setImg("https://m.media-amazon.com/images/I/71fxesH-fAL._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy6 = new com.example.ecommerce.entity.Product();
        toy6.setDocument_id(UUID.randomUUID().toString());
        toy6.setName("Webby Plush Adorable Standing Giraffe Soft Toy for Kids and Adult, 40 CM (Green)");
        toy6.setPrice(459L);
        toy6.setRating(4.0);
        toy6.setBrand("Webby");
        toy6.setCategory("toy");
        toy6.setImg("https://m.media-amazon.com/images/I/61Kj1RvR-mL._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy7 = new com.example.ecommerce.entity.Product();
        toy7.setDocument_id(UUID.randomUUID().toString());
        toy7.setName("Toy Imagine™ Lattoo Spinning Launcher Gyro Top with Flashing Led Light Beyblade (Color May Vary)");
        toy7.setPrice(154L);
        toy7.setRating(2.0);
        toy7.setBrand("Toy Imagine");
        toy7.setCategory("toy");
        toy7.setImg("https://m.media-amazon.com/images/I/61D7d5DjSoL._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy8 = new com.example.ecommerce.entity.Product();
        toy8.setDocument_id(UUID.randomUUID().toString());
        toy8.setName("Jack Royal Storm Hot Fire Soft Bullet Gun Toy with 10 Safe Soft Foam Bullets, Fun Target Shooting Battle Fight Game for Kids Boys (Storm- Hot Fire)");
        toy8.setPrice(224L);
        toy8.setRating(4.0);
        toy8.setBrand("Jack Royal");
        toy8.setCategory("toy");
        toy8.setImg("https://m.media-amazon.com/images/I/61Hj3s9tHtL._SL1500_.jpg");
        com.example.ecommerce.entity.Product toy9 = new com.example.ecommerce.entity.Product();
        toy9.setDocument_id(UUID.randomUUID().toString());
        toy9.setName("Storio Toy Octopus Plushie Reversible Soft Toys for Kids | Plush Soft Toys for Baby Boys and Girls | Octopus Soft Toy for Kids -18cm");
        toy9.setPrice(149L);
        toy9.setRating(4.0);
        toy9.setBrand("Storio");
        toy9.setCategory("toy");
        toy9.setImg("https://m.media-amazon.com/images/I/517tM2o269L._SL1038_.jpg");
        com.example.ecommerce.entity.Product toy10 = new com.example.ecommerce.entity.Product();
        toy10.setDocument_id(UUID.randomUUID().toString());
        toy10.setName("VGRASSP Handheld Video Game Console, Retro Mini Game with 400 Classic Sup Game TV Compatible for Kids, Rechargeable 8 Bit Classic");
        toy10.setPrice(649L);
        toy10.setRating(4.0);
        toy10.setBrand("VGRASSP");
        toy10.setCategory("toy");
        toy10.setImg("https://m.media-amazon.com/images/I/51qC3djhLQL.jpg");

        products.add(toy1);
        products.add(toy2);
        products.add(toy3);
        products.add(toy4);
        products.add(toy5);
        products.add(toy6);
        products.add(toy7);
        products.add(toy8);
        products.add(toy9);
        products.add(toy10);

        for (com.example.ecommerce.entity.Product p : products) {
            productRepo.save(p);
        }
    }

    public List<com.example.ecommerce.entity.Product> getProducts() {
        return productRepo.findAll();
    }


    public List<com.example.ecommerce.entity.Product> getProductsForCategory(String category) {
        return productRepo.findAllByCategory(category);

    }

    public List<com.example.ecommerce.entity.Product> getProductsForSearchKey(String searchKey) {
        return productRepo.findAllByCategoryContainingOrNameContainingOrBrandContaining(searchKey, searchKey, searchKey);
    }


}
