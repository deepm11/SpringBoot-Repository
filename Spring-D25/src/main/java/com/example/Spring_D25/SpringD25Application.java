package com.example.Spring_D25;

import com.example.Spring_D25.Entity.Employee;
import com.example.Spring_D25.repository.EmployeeCrudRepository;
import com.example.Spring_D25.repository.EmployeeJpaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;

@SpringBootApplication
@EnableJpaAuditing
public class SpringD25Application {


    @Bean
    CommandLineRunner run (EmployeeJpaRepository repo){
        return args ->{

            Employee e1 = new Employee("Amit","IT", 50000);
            repo.save(e1);

            repo.saveAll(List.of(

                    new Employee("Raj","HR",4000),
                    new Employee("neha","IT",60000),
                    new Employee("Raj","TIR",60000)
            ));
            repo.flush();


            repo.findAll().forEach(System.out::println);
            repo.deleteById(e1.getId());

            PageRequest pageRequest = PageRequest.of(0, 2);
            Page<Employee> page = repo.findAll(pageRequest);

            System.out.println("--------------PAGE DATA-------");
            page.getContent().forEach(System.out::println);

            //SORTING
            Sort sort = Sort.by("salary").descending();
            System.out.println("--------------SORTING DATA-------");
            repo.findAll(sort).forEach(System.out::println);


           //DERIVED QUERY
            System.out.println("---- IT DEPARTMENT ----");
            repo.findByDepartment("IT").forEach(System.out::println);


            //JPQL QUERY
            System.out.println("---- HIGH SALARY ----");
            repo.findHighSalary(50000).forEach(System.out::println);

           //NATIVE QUERY
            System.out.println("---- NATIVE QUERY ----");
            repo.findByDepartmentNative("HR").forEach(System.out::println);

//SLICE DATA   ...mmmmm

            Slice<Employee> slice = repo.findAll(PageRequest.of(0, 2));

            System.out.println("---- SLICE DATA ----");
            slice.getContent().forEach(System.out::println);



        };
    }


	public static void main(String[] args) {
		SpringApplication.run(SpringD25Application.class, args);
	}


}
