package com.mcworkshop.dongjing;

import com.mcworkshop.dongjing.domain.Right;
import com.mcworkshop.dongjing.domain.Role;
import com.mcworkshop.dongjing.domain.User;
import com.mcworkshop.dongjing.persistence.repository.RightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.mcworkshop.dongjing.persistence")
public class DongjingApplication implements CommandLineRunner {

    @Autowired
    RightRepository rightRepository;

    public static void main(String[] args) {
        SpringApplication.run(DongjingApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
        List<String> rights = Arrays.asList("PM.CHANGE",
            "RM.BKX",
            "RM.OVERALL",
            "SECURITY.VIEW",
            "SECURITY.CHANGE",
            "AGRI.VIEW",
            "AGRI.CHANGE",
            "INFO.SMS",
            "INFO.EMAIL",
            "CA.VIEW",
            "CA.CHANGE",
            "DEPARTMENT.JFB",
            "DEPARTMENT.CZS",
            "DEPARTMENT.AJS",
            "DEPARTMENT.BKX",
            "DEPARTMENT.JGS",
            "DEPARTMENT.MYC",
            "DEPARTMENT.NFGS",
            "DEPARTMENT.ZHDW",
            "BLOCK.BL1",
            "BLOCK.BL2",
            "BLOCK.BL3",
            "BLOCK.BL4",
            "BLOCK.BL5",
            "BLOCK.BL6",
            "BLOCK.BL7",
            "BLOCK.BL8",
            "BLOCK.BL9",
            "BLOCK.BL10",
            "BLOCK.BL11",
            "BLOCK.BL12",
            "BLOCK.BL13",
            "BLOCK.BL14",
            "BLOCK.BL15",
            "BLOCK.BL16",
            "BLOCK.BL17",
            "BLOCK.BL18",
            "BLOCK.BL19" ,
            "CM.CHANGE_COMPANY",
            "CM.VIEW_COMPANY",
            "CM.IMPORT_COMPANY",
            "CM.EXPORT_COMPANY",
            "TAX.VIEW",
            "TAX.IMPORT",
            "PM.VIEW");
        for (String right : rights) {
            rightRepository.save(new Right(right));
        }
        Right system = new Right("SYSTEM");
        rightRepository.save(system);
        Role role = new Role();
        role.setRoleOID(UUID.randomUUID());
        role.setName("Admin");
        role.getRights().add(system);
        User user = new User();
        user.setUserOID(UUID.randomUUID());
        user.setUsername("admin");
//        user.setPassword();
    }
}
