import * as post from '../../src/js/http/post'
import {createMinutes} from '../../src/js/minutes/minutesRepository'

describe('minutesRepository', () => {
    describe('createMinutes', () => {
        it('posts to create minutes API', () => {
            const postSpy = jest.spyOn(post, 'default')


            createMinutes()


            expect(postSpy).toHaveBeenCalledWith('minutes')
        })
    })
})
