// @flow
import apiUrl from './apiUrl'

export default (path: string): Promise<Response> => {
    return fetch(`${apiUrl}/${path}`, {method: 'POST'})
}
