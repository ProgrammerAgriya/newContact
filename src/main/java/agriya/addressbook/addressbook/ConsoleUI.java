package agriya.addressbook.addressbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class ConsoleUI implements CommandLineRunner {

    @Autowired
    private ContactController controller;
    @Override
    public void run(String... args) throws Exception {

        int selection;
        do {
            selection = menu();
            switch (selection) {
                case 1:
                    DisplayContacts();
                    break;
                case 2:
                    AddContact();
                    break;
                case 3:
                    EditContact();
                    break;
                case 4:
                    DeleteContact();
                    break;
                case 5:
                    GoodBye();
            }//end switch
        } while (selection != 5);
    }

    private void GoodBye() {
        System.out.println("Thank you for visiting !");
        //prompt user if he really wants to quit.
        // if response is yes end the application
        // if response is no show the menu again.
    }

    private void DeleteContact() {
        Integer deleteId = ReadIntInput("Enter the ID of contact to delete:");
        controller.deletecontact(deleteId);
        System.out.println("Contact successfully deleted");
        List<Contact> allContact = controller.getAllContact();
        allContact.forEach(System.out::println);
        //prompt user to get the id of the contact to edit.
        // call the delete method passing the id of contact
    }

    private void EditContact() {
        //prompt user to get the id of the contact to edit.
        Integer editId = ReadIntInput("Enter the ID of contact to edit");
        //show chosen contact based by id
        Optional<Contact> editContact = controller.getContactByID(editId);
        editContact.ifPresent(contact -> System.out.println("Current First Name is " + contact.getFirstName()
        +"\n" + "Current Last Name is " + contact.getLastName() + "\n" + "Current Address is " + contact.getAddress() +
        "\n"  + "Current Phone Number is " + contact.getPhoneNumber() + "\n" + "Current Email Address is " + contact.getEmailAddress()
        ));
     //   System.out.println(editContact.toString());
        //show a menu of options to select that part of contact has to be updated.
        int choice = edit_menu();
        switch (choice){
            case 1:
                String firstname = ReadInput("Enter the updated first name:");
                editContact.ifPresent(contact -> contact.setFirstName(firstname));
                Contact contact = editContact.get();
                controller.updatecontact(contact);
            case 2:
                String lastname = ReadInput("Enter the updated last name:");
                editContact.ifPresent(contact1 -> contact1.setFirstName(lastname));
                Contact contacT = editContact.get();
                controller.updatecontact(contacT);
            case 3:
                String address = ReadInput("Enter the updated address:");
                editContact.ifPresent(contact2 -> contact2.setFirstName(address));
                Contact contact3 = editContact.get();
                controller.updatecontact(contact3);
            case 4:
                String phonenumber = ReadInput("Enter the updated first name:");
                editContact.ifPresent(contact4 -> contact4.setFirstName(phonenumber));
                Contact contAct = editContact.get();
                controller.updatecontact(contAct);
            case 5:
                String emailaddress = ReadInput("Enter the updated first name:");
                editContact.ifPresent(contact5 -> contact5.setFirstName(emailaddress));
                Contact cOntact = editContact.get();
                controller.updatecontact(cOntact);
        }
        //prompt user to enter the updated value.
        // update the contact using setter method.
        //call save method to update the contact.

    }

    private void AddContact() {
        String firstName = ReadInput("Enter First Name");
        String lastName = ReadInput("Enter Last Name");
        String address = ReadInput("Enter address:");
        String phoneNumber = ReadInput("Enter phone number:");
        String emailAddress = ReadInput("Enter email:");
        Integer contactId = ReadIntInput("Enter contact id:");
        //get other variables.

        // call constructor to create the contact object
        Contact contact;
        contact = new Contact(contactId,firstName,lastName, address, phoneNumber, emailAddress);
        controller.savenewcontact(contact);
    }

    public  void DisplayContacts() {
        List<Contact> allContact = controller.getAllContact();
        allContact.forEach(System.out::println);
    }
    public static int menu() {

        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Display All contacts");
        System.out.println("2 - Create a contact");
        System.out.println("3 - Edit a contact");
        System.out.println("4 - Delete a contact");
        System.out.println("5 - Quit");

        selection = input.nextInt();
        return selection;
    }

    public static int edit_menu() {

        int selection;
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Change First Name");
        System.out.println("2 - Change Last Name");
        System.out.println("3 - Change Email");
        System.out.println("4 - Change Phone");
        System.out.println("5 - NeverMind Changed My Mind");

        selection = input.nextInt();
        return selection;
    }
    private static String ReadInput(String prompt) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(prompt);
        return myObj.nextLine();
    }

    private static Integer ReadIntInput(String prompt) {
        Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        System.out.println(prompt);
        return myObj.nextInt();
    }


}
