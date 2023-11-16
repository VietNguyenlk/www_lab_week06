package com.example.www_lab_week6;

import net.datafaker.Faker;
import org.loremipsum.LoremIpsum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import com.example.www_lab_week6.backend.models.Post;
import com.example.www_lab_week6.backend.models.User;
import com.example.www_lab_week6.backend.repositories.PostCommentRepository;
import com.example.www_lab_week6.backend.repositories.PostRepository;
import com.example.www_lab_week6.backend.repositories.UserRepository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@SpringBootApplication
@NoArgsConstructor
public class WwwLabWeek6Application {

    @Autowired
    private PostCommentRepository postCommentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;


    public static void main(String[] args) {
        SpringApplication.run(WwwLabWeek6Application.class, args);
    }

    @Bean
    CommandLineRunner test() {
        return args -> {

            Faker faker = new Faker(new Locale("vi","VN"));

            User user1 = new User("teo", "van", "nguyen",
                    "01=918 444 666", "teo@gmail.com",
                    "$2a$17$IDkLPNOxFvUaLnkvKbPoT.b3pWnJVUza.bKNnYsVA7sonJpn3DvPa"/*teoteo*/,
                    Instant.now(), Instant.now(), LoremIpsum.createParagraph(100),
                    LoremIpsum.createParagraph(100));
            User user2 = new User("ty", "van", "Tran",
                    "0903 646 555", "ty@gmail.com",
                    "$2a$17$IDkLPNOxFvUaLnkvKbPoT.b3pWnJVUza.bKNnYsVA7sonJpn3DvPa"/*teoteo*/,
                    Instant.now(), Instant.now(), LoremIpsum.createParagraph(100),
                    LoremIpsum.createParagraph(100));
            userRepository.save(user1);
            userRepository.save(user2);
            List<Post> lst = new ArrayList<>();
            for (int i = 0; i < 10; i++) {
                Post p = new Post(
                        new Random().nextInt(2) == 0 ? user1 : user2,
                        null,
                        LoremIpsum.createSentence(30),
                        LoremIpsum.createSentence(20),
                        LoremIpsum.createSentence(100)
                        , true,
                        Instant.now(), Instant.now(), Instant.now(),
                        //LoremIpsum.createParagraph(1500)
                        faker.lorem().paragraphs(5).toString()
                );
                lst.add(p);
            }
            postRepository.saveAll(lst);

            /*PostComment pc = new PostComment(p, null, "ZXX", user1, true,
                    Instant.now(), Instant.now(), "sagkjsdgjksgksd", null);
            postCommentRepository.save(pc);*/
        };
    }

}
