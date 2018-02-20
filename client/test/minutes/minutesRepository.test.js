import * as post from '../../src/js/http/post'
import {createMinutes} from '../../src/js/minutes/minutesRepository'

describe('minutesRepository', () => {
    describe('createMinutes', () => {
        it('posts to create minutes API and returns response JSON', () => {
            jest.spyOn(post, 'default').mockReturnValue(Promise.resolve({json: () => 'response'}))


            expect(createMinutes()).resolves.toBe('response')
        })
    })
})
