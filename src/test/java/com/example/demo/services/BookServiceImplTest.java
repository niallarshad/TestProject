package com.example.demo.services;

import com.example.demo.Constants;
import com.example.demo.model.Book;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookServiceImplTest {

    BookServiceImpl personService = new BookServiceImpl();

    @Test
    public void createPersonTest() {
        Book book = createPersonForTests("1", "niall", "The legendary Mechanic");
        assertTrue(book.getId().equalsIgnoreCase("1"));
        assertTrue(book.getAuthor().equalsIgnoreCase("niall"));
        assertEquals("The legendary Mechanic", book.getName());
    }

    @Test
    public void getPersonTest() {
        // create person
        createPersonForTests("10", "niallA", "The legendary Mechanic");
        Book book = personService.getBook();
        assertTrue(book.getId().equalsIgnoreCase("10"));
        assertTrue(book.getAuthor().equalsIgnoreCase("niallA"));
        assertEquals("The legendary Mechanic", book.getName());
    }

    @Test
    public void updatedPersonTest() {
        // create person
        createPersonForTests("11", "niallArshad", "The legendary Mechanic");
        Book updatedBook = new Book("11", "Kiba", "The legendary Mechanic");
        Book book = personService.updateBook("11", updatedBook);
        assertTrue(book.getId().equalsIgnoreCase("11"));
        assertTrue(book.getAuthor().equalsIgnoreCase("Kiba"));
        assertEquals("The legendary Mechanic", book.getName());
    }



    private Book createPersonForTests(String id, String author, String name) {
        personService.setPath(Constants.testPath);
        return personService.createBook(new Book(id, author, name));
    }

    @Test
    public void testFirstDuplicate() {
        int[] a = { 1, 2, 3, 4, 5, 1, 2, 6, 7 };

        for (int m = 0; m < a.length; m++) {

            for (int n = m + 1; n < a.length; n++) {

                if (a[m] == a[n])

                    System.out.print(a[m]);

            }
        }
    }

    @Test
    public void testReverseAString() {
        String str = "hello";

        String reverse = "";

        int length = str.length();

        for (int i = 0; i < length; i++) {

            reverse = str.charAt(i) + reverse;

        }
    }

    @Test
    public void testNumberOfOcc() {
        int count = 0;
        String str = "happy";

        char search = 'a';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == search) {
                count++;
            }
        }

        System.out.println(count);
    }

    @Test
    public void testReverseLinkedList() {
        LinkedList<Integer> ll = new LinkedList<>();

        ll.add(1);

        ll.add(2);

        ll.add(3);

        System.out.println(ll);

        LinkedList<Integer> ll1 = new LinkedList<>();
        ll.descendingIterator().forEachRemaining(ll1::add);
        ll.descendingIterator().forEachRemaining(ll1::add);

        System.out.println(ll1);
    }

    @Test
    public void testNumberOfVowelsConsonants() {
        int vowels = 0;

        int consonants = 0;

        String str = "happy";

        for (int k = 0; k < str.length(); k++) {
            char c = str.charAt(k);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u')
                vowels++;
            else
                consonants++;
        }
    }

    @Test
    public void testReverse3() {
        String str = "DBCABA";


//        for (int i = 0; i < str.length(); i++) {
//            char rec = str.charAt(i);
//            for (int j = i + 1; j < str.length(); j++) {
//                 if(rec == str.charAt(j)) {
//                     System.out.println(rec);
//                     return;
//                 }
//            }
//        }

        Map<Character, Integer> mappy = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if(mappy.get(str.charAt(i)) == null) {
                mappy.put(str.charAt(i), 1);
            } else {
                System.out.println(str.charAt(i));
                return;
            }

        }

    }

    @Test
    public void testReverse2() {

    }

}

