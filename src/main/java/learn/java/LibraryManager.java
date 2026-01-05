package learn.java;

public class LibraryManager {

    public static int linearSearch(Book[] books, int count, String query) {
        for (int i = 0; i < count; i++) {
            if (books[i].getTitle().equalsIgnoreCase(query) || books[i].getIsbn().equals(query)) {
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(Book[] books, int count, String title) {
        int low = 0, high = count - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int res = title.compareToIgnoreCase(books[mid].getTitle());
            if (res == 0) return mid;
            if (res > 0) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }

    public static void bubbleSort(Book[] books, int count) {
        for (int i = 0; i < count - 1; i++) {
            for (int j = 0; j < count - i - 1; j++) {
                if (books[j].getTitle().compareToIgnoreCase(books[j+1].getTitle()) > 0) {
                    Book temp = books[j];
                    books[j] = books[j+1];
                    books[j+1] = temp;
                }
            }
        }
    }

    public static void quickSort(Book[] books, int low, int high) {
        if (low < high) {
            int pi = partition(books, low, high);
            quickSort(books, low, pi - 1);
            quickSort(books, pi + 1, high);
        }
    }

    private static int partition(Book[] books, int low, int high) {
        int pivot = books[high].getPublicationYear();
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (books[j].getPublicationYear() < pivot) {
                i++;
                Book temp = books[i];
                books[i] = books[j];
                books[j] = temp;
            }
        }
        Book temp = books[i + 1];
        books[i + 1] = books[high];
        books[high] = temp;
        return i + 1;
    }

    public static boolean updateBook(Book[] books, int count, String isbn, String newTitle, String newAuthor, int newYear) {
        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                books[i].setTitle(newTitle);
                books[i].setAuthor(newAuthor);
                books[i].setPublicationYear(newYear);
                return true;
            }
        }
        return false;
    }

    public static int removeBook(Book[] books, int count, String isbn) {
        int indexToRemove = -1;

        for (int i = 0; i < count; i++) {
            if (books[i].getIsbn().equals(isbn)) {
                indexToRemove = i;
                break;
            }
        }

        if (indexToRemove != -1) {
            for (int i = indexToRemove; i < count - 1; i++) {
                books[i] = books[i + 1];
            }
            books[count - 1] = null;
            return count - 1;
        }

        return count;
    }
}