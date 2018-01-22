// @flow
import React from 'react'
import {createMinutes} from './minutesRepository'

const Minutes = () => {
    const createMinutesOnClick = () => createMinutes()

    return (<div>
        <h1>議事録作成</h1>
        <button onClick={createMinutesOnClick}>作成</button>
    </div>)
}

export default Minutes
