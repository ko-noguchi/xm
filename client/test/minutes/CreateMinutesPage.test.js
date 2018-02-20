import React from 'react'
import CreateMinutesPage from '../../src/js/minutes/CreateMinutesPage'
import {shallow} from 'enzyme'
import * as minutesRepository from '../../src/js/minutes/minutesRepository'

describe('CreateMinutesPage', () => {
    let pushSpy
    let sut
    beforeEach(() => {
        jest.restoreAllMocks()
        pushSpy = jest.fn()
        sut = shallow(<CreateMinutesPage history={{push: pushSpy}}/>)
    })

    it('has title', () => {
        expect(sut.find('h1').at(0).text()).toContain('議事録作成')
    })

    it('has create button', () => {
        const createButton = sut.find('button').at(0)


        expect(createButton.text()).toContain('作成')
    })

    it('creates minutes and move to the created page when create button clicked', async () => {
        const createMinutesSpy = jest.spyOn(minutesRepository, 'createMinutes').mockReturnValue(Promise.resolve({id: 'abc'}))
        const createButton = sut.find('button').at(0)


        await createButton.simulate('click')


        expect(createMinutesSpy).toHaveBeenCalled()
        expect(pushSpy).toHaveBeenCalledWith('/minutes/abc')
    })
})
