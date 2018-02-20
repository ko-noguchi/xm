package com.github.ko_noguchi.xm

import geb.spock.GebReportingSpec

class CreateMinutesPageSpec extends GebReportingSpec {
    def "議事録を作成"() {
        given: "議事録作成ページを表示しているとき"
        def page = to CreateMinutesPage

        when: "「作成」ボタンを押すと"
        page.createButton.click()

        then: "作成した議事録のページに遷移する"
        at MinutesPage
    }
}
