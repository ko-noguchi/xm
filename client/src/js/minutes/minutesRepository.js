// @flow
import post from '../http/post'

export const createMinutes = () => {
    post('minutes')
}
