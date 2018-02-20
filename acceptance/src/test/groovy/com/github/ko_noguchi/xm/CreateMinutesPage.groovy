package com.github.ko_noguchi.xm

import geb.Page

class CreateMinutesPage extends Page {
    static url = "minutes"
    static at = { $("h1").text() == "議事録作成" }
    static content = {
        createButton { $("button") }
    }
}
