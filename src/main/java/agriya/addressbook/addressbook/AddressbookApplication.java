package agriya.addressbook.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class AddressbookApplication {
	@Autowired
	ContactController contactController;

	public static void main(String[] args) {
		SpringApplication.run(AddressbookApplication.class, args);
	}










}
