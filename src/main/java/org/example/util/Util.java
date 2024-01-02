package org.example.util;

import org.example.controller.*;
import org.example.service.*;

import java.util.Scanner;

public interface Util {
    Scanner scannerNum = new Scanner(System.in);
    Scanner scannerStr = new Scanner(System.in);
    BookService BOOK_SERVICE = new BookService();
    BrochureService BROCHURE_SERVICE = new BrochureService();
    Business_cardService BUSINESS_CARD_SERVICE = new Business_cardService();
    LabelService LABEL_SERVICE = new LabelService();
    MagazineService MAGAZINE_SERVICE = new MagazineService();
    PackagingService PACKAGING_SERVICE = new PackagingService();
    PosterService POSTER_SERVICE = new PosterService();
    UserService USER_SERVICE = new UserService();


}
