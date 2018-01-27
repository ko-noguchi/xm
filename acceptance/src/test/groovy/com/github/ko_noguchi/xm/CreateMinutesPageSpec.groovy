package com.github.ko_noguchi.xm

import geb.spock.GebReportingSpec

class CreateMinutesPageSpec extends GebReportingSpec {
    def "議事録作成ページを表示"() {
        when: "議事録作成ページにアクセスすると"
        to CreateMinutesPage

        then: "「議事録作成」と表示される"
        header.text() == "議事録作成"
    }

    def "議事録を作成"() {
        given: "議事録作成ページを表示しているとき"
        to CreateMinutesPage

        when: "「作成」ボタンを押すと"
        createButton.click()

        then: "作成した議事録のページに遷移する"
        def id = idFromUrl(currentUrl)
        isLikeyyyyMMddHHmmss(id)

        to MinutesPage, id
        header == id
    }

    private static boolean isLikeyyyyMMddHHmmss(String id) {
        id ==~ /\d{14}/
    }

    private static String idFromUrl(String minutesPageUrl) {
        new URL(minutesPageUrl).getPath()
    }
}
