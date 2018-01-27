package com.github.ko_noguchi.xm

import geb.Page

class MinutesPage extends Page {
    static url = "minutes"
    static at = { title == "XM Web Client" }
    static content = {
        header { $("h1") }
    }
}
