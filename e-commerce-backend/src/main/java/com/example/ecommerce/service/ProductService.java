package com.example.ecommerce.service;

import com.example.ecommerce.model.Product;
import com.example.ecommerce.model.ProductDetail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Slf4j
public class ProductService {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    public ProductService(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public List<Product> getProducts() {
        List<Product> products = jdbcTemplate.query("SELECT * FROM Product", new BeanPropertyRowMapper<>(Product.class));
        for (Product product : products) {
            List<ProductDetail> details = jdbcTemplate.query("SELECT * FROM ProductDetail WHERE product_document_id = :product_document_id",
                    new MapSqlParameterSource("product_document_id", product.getDocument_id()),
                    new BeanPropertyRowMapper<>(ProductDetail.class));
            product.setDetails(details);
        }
        return products;
    }

    public void initializeProducts() {
        List<ProductDetail> googlePixel8details = new ArrayList<>();
        ProductDetail googlePixel8details1 = new ProductDetail();
        ProductDetail googlePixel8details2 = new ProductDetail();
        ProductDetail googlePixel8details3 = new ProductDetail();
        googlePixel8details1.setKeyText("The fully upgraded Pixel 8 camera uses Google AI to help you create memorable photos and videos, day or night.");
        googlePixel8details1.setImgPath("https://lh3.googleusercontent.com/bYqrYe2Xyld9Owia72FvCZjjJVZKUSCLcAQVPF4I51zmozzBPq89Ag-l63USd3tOS4dsevSuGn8Pnu6lT9lRqKiOECqL0Hcx7TA=s0");
        googlePixel8details2.setKeyText("Built with Google AI, Pixel 8 makes it even easier to search, screen calls, connect in new languages, and more.");
        googlePixel8details2.setImgPath("https://lh3.googleusercontent.com/5fqWdQDgmLtuYqjtBnjcITPTuM-RXxjWVEzWhKB7PltMRJ0WMTrfepr-gQdTww8KFy6fXA90-Mxwc2Z4WDA8cDgshS1WxcmRhko=rw-e365-nu-w1512");
        googlePixel8details3.setKeyText("Pixel helps to keep you and your info safe.");
        googlePixel8details3.setImgPath("https://lh3.googleusercontent.com/cTq7ggkf9gx590YJIFK3yvyZVWRRjru9DRhyPRPFecGlj1lGlEY3NEz37DN92z16oMbO-byOatwwPOZSIN1s6SL-B7qyi7jutw=rw-e365-nu-w1764");
        googlePixel8details.add(googlePixel8details1);
        googlePixel8details.add(googlePixel8details2);
        googlePixel8details.add(googlePixel8details3);

        insertData("Pixel 8 5G, 8GB RAM, 128GB Storage (Rose)", "Google", "mobile", 70000L, "https://m.media-amazon.com/images/I/41LRhbf44GL.jpg", 3.0, googlePixel8details);

        List<ProductDetail> googlePixel8Prodetails = new ArrayList<>();
        googlePixel8Prodetails.add(new ProductDetail(null, "Pixel helps to keep you and your info safe.", "https://lh3.googleusercontent.com/5SuvvxhwMUrCDQ8ULEmuCNexoJoryvVpmnrUbN-_dJM0anzf0gKa2eCn7BeUE357CpANbBcaX-ggHuTHo8topBNuxS6jIDTJyJw=rw-e365-nu-w1512"));
        googlePixel8Prodetails.add(new ProductDetail(null, "Better low-light photos. It's like night and day.", "https://lh3.googleusercontent.com/d6VLLZ4ueY9TGWR1F-o9J24Wt3WOQkGnMvoNf0nFq64szvCseEvzGleVPoiAIonJEhxCW3DJ8TlghYHc2t88YZ25CLyOcz9IRToZ=rw-e365-nu-w756"));
        googlePixel8Prodetails.add(new ProductDetail(null, "Four exceptional cameras.\nCompletely upgraded.", "https://lh3.googleusercontent.com/5SfKY3I-7YQLl00zImCCFNcCYMyvzByxI5rynBfKk5yqgo6oIAadL_uoZsZ91GCTAKGd3IHiNYut2Q18PmygwlDy4U1410bcVeE=rw-e365-nu-w1512"));
        insertData("Pixel 8 Pro 5G (12GB RAM+ 128GB Storage) (Obsidian Black)", "Google", "mobile", 90000L, "https://m.media-amazon.com/images/I/61X4kxP-OnL._SL1500_.jpg", 4.0, googlePixel8Prodetails);

        List<ProductDetail> samsungS22details = new ArrayList<>();
        samsungS22details.add(new ProductDetail(null, "Go #Galaxy.", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_BoraPurple_Carousel_ProductKV_PC.jpg?imbypass=true"));
        samsungS22details.add(new ProductDetail(null, "Bright sunlight, meet our brightest display.", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_7_PC.jpg?imbypass=true"));
        samsungS22details.add(new ProductDetail(null, "Nightography with #Galaxy", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_6_PC.jpg?imbypass=true"));
        insertData("Samsung Galaxy S22 5G (Green, 8GB, 128GB Storage)", "Samsung", "mobile", 50000L, "https://m.media-amazon.com/images/I/71qZERyxy6L._SL1500_.jpg", 4.0, samsungS22details);

        List<ProductDetail> samsungS22Plusdetails = new ArrayList<>();
        samsungS22Plusdetails.add(new ProductDetail(null, "Go #Galaxy.", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_BoraPurple_Carousel_ProductKV_PC.jpg?imbypass=true"));
        samsungS22Plusdetails.add(new ProductDetail(null, "Bright sunlight, meet our brightest display.", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_7_PC.jpg?imbypass=true"));
        samsungS22Plusdetails.add(new ProductDetail(null, "Nightography with #Galaxy", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_KV_6_PC.jpg?imbypass=true"));
        insertData("Samsung Galaxy S22 Plus 5G (Phantom Black, 8GB, 128GB Storage)", "Samsung", "mobile", 60000L, "https://m.media-amazon.com/images/I/71WdFQHjDwL._SL1500_.jpg", 4.0, samsungS22Plusdetails);

        List<ProductDetail> samsungS22Ultradetails = new ArrayList<>();
        samsungS22Ultradetails.add(new ProductDetail(null, "Go #Galaxy.", "https://images.samsung.com/is/image/samsung/assets/uk/smartphones/galaxy-s22-ultra/lifestyle-imagery/6_ultra_1440.jpg?imwidth=1366?imbypass=true"));
        samsungS22Ultradetails.add(new ProductDetail(null, "One pen, unlimited ways to create.", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_ULTRA_KV_8_PC.jpg?imbypass=true"));
        samsungS22Ultradetails.add(new ProductDetail(null, "Super-fast charge that outlasts the day", "https://images.samsung.com/is/image/samsung/assets/in/smartphones/galaxy-s22/buy/S22_ULTRA_KV_9_PC.jpg?imbypass=true"));
        insertData("Samsung Galaxy S22 Ultra 5G (Burgundy, 12GB, 512GB Storage)", "Samsung", "mobile", 80000L, "https://m.media-amazon.com/images/I/71J8tz0UeJL._SL1500_.jpg", 4.0, samsungS22Ultradetails);

        List<ProductDetail> iphone13details = new ArrayList<>();
        iphone13details.add(new ProductDetail(null, "", "https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/iphone-13-finish-unselect-gallery-4-202207?wid=5120&hei=2880&fmt=webp&qlt=70&.v=WGQwVDZoTWdLODlMWERUbVY5M013dFgrSXpWVEhWaW9YTGlWRHFoSHU0L0h3NWdOb0R0dTdZRGI4MUY4Zlpiamd2S3NaRzcrU0dmYjNHTUFiMnlsWFRocXAvNjVVaCtjTTZGTUNzOU8wNkd5NkRVb1VyLzVzTm5uc09VSjV1ZE0=&traceId=1"));
        iphone13details.add(new ProductDetail(null, "", "https://store.storeimages.cdn-apple.com/1/as-images.apple.com/is/iphone-13-finish-unselect-gallery-1-202207_GEO_EMEA?wid=5120&hei=2880&fmt=webp&qlt=70&.v=WGQwVDZoTWdLODlMWERUbVY5M013dFgrSXpWVEhWaW9YTGlWRHFoSHU0OTdiNW5KU1VHNUdNN1hwR2ZLWkZrV3NCckZqMTMrS3dIUWFPL2dFWXJDTmhNQnJMcnc4RkxJd3ZMc3hKZVVFWHZ2UXcrMDFsU2Ixb1NRMEpLZFhXYnlKM3ZXd25kQVFkTmhRSjhQenRTazlBPT0=&traceId=1"));
        insertData("Apple iPhone 13 (128GB) - (Product) RED", "Apple", "mobile", 50000L, "https://m.media-amazon.com/images/I/71gm8v4uPBL._SL1500_.jpg", 3.0, iphone13details);

        List<ProductDetail> iphone13Prodetails = new ArrayList<>();
        iphone13Prodetails.add(new ProductDetail(null, "Titanium frame.", "https://www.apple.com/in/iphone-15-pro/images/overview/welcome/hero_endframe__ov6ewwmbhiqq_large.jpg"));
        iphone13Prodetails.add(new ProductDetail(null, "A camera that captures your wildest imagination.", "https://www.apple.com/v/iphone-15-pro/c/images/overview/camera/camera__bo5k5tfk6cmu_large.jpg"));
        iphone13Prodetails.add(new ProductDetail(null, "120 mm of\npure Pro zoom.", "https://www.apple.com/v/iphone-15-pro/c/images/overview/5x-zoom/pro-zoom_endframe__bpmc72f8qwgi_large.jpg"));
        insertData("Apple iPhone 15 Pro (256 GB) - Natural Titanium", "Apple", "mobile", 70000L, "https://m.media-amazon.com/images/I/81CgtwSII3L._SL1500_.jpg", 4.0, iphone13Prodetails);

        List<ProductDetail> peterEnglandShirtdetails = new ArrayList<>();
        peterEnglandShirtdetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61abAM12J9L._SY741_.jpg"));
        peterEnglandShirtdetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61-JoJCyvML._SY741_.jpg"));
        insertData("Peter England Men's Shirt (White)", "Peter England", "clothing", 1000L, "https://m.media-amazon.com/images/I/61ZdMVCSnhL._SY741_.jpg", 4.0, peterEnglandShirtdetails);

        List<ProductDetail> peterEnglandShirt2details = new ArrayList<>();
        peterEnglandShirt2details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/518kaW9wg8L._SY741_.jpg"));
        peterEnglandShirt2details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/51pyOXghI3L._SY741_.jpg"));
        insertData("Peter England Men's Slim Fit Shirt", "Peter England", "clothing", 1000L, "https://m.media-amazon.com/images/I/51ystSbVCQL._SY741_.jpg", 4.0, peterEnglandShirt2details);

        List<ProductDetail> theSouledStoredetails = new ArrayList<>();
        theSouledStoredetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61oZzGGfuRL._SY741_.jpg"));
        theSouledStoredetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/610ImiG7AYL._SY741_.jpg"));
        insertData("The Souled Store Captain America: The Super Soldier Oversized Full Sleeve T-Shirts", "The Souled Store", "clothing", 800L, "https://m.media-amazon.com/images/I/61bPqVAuGOL._SY741_.jpg", 3.0, theSouledStoredetails);

        List<ProductDetail> theSouledStore2details = new ArrayList<>();
        theSouledStore2details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/712orXIYQEL._SY741_.jpg"));
        theSouledStore2details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/71DTiBQVkjL._SY741_.jpg"));
        insertData("The Souled Store Men Official Garfield: Made to Lounger White Printed Summer Shirts Shirt for Men Casual Half Sleeves Regular Fit Printed Stylish Latest Cotton Summer Branded Wrinkle Free", "The Souled Store", "clothing", 800L, "https://m.media-amazon.com/images/I/71ck2zlPMLL._SY879_.jpg", 4.0, theSouledStore2details);

        List<ProductDetail> leeCooperdetails = new ArrayList<>();
        leeCooperdetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/71HTar2n1pL._SY741_.jpg"));
        leeCooperdetails.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61XOPDhVxbL._SY741_.jpg"));
        insertData("Van Heusen Men's Shirt", "Lee Cooper", "clothing", 800L, "https://m.media-amazon.com/images/I/91t89qKUjuL._SY879_.jpg", 4.0, leeCooperdetails);

        List<ProductDetail> toy1Details = new ArrayList<>();
        toy1Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/51kFlytvjAL._SL1481_.jpg"));
        insertData("Storio Toys Dancing Cactus Talking Toy, Cactus Plush Toy, Wriggle & Singing Recording Repeat What You Say Funny Education Toys for Babies Children Playing, Home Decorate", "Storio", "toy", 318L, "https://m.media-amazon.com/images/I/51kFlytvjAL._SL1481_.jpg", 4.0, toy1Details);

        List<ProductDetail> toy2Details = new ArrayList<>();
        toy2Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61g9sptTYQL._SL1100_.jpg"));
        insertData("Wembley Dancing Monkey Musical Toy for Kids Baby Spinning Rolling Doll Tumble Toy with Voice Control Musical Light and Sound Effects with Sensor - ISI Mark - Multicolor", "Wembley", "toy", 299L, "https://m.media-amazon.com/images/I/61g9sptTYQL._SL1100_.jpg", 4.0, toy2Details);

        List<ProductDetail> toy3Details = new ArrayList<>();
        toy3Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61fu2vtWH4L._SL1500_.jpg"));
        insertData("GRAPHENE® 6 Slides 48 Patterns Mini Projector Torch Toy Slide Flashlight Projector Torch for Kids Projection Light Toy Slide Flashlight Lamp Education Learning Night Light (Random Slides)", "GRAPHENE", "toy", 189L, "https://m.media-amazon.com/images/I/61fu2vtWH4L._SL1500_.jpg", 3.0, toy3Details);

        List<ProductDetail> toy4Details = new ArrayList<>();
        toy4Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/71jxRbW7jDL._SL1500_.jpg"));
        insertData("Brand Conquer Plastic Construction Realistic Engineer Vehicle Pushdozer Excavator Bulldozer Construction Toys Truck Machine for Kids Yellow", "Conquer", "toy", 299L, "https://m.media-amazon.com/images/I/71jxRbW7jDL._SL1500_.jpg", 3.0, toy4Details);

        List<ProductDetail> toy5Details = new ArrayList<>();
        toy5Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/71fxesH-fAL._SL1500_.jpg"));
        insertData("TOYZONE Friction Powered Mini Truck Series | Made in India | Friction Powered Toy | Unbreakable City Service Truck | Pull Back | Push & Go Crawling Toys (City Service Truck Dumper)", "TOY ZONE", "toy", 149L, "https://m.media-amazon.com/images/I/71fxesH-fAL._SL1500_.jpg", 4.0, toy5Details);

        List<ProductDetail> toy6Details = new ArrayList<>();
        toy6Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61Kj1RvR-mL._SL1500_.jpg"));
        insertData("Webby Plush Adorable Standing Giraffe Soft Toy for Kids and Adult, 40 CM (Green)", "Webby", "toy", 459L, "https://m.media-amazon.com/images/I/61Kj1RvR-mL._SL1500_.jpg", 4.0, toy6Details);

        List<ProductDetail> toy7Details = new ArrayList<>();
        toy7Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61D7d5DjSoL._SL1500_.jpg"));
        insertData("Toy Imagine™ Lattoo Spinning Launcher Gyro Top with Flashing Led Light Beyblade (Color May Vary)", "Toy Imagine", "toy", 154L, "https://m.media-amazon.com/images/I/61D7d5DjSoL._SL1500_.jpg", 2.0, toy7Details);

        List<ProductDetail> toy8Details = new ArrayList<>();
        toy8Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/61Hj3s9tHtL._SL1500_.jpg"));
        insertData("Jack Royal Storm Hot Fire Soft Bullet Gun Toy with 10 Safe Soft Foam Bullets, Fun Target Shooting Battle Fight Game for Kids Boys (Storm- Hot Fire)", "Jack Royal", "toy", 224L, "https://m.media-amazon.com/images/I/61Hj3s9tHtL._SL1500_.jpg", 4.0, toy8Details);

        List<ProductDetail> toy9Details = new ArrayList<>();
        toy9Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/517tM2o269L._SL1038_.jpg"));
        insertData("Storio Toy Octopus Plushie Reversible Soft Toys for Kids | Plush Soft Toys for Baby Boys and Girls | Octopus Soft Toy for Kids -18cm", "Storio", "toy", 149L, "https://m.media-amazon.com/images/I/517tM2o269L._SL1038_.jpg", 4.0, toy9Details);

        List<ProductDetail> toy10Details = new ArrayList<>();
        toy10Details.add(new ProductDetail(null, "", "https://m.media-amazon.com/images/I/51qC3djhLQL.jpg"));
        insertData("VGRASSP Handheld Video Game Console, Retro Mini Game with 400 Classic Sup Game TV Compatible for Kids, Rechargeable 8 Bit Classic", "VGRASSP", "toy", 649L, "https://m.media-amazon.com/images/I/51qC3djhLQL.jpg", 4.0, toy10Details);
    }

    void insertData(String name, String brand, String category, Long price, String img, Double rating, List<ProductDetail> details) {
        String sql = "INSERT INTO Product (name, brand, category, price, img, rating) VALUES (:name, :brand, :category, :price, :img, :rating)";
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("brand", brand);
        params.put("category", category);
        params.put("price", price);
        params.put("img", img);
        params.put("rating", rating);

        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(sql, new MapSqlParameterSource(params), keyHolder, new String[]{"document_id"});
        Integer productId = keyHolder.getKey().intValue();

        // Insert into ProductDetail table
        String detailSql = "INSERT INTO ProductDetail (product_document_id, keyText, imgPath) VALUES (:product_document_id, :keyText, :imgPath)";
        for (ProductDetail detail : details) {
            Map<String, Object> productDetailParams = new HashMap<>();
            productDetailParams.put("product_document_id", productId);
            productDetailParams.put("keyText", detail.getKeyText());
            productDetailParams.put("imgPath", detail.getImgPath());
            jdbcTemplate.update(detailSql, productDetailParams);
        }
    }


    public List<com.example.ecommerce.model.Product> getProductsForCategory(String category) {
        String sql = "SELECT * FROM Product WHERE category = :category";
        Map<String, Object> params = new HashMap<>();
        params.put("category", category);
        List<Product> products = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Product.class));
        for (Product product : products) {
            List<ProductDetail> details = jdbcTemplate.query("SELECT * FROM ProductDetail WHERE product_document_id = :product_document_id",
                    new MapSqlParameterSource("product_document_id", product.getDocument_id()),
                    new BeanPropertyRowMapper<>(ProductDetail.class));
            product.setDetails(details);
        }
        return products;
    }

    public List<com.example.ecommerce.model.Product> getProductsForSearchKey(String searchKey) {
        String sql = "SELECT * FROM Product WHERE name LIKE :searchKey OR brand LIKE :searchKey OR category LIKE :searchKey";
        Map<String, Object> params = new HashMap<>();
        params.put("searchKey", "%" + searchKey + "%");
        List<Product> products = jdbcTemplate.query(sql, params, new BeanPropertyRowMapper<>(Product.class));
        for (Product product : products) {
            List<ProductDetail> details = jdbcTemplate.query("SELECT * FROM ProductDetail WHERE product_document_id = :product_document_id",
                    new MapSqlParameterSource("product_document_id", product.getDocument_id()),
                    new BeanPropertyRowMapper<>(ProductDetail.class));
            product.setDetails(details);
        }
        return products;
    }


}
