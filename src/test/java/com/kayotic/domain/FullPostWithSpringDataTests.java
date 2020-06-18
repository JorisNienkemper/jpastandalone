package com.kayotic.domain;

import com.kayotic.repositories.FullPostRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Optional;

@ExtendWith(SpringExtension.class) //Niet nodig zie @DataJpaTest
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class FullPostWithSpringDataTests {

    @Autowired
    FullPostRepository fpRepo;

    @Test
    void getFPFromDb() {
        //Category lunch = new Category( 10"Lunch"); // ID wordt gegenereerd
        Category lunch = new Category("Lunch");
        FullPost fp1 = new FullPost(1, "Smullen met pannenkoeken",lunch);
        fpRepo.save(fp1);

        Optional<FullPost> fp = fpRepo.findById(1);
        System.out.println(fp);
    }
}
