package com.example.demo;

import com.example.demo.model.Profile;
import com.example.demo.repository.ProfileRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(ProfileRepository repository) {
        return args -> {
            try {
                // Kiểm tra xem có kết nối được và ghi được không
                Profile p = new Profile();
                p.setName("Nguyen Thu Ha");
                p.setEmail("ha.nguyen@student.com");
                repository.save(p);
                System.out.println(">> Đã tự động tạo dữ liệu thành công!");
            } catch (Exception e) {
                System.err.println(">> Chưa ghi được dữ liệu do lỗi Replica Set, nhưng App vẫn sẽ chạy để bạn xem trang web.");
            }
        };
    }
}