import post from '../../src/js/http/post'

describe('post', () => {
    it('posts to the specified URL', () => {
        const fetchSpy = fetch.mockResponse('return value')


        const responsePromise = post('path')


        expect(fetchSpy).toHaveBeenCalledWith('http://localhost:8080/path', {method: 'POST'})
        return responsePromise.then(response => {
            expect(response.body).toEqual('return value')
        })
    })
})
