// @flow
import post from '../http/post'

export const createMinutes = (): Promise<any> => {
    return post('minutes').then(response => response.json())
}
