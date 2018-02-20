// @flow
import React from 'react'
import {createMinutes} from './minutesRepository'

type Props = {
    history: {
        push: Function
    }
}

class CreateMinutesPage extends React.Component<Props> {
    createMinutesAndMoveToThePage() {
        createMinutes()
            .then(json => this.props.history.push('/minutes/' + json.id))
    }

    render() {
        return (<div>
            <h1>議事録作成</h1>
            <button onClick={this.createMinutesAndMoveToThePage.bind(this)}>作成</button>
        </div>)
    }
}

export default CreateMinutesPage
