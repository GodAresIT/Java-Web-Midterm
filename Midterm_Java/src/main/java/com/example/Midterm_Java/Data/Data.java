package com.example.Midterm_Java.Data;

import com.example.Midterm_Java.Models.*;
import com.example.Midterm_Java.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Data {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductDetailsRepository productDetailsRepository;
    @Autowired
    BrandRepository brandRepository;
    @Autowired
    TypeRepository typeRepository;
    @Bean
    public CommandLineRunner insertData(){
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {
                // data Account
                accountRepository.save(new Account("admin", "123", "admin", "Admin 1"));
                accountRepository.save(new Account("user", "123", "user", "User 1"));

                //data Brand
                brandRepository.save(new Brand("Apple"));
                brandRepository.save(new Brand("Asus"));
                brandRepository.save(new Brand("Dell"));
                brandRepository.save(new Brand("Acer"));

                //data Type

                typeRepository.save(new Typeofbrand("Macbook Air",1));
                typeRepository.save(new Typeofbrand("Macbook Pro",1));
                typeRepository.save(new Typeofbrand("Vivo Book",2));
                typeRepository.save(new Typeofbrand("Gaming",2));
                typeRepository.save(new Typeofbrand("Vostro",3));
                typeRepository.save(new Typeofbrand("Inspiron",3));
                typeRepository.save(new Typeofbrand("Nitro",4));
                typeRepository.save(new Typeofbrand("Spin",4));
                typeRepository.save(new Typeofbrand("Predator",4));

                //data Product
                productRepository.save(new Product(12000000L,"Thinkpad","/images/p11.png","Asus Vivo Book"));
                productRepository.save(new Product(74990000L,"Macbook","/images/p12.png","Macbook M3"));
                productRepository.save(new Product(17490000L,"Acer Nitro","/images/p13.png","Acer Nitro 5"));
                productRepository.save(new Product(32990000L,"Acer Predator","/images/p14.png","Acer Predator"));

                productRepository.save(new Product(26490000L,"Macbook Air","/images/p15.png","Macbook Air M2 2022"));
                productRepository.save(new Product(29790000L,"Macbook Pro","/images/p16.png","Apple Macbook Pro 13"));
                productRepository.save(new Product(29990000L,"Asus Gaming","/images/p17.png","ASUS ROG Flow X13GV301RC-LJ050W"));
                productRepository.save(new Product(17990000L,"Vivo Book","/images/p18.png","Asus VivoBook 15 OLED A1505VA-L1114W"));

                productRepository.save(new Product(13490000L,"Dell Inspiron","/images/p19.png","Dell Inspirion 15 3511 PDP3H"));
                productRepository.save(new Product(17490000L,"Dell Vostro","/images/p20.png","Dell Vostro 3520"));
                productRepository.save(new Product(18890000L,"Dell Inspiron","/images/p21.png","Dell Inspiron 7506-5903SLV"));
                productRepository.save(new Product(15490000L,"Dell Vostro","/images/p22.png","Dell Vostro 3405 V4R53500U003W"));

                //data Product Details
                productDetailsRepository.save(new Productdetails(1,12000000L,"Asus","Laptop Asus Vivobook Go 14 E1404FA-NK177W – " + "Thiết kế mỏng nhẹ, hiệu năng ổn định Là một sản phẩm thuộc series Asus Vivobook do đó laptop Asus Vivobook Go 14 E1404FA-NK177W sở hữu nhiều đặc điểm của series này. " +
                        "Bên cạnh đó là nhiều tính năng được nâng cấp, hỗ trợ tối ưu trong quá trình sử dụng của người dùng. " +
                        "Bộ nhớ RAM lớn đa nhiệm ổn định cùng SSD PCIE 512GB Asus Vivobook Go 14 E1404FA-NK177W được hãng sản xuất trang bị bộ nhớ RAM lên đến 16GB. " +
                        "Với dung lượng RAM ấn tượng này máy có thể thoải mái đa nhiệm nhờ đó người dùng có thể sử dụng cùng lúc nhiều ứng dụng.",
                        "/images/p11.png","/images/p11.png","/images/p11.png","Asus VivoBook Go 14 E1404FA-NK177W",
                        "Design","VivoBook", "Silver"));

                productDetailsRepository.save(new Productdetails(2,74990000L,"Apple","Macbook Pro 16 inch M3 Pro 36GB 512GB với màn hình 16.2" +
                        " inch cho hiển thị thoải mái, cùng hiệu năng mạnh mẽ nhờ chip Apple M3 Pro giúp bạn trải nghiệm hoàn hảo hơn. Thiết kế sản phẩm Macbook Pro 2023 này với" +
                        " 79 phím bao gồm 12 phím chức năng với chiều cao tiêu chuẩn,… Touch ID vừa tiện lợi vừa tăng độ bảo mật, RAM 36GB cùng ổ cứng 512GB giúp lưu trữ thoải" +
                        " mái.","/images/p12.png","/images/p12.png","/images/p12.png","Macbook Pro 16 M3 Pro 36GB - 512GB",
                        "Design","Macbook Pro", "Black"));

                productDetailsRepository.save(new Productdetails(3,17490000L,"Acer","Hiệu năng siêu cao, bộ nhớ dữ liệu lớn Laptop Acer Nitro" +
                        " sở hữu con chip Intel® Core™ i5-11400H có tốc độ 2.7GHz và tốc độ tối đa lên tới 4.5GHz. Cùng Ram DDR4 8GB 2 khe có tốc độ 3200Mhz, giúp đảm bảo hiệu" +
                        " năng của máy tính luôn nhanh nhạy, hiệu quả cao. Trang bị ổ cứng 512GB PCIe NVMe SSD cắm sẵn (có khả năng nâng cấp tối đa lên 2TB SSD PCIe Gen3, 8 Gb/s," +
                        " NVMe và 2TB HDD 2.5-inch 5400 RPM). Đảm bảo thao tác lưu tạo và tìm kiếm cực nhanh, hỗ trợ công việc tiến triển thuận lợi.","/images/p13.png",
                        "/images/p13.png","/images/p13.png","Laptop Gaming Acer Nitro 5 Eagle AN515-57-5669 NH.QEHSV.001", "Gaming",
                        "Acer Nitro", "Black"));

                productDetailsRepository.save(new Productdetails(4,32990000L,"Acer","Thiết kế kim loại, logo Predator nổi bật Acer Predator" +
                        " Helios 300 sở hữu thiết kế đậm chất gaming với vỏ kim loại chắc chắn. Cũng như các laptop Acer Predator khác, Predator Helios 300 cũng được thiết kế " +
                        "với các nét xanh electric. Phía nắp ngoài, laptop được thiết kế nổi bật với logo Predator với đèn viền LED phát sáng.Các góc máy cũng thiết kế đậm" +
                        " gaming với các cạnh được vát đặc trưng. Laptop cũng sở hữu bản lề cứng cáp với góc mở rộng, lên đến 180 độ giúp trải nghiệm chơi game, làm việc trở" +
                        " nên hoàn hảo hơn. Máy còn sở hữu nhiều cổng kết nối phổ biến hiện nay như cổng ThunderBolt, HDMI,...","/images/p14.png",
                        "/images/p14.png","/images/p14.png","Laptop Acer Predator Helios 300 PH315-53-770L NH.Q7XSV.002", "Gaming",
                        "Acer Predator", "Blue"));

                productDetailsRepository.save(new Productdetails(5,26490000L,"Apple","Thiết kế sang trọng, lịch lãm - siêu mỏng 11.3mm, chỉ" +
                        " 1.24kg Hiệu năng hàng đầu - Chip Apple M2, 8 nhân GPU, hỗ trợ tốt các phần mềm như Word, Axel, Adoble Premier Đa nhiệm mượt mà - Ram 8GB, SSD 256GB cho" +
                        " phép vừa làm việc, vừa nghe nhạc Màn hình sắc nét - Độ phân giải 2560 x 1664 cùng độ sáng 500 nits Âm thanh sống động - 4 loa tramg bị công nghệ Dolby" +
                        " Atmos và âm thanh đa chiều","/images/p15.png","/images/p15.png","/images/p15.png","Apple Macbook Air M2 2022 8GB 256GB"
                        , "Design","Macbook Air", "White"));

                productDetailsRepository.save(new Productdetails(6,29790000L,"Apple","Chip M2 mới nhất - hiệu năng hàng đầu, thoải mái sử dụng" +
                        " các phần mềm đồ hoạ hay render video Màn hình Retina - màu sắc hiển thị sống động tạo ra không gian giải trí đỉnh cao Thiết kế sang trọng - Trọng lượng" +
                        " máy chỉ 1.4kg, độ dày chỉ 15.6mm giúp bạn dễ dàng mang theo Âm thanh chân thật - Tích hợp loa kép cùng công nghệ Dolby Atmos mang đến chất lượng âm" +
                        " thanh tuyệt vời.","/images/p16.png","/images/p16.png","/images/p16.png","Apple Macbook Pro 13 M2 2022 8GB 256GB",
                        "Design","Macbook Air", "Silver"));

                productDetailsRepository.save(new Productdetails(7,29990000L,"Asus","Card đồ hoạ RTX3050 - Chiến mọi tựa game ở mức đồ hoạ cao" +
                        " Ram 16GB onboard - Đa nhiệm tốt, không lo tràn ram Chiến game ở mức 120fps với màn 120hz Màn hình độ phủ màu 100% sRGB - cân tốt cà các tác vụ đồ hoạ" +
                        " Thoải mái sáng tạo với màn hình cảm ứng","/images/p17.png","/images/p17.png","/images/p17.png","Laptop ASUS ROG Flow" +
                        " X13 GV301RC-LJ050W", "Gaming","Gaming", "Black"));

                productDetailsRepository.save(new Productdetails(8,17990000L,"Asus","Màn hình 15.6 inch tấm nền OLED cho khả năng tái tạo hoàn" +
                        " hảo CPU Intel Core i5-13500H mạnh mẽ có thể xử lý mượt mà mọi tác vụ Card Intel UHD cho trải nghiệm giải trí cao RAM 16 GB chạy đa ứng dụng mượt mà" +
                        " không lo giật, lag Ổ cứng SSD 512 GB cho tốc độ truy xuất dữ liệu nhanh, không gian lưu trữ đủ lớn","/images/p18.png","/images/p18.png"
                        ,"/images/p18.png","Laptop Asus VivoBook 15 OLED A1505VA-L1114W", "Thinkpad","VivoBook", "White"));

                productDetailsRepository.save(new Productdetails(9,13490000L,"Dell","Laptop Dell Inspiron 15 3511 PDP3H đang được người tiêu " +
                        "dùng hết mực săn đón nhờ thiết kế bên ngoài mỏng nhẹ cùng cấu hình mượt tới từ chipset Intel hiện đại. Bên cạnh đó laptop Dell Inspiron còn sở hữu khả " +
                        "năng lưu trữ ổn định thông qua thông số bộ nhớ lên tới 256GB bộ nhớ trong và 8GB RAM, đem tới trải nghiệm đa nhiệm mượt mà cùng không gian ghi nhớ tuyệt" +
                        " vời.","/images/p19.png","/images/p19.png","/images/p19.png","Laptop Dell Inspirion 15 3511 PDP3H", "Thinkpad",
                        "Inspirion", "Black"));

                productDetailsRepository.save(new Productdetails(10,17490000L,"Dell","Hiệu năng ổn định với I7-1235U xử lý tốt các tác vụ từ " +
                        "văn phòng đến chỉnh sứa hình ảnh RAM 8 GB tối ưu hoá tốt hiệu suất sử dụng, cho phép mở nhiều ứng dụng cùng lúc SSD 512 GB NVMe tốc độ cao rút ngắn " +
                        "thời gian load ứng dụng Giải trí sống động với màn hình 15.6 inch cùng độ phân giải full HD","/images/p20.png","/images/p20.png",
                        "/images/p20.png","Laptop Dell Vostro 3520", "Business","Vostro", "Silver"));

                productDetailsRepository.save(new Productdetails(11,18890000L,"Dell","Màn hình 15.6 inch cho góc nhìn rộng hơn cùng công nghệ" +
                        " Anti Glare hạn chế tình trạng chói, lóa. CPU Intel Core i5-1135G7 cho khả năng xử lý nhanh gọn, hiệu quả các tác vụ văn phòng. Card đồ họa" +
                        " Intel Iris Xe graphics đáp ứng đầy đủ nhu cầu lướt web, xem phim, thiết kế cơ bản trên Photoshop, Canva,... Laptop RAM 8 GB cho phép mở hàng loạt " +
                        "cửa sổ trình duyệt cùng lúc. Máy được trang bị đầy đủ cổng kết nối phổ biến như: USB Type-A, USB Type-C, HDMI,... giúp chia sẻ thông tin hay truyền tải" +
                        " dữ liệu nhanh chóng. Hỗ trợ kết nối không dây Bluetooth và Wi-Fi 6 802.11AX, 802.11AC mang đến tốc độ truyền tải cao, đảm bảo đường truyền ổn định."
                        ,"/images/p21.png","/images/p21.png","/images/p21.png","Laptop Dell Inspiron 7506-5903SLV", "Business",
                        "Inspiron", "Blue"));

                productDetailsRepository.save(new Productdetails(12,15490000L,"Dell","Chip AMD Ryzen 5-3500U xử lý mượt mà các tác vụ văn" +
                        " phòng hay chỉnh sửa ảnh cơ bản trên PTS. Ổ cứng SSD 512GB - mang đến khả năng đa nhiệm nhiều tác vụ cùng lúc, tiết kiệm tối đa thời gian mở máy. Công " +
                        "nghệ chống chói Anti Glare - Làm việc không lo bị mỏi mắt. Khả năng hiển thị rực rỡ - màn hình 14.0 inch, độ phân giải Full HD. Cổng kết nối đa dạng:" +
                        " HDMI 1.4, USB 2.0, USB 3.2, .. - Thuận tiện cho người dùng. Pin cực khỏe - 3 cell - 45Whr cho thời gian sử dụng bền bỉ. Thiết kế mỏng nhẹ, sang trọng" +
                        " thuận tiện di chuyển, mang theo - Nặng 1.6 kg Máy đi kèm Windows 10 bản quyền. ","/images/p22.png","/images/p22.png",
                        "/images/p22.png","Laptop Dell Vostro 3405 V4R53500U003W", "Business","Vostro", "Black"));


            }
        };
    }
}
