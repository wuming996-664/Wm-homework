import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class LibrarySystem {
    private ArrayList<Book> bookList;
    private HashMap<Integer, Book> bookMap;
    private HashSet<String> genreSet;

    public LibrarySystem() {
        bookList = new ArrayList<>();
        genreSet = new HashSet<>();
        bookMap =new HashMap<>();
    }

    public void addBook(Book book) {
        bookList.add(book);
        genreSet.add(book.getGenre());
        bookMap.put(book.getId(), book);
    }

    public void removeBooksByKeyword(String keyword) {
        Iterator<Book> it = bookList.iterator();
        while (it.hasNext()) {
            Book currentBook = it.next();
            if (currentBook.getTitle().contains(keyword)) {
                it.remove();
                bookMap.remove(currentBook.getId());
            }
        }
    }

    public void displayStatus() {
        System.out.println("========== 所有图书列表（按添加顺序）==========");
        for (Book book : bookList) {
            System.out.println(book);
        }
        System.out.println("\n========= 按ID快速查找演示（查询ID为1的图书）==========");
        System.out.println(bookMap.get(1));
    }
    public static void main(String[] args) {
        LibrarySystem library = new LibrarySystem();
        library.addBook(new Book(1, "Java入门到精通", "编程"));
        library.addBook(new Book(2, "红楼梦", "文学"));
        library.addBook(new Book(3, "C语言程序设计", "编程"));
        library.addBook(new Book(4, "西游记", "文学"));

        System.out.println("===== 初始系统状态 =====");
        library.displayStatus();
        System.out.println("\n===== 删除含'Java'的图书后 =====");
        library.removeBooksByKeyword("Java");
        library.displayStatus();
    }
}
