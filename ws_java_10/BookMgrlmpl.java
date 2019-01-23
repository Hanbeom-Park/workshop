package com.ssafy.ws;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.ssafy.edu.h23g.Student;

public class BookMgrlmpl implements IBookMgr {
	private static BookMgrlmpl bookManager;

	private BookMgrlmpl() {
	}

	public static BookMgrlmpl getInstance() {
		if (bookManager == null) {
			bookManager = new BookMgrlmpl();
		}
		return bookManager;
	}

	private ArrayList<Book> books = new ArrayList<>();

	@Override
	public void add(Book b) {
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(b.getIsbn())) {
				System.out.println("이미 존재함");
				return;
			}
		}
		books.add(b);
	}

	@Override
	public List<Book> search() {
		return books;
	}

	@Override
	public void sell(String isbn, int quantity) throws QuantityException, ISBNNotFoundException {
		int find=0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				find=1;
				if (books.get(i).getQuantity() - quantity < 0) {
						throw new QuantityException();
				} else {
					books.get(i).setQuantity(books.get(i).getQuantity() - quantity);
				}
			}
			
		}
		if(find==0) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public void buy(String isbn, int quantity) throws ISBNNotFoundException {
		int find=0;
		for (int i = 0; i < books.size(); i++) {
			if (books.get(i).getIsbn().equals(isbn)) {
				books.get(i).setQuantity(books.get(i).getQuantity() + quantity);
				find=1;
			}
		}
		if(find==0) {
			throw new ISBNNotFoundException();
		}
	}

	@Override
	public int getTotalAmount() {
		int tot = 0;
		for (int i = 0; i < books.size(); i++) {
			tot = tot + books.get(i).getPrice() * books.get(i).getQuantity();
		}
		return tot;
	}

	@Override
	public void open() {
		String fname = "book.txt";
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(fname));
			String msg = "";
			while ((msg = br.readLine()) != null) {
				StringTokenizer st = new StringTokenizer(msg, "|");
				int kind = Integer.parseInt(st.nextToken().trim());
				if (kind == 1) {
					books.add(new Book(st.nextToken().trim(), st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim())));
				} else {
					books.add(new Magazine(st.nextToken().trim(), st.nextToken().trim(),
							Integer.parseInt(st.nextToken().trim()), Integer.parseInt(st.nextToken().trim()),
							Integer.parseInt(st.nextToken().trim())));
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("파일이 존재하지 않습니다.");
		} catch (IOException e) {
			System.out.println("파일을 읽는 도중 예외가 발생했습니다.");
		}
	}

	@Override
	public void close() {
		String fname = "book.txt";
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(fname, false), true);

			for (int i = 0; i < books.size(); i++) {
				Book b = books.get(i);
				String msg;
				if (b instanceof Magazine) {
					msg = String.format("%d%s%s%s%s%s%d%s%d%s%d", 2, "|", b.getIsbn(), "|", b.getTitle(), "|",
							b.getPrice(), "|", b.getQuantity(), "|", ((Magazine) b).getMonth());

				} else {
					msg = String.format("%d%s%s%s%s%s%d%s%d", 1, "|", b.getIsbn(), "|", b.getTitle(), "|", b.getPrice(),
							"|", b.getQuantity());
				}
				pw.println(msg);

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (pw != null) {
				pw.close();
			}
		}

	}

}
