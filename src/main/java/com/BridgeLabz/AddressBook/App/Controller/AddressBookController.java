package com.BridgeLabz.AddressBook.App.Controller;


import com.BridgeLabz.AddressBook.App.DTO.AddressBookDTO;
import com.BridgeLabz.AddressBook.App.Entity.AddressBook;
import com.BridgeLabz.AddressBook.App.Service.AddressBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/addressbook")
public class AddressBookController {


    @Autowired
    private AddressBookService addressBookService;

    @GetMapping
    public ResponseEntity<List<AddressBook>> getAllContacts() {
        return ResponseEntity.ok(addressBookService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AddressBook> getContactById(@PathVariable int id) {
        return addressBookService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<AddressBook> addContact(@RequestBody AddressBookDTO addressBookDTO) {
        return ResponseEntity.ok(addressBookService.addContact(addressBookDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AddressBook> updateContact(@PathVariable int id, @RequestBody AddressBookDTO addressBookDTO) {
        return addressBookService.updateContact(id, addressBookDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
=======
    @GetMapping
    public ResponseEntity<String> getAllContacts() {
        return ResponseEntity.ok("Fetching all contacts...");
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getContactById(@PathVariable int id) {
        return ResponseEntity.ok("Fetching contact with ID: " + id);
    }

    @PostMapping
    public ResponseEntity<String> addContact() {
        return ResponseEntity.ok("Adding a new contact...");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateContact(@PathVariable int id) {
        return ResponseEntity.ok("Updating contact with ID: " + id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteContact(@PathVariable int id) {

        if (addressBookService.deleteContact(id)) {
            return ResponseEntity.ok("Contact deleted successfully.");
        }
      
        return ResponseEntity.ok("Deleting contact with ID: " + id);

    }
}
