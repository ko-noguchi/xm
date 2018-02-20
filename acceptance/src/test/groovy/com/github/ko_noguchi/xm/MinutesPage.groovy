package com.github.ko_noguchi.xm

import geb.Page

class MinutesPage extends Page {
    static url = "minutes"
    static at = { isLikeyyyyMMddHHmmss($("h1").text()) }

    static boolean isLikeyyyyMMddHHmmss(String id) {
        id ==~ /\d{14}/
    }
}
