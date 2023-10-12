package com.example.buildingapi;

import com.example.buildingapi.Inheritance.joinedtable.*;
import com.example.buildingapi.Inheritance.mappedsuperclass.MSCInstructorRepository;
import com.example.buildingapi.Inheritance.mappedsuperclass.MSCMentorRepository;
import com.example.buildingapi.Inheritance.mappedsuperclass.MSCTARepository;
import com.example.buildingapi.Inheritance.singleclass.SCInstructorRepository;
import com.example.buildingapi.Inheritance.singleclass.SCMentorRepository;
import com.example.buildingapi.Inheritance.singleclass.SCTARepository;
import com.example.buildingapi.Inheritance.singleclass.SCUserRepository;
import com.example.buildingapi.Inheritance.tableperclass.TPCInstructorRepository;
import com.example.buildingapi.Inheritance.tableperclass.TPCMentorRepository;
import com.example.buildingapi.Inheritance.tableperclass.TPCTARepository;
import com.example.buildingapi.Inheritance.tableperclass.TPCUserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BuildingApiApplicationTests {

    @Autowired
    private JTMentorRepository jtMentorRepository;
    @Autowired
    private JTUserRepository jtUserRepository;
    @Autowired
    private JTInstructorRepository jtInstructorRepository;
    @Autowired
    private JTTARepository jttaRepository;

    @Autowired
    private SCInstructorRepository scInstructorRepository;
    @Autowired
    private SCTARepository sctaRepository;
    @Autowired
    private SCMentorRepository scMentorRepository;
    @Autowired
    private SCUserRepository scUserRepository;

    @Autowired
    private MSCInstructorRepository mscInstructorRepository;
    @Autowired
    private MSCTARepository msctaRepository;
    @Autowired
    private MSCMentorRepository mscMentorRepository;

    @Autowired
    private TPCInstructorRepository tpcInstructorRepository;
    @Autowired
    private TPCTARepository tpctaRepository;
    @Autowired
    private TPCMentorRepository tpcMentorRepository;
    @Autowired
    private TPCUserRepository tpcUserRepository;

    @Test
    void contextLoads() {

    }

    @Test
    void testJTInheritance(){
        User mUser = new User();
        mUser.setEmail("mentor@test.com");
        mUser.setPassword("mpassword");
        jtUserRepository.save(mUser);

        Mentor mentor = new Mentor();
        mentor.setEmail("mentor@test.com");
        mentor.setPassword("mpassword");
        mentor.setNumberOfMentees(15);
        mentor.setNumberOfSessions(3);
        jtMentorRepository.save(mentor);

        User tUser = new User();
        tUser.setEmail("ta@test.com");
        tUser.setPassword("tpassword");
        jtUserRepository.save(tUser);

        TA ta = new TA();
        ta.setEmail("ta@test.com");
        ta.setPassword("tpassword");
        ta.setAverageRating(5);
        jttaRepository.save(ta);


        User iUser = new User();
        iUser.setEmail("instructor@test.com");
        iUser.setPassword("ipassword");
        jtUserRepository.save(iUser);

        Instructor instructor = new Instructor();
        instructor.setEmail("instructor@test.com");
        instructor.setPassword("ipassword");
        instructor.setHandsome(true);
        jtInstructorRepository.save(instructor);
    }

    @Test
    void testSCInheritance(){
        com.example.buildingapi.Inheritance.singleclass.User mUser = new com.example.buildingapi.Inheritance.singleclass.User();
        mUser.setEmail("mentor@test.com");
        mUser.setPassword("mpassword");
        scUserRepository.save(mUser);

        com.example.buildingapi.Inheritance.singleclass.Mentor mentor = new com.example.buildingapi.Inheritance.singleclass.Mentor();
        mentor.setEmail("mentor@test.com");
        mentor.setPassword("mpassword");
        mentor.setNumberOfMentees(15);
        mentor.setNumberOfSessions(3);
        scMentorRepository.save(mentor);

        com.example.buildingapi.Inheritance.singleclass.User tUser = new com.example.buildingapi.Inheritance.singleclass.User();
        tUser.setEmail("ta@test.com");
        tUser.setPassword("tpassword");
        scUserRepository.save(tUser);

        com.example.buildingapi.Inheritance.singleclass.TA ta = new com.example.buildingapi.Inheritance.singleclass.TA();
        ta.setEmail("ta@test.com");
        ta.setPassword("tpassword");
        ta.setAverageRating(5);
        sctaRepository.save(ta);


        com.example.buildingapi.Inheritance.singleclass.User iUser = new com.example.buildingapi.Inheritance.singleclass.User();
        iUser.setEmail("instructor@test.com");
        iUser.setPassword("ipassword");
        scUserRepository.save(iUser);

        com.example.buildingapi.Inheritance.singleclass.Instructor instructor = new com.example.buildingapi.Inheritance.singleclass.Instructor();
        instructor.setEmail("instructor@test.com");
        instructor.setPassword("ipassword");
        instructor.setHandsome(true);
        scInstructorRepository.save(instructor);
    }

    @Test
    void testTPCInheritance(){
        com.example.buildingapi.Inheritance.tableperclass.User mUser = new com.example.buildingapi.Inheritance.tableperclass.User();
        mUser.setEmail("mentor@test.com");
        mUser.setPassword("mpassword");
        tpcUserRepository.save(mUser);

        com.example.buildingapi.Inheritance.tableperclass.Mentor mentor = new com.example.buildingapi.Inheritance.tableperclass.Mentor();
        mentor.setEmail("mentor@test.com");
        mentor.setPassword("mpassword");
        mentor.setNumberOfMentees(15);
        mentor.setNumberOfSessions(3);
        tpcMentorRepository.save(mentor);

        com.example.buildingapi.Inheritance.tableperclass.User tUser = new com.example.buildingapi.Inheritance.tableperclass.User();
        tUser.setEmail("ta@test.com");
        tUser.setPassword("tpassword");
        tpcUserRepository.save(tUser);

        com.example.buildingapi.Inheritance.tableperclass.TA ta = new com.example.buildingapi.Inheritance.tableperclass.TA();
        ta.setEmail("ta@test.com");
        ta.setPassword("tpassword");
        ta.setAverageRating(5);
        tpctaRepository.save(ta);


        com.example.buildingapi.Inheritance.tableperclass.User iUser = new com.example.buildingapi.Inheritance.tableperclass.User();
        iUser.setEmail("instructor@test.com");
        iUser.setPassword("ipassword");
        tpcUserRepository.save(iUser);

        com.example.buildingapi.Inheritance.tableperclass.Instructor instructor = new com.example.buildingapi.Inheritance.tableperclass.Instructor();
        instructor.setEmail("instructor@test.com");
        instructor.setPassword("ipassword");
        instructor.setHandsome(true);
        tpcInstructorRepository.save(instructor);
    }

    @Test
    void testMSCInheritance(){

        com.example.buildingapi.Inheritance.mappedsuperclass.Mentor mentor = new com.example.buildingapi.Inheritance.mappedsuperclass.Mentor();
        mentor.setEmail("mentor@test.com");
        mentor.setPassword("mpassword");
        mentor.setNumberOfMentees(15);
        mentor.setNumberOfSessions(3);
        mscMentorRepository.save(mentor);

        com.example.buildingapi.Inheritance.mappedsuperclass.TA ta = new com.example.buildingapi.Inheritance.mappedsuperclass.TA();
        ta.setEmail("ta@test.com");
        ta.setPassword("tpassword");
        ta.setAverageRating(5);
        msctaRepository.save(ta);

        com.example.buildingapi.Inheritance.mappedsuperclass.Instructor instructor = new com.example.buildingapi.Inheritance.mappedsuperclass.Instructor();
        instructor.setEmail("instructor@test.com");
        instructor.setPassword("ipassword");
        instructor.setHandsome(true);
        mscInstructorRepository.save(instructor);
    }

}
