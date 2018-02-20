import React from 'react'
import {shallow} from 'enzyme'
import MinutesPage from '../../src/js/minutes/MinutesPage'

describe('MinutesPage', () => {
    let sut
    beforeEach(() => {
        sut = shallow(<MinutesPage match={{params: {id: '20180220223941'}}}/>)
    })

    it('has title', () => {
        expect(sut.find('h1').at(0).text()).toContain('20180220223941')
    })
})
