package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.concurrent.ExecutionException;

@Service
@Slf4j
public class ProductService {

    public void storeProducts1() {
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
    }

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


}
