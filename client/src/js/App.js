// @flow
import React from 'react'
import {BrowserRouter, Route} from 'react-router-dom'
import CreateMinutesPage from './minutes/CreateMinutesPage'
import MinutesPage from './minutes/MinutesPage'

const App = () => (
    <BrowserRouter>
        <div>
            <Route exact path='/minutes' component={CreateMinutesPage}/>
            <Route path='/minutes/:id' component={MinutesPage}/>
        </div>
    </BrowserRouter>
)

export default App
