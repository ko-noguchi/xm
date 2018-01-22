import React from 'react'
import Minutes from '../../src/js/minutes/Minutes'
import {shallow} from 'enzyme'
import * as minutesRepository from '../../src/js/minutes/minutesRepository'

describe('Minutes', () => {
    let sut
    beforeEach(() => sut = shallow(<Minutes/>))

    it('has title', () => {
        expect(sut.find('h1').at(0).text()).toContain('議事録作成')
    })

    it('has create button', () => {
        const createButton = sut.find('button').at(0)


        expect(createButton.text()).toContain('作成')
    })

    it('creates minutes when create button clicked', () => {
        const createMinutesSpy = jest.spyOn(minutesRepository, 'createMinutes')
        const createButton = sut.find('button').at(0)


        createButton.simulate('click')


        expect(createMinutesSpy).toHaveBeenCalled()
    })
})
