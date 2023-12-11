package deque;

import java.util.List;

public class App {

	public static void main(String[] args) {
		 // Create a LinkedDeque to represent the book list
        LinkedDeque<String> bookList = new LinkedDeque<>();

        // Add books to the list (to the front and back)
        bookList.addToFront("Book 1");
        bookList.addToFront("Book 0");
        bookList.addToBack("Book 2");
        bookList.addToBack("Book 3");

        // Display all books in the list
        List<String> allBooks = bookList.getAll();
        System.out.println("All books in the list:");
        for (String book : allBooks) {
            System.out.println(book);
        }

        // Display the front and back books in the list
        if (!bookList.isEmpty()) {
            System.out.println("Front book: " + bookList.getFront());
            System.out.println("Back book: " + bookList.getBack());
        } else {
            System.out.println("The book list is empty.");
        }

        // Remove and display books from the front and back
        String removedFrontBook = bookList.removeFront();
        String removedBackBook = bookList.removeBack();
        System.out.println("Removed front book: " + removedFrontBook);
        System.out.println("Removed back book: " + removedBackBook);

        // Check if the list is empty after removal
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty.");
        }

        // Clear the list
        bookList.clear();

        // Check if the list is empty after clearing
        if (bookList.isEmpty()) {
            System.out.println("The book list is empty after clearing.");
        }
    }

	}


