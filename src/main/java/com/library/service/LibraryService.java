package com.library.service;

import com.library.repository.BookRepository;
import com.library.repository.MemberRepository;

public class LibraryService {
    private final BookRepository bookRepository = new BookRepository();
    private final MemberRepository memberRepository = new MemberRepository();
    public void borrowBook(int bookId, int memberId) {
        // Code to borrow a book

        // Check if the book is available, then mark it as borrowed and associate it with the member

    }




}
