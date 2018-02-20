// @flow
import React from 'react'

type Props = {
    match: any
}

const MinutesPage = (props: Props) => {
    return (<div>
        <h1>{props.match.params.id}</h1>
    </div>)
}

export default MinutesPage
